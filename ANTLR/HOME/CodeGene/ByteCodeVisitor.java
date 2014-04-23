package HOME.CodeGene;

import HOME.Grammar.HOMEBaseVisitor;
import HOME.Grammar.HOMEParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Michael on 14/04/14.
 */
public class ByteCodeVisitor extends HOMEBaseVisitor {

    private Map<String, String> refTable = new HashMap<String, String>();
    private ArrayList<String> fields = new ArrayList<String>();
    private ArrayList<String> setup = new ArrayList<String>();

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
//        .end method

    }

    public void build() {
        for (String field : fields) {
            Write(field);
        }
    }

    @Override
    public Object visitExpression(@NotNull HOMEParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Object visitFunction(@NotNull HOMEParser.FunctionContext ctx) {
        // .method public static main([Ljava/lang/String;)V
        setup.add(".method public static main([Ljava/lang/String;)V");

        setup.add(".end method");
        // .end method
       return super.visitFunction(ctx);
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

    private void Write(String out) {
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
