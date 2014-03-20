import com.sun.org.apache.xpath.internal.SourceTree;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;

import javax.xml.bind.ValidationEvent;
import java.beans.Expression;
import java.security.KeyStore;
import java.util.Stack;

/**
 * Created by Jacob on 13-03-14.
 */
public class ExtractHelloVisitor extends HelloBaseVisitor<Type>
{
    SymbolTable scope = MainTwo.scope;
    String currentFunction = "";
    ForkReturnStack forkReturnStack = new ForkReturnStack();

    @Override
    public Type visitStmts(@NotNull HelloParser.StmtsContext ctx)
    {
        Type returnType = null;

        if(ctx.stmt().declaration() != null)
            returnType = visitDeclaration(ctx.stmt().declaration());
        else if(ctx.stmt().assign() != null)
            returnType = visitAssign(ctx.stmt().assign());
        else if(ctx.stmt().ifStmt() != null){
            returnType = visitIfStmt(ctx.stmt().ifStmt());

            if(forkReturnStack.closed() && ctx.stmt().ifStmt().elseStmt() != null){
                if(ctx.stmts().getChildCount() > 0)
                {
                    //Unreachable code ahead!
                    System.out.println("Unreachable code found, after if/else stuff");
                    ctx.removeLastChild();
                }

                forkReturnStack.dispose();
                forkReturnStack.addReturn();
            } else {
                forkReturnStack.dispose();
            }

        }
        else if(ctx.stmt().loop() != null)
            returnType = visitLoop(ctx.stmt().loop());
        else if(ctx.stmt().funcCall() != null)
            returnType = super.visitFuncCall(ctx.stmt().funcCall());
        else if(ctx.stmt().returnFunction() != null)
        {
            returnType = visitReturnFunction((ctx.stmt().returnFunction()));
            if(returnType == null)
                returnType = new Type(Type.TypeEnum.Error, String.format("Missing return statement at function: %s", currentFunction));
            else if(ctx.stmts().getChildCount() > 0)
            {
                System.out.println(String.format("Warning line %d: Reached unreachable code!", ctx.getStart().getLine()));
                ctx.removeLastChild();
            }
        }

        if(returnType.equals(Type.TypeEnum.Error))
        {
            System.out.println(String.format("\tERROR line %d: %s", ctx.getStart().getLine(), returnType.value));
            return returnType;
        }

        if(ctx.stmts() != null && ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        return returnType;
    }

    @Override
    public Type visitFunction(@NotNull HelloParser.FunctionContext ctx)
    {
        String name = ctx.getChild(1).getText();
        Type returnType;

        currentFunction = name;

        if(ctx.type() != null)
            returnType = visitType(ctx.type());
        else
            returnType = new Type(Type.TypeEnum.Nothing);

//        scope.AddSymbol(name, returnType);
        scope.OpenScope();

        forkReturnStack.newStack();
        forkReturnStack.addFork();

        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        if(forkReturnStack.closed()){
            //We have a return statement
            System.out.println("Yay, return!");
        } else {
            System.out.println("No return statement found");
        }

        forkReturnStack.dispose();

        scope.CloseScope();
        return returnType;
    }

    @Override
    public Type visitReturnFunction(@NotNull HelloParser.ReturnFunctionContext ctx)
    {
        Type returnType = null;
        if(scope.SymbolExists(currentFunction))
        {
            Type expressionType;
            if(ctx.expression() == null){
                expressionType = new Type(Type.TypeEnum.Nothing);
            } else {
                expressionType = visitExpression(ctx.expression());
            }

            Type functionType = new Type(scope.GetSymbol(currentFunction).type.typeEnum);

            if(expressionType.equals(Type.TypeEnum.Error))
                return expressionType;
            if(functionType.equals(expressionType)){
                returnType = new Type(functionType.typeEnum);
                forkReturnStack.addReturn();
            }
        else if(functionType.equals(Type.TypeEnum.Decimal) && expressionType.equals(Type.TypeEnum.Integer))
            {
                System.out.println("\tReturnshit should be converted, yo mama");
                returnType = new Type(functionType.typeEnum);

                forkReturnStack.addReturn();
            }
            else
                returnType = new Type(Type.TypeEnum.Error, String.format("expected return-statement of type: %s, got %s", functionType, expressionType));
        }

        return returnType;
    }

    @Override
    public Type visitAssign(@NotNull HelloParser.AssignContext ctx)
    {
        Type returnType;

        String identifier = ctx.getChild(0).getText();
        if(!scope.SymbolExists(identifier))
            return new Type(Type.TypeEnum.Error, String.format("Assign to unknown identifier : %s", identifier));

        Type type = new Type(scope.GetSymbol(identifier).type.typeEnum);


        Type expression = visitExpression(ctx.expression());
        if(expression.equals(Type.TypeEnum.Error))
            return expression;

        if(type.equals(expression))
        {
            returnType = new Type(type.typeEnum, expression.value);
        }
        else if(type.equals(Type.TypeEnum.Decimal) && expression.equals(Type.TypeEnum.Integer))
        {
            System.out.println("\tShit should be converted, yo mama!");
            returnType = new Type(type.typeEnum, expression.value);
        }
        else
        {
            returnType = new Type(Type.TypeEnum.Error, String.format("Incompatible types. Expected %s, got %s", type.typeEnum, expression.typeEnum));
        }



        //System.out.println("\t" + ctx.getChild(0).getText() + " = " + returnType);

        return returnType;
    }

    @Override
    public Type visitDeclaration(@NotNull HelloParser.DeclarationContext ctx)
    {
        System.out.println("enter declaration....");
        Type returnType;
        Type type = visitType(ctx.type());
        String identifier = ctx.getChild(1).getText();
        Type expression = null;

        //if expression found: integer i = something
        if(ctx.expression() != null)
        {
            expression = visitExpression(ctx.expression());
            if(expression.equals(Type.TypeEnum.Error))
                return expression;

      }

        if(!scope.AddSymbol(identifier, type.typeEnum))
            return new Type(Type.TypeEnum.Error, String.format("Can't declare symbol. %s already exists!", identifier));


        //if "integer i", return no value back. If "Integer i = 3" return value
        if(expression == null || type.equals(expression))
        {
            returnType = new Type(type.typeEnum, expression == null ? "" : expression.value);
        }
        else if(type.equals(Type.TypeEnum.Decimal) && expression.equals(Type.TypeEnum.Integer))
        {
            System.out.println("\tShit should be converted, yo mama!");
            returnType = new Type(type.typeEnum, expression.value);
        }
        else
            returnType = new Type(Type.TypeEnum.Error, String.format("Incompatible types. Expected %s, got %s", type.typeEnum, expression.typeEnum));

        return returnType;
    }

    @Override
    public Type visitExpression(@NotNull HelloParser.ExpressionContext ctx)
    {
        Type returnType = new Type(Type.TypeEnum.Error, "Unknown expression");

        if(ctx.expression().size() > 0)
        {
            Type r1, r2;
            String operator;

            //( Expr )
            if(ctx.expression().size() == 1)
            {
                HelloParser.ExpressionContext currCtx = ctx.expression(0);
                while(currCtx.expression().size() == 1)
                {
                    currCtx = currCtx.expression(0);
                }

                r1 = visitExpression(currCtx.expression(0));
                operator = currCtx.getChild(1).getText();
                r2 = visitExpression(currCtx.expression(1));
//                visitExpression(ctx.expression(0));
            }else{
                r1 = visitExpression(ctx.expression(0));
                operator = ctx.getChild(1).getText();
                r2 = visitExpression(ctx.expression(1));
            }

            //1. Check if types are equal
            //2. Check if types are decimal and integer
            if(Type.isBooleanOperator(operator))
            {
                returnType = new Type(Type.TypeEnum.Boolean, r1.value + operator + r2.value);
            }
            else if(r1.equals(r2))
            {
                returnType = new Type(r1.typeEnum, r1.value + operator + r2.value);
            }
            else if((r1.equals(Type.TypeEnum.Integer) && r2.equals(Type.TypeEnum.Decimal)) || (r1.equals(Type.TypeEnum.Decimal) && r2.equals(Type.TypeEnum.Integer)))
            {
//                System.out.println("\tShit should be converted, yo mama!");
                returnType = new Type(Type.TypeEnum.Decimal, r1.value + operator + r2.value);
            }
            else if(r1.typeEnum == Type.TypeEnum.Error){
                returnType = r1;
            }
            else if(r2.typeEnum == Type.TypeEnum.Error){
                returnType = r2;
            }
            else
            {
//                System.out.println("\tFuckhoved!: " + r1.type + "!=" + r2.type);
                returnType = new Type(Type.TypeEnum.Error, String.format("Incompatible types %s and %s", r1.typeEnum, r2.typeEnum));
            }

        }
        else if(ctx.literal() != null)
        {
            returnType = visitLiteral(ctx.literal());
        }
        else if(ctx.identifierOrListIndex() != null)
        {
            String symbol = ctx.identifierOrListIndex().getChild(0).getText();
            if(!scope.SymbolExists(symbol))
            {
                returnType = new Type(Type.TypeEnum.Error, String.format("Couldn't evaluate expression. Symbol %s doesn't exist", symbol));
            }
            else
                returnType = new Type((scope.GetSymbol(symbol).type.typeEnum));
        }

        return returnType;
    }

    @Override
    public Type visitLiteral(@NotNull HelloParser.LiteralContext ctx)
    {
        Type returnType = null;
        Object value = ctx.getChild(0);

        if(ctx.IntegerLiteral() != null)
            returnType = new Type(Type.TypeEnum.Integer, value);
        else if(ctx.booleanLiteral() != null)
            returnType = new Type(Type.TypeEnum.Boolean, ctx.getChild(0).getChild(0));
        else if(ctx.DecimalLiteral() != null)
            returnType = new Type(Type.TypeEnum.Decimal, value);
        else if(ctx.StringLiteral() != null)
            returnType = new Type(Type.TypeEnum.String, value);

        return returnType;
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
            default:
                returnType = new Type(Type.TypeEnum.Error, "Unknown primitive type");
                break;
        }
        return returnType;
    }


    @Override
    public Type visitIfStmt(@NotNull HelloParser.IfStmtContext ctx)
    {
        scope.OpenScope();

        forkReturnStack.newStack();
        forkReturnStack.addFork();

        Type returnType = null;

        if(ctx.expression() != null)
            returnType = visitExpression(ctx.expression());

        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        scope.CloseScope();

        if(ctx.elseIfStmt().size() > 0)
        {
            for (HelloParser.ElseIfStmtContext currCtx : ctx.elseIfStmt())
            {
                forkReturnStack.addFork();
                if(visitElseIfStmt(currCtx).equals(Type.TypeEnum.Error))
                    return new Type(Type.TypeEnum.Error);
            }
        }

        if(ctx.elseStmt() != null){
            forkReturnStack.addFork();
            if(visitElseStmt(ctx.elseStmt()).equals(Type.TypeEnum.Error)){
                return new Type(Type.TypeEnum.Error);
            }
        }

        return returnType;
    }

    @Override
    public Type visitElseIfStmt(@NotNull HelloParser.ElseIfStmtContext ctx)
    {
        scope.OpenScope();
        Type returnType = null;
//        System.out.println("\tIf statement: ");

        if(ctx.expression() != null)
            returnType = visitExpression(ctx.expression());

        if(ctx.stmts() != null)
            visitStmts(ctx.stmts());

        scope.CloseScope();
        return returnType;
    }


    @Override
    public Type visitElseStmt(@NotNull HelloParser.ElseStmtContext ctx)
    {
        scope.OpenScope();

        Type returnType = new Type(Type.TypeEnum.Boolean);

        if(ctx.stmts() != null)
            visitStmts(ctx.stmts());

        scope.CloseScope();
        return returnType;
    }

    @Override
    public Type visitLoop (@NotNull HelloParser.LoopContext ctx)
    {
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        Type returnType = null;
//        System.out.println("\trepeat statement: ");

        if(ctx.loopWhileOrUntil() != null)
            returnType = visitLoopWhileOrUntil(ctx.loopWhileOrUntil());
        else if (ctx.loopForeach() != null)
            returnType = super.visitLoopForeach(ctx.loopForeach());

//        System.out.println("\t" + returnType);

        forkReturnStack.dispose();

        return returnType;
    }

    public Type visitLoopWhileOrUntil(@NotNull HelloParser.LoopWhileOrUntilContext ctx)
    {
        scope.OpenScope();

        String loopType = ctx.getChild(1).getText();
        Type returnType = visitExpression(ctx.expression());

        if(!returnType.equals(Type.TypeEnum.Boolean))
            returnType = new Type(Type.TypeEnum.Error, String.format("Loop expressions should be of type Boolean - got %s", returnType.typeEnum));

        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        scope.CloseScope();
        return returnType;
    }

//    public Type visitLoopForeach(@NotNull HelloParser.LoopForeachContext ctx)
//    {
//        scope.OpenScope();
//
//        scope.CloseScope();
//    }
}

//TODO: Check if function parameters is type correct
//TODO: Unreachable code in if's and loops
//TODO: Prevent infinite loops
