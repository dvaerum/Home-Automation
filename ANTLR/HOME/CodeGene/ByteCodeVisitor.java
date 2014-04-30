package HOME.CodeGene;

import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import HOME.Main;
import SymbolTableNew.SymbolTableNew;
import SymbolTableNew.VariableTable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ByteCodeVisitor extends HOMEBaseVisitor {

    SymbolTableNew symbolTable = Main.symbolTable;

    class Function {
        private String _begin;
        public Statements stmts;
        private String _return;
        private String _end;

        public Function (String _begin, String _end) {
            this._begin = _begin;
            this._return = "";
            this._end = _end;
        }

        public Function (String _begin, String _return, String _end) {
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

    @Override
    public Object visitExpression(@NotNull HOMEParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    public void visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx, Statements stmt)
    {
        String operator = ctx.expression().logicalOperator().getText();
        switch(operator) {
            case "==":
                stmt.addStatement("ldc " + ctx.expression().getText());
                stmt.addStatement("if_cmpne goto " + symbolTable.newLabel());
                if(ctx.stmts()!=null) {
                    visitStmts(ctx.stmts(), stmt);
//                    if(ctx.stmts().stmt().funcCall().funcParameters()!=null)
//                        stmt.addStatement("invokestatic " + ctx.stmts().stmt().funcCall().identifier().getText() +"(" + ctx.stmts().stmt().funcCall().funcParameters().expression().iterator().next().getText() +")");
//                    else
//                        stmt.addStatement("invokestatic " + ctx.stmts().stmt().funcCall().identifier().getText() +"()");

                } stmt.addStatement(symbolTable.getLabel());
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

        if(funcName.equals("Setup")){
            this.setup = new Function(".method public static main([Ljava/lang/String;)V",
                    ".end method");
            setup.stmts = new Statements();

            visitStmts(ctx.stmts(), setup.stmts);
        } else {
            String parameters;
            parameters = visitDeclarationParameters(ctx.declarationParameters());
            String returnType;
            if(ctx.nothing() != null){
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

    public String bytecodeType(String str){
        if(str.contains("List"))
        {

        } else if(str.contains("Dictionary"))
        {

        }

        switch(str){
            case "Integer":
                return "Ljava/lang/Integer;";
            case "Decimal":
                return "Ljava/lang/Double;";
            case "String":
                return "Ljava/lang/String;";
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

    public String visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx){
        if(ctx == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for(HOMEParser.DeclarationContext dec : ctx.declaration())
        {
            String t = dec.type().getText().trim();
            sb.append(bytecodeType(t));
        }

        return sb.toString();
    }

    public void visitStmts(@NotNull HOMEParser.StmtsContext ctx, Statements _stmts ) {
        if (ctx.stmts() != null){
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

        } else if (ctx.funcCall() != null) {

        } else if (ctx.variableMethodCall() != null) {

        } else if (ctx.incDec() != null) {

        }
        Double d = 2.0;
    }

    @Override
    public Object visitNewline(@NotNull HOMEParser.NewlineContext ctx) {
        symbolTable.newLine();
        return super.visitNewline(ctx);
    }

    public void visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx, Statements stmt) {
        String type = ctx.type().getText();

        switch (type) {
            case "Integer":
                stmt.addStatement("ldc " + ctx.expression().literal().getText()); // TODO Add visitExpression
                stmt.addStatement("istore " + stmt.nextLocal());
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

    public void createObject(@NotNull HOMEParser.DeclarationContext ctx, String _class, String _parameter, Statements stmt){
        stmt.addStatement("new " + "java/lang/Integer");
        stmt.addStatement("dup");
        stmt.addStatement("ldc " + ctx.expression().getText());


        if (ctx.expression() != null){
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



    private void checkGlobal(HOMEParser.DeclarationContext ctx) // change the input to be more general
    {
        // Checks whether the variable is global, if it is, add a .fields to the output
        String declaration = refTable.get(ctx.type().getText().trim());

        declaration = declaration.replace("<field-name>",ctx.identifier().getText());

        if(ctx.expression()!=null) {
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
