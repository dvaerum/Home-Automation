package HOME.CodeGene;

import HOME.ForkReturnStack;
import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import HOME.Main;
import HOME.Type.CollectionType;
import HOME.Type.Type;
import HOME.SymbolTable.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ByteCodeVisitor extends HOMEBaseVisitor
{

    SymbolTable symbolTable = Main.symbolTable;
    ForkReturnStack forkReturnStack = new ForkReturnStack();

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
            stmts.addStatement("aload_0");
            stmts.addStatement("invokespecial java/lang/Object/<init>()V");
            _end = ".end method";
        }

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
        private String _return;
        private String _end;

        public Function(String _begin, String _end)
        {
            this._begin = _begin;
            this._return = "";
            this._end = _end;
        }

        public Function(String _begin, String _return, String _end)
        {
            this._begin = _begin;
            this._return = _return;
            this._end = _end;
        }

        public void build()
        {
            Write(this._begin);
            stmts.build();
            Write(this._end);
            Write("");
        }
    }

    // Statements are organized and added here, this is mainly used as a parameters
    // when travelling trough the visitor
    public class Statements
    {
        private int limit_stack;
        private int limit_locale;
        private ArrayList<String> statements;

        public Statements()
        {
            this.statements = new ArrayList<>();
            this.limit_stack = 32; // TODO change to improve performance
            this.limit_locale = 0;
        }

        public Statements(int limit_stack)
        {
            this.statements = new ArrayList<>();
            this.limit_stack = limit_stack;
            this.limit_locale = 0;
        }

        public void addStatement(String statement)
        {
            this.statements.add(statement);
        }

        public void addLocal(int limit)
        {
            this.limit_locale += limit;
        }

        public int nextLocal()
        {
            return this.limit_locale + 1;
        }

        public int currentLocal()
        {
            return this.limit_locale;
        }

        public void build()
        {
            Write(String.format("    " + ".limit stack %d", this.limit_stack < 10 ? this.limit_stack + 10 : this.limit_stack));
            Write(String.format("    " + ".limit locals %d", this.limit_locale + 1));
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
            return this.type.equals(epxR.type);
        }

        public boolean equals(Type epxR)
        {
            return this.type.equals(epxR);
        }

        public void invokeToObject(Statements stmts)
        {
            String typeName;
            if (this.type == Main.variable)
            {
                typeName = this.actualType.name;
            }
            else
            {
                typeName = this.type.name;
            }

            switch (typeName)
            {
                case "Integer":
                    stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                    break;
                case "Decimal":
                    stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
                    break;
                case "Boolean":
                    stmts.addStatement("invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;");
                    break;
            }
        }
    }

    Function setup;
    GlobalVariables globalVariables;
    private ArrayList<Function> functions = new ArrayList<>();

    private FileOutputStream newClass;

    // The constructor of the bytecode visitor only generates the shell of the Jasmin J file.
    // The ByteCodeVisitor can then visit(ParseTree) from the HOMEBaseVisitor which in turn
    // runs through our entire code depending on the nodes attached to the tree.
    public ByteCodeVisitor()
    {
        globalVariables = new GlobalVariables();
    }

    // The build method expects that the entire tree has already been visited and can therefore
    // write to the Jasmin J file corresponding to the results build
    public void build() throws IOException
    {
        String cwd = new File("").getAbsolutePath();

        File newClassFile = new File(cwd + "/HOME/CodeGene/" + "Output_test.j");
        newClass = new FileOutputStream(newClassFile);

        Scanner metaClass = new Scanner(new File("HOME/CodeGene/Frame"));
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

    protected void Write(String out)
    {
        System.out.println(out);
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

    @Override
    public Object visitNewline(@NotNull HOMEParser.NewlineContext ctx)
    {
        symbolTable.newLine();
        return super.visitNewline(ctx);
    }

    @Override
    public Object visitGlobal(@NotNull HOMEParser.GlobalContext ctx)
    {
        // Declaration
        if (ctx.declaration() != null)
        {
            Type symbolType = symbolTable.types.getSymbol(ctx.declaration().type().getText());
            String identifier = ctx.declaration().identifier().getText();
            String declaration = String.format(".field public %s %s", identifier, returnTypeForFunction(symbolType));// = <value>";

            globalVariables.fields.add(declaration);
            globalVariables.stmts.addStatement("aload_0");
            visitDeclaration(ctx.declaration(), globalVariables.stmts);
        }
        return super.visitGlobal(ctx);
    }

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
//            this.setup = new Function(".method public static main([Ljava/lang/String;)V",
//                    ".end method");
            this.setup = new Function(".method public Setup()V", ".end method");
            setup.stmts = new Statements();

            Function mainFunc = new Function(".method public static main([Ljava/lang/String;)V",
                    ".end method");

            mainFunc.stmts = new Statements();

            Statements mainStmts = mainFunc.stmts;

            mainStmts.addStatement("new HOME");
            mainStmts.addStatement("dup");
            mainStmts.addStatement("invokespecial HOME/<init>()V");
            mainStmts.addStatement("invokespecial HOME/Setup()V");
            mainStmts.addStatement("return");

            this.functions.add(mainFunc);

            visitStmts(ctx.stmts(), setup.stmts);

            func = setup;
        }
        else
        {
            String parameters;
            Statements stmts = new Statements(1);
            parameters = visitDeclarationParameters(ctx.declarationParameters(), stmts);

            String returnsType;
            if (ctx.nothing() != null)
            {
                returnsType = "V";
            }
            else
            {
                Type type = symbolTable.types.getSymbol(ctx.type().getText());
                returnsType = returnTypeForFunction(type);
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

        return super.visitFunction(ctx);
    }

    public String returnTypeForFunction(Type type)
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

//region Stmts

    public void visitStmts(@NotNull HOMEParser.StmtsContext ctx, Statements stmts)
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

    public void visitStmt(@NotNull HOMEParser.StmtContext ctx, Statements stmts)
    {
        // TODO just a test
        symbolTable.newLine();
        stmts.addStatement(symbolTable.getLineNumberText());

        if (ctx.declaration() != null)
        {
            visitDeclaration(ctx.declaration(), stmts);
        }
        else if (ctx.assign() != null)
        {
            visitAssign(ctx.assign(), stmts);
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
            visitVariableMethodCall(ctx.variableMethodCall(), stmts);
        }
        else if (ctx.incDec() != null)
        {
            visitIncDec(ctx.incDec(), stmts);
        }
        else if (ctx.returnFunction() != null)
        {
            visitReturnFunction(ctx.returnFunction(), stmts);
        }
        else if (ctx.ifStmt() != null)
        {
            visitIfStmt(ctx.ifStmt(), stmts);
        }
    }

    public void visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx, Statements stmts)
    {
        String type = ctx.type().getText();
        type = type.replaceAll("<.+>", "");
        // TODO check if there is are any expressions on Declaration
        CollectionType symbolType;
        SymbolInfo variable;

        switch (type)
        {
            case "Integer":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.integer, stmts.currentLocal());
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts); // TODO Add visitExpression
                }
                else
                {
                    stmts.addStatement("iconst_0");
                }
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                variable.store(stmts);
                break;

            case "Decimal":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.decimal, stmts.currentLocal());
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.addStatement("dconst_0");
                }
                stmts.addStatement("dstore " + stmts.currentLocal());
                stmts.addLocal(1);
                break;

            case "String":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.string, stmts.currentLocal());
                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.addStatement("ldc \"\"");
                }
                stmts.addStatement("astore " + stmts.currentLocal());
                break;

            case "Boolean":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.bool, stmts.currentLocal());

                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.addStatement("iconst_0");
                }
                stmts.addStatement("istore " + stmts.currentLocal());
                break;

            case "List":
                symbolType = (CollectionType) symbolTable.types.getSymbol(ctx.type().getText());
                int currentLocal = stmts.nextLocal();
                if (ctx.expression() != null)
                {
                    if (ctx.expression().literal() != null)
                    {
                        int depth = emptyInit(ctx.expression().literal(), 1);
                        //If depth equals -1, then it contains something
                        if (depth == -1)
                        {
                            visitExpression(ctx.expression(), stmts);
                        }
                        else
                        {
                            buildList(stmts, symbolType, depth);
                        }
                    }
                    else
                    {
                        // Here we do not re-use the list
                        visitExpression(ctx.expression(), stmts);
                        stmts.addStatement("astore " + currentLocal);
                        stmts.addLocal(1);
                    }
                }
                else
                {
                    buildList(stmts, symbolType, 1);
                }
                symbolTable.variables.addSymbol(ctx.identifier().getText(), symbolType, currentLocal);
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                if (variable.depth == 0)
                {
                    stmts.addStatement("aload " + variable.var.location);
                    variable.store(stmts);
                }
                break;

            case "Dictionary":
                symbolType = (CollectionType) symbolTable.types.getSymbol(ctx.type().getText());
                int currentLocal2 = stmts.nextLocal();
                if (ctx.expression() != null)
                {
                    //If depth equals -1, then it contains something
                    if (ctx.expression().literal() != null)
                    {
                        int depth2 = emptyInit(ctx.expression().literal(), 1);
                        //If depth equals -1, then it contains something
                        if (depth2 == -1)
                        {
                            visitExpression(ctx.expression(), stmts);
                        }
                        else
                        {
                            buildDictionary(stmts, symbolType, depth2);
                        }
                    }
                    else
                    {
                        // Here we do not re-use the list
                        visitExpression(ctx.expression(), stmts);
                        stmts.addStatement("astore " + currentLocal2);
                        stmts.addLocal(1);
                    }
                }
                else
                {
                    buildDictionary(stmts, symbolType, 1);
                }
                symbolTable.variables.addSymbol(ctx.identifier().getText(), symbolType, currentLocal2);
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                if (variable.depth == 0)
                {
                    stmts.addStatement("aload " + variable.var.location);
                    variable.store(stmts);
                }
                break;

            default:
                stmts.addLocal(1);
                String className = ctx.type().getText();
                Type symbol = symbolTable.types.getSymbol(className);
                SymbolInfo symbolInfoClass = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), symbol, stmts.currentLocal());

                if (ctx.expression() != null)
                {
                    visitExpression(ctx.expression(), stmts);
                }
                else
                {
                    stmts.addStatement("aconst_null");
                }

                symbolInfoClass.store(stmts);

                break;
        }
    }

    public String visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx, Statements stmts)
    {
        if (ctx == null)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (HOMEParser.DeclarationContext dec : ctx.declaration())
        {
            String t = dec.type().getText().trim();
            Type type = Main.symbolTable.types.getSymbol(t);

            Integer location = stmts.nextLocal();

            if (type.equals(Main.decimal))
            {
                stmts.addLocal(2);
            }
            else
            {
                stmts.addLocal(1);
            }
            symbolTable.variables.addSymbol(dec.identifier().getText(), type, location);
            //visitDeclaration(dec, stmts);

            sb.append(Main.symbolTable.types.getSymbol(t).getSimpleByteCode());
        }

        return sb.toString();
    }

    public void visitAssign(@NotNull HOMEParser.AssignContext ctx, Statements stmts)
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
                        variable.load(stmts);
                    }
                    visitExpression(ctx.expression(), stmts);
                    visitAnyAssign(ctx.AnyAssign(), variable, stmts);
                    stmts.addStatement("istore " + variable.var.location);
                    break;
                case "Decimal":
                    if (ctx.AnyAssign() != null)
                    {
                        variable.load(stmts);
                    }
                    visitExpression(ctx.expression(), stmts);
                    visitAnyAssign(ctx.AnyAssign(), variable, stmts);
                    stmts.addStatement("dstore " + variable.var.location);
                    break;
                case "String":
                    visitExpression(ctx.expression(), stmts);

                    break;
                case "List":
                    CollectionType symbolType = (CollectionType) variable.var.type;
                    int currentLocal = stmts.nextLocal();
                    // TODO make it work with fields as well
                    if (ctx.expression() != null)
                    {
                        if (ctx.expression().literal() != null)
                        {
                            int depth = emptyInit(ctx.expression().literal(), 1);
                            //If depth equals -1, then it contains something
                            if (depth == -1)
                            {
                                visitExpression(ctx.expression(), stmts);
                                stmts.addStatement("aload " + currentLocal);
                            }
                            else
                            {
                                buildList(stmts, symbolType, depth);
                                stmts.addStatement("aload " + currentLocal);
                            }
                        }
                        else
                        {
                            // Here we do not re-use the list and it is therefore on the stack, no need to aload
                            visitExpression(ctx.expression(), stmts);
                            if (variable.depth != 0)
                            {
                                stmts.addLocal(1);
                                currentLocal++;
                            }
                        }
                    }
                    else
                    {
                        buildList(stmts, symbolType, 1);
                        stmts.addStatement("aload " + currentLocal);
                    }
                    variable.store(stmts);
                    break;
                case "Dictionary":
                    symbolType = (CollectionType) variable.var.type;
                    currentLocal = stmts.nextLocal();
                    // TODO make it work with fields as well
                    if (ctx.expression() != null)
                    {
                        if (ctx.expression().literal() != null)
                        {
                            int depth = emptyInit(ctx.expression().literal(), 1);
                            //If depth equals -1, then it contains something
                            if (depth == -1)
                            {
                                visitExpression(ctx.expression(), stmts);
                                stmts.addStatement("aload " + currentLocal);
                            }
                            else
                            {
                                buildDictionary(stmts, symbolType, depth);
                                stmts.addStatement("aload " + currentLocal);
                            }
                        }
                        else
                        {
                            // Here we do not re-use the list and it is therefore on the stack, no need to aload
                            visitExpression(ctx.expression(), stmts);
                            if (variable.depth != 0)
                            {
                                stmts.addLocal(1);
                                currentLocal++;
                            }
                        }
                    }
                    else
                    {
                        buildDictionary(stmts, symbolType, 1);
                        stmts.addStatement("aload " + currentLocal);
                    }
                    variable.store(stmts);
                    break;
                default:
                    visitExpression(ctx.expression(), stmts);
                    stmts.addStatement("astore " + variable.var.location);
                    break;
            }
        }
        else if (ctx.listIndex() != null)
        {
            // list[0][0] = 77
            CollectionType type = (CollectionType) symbolTable.variables.getType(ctx.listIndex().IdentifierExact().getText());
            SymbolInfo symbol = symbolTable.variables.getSymbol(ctx.listIndex().IdentifierExact().getText());

//            symbol.load(stmts);

            /*List<HOMEParser.ExpressionContext> expressionContexts = ctx.listIndex().expression();
            for (Integer i = 0; i < expressionContexts.size() - 1; i++)
            {
                visitExpression(expressionContexts.get(i), stmts);
                stmts.addStatement("invokevirtual java/util/ArrayList/get(I)Ljava/lang/Object;");
                stmts.addStatement("checkcast java/util/ArrayList");
                type = (CollectionType) type.innerType;
            }
            HOMEParser.ExpressionContext exp = expressionContexts.get(expressionContexts.size() - 1);
            visitExpression(exp, stmts);*/

            visitExpression(ctx.expression(), stmts);

            switch (type.innerType.name)
            {
                case "String":
                    break;
                case "Integer":
                    stmts.addStatement("invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                    break;
                case "Decimal":
                    stmts.addStatement("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;");
                    break;
                case "Boolean":
                    stmts.addStatement("invokestatic java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;");
                    break;
                case "List":
                    break;
                case "Dictionary":
                    break;
            }
            switch (type.primaryType.name)
            {
                case "List":
                    stmts.addStatement(String.format("invokevirtual %s.set(%sLjava/lang/Object;)Ljava/lang/Object;", Main.list.getClassByteCode(), Main.integer.getSimpleByteCode())); // TODO replace '%r' if this doesn't work for everything
                    break;
                case "Dictionary":
                    stmts.addStatement(String.format("invokevirtual %s.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", Main.dictionary.getClassByteCode())); // TODO replace '%r' if this doesn't work for everything
                    break;
            }
            stmts.addStatement("pop");
        }
        else if (ctx.field() != null)
        {
            SymbolInfo symbolClassInfo = symbolTable.variables.getSymbol(ctx.field().identifier().getText());
            Type fieldType = symbolClassInfo.var.type.getFieldByName(ctx.field().IdentifierExact().getText()).type;
            String fieldname = ctx.field().IdentifierExact().getText();

            symbolClassInfo.load(stmts);

            visitExpression(ctx.expression(), stmts);

            stmts.addStatement(String.format("putfield %s/%s %s",
                    symbolClassInfo.var.type.getClassByteCode(),
                    fieldname,
                    fieldType.getSimpleByteCode()));
        }
    }

    public void visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx, Statements stmts)
    {
        forkReturnStack.newStack();
        forkReturnStack.addFork();
        int tempReturns = 0;
        boolean usingEndLabel = false;

        String ifLabel = symbolTable.newLabel();

        visitExpression(ctx.expression(), stmts, ifLabel);

        List<HOMEParser.ElseIfStmtContext> elseif = ctx.elseIfStmt();

        ArrayList<String> elseifLabel = new ArrayList<>();
        for (int i = 0; i < elseif.size(); i++)
        {
            elseifLabel.add(symbolTable.newLabel());

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

        if (forkReturnStack.getReturns() == tempReturns || ctx.elseStmt() == null)
        {
            stmts.addStatement("goto " + endLabel);
            usingEndLabel = true;
        }

        tempReturns = forkReturnStack.getReturns();

        stmts.addStatement(ifLabel + ":");
        visitStmts(ctx.stmts(), stmts);

        if (forkReturnStack.getReturns() == tempReturns)
        {
            stmts.addStatement("goto " + endLabel);
            usingEndLabel = true;
        }

        for (int i = 0; i < elseif.size(); i++)
        {
            tempReturns = forkReturnStack.getReturns();

            stmts.addStatement(elseifLabel.get(i) + ":");
            visitStmts(elseif.get(i).stmts(), stmts);

            if (forkReturnStack.getReturns() == tempReturns)
            {
                stmts.addStatement("goto " + endLabel);
                usingEndLabel = true;
            }
        }

        if (usingEndLabel)
        {
            stmts.addStatement(endLabel + ":");
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


        //  return super.visitIfStmt(ctx);
    }

    public Object visitLoop(@NotNull HOMEParser.LoopContext ctx, Statements statements)
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

        return super.visitLoop(ctx);
    }

    public void visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx, Statements stmts)
    {
        visitExpression(ctx.expression(), stmts);

        SymbolInfo symbolInfoOfVariable;
        if (ctx.expression().listIndex() != null)
        {
            symbolInfoOfVariable = symbolTable.variables.getSymbol(ctx.expression().listIndex().IdentifierExact().getText());
        }
        else
        {
            symbolInfoOfVariable = symbolTable.variables.getSymbol(ctx.expression().identifier().getText());
        }

        Type realType = symbolInfoOfVariable.var.type;

        if (realType.equals(Main.list))
        {
            stmts.addLocal(1);
            Integer iterator = stmts.currentLocal();

            Type innerType = symbolTable.types.getSymbol(ctx.type().getText());
            String labelStart = symbolTable.newLabel();
            String labelEnd = symbolTable.newLabel();

            stmts.addStatement("invokeinterface java/util/List/iterator()Ljava/util/Iterator; 1");
            stmts.addStatement("astore " + iterator);
            stmts.addStatement(labelStart + ":");
            stmts.addStatement("aload " + iterator);
            stmts.addStatement("invokeinterface java/util/Iterator/hasNext()Z 1");
            stmts.addStatement("ifeq " + labelEnd);
            stmts.addStatement("aload " + iterator);
            stmts.addStatement("invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1");
            stmts.addStatement("checkcast " + innerType.getClassByteCode());
            if (innerType.equals(Main.integer))
                stmts.addStatement("invokevirtual java/lang/Integer/intValue()I");
            if (innerType.equals(Main.decimal))
                stmts.addStatement("invokevirtual java/lang/Double/doubleValue()D");
            if (innerType.equals(Main.bool))
                stmts.addStatement("invokevirtual java/lang/Boolean/booleanValue()Z");

            stmts.addLocal(1);
            SymbolInfo symbolInfo = symbolTable.variables.addAndGetSymbol(ctx.identifier().getText(), innerType, stmts.currentLocal());

            //symbolTable.variables.getSymbol(identifier).store(stmts);
            symbolInfo.store(stmts);

            visitStmts(ctx.stmts(), stmts);

            stmts.addStatement("goto " + labelStart);
            stmts.addStatement(labelEnd + ":");
        }
        else if (realType.equals(Main.dictionary))
        {
            Integer iterator = stmts.nextLocal();
            stmts.addLocal(1);

            Type innerType = symbolTable.types.getSymbol(ctx.type().getText());
            String labelStart = symbolTable.newLabel();
            String labelEnd = symbolTable.newLabel();

            stmts.addStatement("invokevirtual java/util/HashMap/values()Ljava/util/Collection;");
            stmts.addStatement("invokeinterface java/util/Collection/iterator()Ljava/util/Iterator; 1");
            stmts.addStatement("astore " + iterator);
            stmts.addStatement(labelStart + ":");
            stmts.addStatement("aload " + iterator);
            stmts.addStatement("invokeinterface java/util/Iterator/hasNext()Z 1");
            stmts.addStatement("ifeq " + labelEnd);
            stmts.addStatement("aload " + iterator);
            stmts.addStatement("invokeinterface java/util/Iterator/next()Ljava/lang/Object; 1");
            stmts.addStatement("checkcast " + innerType.getClassByteCode());
            if (innerType.equals(Main.integer))
                stmts.addStatement("invokevirtual java/lang/Integer/intValue()I");
            if (innerType.equals(Main.decimal))
                stmts.addStatement("invokevirtual java/lang/Double/doubleValue()D");
            if (innerType.equals(Main.bool))
                stmts.addStatement("invokevirtual java/lang/Boolean/booleanValue()Z");

            stmts.addLocal(1);
            symbolTable.variables.addSymbol(ctx.identifier().getText(), innerType, stmts.currentLocal());

            String storeCode;

            switch (innerType.name)
            {
                case "Integer":
                case "Boolean":
                    storeCode = "istore";
                    break;
                case "Decimal":
                    storeCode = "dstore";
                    break;
                default:
                    storeCode = "astore";
                    break;
            }

            stmts.addStatement(storeCode + " " + stmts.currentLocal());

            visitStmts(ctx.stmts(), stmts);

            stmts.addStatement("goto " + labelStart);
            stmts.addStatement(labelEnd + ":");
        }
    }

    public Object visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx, Statements statements)
    {
        String label1 = symbolTable.newLabel();
        String label2 = symbolTable.newLabel();
        String loopType = ctx.getChild(1).getText();

        if (loopType.equalsIgnoreCase("while"))
        {
            statements.addStatement("goto " + label2);
            statements.addStatement(label1 + ":");
        }
        else if (loopType.equalsIgnoreCase("until"))
        {
            statements.addStatement(label1 + ":");
            // CHECK CONDITION. IF TRUE GOTO LABEL2);
            visitExpression(ctx.expression(), statements, label2);
        }

        // DO STUFF HERE
        visitStmts(ctx.stmts(), statements);


        if (loopType.equalsIgnoreCase("while"))
        {
            statements.addStatement(label2 + ":");
            // CHECK CONDITION. IF TRUE GOTO LABEL1);
            visitExpression(ctx.expression(), statements, label1);
        }
        else if (loopType.equalsIgnoreCase("until"))
        {
            statements.addStatement("goto " + label1);
            statements.addStatement(label2 + ":");
        }

        return super.visitLoopWhileOrUntil(ctx);
    }

    public ExpressionReturn visitFuncCall(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts, Boolean pop)
    {
        if (ctx.identifier().getText().equals("RegisterEvent"))
        {
            return visitFuncCallRegisterEvent(ctx, stmts, pop);
        }
        else
        {
            return visitFuncCallNormal(ctx, stmts, pop);
        }
    }

    public ExpressionReturn visitFuncCallNormal(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts, Boolean pop)
    {
        HOME.Type.Function function = symbolTable.functions.getSymbol(ctx.identifier().getText());

        if (function.name.equals(function.returnType.name))
        {
            stmts.addStatement("new " + function.returnType.getClassByteCode());
            stmts.addStatement("dup");
        }
        else
        {
            stmts.addStatement("aload_0");
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
            // TODO This is hard coded, nono
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
            bytecode += ")" + returnTypeForFunction(function.returnType);
        }

        stmts.addStatement(bytecode);
        if (pop && !function.returnType.equals(Main.nothing))
        {
            if (function.returnType.equals(Main.decimal))
            {
                stmts.addStatement("pop2");
            }
            else
            {
                stmts.addStatement("pop");
            }
        }

        return new ExpressionReturn(function.returnType, "");
    }

    public ExpressionReturn visitFuncCallRegisterEvent(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts, Boolean pop)
    {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.funcParameters().expression(0).field().identifier().getText());

        symbolInfo.load(stmts);
        stmts.addStatement("ldc " + "\"" + ctx.funcParameters().expression(0).field().IdentifierExact().getText() + "\"");
        stmts.addStatement("ldc " + "\"" + ctx.funcParameters().expression(1).identifier().getText() + "\"");

        String bytecode = "invokevirtual ";

        bytecode += symbolInfo.var.type.getClassByteCode();
        bytecode += "/registerEvent(";
        bytecode += Main.string.getObjectByteCode();
        bytecode += Main.string.getObjectByteCode();
        bytecode += ")V";

        stmts.addStatement(bytecode);

        return new ExpressionReturn(Main.nothing, "");
    }

    public void visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx, Statements stmts)
    {
        visitVariableMethodCall(ctx, stmts, false);
    }

    public ExpressionReturn visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.identifier().getText());

        HOME.Type.Function variableMethod = variable.var.type.getMethodByName(ctx.funcCall().identifier().getText());

        visitIdentifier(ctx.identifier(), stmts, false).invokeToObject(stmts);

        for (HOMEParser.ExpressionContext expressionContext : ctx.funcCall().funcParameters().expression())
        {
            visitExpression(expressionContext, stmts);
        }

        StringBuilder bytecode = new StringBuilder("invokevirtual ").
                append(variable.var.type.getClassByteCode()).
                append(".").append(variableMethod.name).
                append("(");

        for (Type parameter : variableMethod.parameters)
        {
            bytecode.append(parameter.getSimpleByteCode()); // TODO if this is a class, check bytecode for it.
        }

        bytecode.append(")").
                append(variableMethod.returnType.getSimpleByteCode());

        stmts.addStatement(bytecode.toString());

        if (convertingFlag)
        {
            stmts.addStatement("i2d");
        }

        return new ExpressionReturn(variableMethod.returnType, "");
    }

    public void visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx, Statements stmts)
    {
        forkReturnStack.addReturn();
        if (ctx == null || ctx.expression() == null)
        {
            stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
            stmts.addStatement("ldc \"Great Success!!\"");
            stmts.addStatement("invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V");
            stmts.addStatement("return");
        }
        else
        {
            // TODO: MAKE USE OF visitExpression
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

                    //TODO: Remove debug
                    //region Debug
                    stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    if (ctx.expression().identifier() != null)
                    {
                        symbol.load(stmts);
                    }
                    else
                    {
                        stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }
                    stmts.addStatement("invokevirtual java/io/PrintStream/println(I)V");
                    //endregion

                    stmts.addStatement("ireturn");
                    break;
                case "Decimal":

                    // TODO: Remove debug
                    //region Debug
                    stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    if (ctx.expression().identifier() != null)
                    {
                        symbol.load(stmts);
                    }
                    else
                    {
                        stmts.addStatement("ldc " + ctx.expression().literal().getText());
                    }
                    stmts.addStatement("invokevirtual java/io/PrintStream/println(D)V");
                    //endregion

                    stmts.addStatement("dreturn");
                    break;

                case "Boolean":
                    //TODO: Remove debug
                    //region Debug
                    stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    if (ctx.expression().identifier() != null)
                    {
                        symbol.load(stmts);
                    }
                    else
                    {
                        stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }
                    stmts.addStatement("invokevirtual java/io/PrintStream/println(Z)V");
                    //endregion

                    stmts.addStatement("ireturn");
                    break;

                //region Debug
                case "String":
                    // TODO: Remove debug
                    stmts.addStatement("dup");
                    stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    stmts.addStatement("swap");
                    stmts.addStatement("invokevirtual java/io/PrintStream/println(" + Main.symbolTable.types.getSymbol(type).getObjectByteCode() + ")V");


                    stmts.addStatement("areturn");
                    break;
                //endregion

                case "Nothing":
                    stmts.addStatement("return");
                    break;

                default:
                    // TODO: Remove debug
                    //region Debug
/*
                    stmts.addStatement("dup");
                    stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    stmts.addStatement("swap");
                    stmts.addStatement("invokevirtual java/io/PrintStream/println(" + Main.symbolTable.types.getSymbol(type).getObjectByteCode() + ")V");
*/
                    //endregion

                    stmts.addStatement("areturn");
                    break;
            }
        }
    }

    public Object visitIncDec(@NotNull HOMEParser.IncDecContext ctx, Statements stmts)
    {
        // TODO Identifier, check local or field
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.identifier().getText());
        int location = symbolInfo.var.location;
        Type type = symbolInfo.var.type;


        if (ctx.INC() != null)
        {
            if (type.equals(Main.integer))
            {
                stmts.addStatement("iinc " + location + " 1");
            }
            else if (type.equals(Main.decimal))
            {
                symbolInfo.load(stmts);
                stmts.addStatement("dconst_1");
                stmts.addStatement("dadd");
                symbolInfo.store(stmts);
            }
        }
        else if (ctx.DEC() != null)
        {
            if (type.equals(Main.integer))
            {
                stmts.addStatement("iinc " + location + " -1");
            }
            else if (type.equals(Main.decimal))
            {
                symbolInfo.load(stmts);
                stmts.addStatement("dconst_1");
                stmts.addStatement("dsub");
                symbolInfo.store(stmts);
            }
        }

        return super.visitIncDec(ctx);
    }

//endregion

//region Visit Expression

    public ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts)
    {
        return visitExpression(ctx, stmts, null, false);
    }

    public ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label)
    {
        return visitExpression(ctx, stmts, label, false);
    }

    public ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label, boolean convertingFlag)
    {

        if (!convertingFlag)
        {
            convertingFlag = ctx.int2dec() != null;
        }

        if (ctx.expression().size() == 2)
        {
            ExpressionReturn r1, r2;

            r1 = visitExpression(ctx.expression(0), stmts, null, convertingFlag);
            r2 = visitExpression(ctx.expression(1), stmts, null, convertingFlag);

            Type type = compareTypes(r1, r2);

            if (label == null)
            {
                type = visitOperator(ctx, stmts, type);
            }
            else
            {
                type = visitOperator(ctx, stmts, type, label);
            }

            return new ExpressionReturn(type, "");
        }
        else if (ctx.expression().size() == 1)
        {
            ExpressionReturn r1 = checkExpression(ctx, stmts, 0, convertingFlag);

            return new ExpressionReturn(r1.type, "");
        }
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

        //should never get here
        return null;
    }

//endregion

//region Visit Variables

    public ExpressionReturn visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.getText());
        Type type = variable.var.type;
        variable.load(stmts);
        if (convertingFlag)
        {
            stmts.addStatement("i2d");
        }
        return new ExpressionReturn(ctx.getText(), type);
    }

    public ExpressionReturn visitListIndex(@NotNull HOMEParser.ListIndexContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.IdentifierExact().getText());
        CollectionType type = ((CollectionType) symbolInfo.var.type);
        for (int i = 0; i < ctx.expression().size(); i++)
        {
            if (i == 0)
            {
                symbolInfo.load(stmts);
            }

            visitExpression(ctx.expression(i), stmts);

            switch (type.primaryType.name)
            {
                case "List":
                    stmts.addStatement(String.format("invokevirtual %s.get(%s)Ljava/lang/Object;", Main.list.getClassByteCode(), Main.integer.bytecode)); // TODO replace '%r' if this doesn't work for everything
                    break;
                case "Dictionary":
                    stmts.addStatement(String.format("invokevirtual %s.get(%s)Ljava/lang/Object;", Main.dictionary.getClassByteCode(), Main.object.bytecode)); // TODO replace '%r' if this doesn't work for everything
                    break;
            }

            stmts.addStatement("checkcast " + type.innerType.getClassByteCode());

            if (type.innerType.equals(Main.integer))
                stmts.addStatement("invokevirtual java/lang/Integer/intValue()I");
            if (type.innerType.equals(Main.decimal))
                stmts.addStatement("invokevirtual java/lang/Double/doubleValue()D");
            if (type.innerType.equals(Main.bool))
                stmts.addStatement("invokevirtual java/lang/Boolean/booleanValue()Z");

            if (convertingFlag)
            {
                stmts.addStatement("i2d");
            }

            if (type.innerType instanceof CollectionType)
            {
                type = (CollectionType) type.innerType;
            }
        }
        return new ExpressionReturn(type.innerType, "");
    }

    public ExpressionReturn visitField(@NotNull HOMEParser.FieldContext ctx, Statements stmts, boolean convertingFlag)
    {
        SymbolInfo symbolClassInfo = symbolTable.variables.getSymbol(ctx.identifier().getText());
        Type fieldType = symbolClassInfo.var.type.getFieldByName(ctx.IdentifierExact().getText()).type;
        String fieldname = ctx.IdentifierExact().getText();

        visitIdentifier(ctx.identifier(), stmts, convertingFlag);

        stmts.addStatement(String.format("getfield %s/%s %s",
                symbolClassInfo.var.type.getClassByteCode(),
                fieldname,
                fieldType.getSimpleByteCode()));
        if (convertingFlag)
        {
            stmts.addStatement("i2d");
        }

        return new ExpressionReturn(fieldType, "");
    }

//endregion

//region Expression methods

    public void visitNegate(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, ExpressionReturn value, boolean convertingFlag)
    {
        if (getNegate(ctx).equals("-"))
        {
            if (value.type == Main.decimal || convertingFlag)
            {
                stmts.addStatement("dneg");
            }
            else if (value.type == Main.integer)
            {
                stmts.addStatement("ineg");
            }
        }
    }

    public String getNegate(HOMEParser.ExpressionContext expressionContext)
    {
        if (expressionContext.expression().size() == 1)
        {
            return expressionContext.getChild(0).getText();
        }
        return "";
    }

    public String getOperator(HOMEParser.ExpressionContext expressionContext)
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

    private void visitAnyAssign(TerminalNode terminalNode, SymbolInfo variable, Statements stmts)
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

        StringBuilder sAssign = new StringBuilder();
        switch (typeName)
        {
            case "Integer":
                sAssign.append("i");
                break;
            case "Decimal":
                sAssign.append("d");
                break;
        }

        switch (terminalNode.getText())
        {
            case "+=":
                sAssign.append("add");
                break;
            case "-=":
                sAssign.append("sub");
                break;
            case "*=":
                sAssign.append("mul");
                break;
            case "/=":
                sAssign.append("div");
                break;
            case "%=":
                sAssign.append("rem");
                break;
        }
        stmts.addStatement(sAssign.toString());
    }

    public ExpressionReturn checkExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, int expressionNR, boolean convertingFlag)
    {
        if (ctx.expression(expressionNR).literal() != null)
        {
            if (ctx.expression(expressionNR).literal().IntegerLiteral() != null)
            {
                ExpressionReturn _return = visitLiteral(ctx.expression(expressionNR).literal(), stmts, convertingFlag);
                visitNegate(ctx, stmts, _return, convertingFlag);
                return _return;
            }
            else if (ctx.expression(expressionNR).literal().DecimalLiteral() != null)
            {
                ExpressionReturn _return = visitLiteral(ctx.expression(expressionNR).literal(), stmts, false);
                visitNegate(ctx, stmts, _return, convertingFlag);
                return _return;
            }
            else if (ctx.expression(expressionNR).literal().StringLiteral() != null)
            {
                return visitLiteral(ctx.expression(expressionNR).literal(), stmts, false);
            }
            else if (ctx.expression(expressionNR).literal().booleanLiteral() != null)
            {
                return visitLiteral(ctx.expression(expressionNR).literal(), stmts, false);
            }
            else
            {
                return null;
            }
            //r1 = new ExpressionReturn(Main.integer, ctx.expression(0).literal().IntegerLiteral().getText());
        }
        else if (ctx.expression(expressionNR).identifier() != null)
        {
            ExpressionReturn _return = visitIdentifier(ctx.expression(expressionNR).identifier(), stmts, convertingFlag);
            visitNegate(ctx, stmts, new ExpressionReturn(symbolTable.variables.getType(_return.returnValue), ""), convertingFlag);
            return _return;
        }
        else if (ctx.expression(expressionNR).field() != null)
        {
            ExpressionReturn _return = visitField(ctx.expression(expressionNR).field(), stmts, convertingFlag);
            visitNegate(ctx, stmts, new ExpressionReturn(_return.type, ""), convertingFlag);
            return _return;
        }
        else
        {
            ExpressionReturn _return = visitExpression(ctx.expression(expressionNR), stmts, null, convertingFlag);
            visitNegate(ctx, stmts, _return, convertingFlag);
            return _return;
        }
    }

    public Type visitOperator(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, Type type)
    {
        //TODO: generalize for any operator

        String label1 = null;
        String label2 = null;

        String operator = getOperator(ctx);

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
                stmts.addStatement(typePrefix + "add");
                return type;
            case "-":
                stmts.addStatement(typePrefix + "sub");
                return type;
            case "*":
                stmts.addStatement(typePrefix + "mul");
                return type;
            case "/":
                stmts.addStatement(typePrefix + "div");
                return type;
            case "%":
                stmts.addStatement(typePrefix + "rem");
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
                            stmts.addStatement("if_icmpne " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "!=":
                            stmts.addStatement("if_icmpeq " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement("" + label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "<=":
                            stmts.addStatement("if_icmpgt " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "<":
                            stmts.addStatement("if_icmpge " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case ">=":
                            stmts.addStatement("if_icmplt " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case ">":
                            stmts.addStatement("if_icmple " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
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
                            stmts.addStatement("dcmpl");
                            stmts.addStatement("ifne " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "!=":
                            stmts.addStatement("dcmpl");
                            stmts.addStatement("ifeq " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement("" + label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "<=":
                            stmts.addStatement("dcmpl");
                            stmts.addStatement("ifgt " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "<":
                            stmts.addStatement("dcmpl");
                            stmts.addStatement("ifge " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case ">=":
                            stmts.addStatement("dcmpl");
                            stmts.addStatement("iflt " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case ">":
                            stmts.addStatement("dcmpl");
                            stmts.addStatement("ifle " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        //endregion
                    }
                }
                else if (type.equals(Main.string))
                {
                    switch (operator)
                    {
                        case "+":
                            stmts.addLocal(1);
                            stmts.addStatement("astore " + (stmts.currentLocal() + 1));
                            stmts.addStatement("astore " + stmts.currentLocal());
                            stmts.addStatement("new java/lang/StringBuilder");
                            stmts.addStatement("dup");
                            stmts.addStatement("invokespecial java/lang/StringBuilder.<init>()V");
                            stmts.addStatement("aload " + stmts.currentLocal());
                            stmts.addStatement("invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
                            stmts.addStatement("aload " + (stmts.currentLocal() + 1));
                            stmts.addStatement("invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;");
                            stmts.addStatement("invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;");
                            stmts.addLocal(1);
                            return type;

                        case "==":
                            stmts.addStatement("invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z");
                            return Main.bool;
                    }
                }

                if (type.equals(Main.bool))
                {
                    //region more code...
                    switch (operator)
                    {
                        case "AND":
                            stmts.addLocal(1);
                            stmts.addStatement("istore " + stmts.currentLocal());
                            stmts.addStatement("ifeq " + label1);
                            stmts.addStatement("iload " + stmts.currentLocal());
                            stmts.addStatement("ifeq " + label1);
                            stmts.addStatement("iconst_1");
                            stmts.addStatement("goto " + label2);
                            stmts.addStatement(label1 + ":");
                            stmts.addStatement("iconst_0");
                            stmts.addStatement(label2 + ":");
                            return Main.bool;
                        case "OR":
                            stmts.addLocal(1);
                            stmts.addStatement("istore " + stmts.currentLocal());
                            stmts.addStatement("ifne " + label2);
                            stmts.addStatement("iload " + stmts.currentLocal());
                            stmts.addStatement("ifne " + label2);
                            stmts.addStatement("iconst_0");
                            stmts.addStatement("goto " + label1);
                            stmts.addStatement(label2 + ":");
                            stmts.addStatement("iconst_1");
                            stmts.addStatement(label1 + ":");
                            return Main.bool;
                    }
                    //endregion
                }
        }

        return null;
    }

    public Type visitOperator(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, Type type, String label)
    {
        String operator = getOperator(ctx);

        if (type.equals(Main.integer) || type.equals(Main.bool))
        {
            //region more code...
            switch (operator)
            {
                case "==":
                    stmts.addStatement("if_icmpeq " + label);
                    return Main.bool;
                case "!=":
                    stmts.addStatement("if_icmpne " + label);
                    return Main.bool;
                case "<=":
                    stmts.addStatement("if_icmple " + label);
                    return Main.bool;
                case "<":
                    stmts.addStatement("if_icmplt " + label);
                    return Main.bool;
                case ">=":
                    stmts.addStatement("if_icmpge " + label);
                    return Main.bool;
                case ">":
                    stmts.addStatement("if_icmpgt " + label);
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
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("ifeq " + label);
                    return Main.bool;
                case "!=":
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("ifne " + label);
                    return Main.bool;
                case "<=":
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("ifle " + label);
                    return Main.bool;
                case "<":
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("iflt " + label);
                    return Main.bool;
                case ">=":
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("ifge " + label);
                    return Main.bool;
                case ">":
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("ifgt " + label);
                    return Main.bool;
            }
            //endregion
        }
        else if (type.equals(Main.string))
        {
            switch (operator)
            {
                case "==":
                    stmts.addStatement("invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z");
                    stmts.addStatement("ifne " + label);
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
                    stmts.addLocal(1);
                    stmts.addStatement("istore " + stmts.currentLocal());
                    stmts.addStatement("ifeq " + label1);
                    stmts.addStatement("iload " + stmts.currentLocal());
                    stmts.addStatement("ifeq " + label1);
                    stmts.addStatement("goto " + label);
                    stmts.addStatement(label1 + ":");
                    return Main.bool;
                case "OR":
                    stmts.addLocal(1);
                    stmts.addStatement("istore " + stmts.currentLocal());
                    stmts.addStatement("ifne " + label);
                    stmts.addStatement("iload " + stmts.currentLocal());
                    stmts.addStatement("ifne " + label);
                    return Main.bool;
            }
            //endregion
        }

        return null;
    }

    public Type compareTypes(ExpressionReturn r1, ExpressionReturn r2)
    {
        if (r1.equals(Main.integer) && r2.equals(Main.integer))
        {
            return Main.integer;

        }
        else if (r1.equals(Main.bool) && r2.equals(Main.bool))
        {
            return Main.bool;

        }
        else if (r1.equals(Main.variable) || r2.equals(Main.variable))
        {
            if (r1.equals(Main.variable) && symbolTable.variables.getType(r1.returnValue).equals(Main.decimal))
            {
                return Main.decimal;
            }
            else if (r2.equals(Main.variable) && symbolTable.variables.getType(r2.returnValue).equals(Main.decimal))
            {
                return Main.decimal;
            }
            else if (r1.equals(Main.variable) && symbolTable.variables.getType(r1.returnValue).equals(Main.string))
            {
                return Main.string;
            }
            else if (r2.equals(Main.variable) && symbolTable.variables.getType(r2.returnValue).equals(Main.string))
            {
                return Main.string;
            }
            else
            {
                return Main.integer;
            }

        }
        else if (r1.equals(Main.string) || r2.equals(Main.string))
        {
            return Main.string;

        }
        else if (r1.equals(Main.decimal) || r2.equals(Main.decimal))
        {
            return Main.decimal;
        }

        return null;
    }


//endregion

//region Literal

    public ExpressionReturn visitLiteral(@NotNull HOMEParser.LiteralContext ctx, Statements stmts, boolean convertingFlag)
    {
        ExpressionReturn returnType = null;

        if (ctx.IntegerLiteral() != null)
        {
            if (convertingFlag)
                returnType = new ExpressionReturn(Main.decimal, ctx.getText());
            else
                returnType = new ExpressionReturn(Main.integer, ctx.getText());
            addLiteral(stmts, returnType, convertingFlag);
        }
        else if (ctx.booleanLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.bool, ctx.getText());
            String booleanReturnValue = returnType.returnValue;
            if (booleanReturnValue.equals("true"))
                stmts.addStatement("iconst_1");
            else
                stmts.addStatement("iconst_0");
        }
        else if (ctx.DecimalLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.decimal, ctx.getText());
            addLiteral(stmts, returnType, convertingFlag);
        }
        else if (ctx.StringLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.string, ctx.getText());
            stmts.addStatement("ldc " + returnType.returnValue);
        }
        else if (ctx.listLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.list, ctx.getText());
            visitListLiteral(ctx.listLiteral(), stmts); // Todo visitListLiteral
        }
        else if (ctx.dictionaryLiteral() != null)
        {
            returnType = new ExpressionReturn(Main.dictionary, ctx.getText());
            visitDictionaryLiteral(ctx.dictionaryLiteral(), stmts); // Todo visitListLiteral
            // returnType = visitDictionaryLiteral(ctx.dictionaryLiteral()); Todo visitDictionaryLiteral
        }
        return returnType;
    }

    public void addLiteral(Statements stmts, ExpressionReturn literal, boolean convertingFlag)
    {
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
                stmts.addStatement("ldc " + literal.returnValue); // can be optimized with bipush when below 127
            }
            else if (value > Math.pow(2, 7) - 1)
            {
                stmts.addStatement("sipush " + literal.returnValue); // can be optimized with bipush when below 127
            }
            else
            {
                stmts.addStatement("bipush " + literal.returnValue); // can be optimized with bipush when below 127
            }
        }
        else if (literal.type == Main.integer && convertingFlag)
        {
            double value = Double.valueOf(literal.returnValue);
            if (value == 0.0d)
            {
                stmts.addStatement("dconst_0");
            }
            else if (value == 1.0d)
            {
                stmts.addStatement("dconst_1");
            }
            else
            {
                stmts.addStatement("ldc2_w " + literal.returnValue + ".d"); // check if .0d notation works or 2.d
            }
        }
        else if (literal.type == Main.decimal)
        {
            double value = Double.valueOf(literal.returnValue);
            if (value == 0.0d)
            {
                stmts.addStatement("dconst_0");
            }
            else if (value == 1.0d)
            {
                stmts.addStatement("dconst_1");
            }
            else
            {
                if (literal.returnValue.contains("."))
                    stmts.addStatement("ldc2_w " + literal.returnValue + "d"); // check if .0d notation works or 2.d
                else
                    stmts.addStatement("ldc2_w " + literal.returnValue + ".d");
            }
        }
        else if (literal.type == Main.string)
        {
            stmts.addStatement("ldc " + literal.returnValue);
        }
    }

//endregion

//region List and Dictionary

    public void visitListLiteral(@NotNull HOMEParser.ListLiteralContext ctx, Statements stmts)
    {
        stmts.addStatement("new java/util/ArrayList");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/ArrayList.<init>()V");
        stmts.addLocal(1);
        stmts.addStatement("astore " + stmts.currentLocal());
        Integer local = stmts.currentLocal();

        for (int i = 0; i < ctx.expression().size(); i++)
        {
            HOMEParser.ExpressionContext expressionContext = ctx.expression(i);
            if (expressionContext.literal() == null)
            {
                stmts.addStatement("aload " + stmts.currentLocal());
                visitExpression(ctx.expression(i), stmts).invokeToObject(stmts);
                stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
                stmts.addStatement("pop");
            }
            else if (expressionContext.literal().listLiteral() == null && expressionContext.literal().dictionaryLiteral() == null)
            {
                stmts.addStatement("aload " + stmts.currentLocal());
                visitExpression(expressionContext, stmts);
                if (expressionContext.literal().IntegerLiteral() != null)
                {
                    stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                }
                else if (expressionContext.literal().DecimalLiteral() != null)
                {
                    stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
                }
                stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
                stmts.addStatement("pop");
            }
            else
            {
                visitExpression(expressionContext, stmts);
                stmts.addStatement("aload " + local);
                stmts.addStatement("aload " + (local + i + 1));
                stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
                stmts.addStatement("pop");
            }
        }
    }

    private void buildList(Statements stmts, CollectionType symbolType, int depth)
    {
        stmts.addStatement("new java/util/ArrayList");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/ArrayList.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        int local = stmts.currentLocal();
        depth--;
        if (depth != 0)
        {
            if (((CollectionType) symbolType.innerType).primaryType.equals(Main.list))
                buildList(stmts, (CollectionType) symbolType.innerType, depth);
            else
                buildDictionary(stmts, (CollectionType) symbolType.innerType, depth);

            stmts.addStatement("aload " + local);
            stmts.addStatement("aload " + (local + 1));
            stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
            stmts.addStatement("pop");
        }
    }

    private void visitDictionaryLiteral(HOMEParser.DictionaryLiteralContext ctx, Statements stmts)
    {
        stmts.addStatement("new java/util/HashMap");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/HashMap.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        Integer local = stmts.currentLocal();

        for (int i = 0; i < ctx.dictionaryEntry().size(); i++)
        {
            HOMEParser.DictionaryEntryContext dictionaryEntryContext = ctx.dictionaryEntry(i);
            stmts.addStatement("aload " + local);
            visitExpression(dictionaryEntryContext.expression(0), stmts);
            ExpressionReturn expressionReturn = visitExpression(dictionaryEntryContext.expression(1), stmts);
            HOMEParser.ExpressionContext expressionContext = dictionaryEntryContext.expression(1);

            if (expressionContext.literal() != null)
            {
                if (expressionContext.literal().dictionaryLiteral() == null && expressionContext.literal().listLiteral() == null)
                {
                    if (expressionContext.literal().IntegerLiteral() != null)
                    {
                        stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                    }
                    else if (expressionContext.literal().DecimalLiteral() != null)
                    {
                        stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
                    }
                    stmts.addStatement("invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                    stmts.addStatement("pop");
                }
                else
                {
                    stmts.addStatement("aload " + (local + i + 1));
                    stmts.addStatement("invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                    stmts.addStatement("pop");
                }
            }
            else
            {

                expressionReturn.invokeToObject(stmts);
                stmts.addStatement("invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                stmts.addStatement("pop");
            }
        }
    }

    private void buildDictionary(Statements stmts, CollectionType symbolType, int depth)
    {
        stmts.addStatement("new java/util/HashMap");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/HashMap.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        depth--;
        if (depth != 0)
        {
            if (((CollectionType) symbolType.innerType).primaryType.equals(Main.list))
                buildList(stmts, (CollectionType) symbolType.innerType, depth);
            else
                buildDictionary(stmts, (CollectionType) symbolType.innerType, depth);
        }
    }

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
