package HOME.CodeGene;

import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import com.sun.org.apache.xpath.internal.operations.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Michael on 14/04/14.
 */
public class ByteCodeVisitor extends HOMEBaseVisitor {

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
        }
    }

    class Statements {
        private int limit;
        private ArrayList<String> statements;

        public Statements() {
            this.statements = new ArrayList<String>();
            this.limit = 0;
        }

        public Statements(int limit) {
            this.statements = new ArrayList<String>();
            this.limit = limit;
        }

        public void addStatement(String statement) {
            this.statements.add(statement);
        }

        public void addStatement(String statement, int limit) {
            this.statements.add(statement);
            this.limit += limit;
        }

        public void build() {
            Write(String.format(".limit stack %d", this.limit));
            for (String statement : statements) {
                Write(statement);
            }
        }
    }

    private Map<String, String> refTable = new HashMap<String, String>();
    private ArrayList<String> fields = new ArrayList<String>();
    Function setup;

    private FileOutputStream newClass;

    public ByteCodeVisitor() throws IOException {
        String path = "/HOME/CodeGene/GlobalReferenceTable";
        //       Files.readAllLines(f.getPath(), Charset);

        String cwd = new File("").getAbsolutePath();
        System.out.println(cwd);

        File f = new File(cwd + path);

        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String[] matches = sc.nextLine().split("@");
            refTable.put(matches[0].trim(), matches[1]);
        }

        File newClassFile = new File(cwd + "/HOME/CodeGene/" + "Output_test.j");
        newClass = new FileOutputStream(newClassFile);

        Scanner metaClass = new Scanner(new File("./HOME/CodeGene/Frame"));
        while (metaClass.hasNextLine()) {
            Write(metaClass.nextLine());
        }

        // Below initiates the class itself, re-check to see how this is properly done.
//        .method public <init>()V
//                aload_0
//        invokenonvirtual java/lang/Object/<init>()V
//        return
//        ._end method

    }

    public void build() {
        for (String field : fields) {
            Write(field);
        }

        Write("");

        setup.build();
    }

    @Override
    public Object visitExpression(@NotNull HOMEParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Object visitFunction(@NotNull HOMEParser.FunctionContext ctx) {
        this.setup = new Function(".method public static main([Ljava/lang/String;)V",
                                  ".end method");
        setup.stmts = new Statements(1);

        visitStmts(ctx.stmts(), setup.stmts);

        return super.visitFunction(ctx);
    }

    public void visitStmts(@NotNull HOMEParser.StmtsContext ctx, Statements _stmts ) {
        if (ctx.stmts() != null){
            visitStmt(ctx.stmt(), _stmts);
            visitStmts(ctx.stmts(), _stmts);
        }
    }

    public void visitStmt(@NotNull HOMEParser.StmtContext ctx, Statements _stmts) {
        _stmts.addStatement("    " + ctx.getText(), 1);
    }

    @Override
    public Object visitMoreFunctions(@NotNull HOMEParser.MoreFunctionsContext ctx) {
        return super.visitMoreFunctions(ctx);
    }

    @Override
    public Object visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx) {
        // .field
        String declaration = refTable.get(ctx.type().getText().trim());

        declaration = declaration.replace("<field-name>",ctx.identifierOrListIndex().getText());

        if(ctx.expression()!=null) {
            declaration = declaration.replace("<value>", ctx.expression().getText()); // replace with whatever the expression returns.
        } else {
            declaration = declaration.replace("<value>", "0");
        }
        fields.add(declaration);

        return super.visitDeclaration(ctx);
    }

    private void checkGlobal(HOMEParser.DeclarationContext ctx) // change the input to be more general
    {
        // Checks whether the variable is global, if it is, add a .fields to the output
        String declaration = refTable.get(ctx.type().getText().trim());

        declaration = declaration.replace("<field-name>",ctx.identifierOrListIndex().getText());

        if(ctx.expression()!=null) {
            declaration = declaration.replace("<value>", ctx.expression().getText()); // replace with whatever the expression returns.
        } else {
            declaration = declaration.replace("<value>", "0");
        }
        fields.add(declaration);
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
