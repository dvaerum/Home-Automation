import com.sun.org.apache.xpath.internal.SourceTree;
import org.antlr.v4.runtime.misc.NotNull;

import javax.xml.bind.ValidationEvent;

/**
 * Created by Jacob on 13-03-14.
 */
public class ExtractHelloVisitor extends HelloBaseVisitor<Types>
{
//    @Override
//    public Types visitProgramtest(@NotNull HelloParser.ProgramtestContext ctx)
//    {
//        System.out.println("Hej fra programtest");
//        return new Types();
//    }

    enum types {Integer, Decimal, Boolean, String};

    @Override
    public Types visitAssign(@NotNull HelloParser.AssignContext ctx)
    {
        Types returnType = null;
        Types type = super.visitExpression(ctx.expression());

        System.out.println(ctx.getChild(0) + " = " + type);

        return returnType = type;
    }

    @Override
    public Types visitDeclaration(@NotNull HelloParser.DeclarationContext ctx)
    {
        Types returnType = null;
        Types type = super.visitType(ctx.type());
        Types expression = super.visitExpression(ctx.expression());

        //System.out.println(type + " ?= " + expression);

        if(type.equals(expression))
        {
            returnType = new Types(type.type, expression.value);
        }
        else
            System.out.println("Oops: DeclError " + type + " != " + expression);


        if(ctx.getChildCount() > 2)
            System.out.println(ctx.getChild(1) + " = (" + returnType + ")");

        return returnType;
    }

    @Override
    public Types visitExpression(@NotNull HelloParser.ExpressionContext ctx)
    {
        Types returnType = null;
        if(ctx.literal() != null)
            returnType = super.visitLiteral(ctx.literal());

        System.out.println("Expr: " + returnType);
//        return new Types(Types.Type.Integer);
        return returnType;
    }

    @Override
    public Types visitLiteral(@NotNull HelloParser.LiteralContext ctx)
    {
        Types returnType = new Types(Types.Type.None);
        Object value = ctx.getChild(0);


        if(ctx.IntegerLiteral() != null)
            returnType = new Types(Types.Type.Integer, value);
        else if(ctx.booleanLiteral() != null)
            returnType = new Types(Types.Type.Boolean, value);
        else if(ctx.DecimalLiteral() != null)
            returnType = new Types(Types.Type.Decimal, value);
        else if(ctx.StringLiteral() != null)
            returnType = new Types(Types.Type.String, value);

        return returnType;
    }

    @Override
    public Types visitPrimitiveType(@NotNull HelloParser.PrimitiveTypeContext ctx)
    {
        Types returnType;

        //System.out.println("Visiting: " + ctx.getText());

        switch (types.valueOf(ctx.getText())){
            case Integer:
                returnType = new Types(Types.Type.Integer);
                break;
            case Decimal:
                returnType = new Types(Types.Type.Decimal);
                break;
            case Boolean:
                returnType = new Types(Types.Type.Boolean);
                break;
            case String:
                returnType = new Types(Types.Type.String);
                break;
            default:
                returnType = null;
                break;
        }
        return returnType;
    }
}
