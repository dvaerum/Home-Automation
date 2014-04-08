import org.antlr.v4.runtime.misc.NotNull;

import java.util.Stack;

/**
 * Created by alt_mulig on 4/8/14.
 */
public class CustomBaseListener extends HOMEBaseListener {
//    private Stack<Scope> scopes;

    public CustomBaseListener() {
//        scopes = new Stack<Scope>();
//        scopes.push(new Scope(null));
    }

    @Override
    public void enterExpression(@NotNull HOMEParser.ExpressionContext ctx) {
        super.enterExpression(ctx);
    }
}
