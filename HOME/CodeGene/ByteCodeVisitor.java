package HOME.CodeGene;

import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import HOME.Main;
import HOME.Type.CollectionType;
import HOME.Type.Type;
import HOME.TypeChecker;
import SymbolTableNew.SymbolTableNew;
import SymbolTableNew.VariableTable;
import SymbolTableNew.SymbolInfo;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ByteCodeVisitor extends HOMEBaseVisitor {

    SymbolTableNew symbolTable = Main.symbolTable;
    TypeChecker typeChecker = new TypeChecker();

    class expressionReturn {
        Type type;
        String returnValue;

        expressionReturn(Type type, String returnValue) {
            this.type = type;
            this.returnValue = returnValue;
        }

        public boolean equals(expressionReturn epxR) {
            if (this.type.equals(epxR.type)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean equals(Type epxR) {
            if (this.type.equals(epxR)) {
                return true;
            } else {
                return false;
            }
        }
    }

    class Function {
        private String _begin;
        public Statements stmts;
        private String _return;
        private String _end;

        public Function(String _begin, String _end) {
            this._begin = _begin;
            this._return = "";
            this._end = _end;
        }

        public Function(String _begin, String _return, String _end) {
            this._begin = _begin;
            this._return = _return;
            this._end = _end;
        }

        public void build() {
            Write(this._begin);
            stmts.build();
            Write(String.format("return %s", this._return));
            Write(this._end);
            Write("");
        }
    }

    class Statements {
        private int limit_stack;
        private int limit_locale;
        private ArrayList<String> statements;

        public Statements() {
            this.statements = new ArrayList<String>();
            this.limit_stack = 32; // TODO change to improve performance
            this.limit_locale = 0;
        }

        public Statements(int limit_stack) {
            this.statements = new ArrayList<String>();
            this.limit_stack = limit_stack;
            this.limit_locale = 0;
        }

        public void addStatement(String statement) {
            this.statements.add(statement);
        }

        public void addStatement(String statement, int limit) {
            this.statements.add(statement);
            this.limit_locale += limit;
        }

        public void addLocal(int limit) {
            this.limit_locale += limit;
        }

        public int nextLocal() {
            return this.limit_locale + 1;
        }

        public void build() {
            Write(String.format("    " + ".limit stack %d", this.limit_stack));
            Write(String.format("    " + ".limit locals %d", this.limit_locale));
            for (String statement : statements) {
                Write("    " + statement);
            }
        }
    }

    class GlobalVariables {
        private String _start;
        private ArrayList<String> fields;
        private Statements stmts;
        private String _end;

        public GlobalVariables() {
            _start = ".method public <init>()V";
            this.fields = new ArrayList<String>();
            stmts = new Statements();
            stmts.addStatement("aload_0");
            stmts.addStatement("invokenonvirtual java/lang/Object/<init>()V");
            _end = ".end method";
        }

        public void build() {
            for (String field : fields) {
                Write(field);
            }

            Write(_start);
            stmts.build();
            Write("return");
            Write(_end);
            Write("");
        }
    }

    private Map<String, String> refTable = new HashMap<String, String>();
    private ArrayList<String> init = new ArrayList<String>();
    Function setup;
    GlobalVariables globalVariables;
    Statements statements;
    private ArrayList<Function> functions = new ArrayList<>();

    private FileOutputStream newClass;

    public ByteCodeVisitor() throws IOException {
        String path = "/HOME/CodeGene/GlobalReferenceTable";
        //       Files.readAllLines(f.getPath(), Charset);
        VariableTable variableTable = new VariableTable();


        String cwd = new File("").getAbsolutePath();
        System.out.println(cwd);

        File f = new File(cwd + path);

        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String[] matches = sc.nextLine().split("@");
            refTable.put(matches[0].trim(), matches[1].trim());
        }

        File newClassFile = new File(cwd + "/HOME/CodeGene/" + "Output_test.j");
        newClass = new FileOutputStream(newClassFile);

        Scanner metaClass = new Scanner(new File("HOME/CodeGene/Frame"));
        while (metaClass.hasNextLine()) {
            Write(metaClass.nextLine());
        }
        globalVariables = new GlobalVariables();
        statements = new Statements();

    }

    public void build() {
        globalVariables.build();
        setup.build();
        for(Function f : this.functions)
        {
            f.build();
        }
    }

    public void visitLogicalOperator(String logicalOperator, Type type, Statements stmts) {
        String operator = logicalOperator;
        String code = "";
        switch (type.name) {
            case "Integer":
                code += "if_icmp";
                break;
            case "Decimal":
                switch (operator) {
                    case "==":
                        code += "if_acmpne";
                        break;
                    case "!=":
                        code += "if_acmpeq";
                        break;
                    case "<":
                        code += "dcmpg";
                        code += "ifge";
                        break;
                    case ">":
                        code += "dcmpl";
                        code += "ifle";
                        break;
                    case "<=":
                        code += "dcmpg";
                        code += "ifgt";
                        break;
                    case ">=":
                        code += "dcmpl";
                        code += "iflt";
                        break;
                }
                code += "if_acmp"; // test if this works or we need to use dcmpl followed by a ifge according to the situation
                break;
            default:
                code += "if_acmp";
                break;
        }
        // not decimal
        switch (operator) {
            case "==":
                code += "ne";
                break;
            case "!=":
                code += "e";
                break;
            case "<":
                code += "ge";
                break;
            case ">":
                code += "le";
                break;
            case "<=":
                code += "gt";
                break;
            case ">=":
                code += "lt";
                break;

        }
    }

    public void visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts) {

        if(ctx.expression().size()>0)
        {
            if(ctx.expression().size() == 1)
            {

//                visitExpression(ctx.expression(0).expression(0));
//
//                HOMEParser.ExpressionContext RHS = ctx.expression(1);
//                String logicalOperator = ctx.logicalOperator().getText();
//                HOMEParser.ExpressionContext LHS = ctx.expression(0).expression(1);
//                Type LHSType = typeChecker.visitExpression(LHS);
//
//                visitLogicalOperator(logicalOperator, LHSType, stmts);
            }
            else // two expressions
            {
//                HOMEParser.ExpressionContext RHS = ctx.expression(1);
//                HOMEParser.LogicalOperatorContext logicalOperator = ctx.logicalOperator();
//                HOMEParser.ExpressionContext LHS = ctx.expression(0);
//                visitExpression(LHS);
//                visitExpression(RHS);
//                visitLogicalOperator(logicalOperator);
            }
        } else if (ctx.funcCall() != null) {
            visitFuncCall(ctx.funcCall());
        } else if (ctx.literal() != null) {
            visitLiteral(ctx.literal());
        } else if (ctx.variableMethodCall() != null) {
            visitVariableMethodCall(ctx.variableMethodCall());
        } else if (ctx.identifier() != null) {
            visitIdentifier(ctx.identifier());
        } else if (ctx.listIndex() != null) {
            visitListIndex(ctx.listIndex(), stmts);
        } else if (ctx.field() != null) {
            visitField(ctx.field());
        }
    }

    public Object visitListIndex(@NotNull HOMEParser.ListIndexContext ctx, Statements stmts) {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.IdentifierExact().getText());
        CollectionType type = ((CollectionType) symbolInfo.var.type);

        for (HOMEParser.ExpressionContext expressionContext : ctx.expression()) {
            if (symbolInfo.depth == 0)
            {
                stmts.addStatement("aload_0");
                stmts.addStatement("getfield " + "HOME/" + symbolInfo.var.name + "");
                // list[2],
                visitExpression(expressionContext);
                switch(type.primaryType.name) {
                    case "List":
                        stmts.addStatement(String.format("invokeinterface java/util/List.get(%r)Ljava/lang/Object; 2","Ljava/lang/Object;")); // TODO replace '%r' if this doesn't work for everything
                        break;
                    case "Dictionary":
                        stmts.addStatement(String.format("invokeinterface java/util/Map.get(%r)Ljava/lang/Object; 2","Ljava/lang/Object;")); // TODO replace '%r' if this doesn't work for everything

                        break;
                }
                switch(type.innerType.name) {
                    case "List":
                        stmts.addStatement(String.format("checkcast class %r","java/util/List")); // TODO replace '%r' if this doesn't work for everything
                        break;
                    case "Dictionary":
                        stmts.addStatement(String.format("checkcast class %r","java/util/Map")); // TODO replace '%r' if this doesn't work for everything

                        break;
                }


                stmts.addStatement("aload_" + symbolInfo.var.location);
            } else { // Local variable
            }
            visitExpression(expressionContext);

            stmts.addStatement("pop");

            type = (CollectionType) type.innerType;
        }



        return super.visitListIndex(ctx);
    }

    public Object visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx, Statements stmts) {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.getText());

        if (symbolInfo.depth == 0) {
            String byteCodeClassName = refTable.get(symbolInfo.var.type.name);
            // field is always in the same class which atm is 'HOME'. Hardcoded ftl
            stmts.addStatement("getfield " + "HOME/" +  symbolInfo.var.name + byteCodeClassName);

// TODO Michael start here
        } else {
            stmts.addStatement("aload_" + symbolInfo.var.location);
        }

        return super.visitIdentifier(ctx);
    }

    List<String> BooleanOperator = Arrays.asList("==", ">", "<", "<=", ">=", "!=", "AND", "OR");


    boolean isBooleanOperator(String str) {
        return BooleanOperator.contains(str);
    }

    public String getOperator(HOMEParser.ExpressionContext expressionContext) {
        if(expressionContext.expression().size()==1) {
            return expressionContext.getChild(0).getText();
        } else {
            return expressionContext.getChild(1).getText();
        }
    }
/*
    public String getOperator(HOMEParser.ExpressionContext expressionContext){
        // Gets the appropriate operator

        if(expressionContext.EQUAL()!=null) {
            return expressionContext.EQUAL().getText();
        } else if(expressionContext.NOTEQUAL()!=null) {
            return expressionContext.NOTEQUAL().getText();
        } else if(expressionContext.LE()!=null) {
            return expressionContext.LE().getText();
        } else if(expressionContext.GE()!=null) {
            return expressionContext.GE().getText();
        } else if(expressionContext.GT()!=null) {
            return expressionContext.GT().getText();
        } else if(expressionContext.LT()!=null) {
            return expressionContext.LT().getText();
        } else if(expressionContext.GT()!=null) {
            return expressionContext.GT().getText();
        } else if(expressionContext.MUL()!=null) {
            return expressionContext.MUL().getText();
        } else if(expressionContext.DIV()!=null) {
            return expressionContext.DIV().getText();
        } else if(expressionContext.MOD()!=null) {
            return expressionContext.MOD().getText();
        } else if(expressionContext.ADD()!=null) {
            return expressionContext.ADD().getText();
        } else if(expressionContext.SUB()!=null) {
            return expressionContext.SUB().getText();
        } else {return null;}
    }
*/
    public void visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx, Statements stmt) {
        String operator = getOperator(ctx.expression());
        switch (operator) {
            case "==":
                //stmt.addStatement("ldc " + ctx.expression().getText());
                // Handle expression
                visitExpression(ctx.expression());
                stmt.addStatement("if_cmpne goto " + symbolTable.newLabel());
                if (ctx.stmts() != null) {
                    visitStmts(ctx.stmts(), stmt);
//                    if(ctx.stmts().stmt().funcCall().funcParameters()!=null)
//                        stmt.addStatement("invokestatic " + ctx.stmts().stmt().funcCall().identifier().getText() +"(" + ctx.stmts().stmt().funcCall().funcParameters().expression().iterator().next().getText() +")");
//                    else
//                        stmt.addStatement("invokestatic " + ctx.stmts().stmt().funcCall().identifier().getText() +"()");

                }
                stmt.addStatement(symbolTable.getLabel());
                break;
            case "<":

                break;
            case ">":

                break;
            case "<=":

                break;
            case ">=":

                break;
            case "!=":

                break;
        }


        //  return super.visitIfStmt(ctx);
    }

    @Override
    public Object visitFunction(@NotNull HOMEParser.FunctionContext ctx) {

        String funcName = ctx.identifier().getText();

        if (funcName.equals("Setup")) {
            this.setup = new Function(".method public static main([Ljava/lang/String;)V",
                    ".end method");
            setup.stmts = new Statements();

            visitStmts(ctx.stmts(), setup.stmts);
        } else {
            String parameters;
            parameters = visitDeclarationParameters(ctx.declarationParameters());
            String returnType;
            if (ctx.nothing() != null) {
                returnType = "V";
            } else {
                returnType = bytecodeType(ctx.type().getText());
            }
            Function func = new Function(".method public ".concat(funcName).concat("(").concat(parameters).concat(")".concat(returnType)), ".end method");
            func.stmts = new Statements(1);

            visitStmts(ctx.stmts(), func.stmts);

            this.functions.add(func);
        }

        return super.visitFunction(ctx);
    }


    public String bytecodeType(String str) {
        if (str.contains("List")) {

        } else if (str.contains("Dictionary")) {

        }

        switch (str) {
            case "Integer":
                return "Ljava/lang/Integer";
            case "Decimal":
                return "Ljava/lang/Double";
            case "String":
                return "Ljava/lang/String";
            case "Boolean":
                return "Z";
            case "Time": // We need our own class here
                break;
            case "Input": // We need our own class here
                break;
            case "Output": // We need our own class here
                break;
            default: // We need the default package name for extensions here
                break;
        }
        return "";
    }

    public String visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx) {
        if (ctx == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (HOMEParser.DeclarationContext dec : ctx.declaration()) {
            String t = dec.type().getText().trim();
            sb.append(bytecodeType(t));
        }

        return sb.toString();
    }

    public void visitStmts(@NotNull HOMEParser.StmtsContext ctx, Statements _stmts) {
        if (ctx.stmts() != null) {
            visitStmt(ctx.stmt(), _stmts);
            visitStmts(ctx.stmts(), _stmts);
        }
    }

    public void visitStmt(@NotNull HOMEParser.StmtContext ctx, Statements stmt) {

        if (ctx.declaration() != null) {
            visitDeclaration(ctx.declaration(), stmt);
        } else if (ctx.assign() != null) {

        } else if (ctx.ifStmt() != null) {
            visitIfStmt(ctx.ifStmt(), stmt);
        } else if (ctx.loop() != null) {
            visitLoop(ctx.loop(), stmt);
        } else if (ctx.funcCall() != null) {

        } else if (ctx.variableMethodCall() != null) {

        } else if (ctx.incDec() != null) {
            visitIncDec(ctx.incDec(), stmt);
        } else if (ctx.returnFunction() != null){
            visitReturnFunction(ctx.returnFunction(), stmt);
        }
        Double d = 2.0;
    }

    public Object visitIncDec(@NotNull HOMEParser.IncDecContext ctx, Statements _stmts) {
        //int location = symbolTable.variables.getSymbol(ctx.identifier().getText()).var.location;
        int location = 42;
        if(ctx.getChild(1).getText() == "++"){
            _stmts.addStatement("iinc " + location + " 1");
        } else {
            _stmts.addStatement("iinc " + location + " -1");
        }

        return super.visitIncDec(ctx);
    }

    @Override
    public Object visitNewline(@NotNull HOMEParser.NewlineContext ctx) {
        symbolTable.newLine();
        return super.visitNewline(ctx);
    }

    public expressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmt, String str) {
        if (ctx.expression().size() > 0) {
            expressionReturn r1 = null, r2 = null;
            String operator = null;

            //1 expr = expression in parenteses
            if (ctx.expression().size() == 1) {
                //parenthesis
                expressionReturn _temp = visitExpression(ctx.expression().get(0), stmt, "");

                //checks for unary operator
                if (ctx.getChild(0).getText().equals("-")) {
                    _temp.returnValue = String.format("%d", -1 * Integer.parseInt(_temp.returnValue));
                }

                return _temp;
            } else //else two expressions
            {
                r1 = visitExpression(ctx.expression(0), stmt, "");
                operator = getOperator(ctx);
                r2 = visitExpression(ctx.expression(1), stmt, "");


                if (isBooleanOperator(operator)) {
                    //If AND or OR is used, check that both sides are boolean, else throw an error
                    if ((operator.equals("AND") || operator.equals("OR"))) {
                        //Todo logical expression

                        //If comparison is used, and both sides are not numbers, throw an error
                    } else if (operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=")) {
                        //Todo return boolean

                        //check if both sides of expression is boolean
                    } else if (operator.equals("==") || operator.equals("!=")) {
                        //Todo return boolean

                        //Else accept the expression
                    } else {
                        //returnType = Main.bool;
                    }
                }

                // Concat Strings and calc int and dec
                else if (r1.equals(r2)) {
                    if (r1.equals(Main.integer)) {
                        switch (operator) {
                            case "+":
                                return new expressionReturn(Main.integer,
                                                            String.format("%d", Integer.parseInt(r1.returnValue) +
                                                                                Integer.parseInt(r2.returnValue)));
                            case "-":
                                return new expressionReturn(Main.integer,
                                                            String.format("%d", Integer.parseInt(r1.returnValue) -
                                                            Integer.parseInt(r2.returnValue)));

                            case "/":
                                return new expressionReturn(Main.integer,
                                                            String.format("%d", Integer.parseInt(r1.returnValue) /
                                                            Integer.parseInt(r2.returnValue)));

                            case "*":
                                return new expressionReturn(Main.integer,
                                                            String.format("%d", Integer.parseInt(r1.returnValue) *
                                                            Integer.parseInt(r2.returnValue)));

                            case "%":
                                return new expressionReturn(Main.integer,
                                                            String.format("%d", Integer.parseInt(r1.returnValue) %
                                                            Integer.parseInt(r2.returnValue)));
                        }
                    } else if (r1.equals(Main.decimal)) {

                    } else if (r1.equals(Main.string)) {

                    }
                }

                //Check if it is possible to convert from Int to Dec
                else if ((r1.equals(Main.integer) && r2.equals(Main.decimal))) {
                    // return decimal;
                } else if ((r1.equals(Main.decimal) && r2.equals(Main.integer))) {
                    // return decimal;
                }

            }
        }

        // Is expression doesn't contain any expressions, use below
        else if (ctx.funcCall() != null) {
            visitFuncCall(ctx.funcCall());
        } else if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.variableMethodCall() != null) {
            //System.out.println("Expression should not go into variableMethodCall() yet");
            visitVariableMethodCall(ctx.variableMethodCall());
        } else if (ctx.identifier() != null) {
            visitIdentifier(ctx.identifier());
        } else if (ctx.listIndex() != null) {
            visitListIndex(ctx.listIndex());
        } else if (ctx.field() != null) {
            visitField(ctx.field());
        }

        return null;
    }

    @Override
    public expressionReturn visitLiteral(@NotNull HOMEParser.LiteralContext ctx) {
        expressionReturn returnType = null;

        if (ctx.IntegerLiteral() != null) {
            returnType = new expressionReturn(Main.integer, ctx.getText());
        } else if (ctx.booleanLiteral() != null) {
            returnType = new expressionReturn(Main.bool, ctx.getText());
        } else if (ctx.DecimalLiteral() != null) {
            returnType = new expressionReturn(Main.decimal, ctx.getText());
        } else if (ctx.StringLiteral() != null) {
            returnType = new expressionReturn(Main.string, ctx.getText());
        } else if (ctx.listLiteral() != null) {
            // returnType = visitListLiteral(ctx.listLiteral()); // Todo visitListLiteral
        } else if (ctx.dictionaryLiteral() != null) {
            // returnType = visitDictionaryLiteral(ctx.dictionaryLiteral()); Todo visitDictionaryLiteral
        }
        return returnType;
    }

    public void visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx, Statements stmt) {
        String type = ctx.type().getText();

        switch (type) {
            case "Integer":
                stmt.addStatement("ldc " + visitExpression(ctx.expression(), stmt, "").returnValue); // TODO Add visitExpression
                stmt.addStatement("istore " + stmt.nextLocal());
                //symbolTable.variables.addSymbol("test", Main.Integer);
                stmt.addLocal(1);
                break;
            case "Decimal":
                stmt.addStatement("ldc2_w " + ctx.expression().literal().getText()); // TODO Add visitExpression
                stmt.addStatement("dstore " + stmt.nextLocal());
                stmt.addLocal(2);
                break;
            case "String":
                stmt.addStatement("ldc " + ctx.expression().literal().getText()); // TODO Add visitExpression
                stmt.addStatement("istore " + stmt.nextLocal());
                stmt.addLocal(1);
                break;
            case "Boolean":


                stmt.addStatement("astore " + stmt.nextLocal());
                stmt.addLocal(1);
                break;

        }
    }

    public void createObject(@NotNull HOMEParser.DeclarationContext ctx, String _class, String _parameter, Statements stmt) {
        stmt.addStatement("new " + "java/lang/Integer");
        stmt.addStatement("dup");
        stmt.addStatement("ldc " + ctx.expression().getText());


        if (ctx.expression() != null) {
            stmt.addStatement("invokespecial " + "java/lang/Integer" + "/<init>(I)V");
        }
    }

    @Override
    public Object visitMoreFunctions(@NotNull HOMEParser.MoreFunctionsContext ctx) {
        return super.visitMoreFunctions(ctx);
    }

    @Override
    public Object visitGlobal(@NotNull HOMEParser.GlobalContext ctx) {
        // Declaration
        if (ctx.declaration() != null) {
            String declaration = refTable.get(ctx.declaration().type().getText().trim());

            declaration = declaration.replace("<field-name>", ctx.declaration().identifier().getText());

            if (ctx.declaration().expression() != null) {
                declaration = declaration.replace("<value>", ctx.declaration().expression().getText()); // replace with whatever the expression returns.
            } else {
                declaration = declaration.replace("<value>", "0");
            }
            globalVariables.fields.add(declaration);
            String type = ctx.declaration().type().getText().trim();
            switch (type) {
                case "Integer":
                    globalVariables.stmts.addStatement("aload_0");

                    Integer value = Integer.valueOf(ctx.declaration().expression().getText().trim());
                    if (value < 0) {
                        value++;
                    } // ensures fx -128 also uses bipush just like 127 would ( not 128 though )
                    value = Math.abs(value);
                    if (value > Math.pow(2, 31) - 1) {
                        // TODO throw error -> Integer too big
                    } else if (value > Math.pow(2, 15) - 1) {
                        globalVariables.stmts.addStatement("ldc " + ctx.declaration().expression().getText()); // can be optimized with bipush when below 127
                    } else if (value > Math.pow(2, 7) - 1) {
                        globalVariables.stmts.addStatement("sipush " + ctx.declaration().expression().getText()); // can be optimized with bipush when below 127
                    } else {
                        globalVariables.stmts.addStatement("bipush " + ctx.declaration().expression().getText()); // can be optimized with bipush when below 127
                    }
                    globalVariables.stmts.addStatement("invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;"); // can be optimized with bipush when below 127
                    globalVariables.stmts.addStatement(String.format("putfield HOME/%s Ljava/lang/Integer;", ctx.declaration().identifier().getText().trim()));
                    break;
                case "String":
                    globalVariables.stmts.addStatement("aload_0");
                    globalVariables.stmts.addStatement("ldc " + ctx.declaration().expression().getText());
                    globalVariables.stmts.addStatement(String.format("putfield HOME/%s Ljava/lang/String;", ctx.declaration().identifier().getText().trim()));
                    break;
                case "Decimal":
                    globalVariables.stmts.addStatement("aload_0");
                    globalVariables.stmts.addStatement("ldc2_w " + ctx.declaration().expression().getText() + "d"); // check if .0d notation works or 2.d
                    globalVariables.stmts.addStatement("invokestatic java/lang/Double.valueOf(D)Ljava/lang/Double;"); // can be optimized with bipush when below 127
                    globalVariables.stmts.addStatement(String.format("putfield HOME/%s Ljava/lang/Double;", ctx.declaration().identifier().getText().trim()));
                    break;
            }
        }

        return super.visitGlobal(ctx);
    }

    public Object visitLoop(@NotNull HOMEParser.LoopContext ctx, Statements statements) {
        if(ctx.loopForeach() != null){
            visitLoopForeach(ctx.loopForeach());
        } else if(ctx.loopWhileOrUntil() != null){
            visitLoopWhileOrUntil(ctx.loopWhileOrUntil(), statements);
        }

        return super.visitLoop(ctx);
    }

    public Object visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx, Statements statements) {
        //TODO: MAKE FOREACH WORK - WHEN LISTS AND DICTIONARIES WORK
       return super.visitLoopForeach(ctx);
    }

    public Object visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx, Statements statements) {
        String label1 = symbolTable.newLabel();
        String label2 = symbolTable.newLabel();
        String loopType = ctx.getChild(1).getText();

        if(loopType.equalsIgnoreCase("while")){
            statements.addStatement("goto " + label2);
            statements.addStatement(label1 + ":");
        } else if(loopType.equalsIgnoreCase("until")){
            statements.addStatement(label1 + ":");
            // CHECK CONDITION. IF TRUE GOTO LABEL2);
            // visitExpression(ctx.expression(), label2);
        }

        // DO STUFF HERE
        visitStmts(ctx.stmts(), statements);


        if(loopType.equalsIgnoreCase("while")){
            statements.addStatement(label2 + ":");
            // CHECK CONDITION. IF TRUE GOTO LABEL1);
            // visitExpression(ctx.expression(), label1);
        } else if(loopType.equalsIgnoreCase("until")){
            statements.addStatement("goto " + label1);
            statements.addStatement(label2 + ":");
        }

        return super.visitLoopWhileOrUntil(ctx);
    }

    public Object visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx, Statements _stmts) {
        if(ctx.expression() == null){
            _stmts.addStatement("return");
        } else {
            SymbolInfo symbol = symbolTable.variables.getSymbol(ctx.expression().identifier().getText());
            String type = symbol.var.type.name;
            switch (type){
                case "Integer":
                    if(ctx.expression().identifier() != null){
                        _stmts.addStatement("iload " + symbol.var.location);
                    } else {
                       _stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("dup");
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    _stmts.addStatement("swap");
                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(I)V");

                    _stmts.addStatement("ireturn");
                    break;
                case "Decimal":
                    if(ctx.expression().identifier() != null){
                        _stmts.addStatement("dload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("ldc " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("dup");
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    _stmts.addStatement("swap");
                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(D)V");

                    _stmts.addStatement("dreturn");
                    break;
                default:
                    if(ctx.expression().identifier() != null){
                        _stmts.addStatement("aload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("ldc " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("dup");
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    _stmts.addStatement("swap");
                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(" + bytecodeType(type) + ")V");

_stmts.addStatement("areturn");
                    break;
            }
        }

        return super.visitReturnFunction(ctx);
    }

    private void checkGlobal(HOMEParser.DeclarationContext ctx) // change the input to be more general
    {
        // Checks whether the variable is global, if it is, add a .fields to the output
        String declaration = refTable.get(ctx.type().getText().trim());

        declaration = declaration.replace("<field-name>", ctx.identifier().getText());

        if (ctx.expression() != null) {
            declaration = declaration.replace("<value>", ctx.expression().getText()); // replace with whatever the expression returns.
        } else {
            declaration = declaration.replace("<value>", "0");
        }
        globalVariables.fields.add(declaration);
    }

    protected void Write(String out) {
        try {
            newClass.write(
                    out.concat(System.getProperty("line.separator")).getBytes()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String Table(ParserRuleContext rule) {
        return refTable.get(rule.getText());
    }

}
