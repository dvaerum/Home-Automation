import java.util.Stack;

public class VarListener extends HelloBaseListener {

    private Stack<Scope> scopes;

    public VarListener() {
        scopes = new Stack<Scope>();
        scopes.push(new Scope(null));
    }

    @Override
    public void enterProgramtest(HelloParser.ProgramtestContext ctx)
    {
        System.out.println("Visiting program");
    }
    @Override
    public void enterFunction(HelloParser.FunctionContext ctx)
    {
        String functionName = ctx.getChild(1).getText();
        //Value type = ctx.type();
        scopes.push(new Scope(scopes.peek()));
        System.out.println("New scope: " + scopes.size());

        System.out.println("Function: " + functionName);
    }

    public void exitFunction(HelloParser.FunctionContext ctx)
    {
        scopes.pop();
        System.out.println("New scope: " + scopes.size());
    }

    @Override
    public void enterTeststmts(HelloParser.TeststmtsContext ctx)
    {
        System.out.println("Stmts");
    }

    @Override
    public void enterDeclaration(HelloParser.DeclarationContext ctx)
    {
        if(ctx.type().primitiveType() != null)
        {
            System.out.println("Decl: " + ctx.type().primitiveType().getText() + " " + ctx.getChild(1).getText());
            if(ctx.getChildCount() > 2)
                System.out.println("=" + ctx.expression().getText());
        }
        else if(ctx.type().collectionType() != null)
            System.out.println("Collection type");
    }
    
    //i this comment is self-explanatory
    @Override
    public void enterExpression(HelloParser.ExpressionContext ctx)
    {
        System.out.println();

        System.out.println("Visiting expression");
        if(ctx.literal() != null)
        {
            if(ctx.literal().IntegerLiteral() != null)
            {

            }
            else if(ctx.literal().booleanLiteral() != null)
            {

            }
        }
    }

    @Override
    public void enterBooleanLiteral(HelloParser.BooleanLiteralContext ctx)
    {
    }

    private void checkVarName(String varName) {
        Scope scope = scopes.peek();
        if(scope.inScope(varName)) {
            System.out.println("OK   : " + varName);
        }
        else {
            System.out.println("Oops : " + varName);
        }
    }
}