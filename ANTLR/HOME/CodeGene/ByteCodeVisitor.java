package HOME.CodeGene;

import HOME.ForkReturnStack;
import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import HOME.Main;
import HOME.Type.CollectionType;
import HOME.Type.Type;
import HOME.TypeChecker;
import HOME.SymbolTable.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.*;
import java.lang.String;
import java.util.*;

public class ByteCodeVisitor extends HOMEBaseVisitor {

    SymbolTable symbolTable = Main.symbolTable;
    TypeChecker typeChecker = new TypeChecker();
    ForkReturnStack forkReturnStack = new ForkReturnStack();

    class ExpressionReturn {
        Type type;
        String returnValue;
        Type actualType;

        ExpressionReturn(Type type, String returnValue) {
            this.type = type;
            this.returnValue = returnValue;
            this.actualType = type;
        }

        ExpressionReturn(String returnValue, Type actualType) {
            this.type = Main.variable;
            this.returnValue = returnValue;
            this.actualType = actualType;
        }

        public boolean equals(ExpressionReturn epxR) {
            return this.type.equals(epxR.type);
        }

        public boolean equals(Type epxR) {
            return this.type.equals(epxR);
        }

        public void invokeToObject(Statements stmts) {
            String typeName;
            if(this.type == Main.variable) {
                typeName = this.actualType.name;
            } else {
                typeName = this.type.name;
            }

            switch (typeName) {
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
            Write(this._end);
            Write("");
        }
    }

    public class Statements {
        private int limit_stack;
        private int limit_locale;
        private ArrayList<String> statements;

        public Statements() {
            this.statements = new ArrayList<>();
            this.limit_stack = 32; // TODO change to improve performance
            this.limit_locale = 0;
        }

        public Statements(int limit_stack) {
            this.statements = new ArrayList<>();
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

        public int currentLocal() {
            return this.limit_locale;
        }

        public void build() {
            Write(String.format("    " + ".limit stack %d", this.limit_stack < 10 ? this.limit_stack + 10 : this.limit_stack));
            Write(String.format("    " + ".limit locals %d", this.limit_locale + 1));
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
            this.fields = new ArrayList<>();
            stmts = new Statements();
            stmts.addStatement("aload_0");
            stmts.addStatement("invokespecial java/lang/Object/<init>()V");
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

    private Map<String, String> refTable = new HashMap<>();
    private ArrayList<String> init = new ArrayList<>();
    Function setup;
    GlobalVariables globalVariables;
    Statements statements;
    private ArrayList<Function> functions = new ArrayList<>();

    private FileOutputStream newClass;

    public ByteCodeVisitor() throws IOException {
        String path = "/HOME/CodeGene/GlobalReferenceTable";

        String cwd = new File("").getAbsolutePath();

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
        for (Function f : this.functions) {
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

    public CollectionType visitListIndex(@NotNull HOMEParser.ListIndexContext ctx, Statements stmts, Boolean assign) {
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.IdentifierExact().getText());
        CollectionType type = ((CollectionType) symbolInfo.var.type);
        for (int i = 0; i < ctx.expression().size(); i++) {
            HOMEParser.ExpressionContext expressionContext = ctx.expression(i);
            // If last element and we need to assign it to a value
            if (assign && ctx.expression().size() == i) {
                visitExpression(expressionContext, stmts);
                // list[0][1] = 77
            } else {
                if (symbolInfo.depth == 0 && i == 0) {
                    stmts.addStatement("aload_0");
                    stmts.addStatement("getfield " + "HOME/" + symbolInfo.var.name + " " + symbolInfo.var.type.getObjectByteCode());
                } else if(i == 0) { // Local variable
                    stmts.addStatement("aload " + symbolInfo.var.location);
                }

                visitExpression(expressionContext, stmts);
                switch (type.primaryType.name) {
                    case "List":
                        stmts.addStatement(String.format("invokevirtual %s.get(%s)Ljava/lang/Object;", Main.list.getClassByteCode(), Main.integer.bytecode)); // TODO replace '%r' if this doesn't work for everything
                        break;
                    case "Dictionary":
                        stmts.addStatement(String.format("invokevirtual %s.get(%s)Ljava/lang/Object;", Main.dictionary.getClassByteCode(), Main.integer.bytecode)); // TODO replace '%r' if this doesn't work for everything
                        break;
                }
                stmts.addStatement("checkcast " + type.innerType.getClassByteCode());
                if(type.innerType.equals(Main.integer))
                    stmts.addStatement("invokevirtual java/lang/Integer/intValue()I");
                if(type.innerType.equals(Main.decimal))
                    stmts.addStatement("invokevirtual java/lang/Double/doubleValue()D");
                if(type.innerType.equals(Main.bool))
                    stmts.addStatement("invokevirtual java/lang/Boolean/booleanValue()Z");


                try{
                    type = (CollectionType) type.innerType;
                } catch (Exception e){
                    System.out.println("well.. no biggie");
                }


            }
            //       stmts.addStatement("aload_" + symbolInfo.var.location);
        }

        if (!assign) {
            //stmts.addStatement("pop");
        }
        return type;
    }

    public ExpressionReturn visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx, Statements stmts, boolean convertingFlag) {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.getText());
        Type type = variable.var.type;
        if (variable.depth == 0) {
            stmts.addStatement("getfield HOME/" + variable.var.name + " " + variable.var.type.getSimpleByteCode());
        } else {
            String typePrefix = "";

            if (type.equals(Main.integer)) {
                typePrefix = "i";
            } else if (type.equals(Main.decimal)) {
                typePrefix = "d";
            } else if (type.equals(Main.bool)) {
                typePrefix = "i";
            } else {
                typePrefix = "a";
            }

            stmts.addStatement(typePrefix + "load " + symbolTable.variables.getSymbol(ctx.getText()).var.location);
            if (convertingFlag){
                stmts.addStatement("i2d");
            }
        }

        return new ExpressionReturn(ctx.getText(), type);
    }

    List<String> BooleanOperator = Arrays.asList("==", ">", "<", "<=", ">=", "!=", "AND", "OR");

    boolean isBooleanOperator(String str) {
        return BooleanOperator.contains(str);
    }

    public String getNegate(HOMEParser.ExpressionContext expressionContext) {
        if (expressionContext.expression().size() == 1) {
            return expressionContext.getChild(0).getText();
        }
        return "";
    }

    public String getOperator(HOMEParser.ExpressionContext expressionContext) {
        if (expressionContext.expression().size() == 1) {
            return expressionContext.getChild(0).getText();
        } else {
            return expressionContext.getChild(1).getText();
        }
    }

    public void visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx, Statements stmts) {
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        String ifLabel = symbolTable.newLabel();

        visitExpression(ctx.expression(), stmts, ifLabel);

        List<HOMEParser.ElseIfStmtContext> elseif = ctx.elseIfStmt();

        ArrayList<String> elseifLabel = new ArrayList<>();
        for (int i = 0; i < elseif.size(); i++) {
            elseifLabel.add(symbolTable.newLabel());

            visitExpression(elseif.get(i).expression(), stmts, elseifLabel.get(i));

            forkReturnStack.addFork();
        }
        String endLabel = symbolTable.newLabel();

        if (ctx.elseStmt() != null) {
            visitStmts(ctx.elseStmt().stmts(), stmts);

            forkReturnStack.addFork();
        }
        stmts.addStatement("goto " + endLabel);

        stmts.addStatement(ifLabel + ":");
        visitStmts(ctx.stmts(), stmts);
        stmts.addStatement("goto " + endLabel);

        for (int i = 0; i < elseif.size(); i++) {
            stmts.addStatement(elseifLabel.get(i) + ":");
            visitStmts(elseif.get(i).stmts(), stmts);
            stmts.addStatement("goto " + endLabel);
        }

        stmts.addStatement(endLabel + ":");

        if (forkReturnStack.closed() && ctx.elseStmt() != null) {
            forkReturnStack.dispose();
            forkReturnStack.addReturn();
        } else {
            forkReturnStack.dispose();
        }


        //  return super.visitIfStmt(ctx);
    }

    @Override
    public Object visitFunction(@NotNull HOMEParser.FunctionContext ctx) {
        symbolTable.openScope();
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        String funcName = ctx.identifier().getText();

        Function func;

        if (funcName.equals("Setup")) {
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
        } else {
            String parameters;
            Statements stmts = new Statements(1);
            parameters = visitDeclarationParameters(ctx.declarationParameters(), stmts);
            String returnType;
            if (ctx.nothing() != null) {
                returnType = "V";
            } else {
                SymbolTable symbolTable = Main.symbolTable;
                Type t = symbolTable.types.getSymbol(ctx.type().getText());
                returnType = t.getSimpleByteCode();
            }
            func = new Function(".method public ".concat(funcName).concat("(").concat(parameters).concat(")".concat(returnType)), ".end method");
            func.stmts = stmts;

            visitStmts(ctx.stmts(), func.stmts);

            this.functions.add(func);
        }

        if (!forkReturnStack.closed()) {
            visitReturnFunction(null, func.stmts);
        }
        forkReturnStack.dispose();

        return super.visitFunction(ctx);
    }

    public String visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx, Statements stmts) {
        if (ctx == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int s = 1;

        for (HOMEParser.DeclarationContext dec : ctx.declaration()) {
            String t = dec.type().getText().trim();
            Type type = Main.symbolTable.types.getSymbol(t);

            Integer location = stmts.nextLocal();

            if(type.equals(Main.decimal)){
                stmts.addLocal(2);
            } else {
                stmts.addLocal(1);
            }
            symbolTable.variables.addSymbol(dec.identifier().getText(), type, location);
            //visitDeclaration(dec, stmts);

            sb.append(Main.symbolTable.types.getSymbol(t).getSimpleByteCode());
        }

        return sb.toString();
    }

    public void visitStmts(@NotNull HOMEParser.StmtsContext ctx, Statements _stmts) {
        if (ctx.stmts() != null) {
            visitStmt(ctx.stmt(), _stmts);
            visitStmts(ctx.stmts(), _stmts);
        }

        for (HOMEParser.NewlineContext nlc : ctx.newline()) {
            //visitNewline(nlc, _stmts);
        }
    }

    public void visitStmt(@NotNull HOMEParser.StmtContext ctx, Statements stmts) {

        if (ctx.declaration() != null) {
            visitDeclaration(ctx.declaration(), stmts);
        } else if (ctx.assign() != null) {
            visitAssign(ctx.assign(), stmts);
        } else if (ctx.ifStmt() != null) {
            visitIfStmt(ctx.ifStmt(), stmts);
        } else if (ctx.loop() != null) {
            visitLoop(ctx.loop(), stmts);
        } else if (ctx.funcCall() != null) {
            visitFuncCall(ctx.funcCall(), stmts, true);
        } else if (ctx.variableMethodCall() != null) {
            visitVariableMethodCall(ctx.variableMethodCall(), stmts);
        } else if (ctx.incDec() != null) {
            visitIncDec(ctx.incDec(), stmts);
        } else if (ctx.returnFunction() != null) {
            visitReturnFunction(ctx.returnFunction(), stmts);
        } else if (ctx.ifStmt() != null) {
            visitIfStmt(ctx.ifStmt(), stmts);
        }
    }

    public void visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx, Statements stmts) {
        visitVariableMethodCall(ctx, stmts, false);
    }

    public ExpressionReturn visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx, Statements stmts, boolean convertingFlag) {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.identifier().getText());

        String variableByteCode = variable.var.type.getSimpleByteCode();

        HOME.Type.Function variableMethod = variable.var.type.getMethodByName(ctx.funcCall().identifier().getText());

        visitIdentifier(ctx.identifier(), stmts, false).invokeToObject(stmts);

//        StringBuilder s = new StringBuilder("invokeinterface " + variableByteCode.replace(";", "") + "/" + variableMethod.name + "(");
//        for (HOMEParser.ExpressionContext expressionContext : ctx.funcCall().funcParameters().expression()) {
//            ExpressionReturn expressionReturn = visitExpression(expressionContext, stmts);
//            expressionReturn.invokeToObject(stmts);
//            s.append("Ljava/lang/Object;");
//        }
//        s.append(")" + variableMethod.returnType.bytecode + " " + (variableMethod.parameters.size() + 1)); // the +1 is for loading the List or Dictionary aswell
//        stmts.addStatement(s.toString());


        for (HOMEParser.ExpressionContext expressionContext : ctx.funcCall().funcParameters().expression()) {
            visitExpression(expressionContext, stmts);
        }

        StringBuilder bytecode = new StringBuilder("invokevirtual ").
                append(variable.var.type.getClassByteCode()).
                append(".").append(variableMethod.name).
                append("(");

        for (Type parameter : variableMethod.parameters) {
            bytecode.append(parameter.getSimpleByteCode()); // TODO if this is a class, check bytecode for it.
        }

        bytecode.append(")").
                append(variableMethod.returnType.getSimpleByteCode()).
                toString();

        stmts.addStatement(bytecode.toString());

        if (convertingFlag){
            stmts.addStatement("i2d");
        }

        return new ExpressionReturn(variableMethod.returnType, "");
    }

    public void visitAssign(@NotNull HOMEParser.AssignContext ctx, Statements stmts) {
        if (ctx.identifier() != null) {
            SymbolInfo variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
            String type = variable.var.type.name;
            type = type.replaceAll("<.+>", "");
            switch (type) {
                case "Integer":
                    visitExpression(ctx.expression(), stmts);

                    stmts.addStatement("istore " + variable.var.location);
                    break;
                case "Decimal":
                    visitExpression(ctx.expression(), stmts);

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
                        if(ctx.expression().literal()!=null) {
                            int depth = emptyInit(ctx.expression().literal(),1);
                            //If depth equals -1, then it contains something
                            if(depth == -1) {
                                visitExpression(ctx.expression(), stmts);
                                stmts.addStatement("aload " + currentLocal);
                            } else {
                                buildList(stmts, symbolType, depth);
                                stmts.addStatement("aload " + currentLocal);
                            }
                        }
                        else {
                            // Here we do not re-use the list and it is therefore on the stack, no need to aload
                            visitExpression(ctx.expression(), stmts);
                            if (variable.depth!=0) {
                                stmts.addLocal(1);
                                currentLocal++;
                            }
                        }
                    }
                    else {
                        buildList(stmts, symbolType, 1);
                        stmts.addStatement("aload " + currentLocal);
                    }
                    variable.store(stmts);
                    break;
                case "Dictionary":
                    stmts.addStatement("astore " + variable.var.location);
                    break;
                default:
                    visitExpression(ctx.expression(), stmts);
                    stmts.addStatement("astore " + variable.var.location);
                    break;
            }
        } else if (ctx.listIndex() != null) {
            // list[0][0] = 77
            CollectionType type;
            if (ctx.ASSIGN() != null) {
                type = visitListIndex(ctx.listIndex(), stmts, true);
            } else {
                type = visitListIndex(ctx.listIndex(), stmts, false);
            }
            visitExpression(ctx.expression(), stmts);
            switch (type.primaryType.name) {
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
            stmts.addStatement("java/util/List.set(ILjava/lang/Object;)Ljava/lang/Object;");
            stmts.addStatement("pop");
        } else if (ctx.field() != null) {
                SymbolInfo variable = symbolTable.variables.getSymbol(ctx.field().identifier().getText());

                String objectname = variable.var.name;
                stmts.addStatement("aload " + stmts.currentLocal());

                visitExpression(ctx.expression(), stmts);

                String className = symbolTable.variables.getSymbol(objectname).var.type.toString();
                String fieldname = ctx.field().IdentifierExact().getText();
                String type = variable.var.type.getFieldByName(ctx.field().IdentifierExact().getText()).type.getSimpleByteCode();

                stmts.addStatement("putfield " + className + "/" + fieldname + " " + type);
        }
    }

    public Object visitIncDec(@NotNull HOMEParser.IncDecContext ctx, Statements _stmts) {
        // TODO Identifier, check local or field
        SymbolInfo symbolInfo = symbolTable.variables.getSymbol(ctx.identifier().getText());
        int location = symbolInfo.var.location;
        if (ctx.getChild(1).getText().equals("++")) {
            _stmts.addStatement("iinc " + location + " 1");
        } else {
            _stmts.addStatement("iinc " + location + " -1");
        }
        return super.visitIncDec(ctx);
    }

    public Object visitNewline(@NotNull HOMEParser.NewlineContext ctx, Statements stmts) {
        symbolTable.newLine();
        stmts.addStatement(symbolTable.getLineNumberText());
        return super.visitNewline(ctx);
    }

    public void visitNegate(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, ExpressionReturn value, boolean convertingFlag) {
        if (getNegate(ctx).equals("-")) {
            if (value.type == Main.decimal || convertingFlag) {
                stmts.addStatement("dneg");
            } else if (value.type == Main.integer) {
                stmts.addStatement("ineg");
            }
        }
    }

    public ExpressionReturn checkExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, int expressionNR) {
        return checkExpression(ctx, stmts, expressionNR, false);
    }

    public ExpressionReturn checkExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, int expressionNR, boolean convertingFlag) {
        if (ctx.expression(expressionNR).literal() != null) {
            if (ctx.expression(expressionNR).literal().IntegerLiteral() != null) {
                ExpressionReturn _return = visitLiteral(ctx.expression(expressionNR).literal(), stmts, convertingFlag);
                visitNegate(ctx, stmts, _return, convertingFlag);
                return _return;
            } else if (ctx.expression(expressionNR).literal().DecimalLiteral() != null) {
                ExpressionReturn _return = visitLiteral(ctx.expression(expressionNR).literal(), stmts, false);
                visitNegate(ctx, stmts, _return, convertingFlag);
                return _return;
            } else if (ctx.expression(expressionNR).literal().StringLiteral() != null) {
                return visitLiteral(ctx.expression(expressionNR).literal(), stmts, false);
            } else if (ctx.expression(expressionNR).literal().booleanLiteral() != null) {
                return visitLiteral(ctx.expression(expressionNR).literal(), stmts, false);
            } else {
                return null;
            }
            //r1 = new ExpressionReturn(Main.integer, ctx.expression(0).literal().IntegerLiteral().getText());
        } else if (ctx.expression(expressionNR).identifier() != null) {
            ExpressionReturn _return = visitIdentifier(ctx.expression(expressionNR).identifier(), stmts, convertingFlag);
            visitNegate(ctx, stmts, new ExpressionReturn(symbolTable.variables.getType(_return.returnValue), ""), convertingFlag);
            return _return;
        } else if (ctx.expression(expressionNR).field() != null) {
            ExpressionReturn _return = visitGetField(ctx.expression(expressionNR).field(), stmts, convertingFlag);
            visitNegate(ctx, stmts, new ExpressionReturn(_return.type, ""), convertingFlag);
            return _return;
        } else {
            ExpressionReturn _return = visitExpression(ctx.expression(expressionNR), stmts, null, convertingFlag);
            visitNegate(ctx, stmts, _return, convertingFlag);
            return _return;
        }
    }

    public ExpressionReturn visitGetField(@NotNull HOMEParser.FieldContext ctx, Statements stmts, boolean convertingFlag ) {
        SymbolInfo variable = symbolTable.variables.getSymbol(ctx.identifier().getText());

        String objectname = variable.var.name;
        stmts.addStatement("aload " + variable.var.location);

        String className = symbolTable.variables.getSymbol(objectname).var.type.toString();
        String fieldname = ctx.IdentifierExact().getText();

        Type type = variable.var.type.getFieldByName(ctx.IdentifierExact().getText()).type;

        stmts.addStatement("getfield " + className + "/" + fieldname + " " + type.getSimpleByteCode());
        if (convertingFlag){
            stmts.addStatement("i2d");
        }

        return new ExpressionReturn(type, "");
    }

    public Type visitOperator(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, Type type) {
        //TODO: generalize for any operator

        String label1 = null;
        String label2 = null;

        String operator = getOperator(ctx);

        String typePrefix = "";
        if (type.equals(Main.integer)) {
            typePrefix = "i";
        } else if (type.equals(Main.decimal)) {
            typePrefix = "d";
        }

        switch (operator) {
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
                if (type.equals(Main.integer) || type.equals(Main.bool)) {
                    //region more code...
                    switch (operator) {
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
                } else if (type.equals(Main.decimal)) {
                    //region more code...
                    switch (operator) {
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
                } else if (type.equals(Main.string)) {
                    switch (operator) {
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

                if (type.equals(Main.bool)) {
                    //region more code...
                    switch (operator) {
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

    public Type visitOperator(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, Type type, String label) {
        String operator = getOperator(ctx);

        if (type.equals(Main.integer) || type.equals(Main.bool)) {
            //region more code...
            switch (operator) {
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
        } else if (type.equals(Main.decimal)) {
            //region more code...
            switch (operator) {
                case "==":
                    stmts.addStatement("dcmpl");
                    stmts.addStatement("ifeg " + label);
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
        } else if (type.equals(Main.string)) {
            switch (operator) {
                case "==":
                    stmts.addStatement("invokevirtual java/lang/String.equals(Ljava/lang/Object;)Z");
                    stmts.addStatement("ifne " + label);
                    return Main.bool;
            }
        }


        if (type.equals(Main.bool)) {
            //region more code...
            String label1 = symbolTable.newLabel();
            switch (operator) {
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

    public Type compareTypes(ExpressionReturn r1, ExpressionReturn r2) {
        if (r1.equals(Main.integer) && r2.equals(Main.integer)) {
            return Main.integer;

        } else if (r1.equals(Main.bool) && r2.equals(Main.bool)) {
            return Main.bool;

        } else if (r1.equals(Main.variable) || r2.equals(Main.variable)) {
            if (r1.equals(Main.variable) && symbolTable.variables.getType(r1.returnValue).equals(Main.decimal)) {
                return Main.decimal;
            } else if (r2.equals(Main.variable) && symbolTable.variables.getType(r2.returnValue).equals(Main.decimal)) {
                return Main.decimal;
            } else if (r1.equals(Main.variable) && symbolTable.variables.getType(r1.returnValue).equals(Main.string)) {
                return Main.string;
            } else if (r2.equals(Main.variable) && symbolTable.variables.getType(r2.returnValue).equals(Main.string)) {
                return Main.string;
            } else {
                return Main.integer;
            }

        } else if (r1.equals(Main.string) || r2.equals(Main.string)) {
            return Main.string;

        } else if (r1.equals(Main.decimal) || r2.equals(Main.decimal)) {
            return Main.decimal;
        }

        return null;
    }

    public ExpressionReturn visitExpressionMew(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts) {
        return visitExpressionMew(ctx, stmts, null);
    }

    public ExpressionReturn visitExpressionMew(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label) {
        ExpressionReturn _return = visitExpression(ctx, stmts, label, false);
        if (_return.equals(Main.bool)) {
            stmts.addStatement("invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;");
        } else if (_return.equals(Main.integer)) {
            stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
        } else if (_return.equals(Main.decimal)) {
            stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
        }
        return _return;
    }

    public ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts) {
        return visitExpression(ctx, stmts, null, false);
    }

    public ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label) {
        return visitExpression(ctx, stmts, label, false);
    }

    public ExpressionReturn visitExpression(@NotNull HOMEParser.ExpressionContext ctx, Statements stmts, String label, boolean convertingFlag) {

        if (!convertingFlag) {
            if (ctx.int2dec() != null)
                convertingFlag = true;
            else
                convertingFlag = false;
        }

        if (ctx.expression().size() == 2) {
            ExpressionReturn r1, r2;
            String operator;

//            r1 = checkExpression(ctx, stmts, 0, convertingFlag);
//            r2 = checkExpression(ctx, stmts, 1, convertingFlag);
            r1 = visitExpression(ctx.expression(0), stmts, label, convertingFlag);
            r2 = visitExpression(ctx.expression(1), stmts, label, convertingFlag);

            Type type = compareTypes(r1, r2);

            if (label == null) {
                type = visitOperator(ctx, stmts, type);
            } else {
                type = visitOperator(ctx, stmts, type, label);
            }

            return new ExpressionReturn(type, "");
        } else if (ctx.expression().size() == 1) {
            ExpressionReturn r1 = checkExpression(ctx, stmts, 0, convertingFlag);

            return new ExpressionReturn(r1.type, "");
        } else {
            // Is expression doesn't contain any expressions, use below
            if (ctx.funcCall() != null) {
                visitFuncCall(ctx.funcCall());
            } else if (ctx.literal() != null) {
                return visitLiteral(ctx.literal(), stmts, convertingFlag);
            } else if (ctx.variableMethodCall() != null) {
                return visitVariableMethodCall(ctx.variableMethodCall(), stmts, convertingFlag);
            } else if (ctx.identifier() != null) {
                return visitIdentifier(ctx.identifier(), stmts, convertingFlag);
            } else if (ctx.listIndex() != null) {
                visitListIndex(ctx.listIndex(), stmts, false);
            } else if (ctx.field() != null) {
                return visitGetField(ctx.field(), stmts, convertingFlag);
            }
        }

        //should never get here
        return null;
    }

    public void visitFuncCall(@NotNull HOMEParser.FuncCallContext ctx, Statements stmts, Boolean pop) {
        stmts.addStatement("aload_0");
        for (HOMEParser.ExpressionContext expressionContext : ctx.funcParameters().expression()) {
            visitExpression(expressionContext, stmts);
        }

        HOME.Type.Function function = symbolTable.functions.getSymbol(ctx.identifier().getText());
        String code = "invokevirtual ";

        // TODO This is hard coded, nono
        code += "HOME/";
        code += function.name + "(";
        for (Type parameter : function.parameters) {
            code += parameter.bytecode;
        }
        code += ")" + function.returnType.bytecode;
        stmts.addStatement(code);
        if(pop && !function.returnType.equals(Main.nothing)) {
            if(function.returnType.equals(Main.decimal)){
                stmts.addStatement("pop2");
            } else {
                stmts.addStatement("pop");
            }
        }
    }

    public void addLiteral(Statements stmts, ExpressionReturn literal) {
        addLiteral(stmts, literal, false);
    }

    public void addLiteral(Statements stmts, ExpressionReturn literal, boolean convertingFlag) {
        if (literal.type == Main.integer && convertingFlag == false) {
            int value = Integer.valueOf(literal.returnValue);
            if (value < 0) {
                value++;
            } // ensures fx -128 also uses bipush just like 127 would ( not 128 though )
            value = Math.abs(value);
            if (value > Math.pow(2, 31) - 1) {
                // TODO throw error -> Integer too big
            } else if (value > Math.pow(2, 15) - 1) {
                stmts.addStatement("ldc " + literal.returnValue); // can be optimized with bipush when below 127
            } else if (value > Math.pow(2, 7) - 1) {
                stmts.addStatement("sipush " + literal.returnValue); // can be optimized with bipush when below 127
            } else {
                stmts.addStatement("bipush " + literal.returnValue); // can be optimized with bipush when below 127
            }
        } else if (literal.type == Main.integer && convertingFlag == true) {
            double value = Double.valueOf(literal.returnValue);
            if (value == 0.0d) {
                stmts.addStatement("dconst_0");
            } else if (value == 1.0d) {
                stmts.addStatement("dconst_1");
            } else {
                stmts.addStatement("ldc2_w " + literal.returnValue + ".d"); // check if .0d notation works or 2.d
            }
        } else if (literal.type == Main.decimal) {
            double value = Double.valueOf(literal.returnValue);
            if (value == 0.0d) {
                stmts.addStatement("dconst_0");
            } else if (value == 1.0d) {
                stmts.addStatement("dconst_1");
            } else {
                if (literal.returnValue.contains("."))
                    stmts.addStatement("ldc2_w " + literal.returnValue + "d"); // check if .0d notation works or 2.d
                else
                    stmts.addStatement("ldc2_w " + literal.returnValue + ".d");
            }
        } else if (literal.type == Main.string) {
            stmts.addStatement("ldc " + literal.returnValue);
        }
    }

    public ExpressionReturn visitLiteral(@NotNull HOMEParser.LiteralContext ctx, Statements stmts) {
        return visitLiteral(ctx, stmts, false);
    }

    public ExpressionReturn visitLiteral(@NotNull HOMEParser.LiteralContext ctx, Statements stmts, boolean convertingFlag) {
        ExpressionReturn returnType = null;

        if (ctx.IntegerLiteral() != null) {
            if (convertingFlag == true)
                returnType = new ExpressionReturn(Main.decimal, ctx.getText());
            else
                returnType = new ExpressionReturn(Main.integer, ctx.getText());
            addLiteral(stmts, returnType, convertingFlag);
        } else if (ctx.booleanLiteral() != null) {
            returnType = new ExpressionReturn(Main.bool, ctx.getText());
            String booleanReturnValue = returnType.returnValue;
            if (booleanReturnValue.equals("true"))
                stmts.addStatement("iconst_1");
            else
                stmts.addStatement("iconst_0");
        } else if (ctx.DecimalLiteral() != null) {
            returnType = new ExpressionReturn(Main.decimal, ctx.getText());
            addLiteral(stmts, returnType, convertingFlag);
        } else if (ctx.StringLiteral() != null) {
            returnType = new ExpressionReturn(Main.string, ctx.getText());
            stmts.addStatement("ldc " + returnType.returnValue);
        } else if (ctx.listLiteral() != null) {
            returnType = new ExpressionReturn(Main.list, ctx.getText());
            visitListLiteral(ctx.listLiteral(), stmts); // Todo visitListLiteral
        } else if (ctx.dictionaryLiteral() != null) {
            returnType = new ExpressionReturn(Main.dictionary, ctx.getText());
            visitDictionaryLiteral(ctx.dictionaryLiteral(), stmts); // Todo visitListLiteral
            // returnType = visitDictionaryLiteral(ctx.dictionaryLiteral()); Todo visitDictionaryLiteral
        }
        return returnType;
    }

    public void visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx, Statements stmts) {
        String type = ctx.type().getText();
        type = type.replaceAll("<.+>", "");
        // TODO check if there is are any expressions on Declaration
        CollectionType symbolType = null;
        SymbolInfo variable=null;
        switch (type) {
            case "Integer":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.integer, stmts.currentLocal());
                if (ctx.expression() != null) {
                    visitExpression(ctx.expression(), stmts); // TODO Add visitExpression
                } else {
                    stmts.addStatement("iconst_0");
                }
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                variable.store(stmts);
                break;

            case "Decimal":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.decimal, stmts.currentLocal());
                if (ctx.expression() != null) {
                    visitExpression(ctx.expression(), stmts); // TODO Add visitExpression
                } else {
                    stmts.addStatement("dconst_0");
                }
                stmts.addStatement("dstore " + stmts.currentLocal());
                stmts.addLocal(1);
                break;

            case "String":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.string, stmts.currentLocal());
                if (ctx.expression() != null) {
                    visitExpression(ctx.expression(), stmts); // TODO Add visitExpression
                } else {
                    stmts.addStatement("ldc ");
                }
                stmts.addStatement("astore " + stmts.currentLocal());
                break;

            case "Boolean":
                stmts.addLocal(1);
                symbolTable.variables.addSymbol(ctx.identifier().getText(), Main.bool, stmts.currentLocal());
                visitExpression(ctx.expression(), stmts); // TODO Add visitExpression
                stmts.addStatement("istore " + stmts.currentLocal());
                break;

            case "List":
                symbolType = (CollectionType) symbolTable.types.getSymbol(ctx.type().getText());
                int currentLocal = stmts.nextLocal();
                // TODO make it work with fields as well
                if (ctx.expression() != null)
                {
                    if(ctx.expression().literal()!=null) {
                        int depth = emptyInit(ctx.expression().literal(),1);
                        //If depth equals -1, then it contains something
                        if(depth == -1) {
                            visitExpression(ctx.expression(), stmts);
                        } else {
                            buildList(stmts, symbolType, depth);
                        }
                    }
                    else {
                        // Here we do not re-use the list
                        visitExpression(ctx.expression(), stmts);
                        stmts.addStatement("astore " + currentLocal);
                        stmts.addLocal(1);
                        //currentLocal++;
                    }
                }
                else {
                    buildList(stmts, symbolType, 1);
                }
                symbolTable.variables.addSymbol(ctx.identifier().getText(), symbolType, currentLocal);
                variable = symbolTable.variables.getSymbol(ctx.identifier().getText());
                if (variable.depth==0) {
                    stmts.addStatement("aload " + variable.var.location);
                    variable.store(stmts);
                }
                break;

            case "Dictionary":
                symbolType = (CollectionType) symbolTable.types.getSymbol(ctx.type().getText());
                symbolTable.variables.addSymbol(ctx.identifier().getText(), symbolType, stmts.nextLocal());
                if (ctx.expression() != null) {
                    int depth = emptyInit(ctx.expression().literal(),1);
                    //If depth equals -1, then it contains something
                    if(depth == -1) {
                        visitDictionaryLiteral(ctx.expression().literal().dictionaryLiteral(), stmts);
                    } else {
                        buildDictionary(stmts, symbolType, depth);
                    }
                }
                break;
        }
    }

    private int emptyInit(HOMEParser.LiteralContext ctx, int currDepth)
    {
        if(ctx!=null) {
            if(ctx.dictionaryLiteral()!=null) {
                if(ctx.dictionaryLiteral().dictionaryEntry()==null) {
                    return currDepth;
                } else {
                    return -1;
                }
            }
            else if(ctx.listLiteral()!=null)
            {
                if(ctx.listLiteral().expression().size()>0) {
                    if(ctx.listLiteral().expression(0).literal()!=null)
                        return currDepth = emptyInit(ctx.listLiteral().expression(0).literal(),currDepth+1);
                }
                else {
                    return currDepth;
                }
            }
        }
       return -1;
    }

    private void buildList(Statements stmts, CollectionType symbolType, int depth) {
        stmts.addStatement("new java/util/ArrayList");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/ArrayList.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        int local = stmts.currentLocal();
        depth--;
        if(depth!=0) {
            if(((CollectionType)symbolType.innerType).primaryType.equals(Main.list))
                buildList(stmts,(CollectionType)symbolType.innerType,depth);
            else
                buildDictionary(stmts,(CollectionType)symbolType.innerType,depth);

            stmts.addStatement("aload " + local);
            stmts.addStatement("aload " + (local + 1));
            stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
            stmts.addStatement("pop");
        }
    }

    private void buildDictionary(Statements stmts, CollectionType symbolType, int depth) {
        stmts.addStatement("new java/util/HashMap");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/HashMap.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        depth--;
        if(depth!=0) {
            if(((CollectionType)symbolType.innerType).primaryType.equals(Main.list))
                buildList(stmts,(CollectionType)symbolType.innerType,depth);
            else
                buildDictionary(stmts,(CollectionType)symbolType.innerType,depth);
        }
    }

    public void visitListLiteral(@NotNull HOMEParser.ListLiteralContext ctx, Statements stmts) {
        stmts.addStatement("new java/util/ArrayList");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/ArrayList.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        Integer local = stmts.currentLocal();

        for (int i = 0; i < ctx.expression().size(); i++) {
            HOMEParser.ExpressionContext expressionContext = ctx.expression(i);
            if (expressionContext.literal().listLiteral() == null && expressionContext.literal().dictionaryLiteral() == null) {
                stmts.addStatement("aload " + stmts.currentLocal());
                visitExpression(expressionContext, stmts);
                if (expressionContext.literal().IntegerLiteral() != null) {
                    stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                } else if (expressionContext.literal().DecimalLiteral() != null) {
                    stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
                }
                stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
                stmts.addStatement("pop");
            } else {
                visitExpression(expressionContext, stmts);
                stmts.addStatement("aload " + local);
                stmts.addStatement("aload " + (local + i + 1));
                stmts.addStatement("invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2");
                stmts.addStatement("pop");
            }
        }
    }

    private void visitDictionaryLiteral(HOMEParser.DictionaryLiteralContext ctx, Statements stmts) {
        stmts.addStatement("new java/util/HashMap");
        stmts.addStatement("dup");
        stmts.addStatement("invokespecial java/util/HashMap.<init>()V");
        stmts.addStatement("astore " + stmts.nextLocal());
        stmts.addLocal(1);
        Integer local = stmts.currentLocal();

        for (int i = 0; i < ctx.dictionaryEntry().size(); i++) {
            HOMEParser.DictionaryEntryContext dictionaryEntryContext = ctx.dictionaryEntry(i);
            stmts.addStatement("aload " + local);
            visitExpression(dictionaryEntryContext.expression(0), stmts);
            ExpressionReturn expressionReturn = visitExpression(dictionaryEntryContext.expression(1), stmts);
            HOMEParser.ExpressionContext expressionContext = dictionaryEntryContext.expression(1);

            if(expressionContext.literal()!=null) {
                if ( expressionContext.literal().dictionaryLiteral() == null && expressionContext.literal().listLiteral() == null) {
                    if (expressionContext.literal().IntegerLiteral() != null) {
                        stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                    } else if (expressionContext.literal().DecimalLiteral() != null) {
                        stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
                    }
                    stmts.addStatement("invokeinterface java/util/Map.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3");
                    stmts.addStatement("pop");
                } else {
                    stmts.addStatement("aload " + (local + i + 1));
                    stmts.addStatement("invokeinterface java/util/Map.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3");
                    stmts.addStatement("pop");
                }
            } else {

                expressionReturn.invokeToObject(stmts);
                stmts.addStatement("invokeinterface java/util/Map.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3");
                stmts.addStatement("pop");
            }
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
            Type symbolType = symbolTable.types.getSymbol(ctx.declaration().type().getText());
            String identifier = ctx.declaration().identifier().getText();
            String declaration = String.format(".field public %s %s", identifier, symbolType.getObjectByteCode());// = <value>";

            globalVariables.fields.add(declaration);
            globalVariables.stmts.addStatement("aload_0");
            visitDeclaration(ctx.declaration(),globalVariables.stmts);
        }
        return super.visitGlobal(ctx);
    }

    public Object visitLoop(@NotNull HOMEParser.LoopContext ctx, Statements statements) {
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        symbolTable.openScope();

        if (ctx.loopForeach() != null) {
            visitLoopForeach(ctx.loopForeach(), statements);
        } else if (ctx.loopWhileOrUntil() != null) {
            visitLoopWhileOrUntil(ctx.loopWhileOrUntil(), statements);
        }

        forkReturnStack.dispose();

        symbolTable.closeScope();

        return super.visitLoop(ctx);
    }

    public Object visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx, Statements stmts) {
        //TODO: MAKE FOREACH WORK - WHEN LISTS AND DICTIONARIES WORK
        ExpressionReturn expressionReturn = visitExpression(ctx.expression(), stmts);
        // TODO make visit expressions show if we have a List or Dictionary ( List or Map )
        Type realType = ((CollectionType)expressionReturn.actualType).primaryType;
        if(realType.equals(Main.list)){
            Integer iterator = stmts.nextLocal();

            Type innerType = symbolTable.types.getSymbol(ctx.type().getText());

            if(innerType.equals(Main.decimal)){
                stmts.addLocal(2);
            } else {
                stmts.addLocal(1);
            }
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
            if(innerType.equals(Main.integer))
                stmts.addStatement("invokevirtual java/lang/Integer/intValue()I");
            if(innerType.equals(Main.decimal))
                stmts.addStatement("invokevirtual java/lang/Double/doubleValue()D");
            if(innerType.equals(Main.bool))
                stmts.addStatement("invokevirtual java/lang/Boolean/booleanValue()Z");


            stmts.addLocal(1);
            symbolTable.variables.addSymbol(ctx.identifier().getText(), innerType, stmts.currentLocal());

            String storeCode;

            switch(innerType.name){
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
        else if(realType.equals(Main.dictionary))
        {
            Integer iterator = stmts.nextLocal();

            Type innerType = symbolTable.types.getSymbol(ctx.type().getText());

            if(innerType.equals(Main.decimal)){
                stmts.addLocal(2);
            } else {
                stmts.addLocal(1);
            }
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
            if(innerType.equals(Main.integer))
                stmts.addStatement("invokevirtual java/lang/Integer/intValue()I");
            if(innerType.equals(Main.decimal))
                stmts.addStatement("invokevirtual java/lang/Double/doubleValue()D");
            if(innerType.equals(Main.bool))
                stmts.addStatement("invokevirtual java/lang/Boolean/booleanValue()Z");

            stmts.addLocal(1);
            symbolTable.variables.addSymbol(ctx.identifier().getText(), innerType, stmts.currentLocal());

            String storeCode;

            switch(innerType.name){
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

//        stmts.addStatement("invokevirtual getList()Ljava/util/List;");
//        stmts.addStatement("invokeinterface java/util/List.iterator()Ljava/util/Iterator;");
//        int listIndex = stmts.nextLocal();
//        stmts.addStatement("astore_" + listIndex);
//        stmts.addLocal(1);
//        stmts.addStatement("aload_" + listIndex);
//        stmts.addStatement("invokeinterface java/util/Iterator.hasNext()Z");
//        stmts.addStatement("ifeq" + symbolTable.newLabel());
//        stmts.addStatement("aload_" + listIndex);
//        stmts.addStatement("invokeinterface java/util/Iterator.next()Ljava/lang/Object;");
//        stmts.addStatement("aload_" + listIndex);
//        // TODO work on this later


//        stmts.addStatement("Label" + symbolTable.getLabel() + ":");
        return super.visitLoopForeach(ctx);
    }

    public Object visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx, Statements statements) {
        String label1 = symbolTable.newLabel();
        String label2 = symbolTable.newLabel();
        String loopType = ctx.getChild(1).getText();

        if (loopType.equalsIgnoreCase("while")) {
            statements.addStatement("goto " + label2);
            statements.addStatement(label1 + ":");
        } else if (loopType.equalsIgnoreCase("until")) {
            statements.addStatement(label1 + ":");
            // CHECK CONDITION. IF TRUE GOTO LABEL2);
            visitExpression(ctx.expression(), statements, label2);
        }

        // DO STUFF HERE
        visitStmts(ctx.stmts(), statements);


        if (loopType.equalsIgnoreCase("while")) {
            statements.addStatement(label2 + ":");
            // CHECK CONDITION. IF TRUE GOTO LABEL1);
            visitExpression(ctx.expression(), statements, label1);
        } else if (loopType.equalsIgnoreCase("until")) {
            statements.addStatement("goto " + label1);
            statements.addStatement(label2 + ":");
        }

        return super.visitLoopWhileOrUntil(ctx);
    }

    public Object visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx, Statements _stmts) {
        forkReturnStack.addReturn();
        if (ctx == null || ctx.expression() == null) {
            _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
            _stmts.addStatement("ldc \"Great Success!!\"");
            _stmts.addStatement("invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V");
            _stmts.addStatement("return");
            return null;
        } else {
            // TODO: MAKE USE OF visitExpression
            SymbolInfo symbol = null;
            String type;
            if (ctx.expression().identifier() != null) {
                symbol = symbolTable.variables.getSymbol(ctx.expression().identifier().getText());
                type = symbol.var.type.name;
            } else {
                type = typeChecker.visitLiteral(ctx.expression().literal()).name;
            }
            switch (type) {
                case "Integer":
                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("iload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");


                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("iload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }

                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(I)V");

                    _stmts.addStatement("ireturn");
                    break;
                case "Decimal":
                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("dload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("ldc " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");

                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("dload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("ldc " + ctx.expression().literal().getText());
                    }

                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(D)V");

                    _stmts.addStatement("dreturn");
                    break;
                case "Boolean":
                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("iload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");


                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("iload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("bipush " + ctx.expression().literal().getText());
                    }

                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(Z)V");

                    _stmts.addStatement("ireturn");
                    break;
                default:
                    if (ctx.expression().identifier() != null) {
                        _stmts.addStatement("aload " + symbol.var.location);
                    } else {
                        _stmts.addStatement("ldc " + ctx.expression().literal().getText());
                    }
                    // TODO: Remove debug
                    _stmts.addStatement("dup");
                    _stmts.addStatement("getstatic java/lang/System/out Ljava/io/PrintStream;");
                    _stmts.addStatement("swap");
                    _stmts.addStatement("invokevirtual java/io/PrintStream/println(" + Main.symbolTable.types.getSymbol(type).getObjectByteCode() + ")V");

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
        System.out.println(out);
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
