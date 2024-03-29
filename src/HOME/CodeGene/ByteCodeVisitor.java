package HOME.CodeGene;

import HOME.ForkReturnStack;
import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import HOME.Main;
import HOME.SymbolTable.SymbolInfo;
import HOME.SymbolTable.SymbolTable;
import HOME.Type.CollectionType;
import HOME.Type.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ByteCodeVisitor extends HOMEBaseVisitor
{
    // When generation the bytecode we need to keep an overview of the entire process,
    // below are a set of classes each defining a unique set of bytecode sequences,
    // 1. GlobalVariables
    // 2. Function
    // 3. Stmts
    // 4. ExpressionReturn

    // Coordinating global variables with the needed ".field" notation
    // and the stmts created in the <init> of the class itself is
    // added here when visiting the tree
    class GlobalVariables
    {
        private String _start;
        private ArrayList<String> fields;
        private Statements stmts;
        private String _end;

        public GlobalVariables()
        {
            _start = ".method public <init>()V";
            this.fields = new ArrayList<>();
            stmts = new Statements();
            stmts.add("aload_0");
            stmts.add("invokespecial java/lang/Object/<init>()V");
            _end = ".end method";
        }

        // Writes jasmin code to file
        public void build()
        {
            for (String field : fields)
            {
                Write(field);
            }

            Write(_start);
            stmts.build();
            Write("return");
            Write(_end);
            Write("");
        }
    }

    // As global variables the each function is build here with the corresponding
    // return type, parameters and stmts involved in the funnction itself.
    class Function
    {
        private String _begin;
        public Statements stmts;
        private String _end;

        public Function(String _begin, String _end)
        {
            this._begin = _begin;
            this._end = _end;
        }

        // Writes jasmin code to file
        public void build()
        {
            Write(this._begin);
            stmts.build();
            Write(this._end);
            Write("");
        }
    }

    // Statements are organized and added here, this is done through the first parameter.
    // It adds the directive ".line" which jasmin uses
    // It calculates the size of the operand stack (but it count too much then encountering if-stmts)
    public class Statements
    {
        private int limitStack;
        private int limitStackCounts = 0;
        private int limitLocale;
        private ArrayList<String> statements;
        private HashMap<Integer, Boolean> lineNumberCheck = new HashMap<Integer, Boolean>();

        public Statements()
        {
            this.statements = new ArrayList<>();
            this.limitStack = 0;
            this.limitStackCounts = 0;
            this.limitLocale = 0;
        }

        public int nextLocal()
        {
            return this.limitLocale + 1;
        }

        public int currentLocal()
        {
            return this.limitLocale;
        }

        public void add(String statement, ParserRuleContext ctx)
        {
            int lineNumber = ctx.getStart().getLine();

            if (!lineNumberCheck.containsKey(lineNumber)) {
                lineNumberCheck.put(lineNumber, true);
                statements.add(".line " + lineNumber);
            }

            add(statement);
        }

        public void add(String statement)
        {
            statement = statement.replaceAll("\\s+", " ");

            String[] bytecode = statement.split(" ");

            if (bytecode[0].contains("_"))
            {
                bytecode = statement.split("_");
            }

            if (bytecode[0].startsWith("Label"))
            {
                bytecode[0] = "Label";
            }

            switch (bytecode[0])
            {
                case ".line":

                case "checkcast":case "dneg":case "ineg":case "goto":case "Label":case "return":case "swap":
                    break;

                case "aload":case "iload":case "iconst":case "bipush":case "sipush":case "ldc":case "aconst":case "new":case "dup":
                    stackInc();
                    break;

                case "astore":case "istore":
                    stackDec();
                    break;

                case "areturn":case "ireturn":
                    stackDec();
                    break;

                case "iadd":case "isub":case "imul":case "idiv":case "irem":case "pop":
                    stackDec();
                    break;

                case "dcmpg":case "dcmpl":
                    stackDec(2 + 2);
                    stackInc();
                    break;

                case "if":
                    stackDec(2);
                    break;

                case "i2d":
                    stackDec();
                    stackInc(2);
                    break;

                case "ifeq":case "ifge":case "ifgt":case "ifle":case "iflt":case "ifne":
                    stackDec();
                    break;

                case "dreturn":
                    stackDec(2);
                    limitLocale++;
                    break;

                case "dstore":
                    stackDec(2);
                    break;

                case "dconst":case "ldc2":case "dload":
                    stackInc(2);
                    break;

                case "dadd":case "dsub":case "dmul":case "ddiv":case "drem":case "pop2":
                    stackDec(2);
                    break;

                case "invokespecial":case "invokevirtual":
                    stackDec();
                    invoke(bytecode);
                    break;

                case "invokeinterface":
                    stackDec(Integer.parseInt(bytecode[2]));
                    stackInc(wordSize(getReturnType(bytecode[1])));
                    break;

                case "invokestatic":
                    invoke(bytecode);
                    break;

                case "getfield":
                    stackDec();
                    stackInc(wordSize(bytecode[2]));
                    break;

                case "putfield":
                    stackDec();
                    stackDec(wordSize(bytecode[2]));
                    break;

                case "getstatic":
                    stackInc(wordSize(bytecode[2]));
                    break;

                default:
                    System.out.println("Der bliver ikke taget højte for dette bytecode\n" + statement + "\nDette er måske fordi: " + bytecode[0]);
                    System.exit(4);
            }

            if (limitStackCounts > limitStack)
            {
                limitStack = limitStackCounts;
            }
            this.statements.add(statement);
        }

        private void invoke(String[] bytecode)
        {
            ArrayList<String> parametes = getParameterTypes(bytecode[1]);
            if (parametes != null)
            {
                for (String str : parametes)
                {
                    stackDec(wordSize(str));
                }
            }

            stackInc(wordSize(getReturnType(bytecode[1])));
        }

        private String getReturnType(String str)
        {
            String[] temp2 = str.split(Pattern.quote(")"));
            return temp2[1];
        }

        private ArrayList<String> getParameterTypes(String s)
        {
            int startIndex = s.indexOf("(") + 1;
            int endIndex = s.indexOf(")");

            if (startIndex != endIndex)
            {
                ArrayList<String> parametes = new ArrayList<String>();

                String temp = s.substring(startIndex, endIndex);

                while (temp.length() > 0)
                {
                    if (temp.startsWith("L"))
                    {
                        endIndex = temp.indexOf(";");

                        parametes.add(temp.substring(0, endIndex + 1));

                        temp = temp.substring(endIndex + 1);
                    }
                    else
                    {
                        parametes.add(temp.substring(0, 1));

                        temp = temp.substring(1);
                    }
                }

                return parametes;
            }
            return null;
        }

        private int wordSize(String s)
        {
            if (s.startsWith("L") && s.endsWith(";"))
            {
                return 1;
            }

            switch (s)
            {
                case "V":
                    return 0;

                case "Z":
                case "I":
                    return 1;
                case "D":
                    return 2;

                default:
                    System.out.println("Der bliver ikke taget højte for denne type\n" + s);
                    System.exit(4);
                    return 1;
            }
        }

        private void stackInc()
        {
            limitStackCounts++;
        }

        private void stackInc(int value)
        {
            limitStackCounts += value;
        }

        private void stackDec()
        {
            limitStackCounts--;
        }

        private void stackDec(int value)
        {
            limitStackCounts -= value;
        }

        public void LocalInc()
        {
            this.limitLocale += 1;
        }

        // Writes jasmin code to file
        public void build()
        {
            Write(String.format("    " + ".limit stack %d", this.limitStack));
            Write(String.format("    " + ".limit locals %d", this.limitLocale + 1));

            //Prettyprint
            for (String statement : statements)
            {
                if (statement.contains(".line"))
                    Write(statement);
                else
                    Write("    " + statement);
            }
        }
    }

    // ExpressionReturn is used due to the usage of the tree, ex when making multiple
    // calculation a large tree is added and the Expressions returntype is given to
    // the former called function, this can in turn be used to see which type the
    // expression finally returns.
    class ExpressionReturn
    {
        Type type;
        String returnValue;
        Type actualType;

        ExpressionReturn(Type type, String returnValue)
        {
            this.type = type;
            this.returnValue = returnValue;
            this.actualType = type;
        }

        ExpressionReturn(String returnValue, Type actualType)
        {
            this.type = Main.variable;
            this.returnValue = returnValue;
            this.actualType = actualType;
        }
        public boolean equals(ExpressionReturn epxR)
        {
            return this.actualType.equals(epxR.actualType);
        }

        public boolean equals(Type epxR)
        {
            return this.actualType.equals(epxR);
        }

        public void invokeToObject(ParserRuleContext ctx, Statements stmts)
        {
            String typeName;
            if (this.type == Main.variable)
            {
                this.actualType.invokeToObject(ctx, stmts);
            }
            else
            {
                this.type.invokeToObject(ctx, stmts);
            }
        }
    }

    // Is used to keep track of variables in the local stack
    private SymbolTable symbolTable = Main.symbolTable;

    // Keeps track off the forks that happens in the program
    private ForkReturnStack forkReturnStack = new ForkReturnStack();

    private Function setup;
    private GlobalVariables globalVariables;
    private ArrayList<Function> functions = new ArrayList<>();

    private FileOutputStream newClass;


    HashMap<String, String> listOfSpecialCaseMethods = new HashMap<>();

    // The constructor of the bytecode visitor only generates the shell of the Jasmin J file.
    // The ByteCodeVisitor can then visit(ParseTree) from the HOMEBaseVisitor which in turn
    // runs through our entire code depending on the nodes attached to the tree.
    public ByteCodeVisitor()
    {
        listOfSpecialCaseMethods.put("add", "Ljava/lang/Object;");

        globalVariables = new GlobalVariables();
    }

    // The build method expects that the entire tree has already been visited and can therefore
    // write to the Jasmin J file corresponding to the results build
    public void build() throws IOException
    {
        File newClassFile = new File("Output_test.j");
        newClass = new FileOutputStream(newClassFile);

        Scanner metaClass = new Scanner(new File("src/HOME/CodeGene/Frame"));
        while (metaClass.hasNextLine())
        {
            Write(metaClass.nextLine());
        }

        globalVariables.build();
        setup.build();
        for (Function f : this.functions)
        {
            f.build();
        }
    }

    void Write(String out)
    {
        try
        {
            newClass.write(
                    out.concat(System.getProperty("line.separator")).getBytes()
            );
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


// Visitors

    // Compiles the global variable
    @Override
    public Object visitGlobal(@NotNull HOMEParser.GlobalContext ctx)
    {
        // Declaration
        if (ctx.declaration() != null)
        {
            Type symbolType = symbolTable.types.getSymbol(ctx.declaration().type().getText());
            String identifier = ctx.declaration().identifier().getText();
            String declaration = String.format(".field public %s %s", identifier, returnTypeForFunctionObject(symbolType));// = <value>";

            globalVariables.fields.add(declaration);
            globalVariables.stmts.add("aload_0", ctx);
            visitDeclaration(ctx.declaration(), globalVariables.stmts);
        }
        return super.visitGlobal(ctx);
    }

    // Compiles the required setup function and the not required functions
    @Override
    public Object visitFunction(@NotNull HOMEParser.FunctionContext ctx)
    {
        symbolTable.openScope();
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        String funcName = ctx.identifier().getText();

        Function func;

        if (funcName.equals("Setup"))
        {
            this.setup = new Function(".method public Setup()V", ".end method");
            setup.stmts = new Statements();

            visitStmts(ctx.stmts(), setup.stmts);

            func = setup;
        }
        else
        {
            String parameters;
            Statements stmts = new Statements();
            parameters = visitFunctionParameters(ctx.functionParameters(), stmts);

            String returnsType;
            if (ctx.nothing() != null)
            {
                returnsType = "V";
            }
            else
            {
                Type type = symbolTable.types.getSymbol(ctx.type().getText());
                returnsType = returnTypeForFunctionSimple(type);
            }

            func = new Function(".method public " + funcName + "(" + parameters + ")" + returnsType, ".end method");
            func.stmts = stmts;

            visitStmts(ctx.stmts(), func.stmts);
            new ArrayList<HashMap<String, Integer>>();
            this.functions.add(func);
        }

        if (!forkReturnStack.closed())
        {
            visitReturnFunction(null, func.stmts);
        }
        forkReturnStack.dispose();

        symbolTable.closeScope();

        return super.visitFunction(ctx);
    }

    // Returns String for simple type, if it is a simple type
    String returnTypeForFunctionSimple(Type type)
    {
        if (type instanceof CollectionType)
        {
            return ((CollectionType) type).primaryType.getObjectByteCode();
        }
        else
        {
            return type.getSimpleByteCode();
        }
    }

    // Returns String for object type, if it is a simple type
    String returnTypeForFunctionObject(Type type)
    {
        if (type instanceof CollectionType)
        {
            return ((CollectionType) type).primaryType.getObjectByteCode();
        }
        else
        {
            return type.getObjectByteCode();
        }
    }

    //region Stmts

    // Compiler jasmin code for one statement and
    // continue to the next statement if there are more
    void visitStmts(@NotNull HOMEParser.StmtsContext ctx, Statements stmts)
    {
        if (ctx.stmt() != null)
        {
            visitStmt(ctx.stmt(), stmts);
        }
        if (ctx.stmts() != null)
        {
            visitStmts(ctx.stmts(), stmts);
        }
    }

    // Determines a single statement node
    void visitStmt(@NotNull HOMEParser.StmtContext ctx, Statements stmts)
    {
        if (ctx.declaration() != null)
        {
            visitDeclaration(ctx.declaration(), stmts);
        }
        else if (ctx.assignment() != null)
        {
            visitAssignment(ctx.assignment(), stmts);
        }
        else if (ctx.ifStmt() != null)
        {
            visitIfStmt(ctx.ifStmt(), stmts);
        }
        else if (ctx.loop() != null)
        {
            visitLoop(ctx.loop(), stmts);
        }
        else if (ctx.funcCall() != null)
        {
            visitFuncCall(ctx.funcCall(), stmts, true);
        }
        else if (ctx.variableMethodCall() != null)
        {
            ExpressionReturn returnvalue = visitVariableMethodCall(ctx.variableMethodCall(), stmts);
            if (returnvalue.equals(Main.decimal)){
                stmts.add("pop2", ctx);
            }
            else if (!returnvalue.equals(Main.nothing))
            {
                stmts.add("pop", ctx);
            }
        }
        else if (ctx.incDec() != null)
        {
            visitIncDec(ctx.incDec(), stmts);
        }
        else if (ctx.returnFunction() != null)
        {
            visitReturnFunction(ctx.returnFunction(), stmts);
        }
    }

    // Declare one variable and initialize it with a value or
    // with 0, "" or null if nothing is specified
    void visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx, Statements stmts)
    {
        String type = ctx.type().getText();
        type = type.replaceAll("<.+>", "");
        CollectionType symbolType;
        SymbolInfo variable;

        switch (type)
        {
            case "Integer":
                stmts.LocalInc();
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.add("iconst_0", ctx);
                }
                variable = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), Main.integer, stmts.currentLocal());
                variable.store(ctx, stmts);
                break;

            case "Decimal":
                stmts.LocalInc();
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.add("dconst_0", ctx);
                }
                variable = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), Main.decimal, stmts.currentLocal());
                variable.store(ctx, stmts);
                stmts.LocalInc();
                break;

            case "String":
                stmts.LocalInc();
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.add("ldc \"\"", ctx);
                }
                variable = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), Main.string, stmts.currentLocal());
                variable.store(ctx, stmts);
                break;

            case "Boolean":
                stmts.LocalInc();
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.add("iconst_0", ctx);
                }
                variable = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), Main.bool, stmts.currentLocal());
                variable.store(ctx, stmts);
                break;

            case "List":
                // There are 4 different special cases when creating a List, each being handled in their own special way.
                // 1. List<Integer> aList   , this case builds the list from the description given and only creates arraylist.
                // 2. List<List<Integer>> aList = {{}}, same as above yet we detect the depth of this list in case of a list within a list.
                // 3. List<Integer> aList = {1,2,3}
                // 4. List<Integer> aList = someFunction()
                symbolType = (CollectionType) symbolTable.types.getSymbol(ctx.type().getText());
                int currentLocal = stmts.nextLocal();
                if (ctx.expression() != null)
                {
                    if (ctx.expression().literal() != null)
                    {
                        int depth = emptyInit(ctx.expression().literal(), 1);
                        //If depth equals -1, then the expression contains elements
                        if (depth == -1)
                        {
                            // case 3
                            visitExpression(ctx.expression(), stmts);
                        }
                        else
                        {
                            // case 2
                            buildList(ctx, stmts, symbolType, depth);
                        }
                    }
                    else
                    {
                        // case 4
                        visitExpression(ctx.expression(), stmts);
                        stmts.add("astore " + currentLocal, ctx);
                        stmts.LocalInc();
                    }
                }
                else
                {
                    // case 1
                    buildList(ctx, stmts, symbolType, 1);
                }
                symbolTable.variables.addSymbol(ctx.identifier().getText(), symbolType, currentLocal);
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                if (variable.depth == 0)
                {
                    stmts.add("aload " + variable.var.location, ctx);
                    variable.store(ctx, stmts);
                }
                break;

            case "Dictionary":
                // There are 4 different special cases when creating a List, each being handled in their own special way.
                // 1. Dictionary<Integer> aList, this case builds the dictionary from the description given and only creates hashmap.
                // 2. Dictionary<Integer> aList = {}, same as above yet we detect the depth of this list in case of a Dictionary within a dictionary.
                // 3. Dictionary<Integer> aList = {"Test"=1}
                // 4. Dictionary<Integer> aList = someFunction()
                symbolType = (CollectionType) symbolTable.types.getSymbol(ctx.type().getText());
                int currentLocal2 = stmts.nextLocal();
                if (ctx.expression() != null)
                {
                    if (ctx.expression().literal() != null)
                    {
                        int depth2 = emptyInit(ctx.expression().literal(), 1);
                        //If depth equals -1, then it contains something
                        if (depth2 == -1)
                        {
                            // case 3
                            visitExpression(ctx.expression(), stmts);
                        }
                        else
                        {
                            // case 2
                            buildDictionary(ctx, stmts, symbolType, depth2);
                        }
                    }
                    else
                    {
                        // case 4
                        visitExpression(ctx.expression(), stmts);
                        stmts.add("astore " + currentLocal2, ctx);
                        stmts.LocalInc();
                    }
                }
                else
                {
                    // case 1
                    buildDictionary(ctx, stmts, symbolType, 1);
                }
                symbolTable.variables.addSymbol(ctx.identifier().getText(), symbolType, currentLocal2);
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                if (variable.depth == 0)
                {
                    stmts.add("aload " + variable.var.location, ctx);
                    variable.store(ctx, stmts);
                }
                break;

            default:
                stmts.LocalInc();
                String className = ctx.type().getText();
                Type symbol = symbolTable.types.getSymbol(className);

                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.add("aconst_null", ctx);
                }
                SymbolInfo symbolInfoClass = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), symbol, stmts.currentLocal());

                symbolInfoClass.store(ctx, stmts);

                break;
        }
    }

    // returns a string of types for the parameter to a functions
    String visitFunctionParameters(@NotNull HOMEParser.FunctionParametersContext ctx, Statements stmts)
    {
        if (ctx == null)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (HOMEParser.FuncParamDeclarationContext dec : ctx.funcParamDeclaration())
        {
            // Safety function: removes all the spaces in the start
            // and end of the string, though this should not be necessary
            String t = dec.type().getText().trim();

            Type type = symbolTable.types.getSymbol(t);

            symbolTable.variables.addSymbol(dec.identifier().getText(), type, stmts.nextLocal());

            stmts.LocalInc();

            sb.append(symbolTable.types.getSymbol(t).getSimpleByteCode());
        }

        return sb.toString();
    }

    // Assign a value to a variable
    void visitAssignment(@NotNull HOMEParser.AssignmentContext ctx, Statements stmts)
    {
        if (ctx.identifier() != null)
        {
            SymbolInfo variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
            String type = variable.var.type.name;
            type = type.replaceAll("<.+>", "");
            switch (type)
            {
                case "Integer":
                case "Boolean":
                    if (ctx.AnyAssign() != null)
                    {
                        variable.load(ctx, stmts);
                    }
                    visitExpression(ctx.expression(), stmts);
                    visitAnyassignment(ctx, ctx.AnyAssign(), variable, stmts);
                    variable.store(ctx, stmts);
                    break;

                case "Decimal":
                    if (ctx.AnyAssign() != null)
                    {
                        variable.load(ctx, stmts);
                    }
                    visitExpression(ctx.expression(), stmts);
                    visitAnyassignment(ctx, ctx.AnyAssign(), variable, stmts);
                    variable.store(ctx, stmts);
                    break;

                case "String":
                    visitExpression(ctx.expression(), stmts);
                    variable.store(ctx, stmts);
                    break;

                case "List":
                    // There are 4 different special cases when creating a List, each being handled in their own special way.
                    // 1. List<List<Integer>> aList = {{}}, same as above yet we detect the depth of this list in case of a list within a list.
                    // 2. List<Integer> aList = {1,2,3}
                    // 3. List<Integer> aList = someFunction()
                    CollectionType symbolType = (CollectionType) variable.var.type;
                    int currentLocal = stmts.nextLocal();
                    if (ctx.expression() != null)
                    {
                        if (ctx.expression().literal() != null)
                        {
                            int depth = emptyInit(ctx.expression().literal(), 1);
                            //If depth equals -1, then the list literal contains elements
                            if (depth == -1)
                            {
                                // case 2
                                visitExpression(ctx.expression(), stmts);
                                stmts.add("aload " + currentLocal, ctx);
                            }
                            else
                            {
                                // case 1
                                buildList(ctx, stmts, symbolType, depth);
                                stmts.add("aload " + currentLocal, ctx);
                            }
                        }
                        else
                        {
                            // case 3
                            visitExpression(ctx.expression(), stmts);
                            if (variable.depth != 0)
                            {
                                stmts.LocalInc();
                                currentLocal++;
                            }
                        }
                    }

                    variable.store(ctx, stmts);
                    break;

                case "Dictionary":
                    // There are 4 different special cases when creating a List, each being handled in their own special way.
                    // 1. Dictionary<Integer> aList = {}, same as above yet we detect the depth of this list in case of a Dictionary within a dictionary.
                    // 2. Dictionary<Integer> aList = {"Test"=1}
                    // 3. Dictionary<Integer> aList = someFunction()
                    symbolType = (CollectionType) variable.var.type;
                    currentLocal = stmts.nextLocal();
                    if (ctx.expression() != null)
                    {
                        if (ctx.expression().literal() != null)
                        {
                            int depth = emptyInit(ctx.expression().literal(), 1);
                            //If depth equals -1, then the dictionary literal contains elements
                            if (depth == -1)
                            {
                                // case 2
                                visitExpression(ctx.expression(), stmts);
                                stmts.add("aload " + currentLocal, ctx);
                            }
                            else
                            {
                                // case 1
                                buildDictionary(ctx, stmts, symbolType, depth);
                                stmts.add("aload " + currentLocal, ctx);
                            }
                        }
                        else
                        {
                            // case 3
                            visitExpression(ctx.expression(), stmts);
                            if (variable.depth != 0)
                            {
                                stmts.LocalInc();
                                currentLocal++;
                            }
                        }
                    }
                    variable.store(ctx, stmts);
                    break;
                default:
                    visitExpression(ctx.expression(), stmts);
                    variable.store(ctx, stmts);
                    break;

            }
        }
        else if (ctx.listIndex() != null)
        {
            SymbolInfo symbol = symbolTable.variables.getSymbol(ctx.listIndex().identifier().getText());
            CollectionType type = (CollectionType) symbolTable.variables.getType(ctx.listIndex().identifier().getText());

            symbol.load(ctx, stmts);

            List<HOMEParser.ExpressionContext> expressionContexts = ctx.listIndex().expression();
            for (Integer i = 0; i < expressionContexts.size() - 1; i++)
            {
                visitExpression(expressionContexts.get(i), stmts);
                switch (type.primaryType.name)
                {
                    case "List":
                        stmts.add(String.format("invokevirtual %s.get(%s)Ljava/lang/Object;", Main.list.getClassByteCode(), Main.integer.bytecode), ctx);
                        break;
                    case "Dictionary":
                        stmts.add(String.format("invokevirtual %s.get(%s)Ljava/lang/Object;", Main.dictionary.getClassByteCode(), Main.object.bytecode), ctx);
                        break;
                }
                stmts.add("checkcast " + type.primaryType.getClassByteCode(), ctx);
                type = (CollectionType) type.innerType;
            }
            HOMEParser.ExpressionContext exp = expressionContexts.get(expressionContexts.size() - 1);
            if (ctx.AnyAssign() != null)
            {
                stmts.add("dup", ctx);
                visitExpression(exp, stmts);
                stmts.add("swap", ctx);
                visitExpression(exp, stmts);
                if (type.primaryType.equals(Main.list))
                {
                    stmts.add("invokevirtual java/util/ArrayList.get(I)Ljava/lang/Object;", ctx);
                }
                else
                {
                    stmts.add("invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;", ctx);
                }
                stmts.add("checkcast " + Main.integer.getClassByteCode(), ctx);
                stmts.add("invokevirtual java/lang/Integer/intValue()I", ctx);
                visitExpression(ctx.expression(), stmts);
                visitAnyassignment(ctx, ctx.AnyAssign(), symbol, stmts);
            }
            else
            {
                visitExpression(exp, stmts);
                visitExpression(ctx.expression(), stmts);
            }

            switch (type.innerType.name)
            {
                case "Integer":
                    stmts.add("invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;", ctx);
                    break;
                case "Decimal":
                    stmts.add("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;", ctx);
                    break;
                case "Boolean":
                    stmts.add("invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;", ctx);
                    break;
            }
            switch (type.primaryType.name)
            {
                case "List":
                    stmts.add(String.format("invokevirtual %s.set(%sLjava/lang/Object;)Ljava/lang/Object;", Main.list.getClassByteCode(), Main.integer.getSimpleByteCode()), ctx);
                    break;
                case "Dictionary":
                    stmts.add(String.format("invokevirtual %s.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", Main.dictionary.getClassByteCode()), ctx);
                    break;
            }
            stmts.add("pop", ctx);
        }
        else if (ctx.field() != null)
        {
            SymbolInfo symbolClassInfo = symbolTable.variables.getSymbol(ctx.field().identifier(0).getText());
            Type fieldType = symbolClassInfo.var.type.getFieldByName(ctx.field().identifier(1).getText()).type;
            String fieldname = ctx.field().identifier(1).getText();

            symbolClassInfo.load(ctx, stmts);

            visitExpression(ctx.expression(), stmts);

            stmts.add(String.format("putfield %s/%s %s",
                    symbolClassInfo.var.type.getClassByteCode(),
                    fieldname,
                    fieldType.getSimpleByteCode()), ctx);
        }
    }


    /*** How if-stmts works ***
     *
     * if (true) goto l_if
     * elseif (true) goto l_elseif
     *     else code...
     *     goto l_end
     * l_if:
     *     if code...
     *     goto l_end
     * l_elseif:
     *     elseif code..
     *     goto l_end
     * l_end
     */

    // Compiles the if statements
    void visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx, Statements stmts)
    {
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        // Used to check if there is a return statement,
        // because if there is, there must not be a goto afterwards
        // because that will resolve in a illegal "jump"
        int tempReturns = 0;

        boolean usingEndLabel = false;

        String ifLabel = symbolTable.newLabel();

        // Will generate the jasmin code for if-stmt
        visitExpression(ctx.expression(), stmts, ifLabel);

        // List of all the elseif statement
        List<HOMEParser.ElseIfStmtContext> elseif = ctx.elseIfStmt();

        ArrayList<String> elseifLabel = new ArrayList<>();
        for (int i = 0; i < elseif.size(); i++)
        {
            elseifLabel.add(symbolTable.newLabel());

            // Will generate the jasmin code for elseif-stmt
            visitExpression(elseif.get(i).expression(), stmts, elseifLabel.get(i));

            forkReturnStack.addFork();
        }
        String endLabel = symbolTable.newLabel();

        if (ctx.elseStmt() != null)
        {
            forkReturnStack.addFork();
            tempReturns = forkReturnStack.getReturns();

            visitStmts(ctx.elseStmt().stmts(), stmts);

        }

        // if there was not return or if there is no else-stmt add goto
        if (forkReturnStack.getReturns() == tempReturns || ctx.elseStmt() == null)
        {
            stmts.add("goto " + endLabel, ctx);
            usingEndLabel = true;
        }

        tempReturns = forkReturnStack.getReturns();

        stmts.add(ifLabel + ":", ctx);
        visitStmts(ctx.stmts(), stmts);

        // if there was not return or if there is no else-stmt add goto
        if (forkReturnStack.getReturns() == tempReturns)
        {
            stmts.add("goto " + endLabel, ctx);
            usingEndLabel = true;
        }

        for (int i = 0; i < elseif.size(); i++)
        {
            tempReturns = forkReturnStack.getReturns();

            stmts.add(elseifLabel.get(i) + ":", ctx);
            visitStmts(elseif.get(i).stmts(), stmts);

            if (forkReturnStack.getReturns() == tempReturns)
            {
                stmts.add("goto " + endLabel, ctx);
                usingEndLabel = true;
            }
        }

        if (usingEndLabel)
        {
            stmts.add(endLabel + ":", ctx);
        }

        if (forkReturnStack.closed() && ctx.elseStmt() != null)
        {
            forkReturnStack.dispose();
            forkReturnStack.addReturn();
        }
        else
        {
            forkReturnStack.dispose();
        }
    }

    void visitLoop(@NotNull HOMEParser.LoopContext ctx, Statements statements)
    {
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        symbolTable.openScope();

        if (ctx.loopForeach() != null)
        {
            visitLoopForeach(ctx.loopForeach(), statements);
        }
        else if (ctx.loopWhileOrUntil() != null)
        {
            visitLoopWhileOrUntil(ctx.loopWhileOrUntil(), statements);
        }

        forkReturnStack.dispose();

        symbolTable.closeScope();
    }

    void visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx, Statements stmts)
    {
        visitExpression(ctx.expression(), stmts);

        SymbolInfo symbolInfoOfVariable;
        if (ctx.expression().listIndex() != null)
        {
            symbolInfoOfVariable = symbolTable.variables.getSymbol(ctx.expression().listIndex().identifier().getText());
        }
        else
        {
            symbolInfoOfVariable = symbolTable.variables.getSymbol(ctx.expression().identifier().getText());
        }

        Type realType = ((CollectionType) symbolInfoOfVariable.var.type).primaryType;

        if (realType.equals(Main.list))
        {
            stmts.LocalInc();
            Integer iterator = stmts.currentLocal();

            Type innerType = symbolTable.types.getSymbol(ctx.type().getText());
            String labelStart = symbolTable.newLabel();
            String labelEnd = symbolTable.newLabel();

            stmts.add("invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1", ctx);
            stmts.add("astore " + iterator, ctx);
            stmts.add(labelStart + ":", ctx);
            stmts.add("aload " + iterator, ctx);
            stmts.add("invokeinterface java/util/Iterator/hasNext()Z 1", ctx);
            stmts.add("ifeq " + labelEnd, ctx);
            stmts.add("aload " + iterator, ctx);
            stmts.add("invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1", ctx);
            stmts.add("checkcast " + innerType.getClassByteCode(), ctx);

            innerType.invokeToSimpleType(ctx, stmts);

            stmts.LocalInc();
            SymbolInfo symbolInfo = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), innerType, stmts.currentLocal());

            //symbolTable.variables.getSymbol(identifier).store(stmts);
            symbolInfo.store(ctx, stmts);

            visitStmts(ctx.stmts(), stmts);

            stmts.add("goto " + labelStart, ctx);
            stmts.add(labelEnd + ":", ctx);
        }
        else if (realType.equals(Main.dictionary))
        {
            Integer iterator = stmts.nextLocal();
            stmts.LocalInc();

            Type innerType = symbolTable.types.getSymbol(ctx.type().getText());
            String labelStart = symbolTable.newLabel();
            String labelEnd = symbolTable.newLabel();

            stmts.add("invokevirtual java/util/HashMap/values()Ljava/util/Collection;", ctx);
            stmts.add("invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1", ctx);
            stmts.add("astore " + iterator, ctx);
            stmts.add(labelStart + ":", ctx);
            stmts.add("aload " + iterator, ctx);
            stmts.add("invokeinterface java/util/Iterator/hasNext()Z 1", ctx);
            stmts.add("ifeq " + labelEnd, ctx);
            stmts.add("aload " + iterator, ctx);
            stmts.add("invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1", ctx);
            stmts.add("checkcast " + innerType.getClassByteCode(), ctx);

            innerType.invokeToSimpleType(ctx, stmts);
            ;

            stmts.LocalInc();
            SymbolInfo symbolInfo = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), innerType, stmts.currentLocal());

            String storeCode;

            symbolInfo.store(ctx, stmts);

            visitStmts(ctx.stmts(), stmts);

            stmts.add("goto " + labelStart, ctx);
            stmts.add(labelEnd + ":", ctx);
        }
    }

    void visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx, Statements statements)
    {
        String label1 = symbolTable.newLabel();
        String label2 = symbolTable.newLabel();
        String loopType = ctx.getChild(1).getText();

        if (loopType.equalsIgnoreCase("while"))
        {
            statements.add("goto " + label2, ctx);
            statements.add(label1 + ":", ctx);
        }
        else if (loopType.equalsIgnoreCase("until"))
        {
            statements.add(label1 + ":", ctx);
            // Check condition. If true goto Label2
            visitExpression(ctx.expression(), statements, label2);
        }

        // Do stuff here
        visitStmts(ctx.stmts(), statements);


        if (loopType.equalsIgnoreCase("while"))
        {
            statements.add(label2 + ":", ctx);
            // Check condition. If true goto Label1
            visitExpression(ctx.expression(), statements, label1);
        }
        else if (loopType.equalsIgnoreCase("until"))
        {
            statements.add("goto " + label1, ctx);
            statements.add(label2 + ":", ctx);
        }
    }

    ExpressionReturn visitFuncCall(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts, Boolean pop)
    {
        if (ctx.identifier().getText().equals("RegisterEvent"))
        {
            return visitFuncCallRegisterEvent(ctx, stmts);
        }
        else
        {
            return visitFuncCallNormal(ctx, stmts, pop);
        }
    }

    ExpressionReturn visitFuncCallNormal(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts, Boolean pop)
    {
        HOME.Type.Function function = symbolTable.functions.getSymbol(ctx.identifier().getText());

        if (function.name.equals(function.returnType.name))
        {
            stmts.add("new " + function.returnType.getClassByteCode(), ctx);
            stmts.add("dup", ctx);
        }
        else
        {
            stmts.add("aload_0", ctx);
        }

        for (HOMEParser.ExpressionContext expressionContext : ctx.funcParameters().expression())
        {
            visitExpression(expressionContext, stmts);
        }

        String bytecode;
        if (function.name.equals(function.returnType.name))
        {
            bytecode = "invokespecial ";
            bytecode += function.returnType.getClassByteCode();
            bytecode += ".<init>(";
        }
        else
        {
            bytecode = "invokevirtual ";

            bytecode += "HOME/";
            bytecode += function.name + "(";
        }

        for (Type parameter : function.parameters)
        {
            bytecode += parameter.getSimpleByteCode();
        }

        if (function.name.equals(function.returnType.name))
        {
            bytecode += ")" + Main.nothing.getSimpleByteCode();
        }
        else
        {
            bytecode += ")" + returnTypeForFunctionSimple(function.returnType);
        }

        stmts.add(bytecode, ctx);
        if (pop && !function.returnType.equals(Main.nothing))
        {
            if (function.returnType.equals(Main.decimal))
            {
                stmts.add("pop2", ctx);
            }
            else
            {
                stmts.add("pop", ctx);
            }
        }

        return new ExpressionReturn(function.returnType, "");
    }

    // Special case for the function RegisterEvent
    ExpressionReturn visitFuncCallRegisterEvent(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts)
    {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.funcParameters().expression(0).field().identifier(0).getText());

        symbolInfo.load(ctx, stmts);
        stmts.add("ldc " + "\"" + ctx.funcParameters().expression(0).field().identifier(1).getText() + "\"", ctx);
        stmts.add("ldc " + "\"" + ctx.funcParameters().expression(1).identifier().getText() + "\"", ctx);

        String bytecode = "invokevirtual ";

        bytecode += symbolInfo.var.type.getClassByteCode();
        bytecode += "/registerEvent(";
        bytecode += Main.string.getObjectByteCode();
        bytecode += Main.string.getObjectByteCode();
        bytecode += ")V";

        stmts.add(bytecode, ctx);

        return new ExpressionReturn(Main.nothing, "");
    }


    ExpressionReturn visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx, Statements stmts)
    {
        return visitVariableMethodCall(ctx, stmts, false);
    }

    // Handles and generate jasmin code for method calls
    ExpressionReturn visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
        Type type = variable.var.type;

        // If the type is a list or dictionary
        if (type instanceof CollectionType){
            // the variable 'type' is being to list or dictinary
            type = ((CollectionType) type).primaryType;
        }

        HOME.Type.Function variableMethod = variable.var.type.getMethodByName(ctx.funcCall().identifier().getText());

        // push object ref. to operator stack
        visitIdentifier(ctx.identifier(), stmts, false).invokeToObject(ctx, stmts);

        ExpressionReturn returnValue = null;
        // push object ref. or simple type to operator stack from parameter
        for (HOMEParser.ExpressionContext expressionContext : ctx.funcCall().funcParameters().expression())
        {
            returnValue = visitExpression(expressionContext, stmts);
            if (listOfSpecialCaseMethods.containsKey(variableMethod.name) && (type.equals(Main.list) || type.equals(Main.dictionary))){
                returnValue.actualType.invokeToObject(ctx, stmts);
            }
        }

        // Construct method call
        // Example: invokevirtual class.method(parameter)returnType
        StringBuilder bytecode = new StringBuilder("invokevirtual ").
                append(type.getClassByteCode()).
                append(".").append(variableMethod.name).
                append("(");

        // Special case for list and dictionary
        if (listOfSpecialCaseMethods.containsKey(variableMethod.name) && (type.equals(Main.list) || type.equals(Main.dictionary))){
            bytecode.append(listOfSpecialCaseMethods.get(variableMethod.name));
        }
        // Adder parameter types to the method call
        else
        {
            for (Type parameter : variableMethod.parameters)
            {
                bytecode.append(parameter.getSimpleByteCode());
            }
        }

        // Adder return types to the method call
        bytecode.append(")").append(variableMethod.returnType.getSimpleByteCode());

        // method call constructing done
        stmts.add(bytecode.toString(), ctx);

        if (convertingFlag)
        {
            stmts.add("i2d", ctx);
            return new ExpressionReturn(Main.decimal, "");
        }

        return new ExpressionReturn(variableMethod.returnType, "");
    }

    // Adds returns in the functions
    void visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx, Statements stmts)
    {
        forkReturnStack.addReturn();
        if (ctx == null || ctx.expression() == null)
        {
            stmts.add("return");
        }
        else
        {

            SymbolInfo symbol = null;
            if (ctx.expression().identifier() != null)
            {
                symbol = symbolTable.variables.getSymbol(ctx.expression().identifier().getText());
            }

            String type;
            ExpressionReturn _return = visitExpression(ctx.expression(), stmts);
            type = _return.actualType.name;

            switch (type)
            {
                case "Integer":
                    stmts.add("ireturn", ctx);
                    break;

                case "Decimal":
                    stmts.add("dreturn", ctx);
                    break;

                case "Boolean":
                    stmts.add("ireturn", ctx);
                    break;

                case "String":
                    stmts.add("areturn", ctx);
                    break;

                case "Nothing":
                    stmts.add("return", ctx);
                    break;

                default:
                    stmts.add("areturn", ctx);
                    break;
            }
        }
    }

    void visitIncDec(@NotNull HOMEParser.IncDecContext ctx, Statements stmts)
    {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.identifier().getText());
        int location = symbolInfo.var.location;
        Type type = symbolInfo.var.type;

        String typePrefix = "";
        if (type.equals(Main.integer))
        {
            typePrefix = "i";
        }
        else if (type.equals(Main.decimal))
        {
            typePrefix = "d";
        }

        symbolInfo.load(ctx, stmts);
        stmts.add(typePrefix + "const_1", ctx);

        if (ctx.INC() != null)
        {
            stmts.add(typePrefix + "add", ctx);
        }
        else if (ctx.DEC() != null)
        {
            stmts.add(typePrefix + "sub", ctx);
        }

        symbolInfo.store(ctx, stmts);
    }

    //endregion

    //region Visit Expression

    ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts)
    {
        return visitExpression(ctx, stmts, null, false);
    }

    ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label)
    {
        return visitExpression(ctx, stmts, label, false);
    }

    // Determines how to calculate expression and handling type converting if necessary
    ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label, boolean convertingFlag)
    {
        // if set to true the value on the top of the operator stack is converted to decimal (double)
        if (!convertingFlag)
        {
            int lastChild = ctx.getChildCount() - 1;
            //if(ctx.getChild(lastChild) instanceof  HOMEParser.Int2decContext)
            convertingFlag = ctx.getChild(lastChild) instanceof  HOMEParser.Int2decContext;
        }

        // if a binary operator, like 2+3
        if (ctx.expression().size() == 2)
        {
            ExpressionReturn r1, r2;

            r1 = visitExpression(ctx.expression(0), stmts, null, convertingFlag);
            r2 = visitExpression(ctx.expression(1), stmts, null, convertingFlag);

            Type type = compareTypes(r1, r2);

            // pops 2 values from the operator stack, calculate/compare and push one back
            if (label == null)
            {
                type = visitOperator(ctx, stmts, type);
            }
            // pops 2 values from the operator stack, compare and adds label
            else
            {
                type = visitOperator(ctx, stmts, type, label);
            }

            return new ExpressionReturn(type, "");
        }
        else if (ctx.expression().size() == 1)
        {
            ExpressionReturn r1 = checkExpression(ctx, stmts, convertingFlag);

            return new ExpressionReturn(r1.type, "");
        }
        // Special case for if-stmt, if there only is one expression
        // Example: if (x)
        else if (ctx.expression().size() == 0 && label != null)
        {
            ExpressionReturn r1 = visitExpression(ctx, stmts, null, convertingFlag);

            stmts.add("ifne " + label, ctx);
        }
        // determines the method to push value to the operator stack
        else
        {
            // Is expression doesn't contain any expressions, use below
            if (ctx.funcCall() != null)
            {
                return visitFuncCall(ctx.funcCall(), stmts, false);
            }
            else if (ctx.literal() != null)
            {
                return visitLiteral(ctx.literal(), stmts, convertingFlag);
            }
            else if (ctx.variableMethodCall() != null)
            {
                return visitVariableMethodCall(ctx.variableMethodCall(), stmts, convertingFlag);
            }
            else if (ctx.identifier() != null)
            {
                return visitIdentifier(ctx.identifier(), stmts, convertingFlag);
            }
            else if (ctx.listIndex() != null)
            {
                return visitListIndex(ctx.listIndex(), stmts, convertingFlag);
            }
            else if (ctx.field() != null)
            {
                return visitField(ctx.field(), stmts, convertingFlag);
            }
        }

        //should never get here, but if it happens it will almost always end with a NullPointerException
        return null;
    }

    //endregion

    //region Visit Variables

    ExpressionReturn visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.getText());
        Type type = variable.var.type;
        variable.load(ctx, stmts);
        if (convertingFlag)
        {
            stmts.add("i2d", ctx);
            return new ExpressionReturn(ctx.getText(), Main.decimal);
        }
        return new ExpressionReturn(ctx.getText(), type);
    }

    ExpressionReturn visitListIndex(@NotNull HOMEParser.ListIndexContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.identifier().getText());
        CollectionType type = ((CollectionType) symbolInfo.var.type);
        for (int i = 0; i < ctx.expression().size(); i++)
        {
            if (i == 0)
            {
                symbolInfo.load(ctx, stmts);
            }

            visitExpression(ctx.expression(i), stmts);

            switch (type.primaryType.name)
            {
                case "List":
                    stmts.add(String.format("invokevirtual %s.get(%s)%s", Main.list.getClassByteCode(), Main.integer.getSimpleByteCode(), Main.object.getSimpleByteCode()), ctx);
                    break;
                case "Dictionary":
                    stmts.add(String.format("invokevirtual %s.get(%s)%s", Main.dictionary.getClassByteCode(), Main.object.getSimpleByteCode(), Main.object.getSimpleByteCode()), ctx);
                    break;
            }

            stmts.add("checkcast " + type.innerType.getClassByteCode(), ctx);

            type.innerType.invokeToSimpleType(ctx, stmts);

            if (convertingFlag)
            {
                stmts.add("i2d", ctx);
                return new ExpressionReturn(Main.decimal, "");
            }

            if (type.innerType instanceof CollectionType)
            {
                type = (CollectionType) type.innerType;
            }
        }
        return new ExpressionReturn(type.innerType, "");
    }

    // Push a value from a field to the operator stack
    ExpressionReturn visitField(@NotNull HOMEParser.FieldContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo symbolClassInfo = symbolTable.variables.getSymbol(ctx.identifier(0).getText());
        Type fieldType = symbolClassInfo.var.type.getFieldByName(ctx.identifier(1).getText()).type;
        String fieldname = ctx.identifier(1).getText();

        visitIdentifier(ctx.identifier(0), stmts, convertingFlag);

        stmts.add(String.format("getfield %s/%s %s",
                symbolClassInfo.var.type.getClassByteCode(),
                fieldname,
                fieldType.getSimpleByteCode()), ctx);
        if (convertingFlag)
        {
            stmts.add("i2d", ctx);
            return new ExpressionReturn(Main.decimal, "");
        }

        return new ExpressionReturn(fieldType, "");
    }

    //endregion

    //region Expression methods

    // Changes the value on the top of the operator stack to a negative value if positive and vice versa
    void visitNegate(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, ExpressionReturn value, boolean convertingFlag)
    {
        if (getNegate(ctx).equals("-"))
        {
            if (value.type == Main.decimal || convertingFlag)
            {
                stmts.add("dneg", ctx);
            }
            else if (value.type == Main.integer)
            {
                stmts.add("ineg", ctx);
            }
        }
    }

    // Returns a negate as a string if existing else return return empty string
    String getNegate(HOMEParser.ExpressionContext expressionContext)
    {
        if (expressionContext.expression().size() == 1)
        {
            return expressionContext.getChild(0).getText();
        }
        return "";
    }

    // Returns the operator as a string
    String getOperator(HOMEParser.ExpressionContext expressionContext)
    {
        if (expressionContext.expression().size() == 1)
        {
            return expressionContext.getChild(0).getText();
        }
        else
        {
            return expressionContext.getChild(1).getText();
        }
    }

    // Handling of the assignments operators +=, -=, *=, /= and %=
    private void visitAnyassignment(ParserRuleContext ctx, TerminalNode terminalNode, SymbolInfo variable, Statements stmts)
    {
        if (terminalNode == null)
        {
            return;
        }

        String typeName;

        if (variable.var.type instanceof CollectionType)
        {
            typeName = ((CollectionType) variable.var.type).getInnermostType().name;
        }
        else
        {
            typeName = variable.var.type.name;
        }

        StringBuilder sassignment = new StringBuilder();
        switch (typeName)
        {
            case "Integer":
                sassignment.append("i");
                break;
            case "Decimal":
                sassignment.append("d");
                break;
        }

        switch (terminalNode.getText())
        {
            case "+=":
                sassignment.append("add");
                break;
            case "-=":
                sassignment.append("sub");
                break;
            case "*=":
                sassignment.append("mul");
                break;
            case "/=":
                sassignment.append("div");
                break;
            case "%=":
                sassignment.append("rem");
                break;
        }
        stmts.add(sassignment.toString(), ctx);
    }

    // Determines literal, identifier or field  and adds it value to operator stack
    ExpressionReturn checkExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, boolean convertingFlag)
    {
        if (ctx.expression(0).literal() != null)
        {
            if (ctx.expression(0).literal().IntegerLiteral() != null)
            {
                ExpressionReturn _return = visitLiteral(ctx.expression(0).literal(), stmts, convertingFlag);
                visitNegate(ctx, stmts, _return, convertingFlag);
                return _return;
            }
            else if (ctx.expression(0).literal().DecimalLiteral() != null)
            {
                ExpressionReturn _return = visitLiteral(ctx.expression(0).literal(), stmts, false);
                visitNegate(ctx, stmts, _return, convertingFlag);
                return _return;
            }
            else if (ctx.expression(0).literal().StringLiteral() != null)
            {
                return visitLiteral(ctx.expression(0).literal(), stmts, false);
            }
            else if (ctx.expression(0).literal().booleanLiteral() != null)
            {
                return visitLiteral(ctx.expression(0).literal(), stmts, false);
            }
            else
            {
                return null;
            }
        }
        else if (ctx.expression(0).identifier() != null)
        {
            ExpressionReturn _return = visitIdentifier(ctx.expression(0).identifier(), stmts, convertingFlag);
            visitNegate(ctx, stmts, new ExpressionReturn(symbolTable.variables.getType(_return.returnValue), ""), convertingFlag);
            return _return;
        }
        else if (ctx.expression(0).field() != null)
        {
            ExpressionReturn _return = visitField(ctx.expression(0).field(), stmts, convertingFlag);
            visitNegate(ctx, stmts, new ExpressionReturn(_return.type, ""), convertingFlag);
            return _return;
        }
        else
        {
            ExpressionReturn _return = visitExpression(ctx.expression(0), stmts, null, convertingFlag);
            visitNegate(ctx, stmts, _return, convertingFlag);
            return _return;
        }
    }

    // Determines and adds the operators for a comparison of 2 literal
    Type visitOperator(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, Type type)
    {


        String label1 = null;
        String label2 = null;

        String operator = getOperator(ctx);

        if (type.equals(Main.string))
        {
            switch (operator)
            {
                case "+":
                    stmts.LocalInc();
                    stmts.add("astore " + (stmts.currentLocal() + 1), ctx);
                    stmts.add("astore " + stmts.currentLocal(), ctx);
                    stmts.add("new java/lang/StringBuilder", ctx);
                    stmts.add("dup", ctx);
                    stmts.add("invokespecial java/lang/StringBuilder.<init>()V", ctx);
                    stmts.add("aload " + stmts.currentLocal(), ctx);
                    stmts.add("invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;", ctx);
                    stmts.add("aload " + (stmts.currentLocal() + 1), ctx);
                    stmts.add("invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;", ctx);
                    stmts.add("invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;", ctx);
                    stmts.LocalInc();
                    return type;

                case "==":
                    stmts.add("invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z", ctx);
                    return Main.bool;
            }
        }

        String typePrefix = "";
        if (type.equals(Main.integer))
        {
            typePrefix = "i";
        }
        else if (type.equals(Main.decimal))
        {
            typePrefix = "d";
        }

        switch (operator)
        {
            case "+":
                stmts.add(typePrefix + "add", ctx);
                return type;
            case "-":
                stmts.add(typePrefix + "sub", ctx);
                return type;
            case "*":
                stmts.add(typePrefix + "mul", ctx);
                return type;
            case "/":
                stmts.add(typePrefix + "div", ctx);
                return type;
            case "%":
                stmts.add(typePrefix + "rem", ctx);
                return type;
            default:
                label1 = symbolTable.newLabel();
                label2 = symbolTable.newLabel();
                if (type.equals(Main.integer) || type.equals(Main.bool))
                {
                    //region more code...
                    switch (operator)
                    {
                        case "==":
                            stmts.add("if_icmpne " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "!=":
                            stmts.add("if_icmpeq " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add("" + label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "<=":
                            stmts.add("if_icmpgt " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "<":
                            stmts.add("if_icmpge " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case ">=":
                            stmts.add("if_icmplt " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case ">":
                            stmts.add("if_icmple " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                    }
                    //endregion
                }
                else if (type.equals(Main.decimal))
                {
                    //region more code...
                    switch (operator)
                    {
                        case "==":
                            stmts.add("dcmpl", ctx);
                            stmts.add("ifne " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "!=":
                            stmts.add("dcmpl", ctx);
                            stmts.add("ifeq " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add("" + label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "<=":
                            stmts.add("dcmpl", ctx);
                            stmts.add("ifgt " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "<":
                            stmts.add("dcmpl", ctx);
                            stmts.add("ifge " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case ">=":
                            stmts.add("dcmpl", ctx);
                            stmts.add("iflt " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case ">":
                            stmts.add("dcmpl", ctx);
                            stmts.add("ifle " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        //endregion
                    }
                }

                if (type.equals(Main.bool))
                {
                    //region more code...
                    switch (operator)
                    {
                        case "AND":
                            stmts.LocalInc();
                            stmts.add("istore " + stmts.currentLocal(), ctx);
                            stmts.add("ifeq " + label1, ctx);
                            stmts.add("iload " + stmts.currentLocal(), ctx);
                            stmts.add("ifeq " + label1, ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add("goto " + label2, ctx);
                            stmts.add(label1 + ":", ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add(label2 + ":", ctx);
                            return Main.bool;
                        case "OR":
                            stmts.LocalInc();
                            stmts.add("istore " + stmts.currentLocal(), ctx);
                            stmts.add("ifne " + label2, ctx);
                            stmts.add("iload " + stmts.currentLocal(), ctx);
                            stmts.add("ifne " + label2, ctx);
                            stmts.add("iconst_0", ctx);
                            stmts.add("goto " + label1, ctx);
                            stmts.add(label2 + ":", ctx);
                            stmts.add("iconst_1", ctx);
                            stmts.add(label1 + ":", ctx);
                            return Main.bool;
                    }
                    //endregion
                }
        }

        return null;
    }

    // Determines and adds the operator for a if-stmt and set its goto label
    Type visitOperator(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, Type type, String label)
    {
        String operator = getOperator(ctx);

        if (type.equals(Main.integer) || type.equals(Main.bool))
        {
            //region more code...
            switch (operator)
            {
                case "==":
                    stmts.add("if_icmpeq " + label, ctx);
                    return Main.bool;
                case "!=":
                    stmts.add("if_icmpne " + label, ctx);
                    return Main.bool;
                case "<=":
                    stmts.add("if_icmple " + label, ctx);
                    return Main.bool;
                case "<":
                    stmts.add("if_icmplt " + label, ctx);
                    return Main.bool;
                case ">=":
                    stmts.add("if_icmpge " + label, ctx);
                    return Main.bool;
                case ">":
                    stmts.add("if_icmpgt " + label, ctx);
                    return Main.bool;
            }
            //endregion
        }
        else if (type.equals(Main.decimal))
        {
            //region more code...
            switch (operator)
            {
                case "==":
                    stmts.add("dcmpl", ctx);
                    stmts.add("ifeq " + label, ctx);
                    return Main.bool;
                case "!=":
                    stmts.add("dcmpl", ctx);
                    stmts.add("ifne " + label, ctx);
                    return Main.bool;
                case "<=":
                    stmts.add("dcmpl", ctx);
                    stmts.add("ifle " + label, ctx);
                    return Main.bool;
                case "<":
                    stmts.add("dcmpl", ctx);
                    stmts.add("iflt " + label, ctx);
                    return Main.bool;
                case ">=":
                    stmts.add("dcmpl", ctx);
                    stmts.add("ifge " + label, ctx);
                    return Main.bool;
                case ">":
                    stmts.add("dcmpl", ctx);
                    stmts.add("ifgt " + label, ctx);
                    return Main.bool;
            }
            //endregion
        }
        else if (type.equals(Main.string))
        {
            switch (operator)
            {
                case "==":
                    stmts.add("invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z", ctx);
                    stmts.add("ifne " + label, ctx);
                    return Main.bool;
            }
        }


        if (type.equals(Main.bool))
        {
            //region more code...
            String label1 = symbolTable.newLabel();
            switch (operator)
            {
                case "AND":
                    stmts.LocalInc();
                    stmts.add("istore " + stmts.currentLocal(), ctx);
                    stmts.add("ifeq " + label1, ctx);
                    stmts.add("iload " + stmts.currentLocal(), ctx);
                    stmts.add("ifeq " + label1, ctx);
                    stmts.add("goto " + label, ctx);
                    stmts.add(label1 + ":", ctx);
                    return Main.bool;
                case "OR":
                    stmts.LocalInc();
                    stmts.add("istore " + stmts.currentLocal(), ctx);
                    stmts.add("ifne " + label, ctx);
                    stmts.add("iload " + stmts.currentLocal(), ctx);
                    stmts.add("ifne " + label, ctx);
                    return Main.bool;
            }
            //endregion
        }

        return null;
    }


    // Check that the the actual type of r1 and r2 are identical.
    // If not identical it will return null and it will most likely resolve in a NullPointerException
    Type compareTypes(ExpressionReturn r1, ExpressionReturn r2)
    {
        if (r1.equals(r2)) {
            return r1.actualType;
        }
        return null;
    }


    //endregion

    //region Literal

    // Determines which kind of literal should be added to the stack
    ExpressionReturn visitLiteral(@NotNull HOMEParser.LiteralContext ctx, Statements stmts, boolean convertingFlag)
    {
        ExpressionReturn returnType = null;

        if (ctx.IntegerLiteral() != null)
        {
            if (convertingFlag)
                returnType = new ExpressionReturn(Main.decimal, ctx.getText());
            else
                returnType = new ExpressionReturn(Main.integer, ctx.getText());
            addLiteral(ctx, stmts, returnType, convertingFlag);
        }
        else if (ctx.booleanLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.bool, ctx.getText());
            String booleanReturnValue = returnType.returnValue;
            if (booleanReturnValue.equals("true"))
                stmts.add("iconst_1", ctx);
            else
                stmts.add("iconst_0", ctx);
        }
        else if (ctx.DecimalLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.decimal, ctx.getText());
            addLiteral(ctx, stmts, returnType, convertingFlag);
        }
        else if (ctx.StringLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.string, ctx.getText());
            stmts.add("ldc " + returnType.returnValue, ctx);
        }
        else if (ctx.listLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.list, ctx.getText());
            visitListLiteral(ctx.listLiteral(), stmts);
        }
        else if (ctx.dictionaryLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.dictionary, ctx.getText());
            visitDictionaryLiteral(ctx.dictionaryLiteral(), stmts);

        }
        return returnType;
    }

    // Adds at literal value to the operator stack
    void addLiteral(ParserRuleContext ctx, Statements stmts, ExpressionReturn literal, boolean convertingFlag)
    {
        // Adds a value of type integer
        if (literal.type == Main.integer && !convertingFlag)
        {
            int value = Integer.valueOf(literal.returnValue);
            if (value < 0)
            {
                value++;
            } // ensures fx -128 also uses bipush just like 127 would ( not 128 though )
            value = Math.abs(value);
            if (value > Math.pow(2, 31) - 1)
            {
                // TODO throw error -> Integer too big
            }
            else if (value > Math.pow(2, 15) - 1)
            {
                stmts.add("ldc " + literal.returnValue, ctx); // can be optimized with bipush when below 127
            }
            else if (value > Math.pow(2, 7) - 1)
            {
                stmts.add("sipush " + literal.returnValue, ctx); // can be optimized with bipush when below 127
            }
            else
            {
                stmts.add("bipush " + literal.returnValue, ctx); // can be optimized with bipush when below 127
            }
        }

        // Adds a value of type decimal if it is integer value that needs to be converted to decimal
        else if (literal.type == Main.integer && convertingFlag)
        {
            double value = Double.valueOf(literal.returnValue);
            if (value == 0.0d)
            {
                stmts.add("dconst_0", ctx);
            }
            else if (value == 1.0d)
            {
                stmts.add("dconst_1", ctx);
            }
            else
            {
                stmts.add("ldc2_w " + literal.returnValue + ".d", ctx); // check if .0d notation works or 2.d
            }
        }
        // Adds a value of type decimal
        else if (literal.type == Main.decimal)
        {
            double value = Double.valueOf(literal.returnValue);
            if (value == 0.0d)
            {
                stmts.add("dconst_0", ctx);
            }
            else if (value == 1.0d)
            {
                stmts.add("dconst_1", ctx);
            }
            else
            {
                if (literal.returnValue.contains("."))
                    stmts.add("ldc2_w " + literal.returnValue + "d", ctx); // check if .0d notation works or 2.d
                else
                    stmts.add("ldc2_w " + literal.returnValue + ".d", ctx);
            }
        }
        // Adds a reference to a string
        else if (literal.type == Main.string)
        {
            stmts.add("ldc " + literal.returnValue, ctx);
        }
    }

    //endregion

    //region List and Dictionary

    void visitListLiteral(@NotNull HOMEParser.ListLiteralContext ctx, Statements stmts)
    {
        stmts.add("new java/util/ArrayList", ctx);
        stmts.add("dup", ctx);
        stmts.add("invokespecial java/util/ArrayList.<init>()V", ctx);
        stmts.LocalInc();
        stmts.add("astore " + stmts.currentLocal(), ctx);
        Integer local = stmts.currentLocal();

        for (int i = 0; i < ctx.expression().size(); i++)
        {
            HOMEParser.ExpressionContext expressionContext = ctx.expression(i);
            if (expressionContext.literal() == null)
            {
                stmts.add("aload " + stmts.currentLocal(), ctx);
                visitExpression(ctx.expression(i), stmts).invokeToObject(ctx, stmts);
                stmts.add("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2", ctx);
                stmts.add("pop", ctx);
            }
            else if (expressionContext.literal().listLiteral() == null && expressionContext.literal().dictionaryLiteral() == null)
            {
                stmts.add("aload " + stmts.currentLocal(), ctx);
                ExpressionReturn returnExpression = visitExpression(expressionContext, stmts);

                returnExpression.invokeToObject(ctx, stmts);

                stmts.add("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2", ctx);
                stmts.add("pop", ctx);
            }
            else
            {
                visitExpression(expressionContext, stmts);
                stmts.add("aload " + local, ctx);
                stmts.add("aload " + (local + i + 1), ctx);
                stmts.add("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2", ctx);
                stmts.add("pop", ctx);
            }
        }
    }


    // This function is called when we have a Declaration or Assignment with any elements in the expression,
    // this results in the need to create the List from the definition of the input itself,
    // meaning that the input: "List<List<Integer>> aList = {{}}" creates a List within a List without any elements
    private void buildList(ParserRuleContext ctx, Statements stmts, CollectionType symbolType, int depth)
    {
        stmts.add("new java/util/ArrayList", ctx);
        stmts.add("dup", ctx);
        stmts.add("invokespecial java/util/ArrayList.<init>()V", ctx);
        stmts.add("astore " + stmts.nextLocal(), ctx);
        stmts.LocalInc();
        int local = stmts.currentLocal();
        depth--;
        if (depth != 0)
        {
            if (((CollectionType) symbolType.innerType).primaryType.equals(Main.list))
                buildList(ctx, stmts, (CollectionType) symbolType.innerType, depth);
            else
                buildDictionary(ctx, stmts, (CollectionType) symbolType.innerType, depth);

            stmts.add("aload " + local, ctx);
            stmts.add("aload " + (local + 1), ctx);
            stmts.add("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2", ctx);
            stmts.add("pop", ctx);
        }
    }

    private void visitDictionaryLiteral(HOMEParser.DictionaryLiteralContext ctx, Statements stmts)
    {
        stmts.add("new java/util/HashMap", ctx);
        stmts.add("dup", ctx);
        stmts.add("invokespecial java/util/HashMap.<init>()V", ctx);
        stmts.add("astore " + stmts.nextLocal(), ctx);
        stmts.LocalInc();
        Integer local = stmts.currentLocal();

        for (int i = 0; i < ctx.dictionaryEntry().size(); i++)
        {
            HOMEParser.DictionaryEntryContext dictionaryEntryContext = ctx.dictionaryEntry(i);
            stmts.add("aload " + local, ctx);
            visitExpression(dictionaryEntryContext.expression(0), stmts);
            ExpressionReturn expressionReturn = visitExpression(dictionaryEntryContext.expression(1), stmts);
            HOMEParser.ExpressionContext expressionContext = dictionaryEntryContext.expression(1);

            if (expressionContext.literal() != null)
            {
                if (expressionContext.literal().dictionaryLiteral() == null && expressionContext.literal().listLiteral() == null)
                {
                    expressionReturn.invokeToObject(ctx, stmts);

                    stmts.add("invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", ctx);
                    stmts.add("pop", ctx);
                }
                else
                {
                    stmts.add("aload " + (local + i + 1), ctx);
                    stmts.add("invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", ctx);
                    stmts.add("pop", ctx);
                }
            }
            else
            {

                expressionReturn.invokeToObject(ctx, stmts);
                stmts.add("invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", ctx);
                stmts.add("pop", ctx);
            }
        }
    }

    // This function is called when we have a Declaration or Assignment with any elements in the expression,
    // this results in the need to create the Dictionary from the definition of the input itself,
    // meaning that the input: "List<Dictionary<Integer>> aList = {{}}" creates a Dictionary within a List without any elements
    private void buildDictionary(ParserRuleContext ctx, Statements stmts, CollectionType symbolType, int depth)
    {
        stmts.add("new java/util/HashMap", ctx);
        stmts.add("dup", ctx);
        stmts.add("invokespecial java/util/HashMap.<init>()V", ctx);
        stmts.add("astore " + stmts.nextLocal(), ctx);
        stmts.LocalInc();
        depth--;
        if (depth != 0)
        {
            if (((CollectionType) symbolType.innerType).primaryType.equals(Main.list))
                buildList(ctx, stmts, (CollectionType) symbolType.innerType, depth);
            else
                buildDictionary(ctx, stmts, (CollectionType) symbolType.innerType, depth);
        }
    }

    // Check whether an expression on the right side contains any input and returns the depth of the expression. Case: List<Integer> = {}
    private int emptyInit(HOMEParser.LiteralContext ctx, int currDepth)
    {
        // if it returns -1, the expression/LiteralContext contains values. Otherwise it returns the depth of the list/dictionary
        if (ctx != null)
        {
            if (ctx.dictionaryLiteral() != null)
            {
                if (ctx.dictionaryLiteral().dictionaryEntry() == null)
                {
                    return currDepth;
                }
                else
                {
                    return -1;
                }
            }
            else if (ctx.listLiteral() != null)
            {
                if (ctx.listLiteral().expression().size() > 0)
                {
                    if (ctx.listLiteral().expression(0).literal() != null)
                    {
                        return currDepth = emptyInit(ctx.listLiteral().expression(0).literal(), currDepth + 1);
                    }
                }
                else
                {
                    return currDepth;
                }
            }
        }
        return -1;
    }

    //endregion

}
