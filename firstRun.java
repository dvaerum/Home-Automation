import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by Jacob on 20-03-14.
 */
public class firstRun extends HelloBaseVisitor<Type> {

    SymbolTable scope = MainTwo.scope;

    @Override
    public Type visitBlock(@NotNull HelloParser.BlockContext ctx)
    {
        Type returnType = new Type(Type.TypeEnum.Nothing);
        Type blockType;

        //Checks if function already exist
        if(ctx.function() != null)
        {
            returnType = visitFunction(ctx.function());
            if(returnType.equals(Type.TypeEnum.Error))
                return returnType;
        }

        //Calls visitBlock recursively if it hasn't failed already.
        if(ctx.block() != null && ctx.block().getChildCount() > 0)
        {
            blockType = visitBlock(ctx.block());
            if(!blockType.equals((Type.TypeEnum.Nothing)))
                returnType = blockType;
        }

        return returnType;
    }

    @Override
    public Type visitFunction(@NotNull HelloParser.FunctionContext ctx)
    {
        Type returnType;
        Type returns = visitType(ctx.type());
        String funcName = ctx.getChild(1).getText();

        if(!scope.AddSymbol(ctx.getChild(1).getText(), returns.typeEnum))
            returnType = new Type(Type.TypeEnum.Error, String.format("Function %s is duplicated at line %d", funcName, ctx.getStart().getLine()));
        else
            returnType = new Type(Type.TypeEnum.Nothing, String.format("Function %s inserted", funcName));

        return returnType;
        //return new Types(Types.Type.Nothing);
    }

    @Override
    public Type visitType(@NotNull HelloParser.TypeContext ctx)
    {
        return visitPrimitiveType(ctx.primitiveType());
    }

    @Override
    public Type visitPrimitiveType(@NotNull HelloParser.PrimitiveTypeContext ctx)
    {
        Type returnType;

        switch (Type.TypeEnum.valueOf(ctx.getText())){
            case Integer:
                returnType = new Type(Type.TypeEnum.Integer);
                break;
            case Decimal:
                returnType = new Type(Type.TypeEnum.Decimal);
                break;
            case Boolean:
                returnType = new Type(Type.TypeEnum.Boolean);
                break;
            case String:
                returnType = new Type(Type.TypeEnum.String);
                break;
            case Nothing:
                returnType = new Type(Type.TypeEnum.Nothing);
                break;
            default:
                returnType = new Type(Type.TypeEnum.Error, "Unknown primitive type");
                break;
        }
        return returnType;
    }
}
