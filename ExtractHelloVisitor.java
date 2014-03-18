import com.sun.org.apache.xpath.internal.SourceTree;
import org.antlr.v4.runtime.misc.NotNull;

import javax.xml.bind.ValidationEvent;
import java.beans.Expression;
import java.security.KeyStore;

/**
 * Created by Jacob on 13-03-14.
 */
public class ExtractHelloVisitor extends HelloBaseVisitor<Types>
{

    @Override
    public Types visitAssign(@NotNull HelloParser.AssignContext ctx)
    {
        Types returnType = null;
        Types type = visitExpression(ctx.expression());

        System.out.println(ctx.getChild(0) + " = " + type);

        return returnType = type;
    }

    @Override
    public Types visitDeclaration(@NotNull HelloParser.DeclarationContext ctx)
    {
        Types returnType = null;
        Types type = visitType(ctx.type());
        Types expression = visitExpression(ctx.expression());

        if(type.equals(expression))
        {
            returnType = new Types(type.type, expression.value);
        }
        else if(type.equals(Types.Type.Decimal) && expression.equals(Types.Type.Integer))
        {
            System.out.println("Shit should be converted, yo mama!");
            returnType = new Types(type.type, expression.value);
        }
        else
            System.out.println("Oops: DeclError " + type + " != " + expression);


        if(ctx.getChildCount() > 2)
            System.out.println(ctx.getChild(1) + " = " + returnType);

        return returnType;
    }

    @Override
    public Types visitExpression(@NotNull HelloParser.ExpressionContext ctx)
    {
        Types returnType = null;

        if(ctx.expression().size() > 0)
        {
            Types r1 = visitExpression(ctx.expression(0));
            String operator = ctx.getChild(1).getText();
            Types r2 = visitExpression(ctx.expression(1));

            System.out.println("Operator: " + operator);

//1. Check if types are equal
            //2. Check if types are decimal and integer
            if(r1.equals(r2))
            {
                returnType = new Types(r1.type, ctx.getChild(1));
            }
            else if((r1.equals(Types.Type.Integer) && r2.equals(Types.Type.Decimal)) || (r1.equals(Types.Type.Decimal) && r2.equals(Types.Type.Integer)))
            {
                System.out.println("Shit should be converted, yo mama!");
                returnType = new Types(Types.Type.Decimal);
            }
            else
            {
                System.out.println("Fuckhoved!");
            }

        }
        else if(ctx.literal() != null)
        {
            returnType = visitLiteral(ctx.literal());
            System.out.println("Expr literal: " + returnType);
        }


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
            returnType = new Types(Types.Type.Boolean, ctx.getChild(0).getChild(0));
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

        switch (Types.Type.valueOf(ctx.getText())){
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

/*    @Override
    public Types visitStmt(@NotNull HelloParser.StmtContext ctx)
    {
        Types returnType;


        return null;
    }*/


    @Override
    public Types visitIfStmt(@NotNull HelloParser.IfStmtContext ctx){
        System.out.println("Hello world");

        return null;
    }

//    @Override
//    public Types visitFunction(@NotNull HelloParser.FunctionContext ctx){
//        System.out.println("Hello");
//
//        return new Types(Types.Type.Function);
//    }
}
