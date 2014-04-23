package HOME;
import HOME.Grammar.*;
import HOME.Type.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jacob on 13-03-14.
 */
public class TypeChecker extends HOMEBaseVisitor<Type>
{
    String currentFunction = "";
    ForkReturnStack forkReturnStack = new ForkReturnStack();

    @Override
    public Type visitStmts(@NotNull HOMEParser.StmtsContext ctx)
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
            returnType = visitFuncCall(ctx.stmt().funcCall());
        else if(ctx.stmt().returnFunction() != null)
        {
            returnType = visitReturnFunction((ctx.stmt().returnFunction()));
            if(returnType == null)
                returnType = new ErrorType( String.format("Missing return statement at function: %s", currentFunction));
            else if(ctx.stmts().getChildCount() > 0)
            {
                System.out.println(String.format("Warning line %d: Reached unreachable code!", ctx.getStart().getLine()));
                ctx.removeLastChild();
            }
        }
        else if(ctx.stmt().variableMethodCall() != null)
            returnType = visitVariableMethodCall(ctx.stmt().variableMethodCall());
        else if(ctx.stmt().incDec() != null)
        {
            returnType = visitIncDec(ctx.stmt().incDec());
        }

        if(returnType instanceof ErrorType)
        {
            System.out.println(String.format("\tERROR line %d: %s", ctx.getStart().getLine(), returnType.toString()));
            return returnType;
        }

        if(ctx.stmts() != null && ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        return returnType;
    }

    @Override
    public Type visitIdentifierOrListIndex(@NotNull HOMEParser.IdentifierOrListIndexContext ctx)
    {
        Type returnType;
        //TODO: Collections!
        /*
        if(ctx.getChildCount()> 1 && ctx.getChild(1).getText().equals("["))
        {
            String symbol = ctx.getChild(0).getText();
            if(Main.symbolTable.variables.symbolExists(symbol))
            {
                returnType = new ErrorType(String.format("Unknown identifier. Symbol %s doesn't exist in the current context", symbol));
            }
            else
            {
                returnType = Main.symbolTable.variables.getSymbol(symbol)....... //scope.getSymbol(symbol).type.typeParameters.get(0);
            }
        }
        else
        */
        {
            String symbol = ctx.getChild(0).getText();
            if(!Main.symbolTable.variables.symbolExists(symbol))
            {
                returnType = new ErrorType(String.format("Unknown identifier. Symbol \"%s\" doesn't exist in the current context", symbol));
            }
            else
                returnType = Main.symbolTable.variables.getSymbol(symbol).type;
        }
        return returnType;
    }

    @Override
    public Type visitFunction(@NotNull HOMEParser.FunctionContext ctx)
    {
        //Name of function
        String name = ctx.getChild(1).getText();
        Type returnType;

        currentFunction = name;

        if(ctx.type() != null)
            returnType = visitType(ctx.type());
        else
            returnType = Main.nothing;

//        scope.addSymbol(name, returnType);
        Main.symbolTable.openScope();

        //Initializes stack for counting returns
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        //Adds parameters to current function. Can now be used in scope of function.
        visitDeclarationParameters(ctx.declarationParameters());

        Type stmtsType = null;

        //Checks for stmts before visiting
        if(ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());

        if(stmtsType != null && !(stmtsType instanceof ErrorType) && !returnType.equals(Main.nothing))
        {

            if(forkReturnStack.closed())
            {
                //forks=returns. We have a return statement
                System.out.println(String.format("Info at line %d: Yay, return!", ctx.getStart().getLine()));
            } else {
                System.out.println(String.format("Warning at line %d: Function doesn't contain any return statement", ctx.getStart().getLine()));
            }
        }

        forkReturnStack.dispose();

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitFuncCall(@NotNull HOMEParser.FuncCallContext ctx)
    {
        Type returnType;
        String funcName = ctx.identifierOrListIndex().getText();

        ArrayList<Type> paramList = getFunctionParameters(ctx.funcParameters());  //(ArrayList<Type>)visitFuncParameters(ctx.funcParameters()).value;

        if(funcName.equals("Setup"))
        {
            returnType = new ErrorType("\"Setup\" function can't be called.");
        }
        else if(Main.symbolTable.functions.symbolExists(funcName))
        {
            if(Type.isListSubtypeOfList(paramList, Main.symbolTable.functions.getSymbol(funcName).parameters))
                returnType = Main.symbolTable.functions.getSymbol(funcName).returnType;
                //returnType = new HOME.Type("Nothing");
            else
                returnType = new ErrorType(String.format("Function parameters doesn't match target function " +
                        "(too many/invalid type(s))"));
        }
        else
            returnType = new ErrorType(String.format("Function %s isn't defined", funcName));

        return returnType;
    }

    public ArrayList<Type> getFunctionParameters(@NotNull HOMEParser.FuncParametersContext ctx)
    {
        ArrayList<Type> returnList = new ArrayList<>();

        for(HOMEParser.ExpressionContext currExpr : ctx.expression())
        {
            if(currExpr.expression() != null)
                returnList.add(visitExpression(currExpr));
        }

        return returnList;
    }
/*
    @Override
    public Type visitFuncParameters(@NotNull HOMEParser.FuncParametersContext ctx)
    {
        Type returnType = new Type("Nothing", new ArrayList<Type>());
        ArrayList<Type> genericList = new ArrayList<>();

        for(HOMEParser.ExpressionContext currCtx : ctx.expression())
        {
            if(currCtx.expression() != null)
                genericList.add(visitExpression(currCtx));

//            //literal
//            if(currCtx.literal() != null)
//                genericList.add(visitLiteral(currCtx.literal()));
//            else if(currCtx.identifierOrListIndex() != null) //variable
//                genericList.add(new HOME.Type(scope.getSymbol(currCtx.getText()).type.primaryType));
//            else
//                System.out.println("WARNING: INCORRECT FUNCTION PARAMETER!: " + currCtx.getText());
        }

        returnType.value = genericList;
        return returnType;
    }

*/
    @Override
    public Type visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx)
    {
        Type returnType = Main.nothing;

        for(HOMEParser.DeclarationContext currCtx : ctx.declaration())
        {
            Main.symbolTable.variables.addSymbol(currCtx.identifierOrListIndex().getText(), visitType(currCtx.type()));
        }

        return returnType;
    }


    @Override
    public Type visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx)
    {
        Type returnType = null;
        if(Main.symbolTable.functions.symbolExists(currentFunction))
        {
            Type expressionType;
            if(ctx.expression() == null){
                expressionType = Main.nothing;
            } else {
                expressionType = visitExpression(ctx.expression());
            }

            Type functionType = Main.symbolTable.functions.getSymbol(currentFunction).returnType;

            if(expressionType instanceof ErrorType)
                return expressionType;
            if(functionType.equals(expressionType)){
                returnType = functionType;
                forkReturnStack.addReturn();
            }
            else if(expressionType.isSubtypeOf(functionType))
            {
                System.out.println(String.format("\t(Line %d) Return Integer should be converted", ctx.getStart().getLine()));
                returnType = functionType;

                forkReturnStack.addReturn();
            }
            else
                returnType = new ErrorType(String.format("Expected return-statement of type: %s, got %s", functionType, expressionType));
        }

        return returnType;
    }

    @Override
    public Type visitAssign(@NotNull HOMEParser.AssignContext ctx)
    {
        String identifier;
        Type LHSType = null;
        Type returnType;

        if(ctx.identifierOrListIndex() != null)
        {
            identifier = ctx.identifierOrListIndex().getChild(0).getText();

            //Sees if Collection exists
            if(!Main.symbolTable.variables.symbolExists(identifier))
                return new ErrorType( String.format("Assign to unknown identifier : %s", identifier));

            //Check for bracket "[" list[2] = 34
            // a = 2
            //TODO: Wait for collections to work again

            if(ctx.identifierOrListIndex().getChildCount()>1 && ctx.identifierOrListIndex().getChild(1).getText().equals("["))
                ;
                //LHSType = Main.symbolTable.variables.getSymbol(identifier)......       //scope.getSymbol(identifier).type.typeParameters.get(0);
            else
                LHSType = Main.symbolTable.variables.getSymbol(identifier).type;
        }
        else
        {
            identifier = ctx.getChild(0).getText();
            if(!Main.symbolTable.variables.symbolExists(identifier))     //!scope.symbolExists(identifier)
                return new ErrorType( String.format("Assign to unknown identifier : %s", identifier));
        }

        Type expression = visitExpression(ctx.expression());
        if(expression instanceof ErrorType)
            return expression;

        if(expression.isSubtypeOf(LHSType))      //LHSType.compatibleWith(expression)
        {
            returnType = LHSType;
        }
        else if(LHSType.equals(Main.decimal) && expression.equals(Main.integer))
        {
            System.out.println(String.format("\t(Assign)(Line %d) Integer should be converted", ctx.getStart().getLine()));
            returnType = LHSType;
        }
        else
        {
            returnType = new ErrorType(String.format("Incompatible types. Expected %s, got %s", LHSType, expression));
        }

        return returnType;
    }


    @Override
    public Type visitDeclaration(@NotNull HOMEParser.DeclarationContext ctx)
    {
         Type returnType;
        //TODO: Collections......
        /*if (ctx.type().collectionType() != null) {
            returnType = visitType(ctx.type().collectionType().type());
            //checks if there's a collection of variables(list)
            if (ctx.expression() != null && ctx.expression().collectionInit() != null) {
                //foreach expression in the collections of variables...
                for (HOMEParser.ExpressionContext expressionContext : ctx.expression().collectionInit().expression()) {
                    /// ListInteger>
                    //HOME.Type expressionType = checkCollectionInit(expressionContext, true, returnType.primaryType);
                    HOME.Type expressionType = visitExpression(ctx.expression());
                    if (expressionType.equals("Error")) {
                        return expressionType;
                    }
                    if (returnType.equals(expressionType)) {
                    } else if (returnType.equals("Decimal") && expressionType.equals("Integer")) {
                        System.out.println("List- should be converted");
                    } else {
                        returnType = new HOME.Type("Error", String.format("Incompatible types. Expected %s, got %s", returnType.primaryType, expressionType.primaryType));
                        return returnType;
                    }
                }
            } else if (ctx.expression() != null) {
                return new HOME.Type("Error", "Please get your shit together Tyrone");
            }

            HOME.Type.TypeEnum collectionType;
            if (ctx.type().collectionType().getChild(0).toString().equalsIgnoreCase("List"))
                collectionType = "List";
            else if (ctx.type().collectionType().getChild(0).toString().equalsIgnoreCase("Dictionary"))
                collectionType = "Dictionary";
            else
                return new HOME.Type("Error", String.format("Could not determine collection type"));

            if (!scope.addSymbol(ctx.getChild(1).getText(), new HOME.Type(collectionType, returnType.toList()))) {
                return new HOME.Type("Error", String.format("Can't declare symbol. %s already exists!", ctx.getChild(1).getText()));
            }
            return returnType;
        }*/

        Type type = visitType(ctx.type());
        String identifier = ctx.getChild(1).getText();
        Type expression = null;

        if(type instanceof ErrorType)
            return type;

        //if expression found: integer i = something
        if(ctx.expression() != null)
        {
            expression = visitExpression(ctx.expression());
            if(expression instanceof ErrorType)
                return expression;

        }

        if(!Main.symbolTable.variables.addSymbol(identifier, type))
            return new ErrorType(String.format("Can't declare symbol. %s already exists!", identifier));


        //if "integer i", return no value back. If "Integer i = 3" return value
        if(expression == null || type.isSubtypeOf(expression))       //type.compatibleWith(expression)
        {
            returnType = type;
        }
        else if(type.equals(Main.decimal) && expression.equals(Main.integer))
        {
            System.out.println(String.format("\t(Line %d) Integer should be converted", ctx.getStart().getLine()));
            //System.out.println("\t Integer should be converted!");
            returnType = Main.decimal;
        }
        else
            returnType = new ErrorType(String.format("Incompatible types. Expected %s, got %s", type, expression));

        return returnType;
    }

    /*
    /**public HOME.Type checkCollectionInit(HOMEParser.ExpressionContext ctx, boolean isList, HOME.Type.TypeEnum targetType)
     {
     HOME.Type returnType;

     //If we're working with a list
     if(isList){

     if(ctx.collectionInit() == null){
     return visitExpression(ctx);
     }
     for(HOMEParser.ExpressionContext eCtx : ctx.collectionInit().expression())
     {
     if(!visitExpression(eCtx).equals(targetType))
     {
     return new HOME.Type("Error", "List value not right.");
     }
     }
     return new HOME.Type(targetType);
     }

     if(ctx.collectionInit().expression(0) != null && ctx.collectionInit().expression(1) == null)
     {
     returnType = new HOME.Type("Error", "Wrong initializer for dictionary.");
     }
     else if(visitExpression(ctx.collectionInit().expression(0)).equals("String"))
     {
     returnType = visitExpression(ctx.collectionInit().expression(1));
     }
     else
     {
     returnType = new HOME.Type("Error", "Dictionary key must be string!");
     }
     return returnType;
     }*/


    @Override
    public Type visitExpression(@NotNull HOMEParser.ExpressionContext ctx)
    {
        Type returnType = new ErrorType("Unknown expression");
        //Check the expression consists of additional expressiffons.

        if(ctx.expression().size() > 0)
        {
            Type r1 = null, r2 = null;
            String operator = null;

            //1 expr = expression in parenteses
            if(ctx.expression().size() == 1)
            {
                returnType = visitExpression(ctx.expression().get(0));
                if(ctx.getChild(0).getText().equals("+") || ctx.getChild(0).getText().equals("-"))
                {
                    //unary + or - can only be in front of integer and decimal
                    if(! (returnType.equals(Main.integer) || returnType.equals(Main.decimal)) )
                    {
                        returnType = new ErrorType(String.format("unary \"%s\" can only be used in front of integer or decimal", ctx.getChild(0).getText()));
                    }
                }
                /*
                //TODO: Look at when collections are ready again.
                // Move to collectionInit
                //Goes down in tree until there are more than one tree
                HOMEParser.ExpressionContext currCtx = ctx.expression(0);
                while(currCtx.expression().size() == 1 && currCtx.getChild(0).getText().equals(("(")))
                {
                    currCtx = currCtx.expression(0);
                }

                if(currCtx.expression().size() == 2)
                {
                    r1 = visitExpression(currCtx.expression(0));
                    operator = currCtx.getChild(1).getText();
                    r2 = visitExpression(currCtx.expression(1));
                    //                visitExpression(ctx.expression(0)); // Integer i = -test()
                }
                else
                {
                    return returnType = visitLiteral(currCtx.literal());
                }
                */
                return returnType;
            }
            else //else two expressions
            {
                r1 = visitExpression(ctx.expression(0));
                operator = ctx.getChild(1).getText();
                r2 = visitExpression(ctx.expression(1));

                if(r1 instanceof ErrorType)
                    return r1;

                if(isBooleanOperator(operator))
                {
                    //If AND or OR is used, check that both sides are boolean, else throw an error
                    if((operator.equals("AND") || operator.equals("OR")) && !(r1.equals(Main.bool) && r1.equals(r2)))
                        returnType = new ErrorType(String.format("AND/OR can't be used with other types than boolean"));
                        //If comparison is used, and be othsides are not numbers, throow an error
                    else if((operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=")) && !((r1.isSubtypeOf(r2) || r2.isSubtypeOf(r1)) && (r1.equals(Main.integer) || r1.equals(Main.decimal))))
                        returnType = new ErrorType(String.format("Comparison can only be used with integers and decimals"));
                        //check if both sides of expression is boolean
                    else if(((operator.equals("==") || operator.equals("!=")) && !(r1.isSubtypeOf(r2) || r2.isSubtypeOf(r1))))
                        returnType = new ErrorType("Can't use equals on different types");
                        //Else accept the expression
                    else
                        returnType = Main.bool;
                }
                // Check for a single literal
                //Check if type is equal
                //TODO: Add more types
                else if(r1.equals(r2))
                {
                    if(r1.equals(Main.bool))
                        returnType = new ErrorType("Can't use this operator with Booleans");
                    else if(r1.equals(Main.string) && !operator.equals("+"))
                        returnType = new ErrorType("String can only be concatinated with \"+\", no other operations allowed");
                    else
                        returnType = r1;            //new Type(r1.type, r1.value + operator + r2.value);
                }
                //Check if it is possible to convert from Int to Dec
                else if((r1.equals(Main.integer) && r2.equals(Main.decimal)) || (r1.equals(Main.decimal) && r2.equals(Main.integer)))
                {
                    System.out.println(String.format("\t(Line %d) Integer should be converted", ctx.getStart().getLine()));
                    returnType = Main.decimal;
                }
                //Check if one of the two results gives an error
                else if(r1 instanceof ErrorType){
                    returnType = r1;
                }
                else if(r2 instanceof ErrorType){
                    returnType = r2;
                }
                else
                {
                    returnType = new ErrorType(String.format("Incompatible types %s and %s", r1, r2));
                }
            }
        }
        // Is expression doesn't contain any expressions, use below
        else if(ctx.funcCall() != null)
        {
            returnType = visitFuncCall(ctx.funcCall());
        }
        else if(ctx.literal() != null)
        {
            returnType = visitLiteral(ctx.literal());
        }
        else if(ctx.collectionInit()!= null)
        {
            //System.out.println("Expression should not go into collectionInit()");
            returnType = visitCollectionInit(ctx.collectionInit());
        }
        else if(ctx.variableMethodCall() != null)
        {
            //System.out.println("Expression should not go into variableMethodCall() yet");
            returnType = visitVariableMethodCall(ctx.variableMethodCall());
        }
        else if(ctx.identifierOrListIndex() != null)
        {
            returnType = visitIdentifierOrListIndex(ctx.identifierOrListIndex());
        }
        return returnType;
    }
/*
    @Override
    public Type visitCollectionInit(@NotNull HOMEParser.CollectionInitContext ctx)
    {
        Type outerType = new Type("List");
        Type containedType = null;
        Type previousContained = null;
        boolean notDictionary = true;

        if (ctx.expression().size() > 0)
        {
            containedType = visitExpression(ctx.expression(0));

            // Check if initializer is a Dictionary
            for(HOMEParser.ExpressionContext expr : ctx.expression())
            {
                if(expr.collectionInit() != null && expr.collectionInit().expression().size() == 2)
                {
                    Type first = visitExpression(expr.collectionInit().expression(0));
                    Type second = visitExpression(expr.collectionInit().expression(1));
                    if (first.equals("String"))
                    {
                        if (second.equals("String"))
                        {
                            // HOME.Type is Dictionary<String> or List<List<String>>
                            outerType = new Type("ListListOrDictionary");
                        }
                        else
                        {
                            // HOME.Type is Dictionary<HOME.Type>
                            outerType = new Type("Dictionary");
                        }
                        containedType = second;
                        if (previousContained != null && !previousContained.equals(containedType))
                        {
                            // Error, different types.
                            return new Type("Error", "Invalid collection initializer");
                        }
                        previousContained = second;
                        notDictionary = false;
                    }
                    else
                    {
                        // First value in inner collectionInitializer is not String, therefore this collectionInitializer can't be a Dictionary.
                        notDictionary = true;
                        break;
                    }
                }
                else
                {
                    // Inner collectionInitializer does not have 2 values or doesn't exist, therefore this collectionInitializer can't be a Dictionary.
                    notDictionary = true;
                    break;
                }
            }

            if (notDictionary)
            {
                // Collection is List
                outerType = new Type("List");
                containedType = visitExpression(ctx.expression(0));
                previousContained = containedType;
                for(HOMEParser.ExpressionContext expr : ctx.expression())
                {
                    Type exprType = visitExpression(expr);
                    if (containedType.equals("Anything"))
                    {
                        containedType = exprType;
                    }
                    if (!previousContained.compatibleWith(exprType) && !exprType.compatibleWith(previousContained) || exprType.primaryType.equals("Error"))
                        return new Type("Error", "Invalid collection initializer");
                    previousContained = exprType;
                }
            }
        }
        else
        {
            containedType = new Type("Anything");
        }

        return new Type(outerType.primaryType, containedType.toList());
    }
*/

    @Override
    public Type visitLiteral(@NotNull HOMEParser.LiteralContext ctx)
    {
        Type returnType = null;
        Object value = ctx.getChild(0);

        if(ctx.IntegerLiteral() != null)
            returnType = Main.integer;
        else if(ctx.booleanLiteral() != null)
            returnType = Main.bool;
        else if(ctx.DecimalLiteral() != null)
            returnType = Main.decimal;
        else if(ctx.StringLiteral() != null)
            returnType = Main.string;

        return returnType;
    }

    @Override
    public Type visitType(@NotNull HOMEParser.TypeContext ctx)
    {
        if (ctx.collectionType() != null)
            return visitCollectionType(ctx.collectionType());
        //if(ctx.classes() != null)
        return visitClasses(ctx.classes());
        //return visitPrimitiveType(ctx.primitiveType());
    }
/*
    @Override
    public Type visitCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx)
    {
        //TODO: Check if working
        String outerType = ctx.getText().split("<")[0];
        //String outerType = HOME.Type.TypeEnum.valueOf(ctx.getText().split("<")[0]);
        Type innerType = visitType(ctx.type());
        return new Type(outerType, innerType.toList());
    }
*/
    @Override
    public Type visitClasses(@NotNull HOMEParser.ClassesContext ctx)
    {
        String className = ctx.getText();

        if (Main.symbolTable.types.symbolExists(className))
        {
            return Main.symbolTable.types.getSymbol(className);
        }

        return new ErrorType( "Undefined Class");
    }

//    @Override
//    public HOME.Type visitPrimitiveType(@NotNull HOMEParser.PrimitiveTypeContext ctx)
//    {
//        return new HOME.Type(ctx.getText());
//    }


    @Override
    public Type visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx)
    {
        Main.symbolTable.openScope();

        forkReturnStack.newStack();
        forkReturnStack.addFork();

        Type returnType = null;

        if(ctx.expression() != null)
            returnType = visitExpression(ctx.expression());

        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        Main.symbolTable.closeScope();

        if(ctx.elseIfStmt().size() > 0)
        {
            for (HOMEParser.ElseIfStmtContext currCtx : ctx.elseIfStmt())
            {
                forkReturnStack.addFork();
                if(visitElseIfStmt(currCtx) instanceof ErrorType)
                    return new ErrorType("Error");
            }
        }

        if(ctx.elseStmt() != null)
        {
            forkReturnStack.addFork();
            if(visitElseStmt(ctx.elseStmt()) instanceof ErrorType)
            {
                return new ErrorType("Error");
            }
        }

        return returnType;
    }

    @Override
    public Type visitElseIfStmt(@NotNull HOMEParser.ElseIfStmtContext ctx)
    {
        Main.symbolTable.openScope();
        Type returnType = null;
//        System.out.println("\tIf statement: ");

        if(ctx.expression() != null)
            returnType = visitExpression(ctx.expression());

        if(ctx.stmts() != null)
            visitStmts(ctx.stmts());

        Main.symbolTable.closeScope();
        return returnType;
    }


    @Override
    public Type visitElseStmt(@NotNull HOMEParser.ElseStmtContext ctx)
    {
        Main.symbolTable.openScope();

        Type returnType = Main.bool;

        if(ctx.stmts() != null)
            visitStmts(ctx.stmts());

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitLoop (@NotNull HOMEParser.LoopContext ctx)
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

    public Type visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx)
    {
        Main.symbolTable.openScope();

        String loopType = ctx.getChild(1).getText();

        Type returnType = visitExpression(ctx.expression());

        if(ctx.expression() != null && ctx.expression().literal() != null && ctx.expression().literal().booleanLiteral() != null)
            returnType = new ErrorType("Illegal loop expression booleanLiteral");
        else if( !(returnType instanceof ErrorType) &&  !returnType.equals(Main.bool))
            returnType = new ErrorType(String.format("Loop expressions should be of type Boolean - got %s", returnType));

        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        Main.symbolTable.closeScope();
        return returnType;
    }

    //TODO: Check if working correct
    public Type visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx)
    {
        Main.symbolTable.openScope();

        Type returnType;

        if(ctx.type() != null)
            returnType = visitType(ctx.type());
        else
            returnType=null;

        Type listType;
        String identifier = ctx.identifierOrListIndex(1).getText();

        //TODO: Functions that returns lists(accepts more than identifiers)

        if( Main.symbolTable.variables.symbolExists(identifier))
        {
            listType = Main.symbolTable.variables.getSymbol(identifier).type;
        }
        else
        {
            returnType = new ErrorType(String.format("Error: " + identifier + " isn't defined"));
        }
        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitIncDec(@NotNull HOMEParser.IncDecContext ctx)
    {
        Type returnType;
        if(ctx.identifierOrListIndex() == null){
            returnType = new ErrorType("No identifier to increment / decrement?");
        } else
        {
            //Check if symbol is null
            if(Main.symbolTable.variables.getSymbol(ctx.identifierOrListIndex().Identifier().getText()) == null)
            {
                returnType = new ErrorType("Only declared variables can be incremented / decremented");
            }
            //Check if symbol is of type integer or decimal
            else if(Main.symbolTable.variables.getSymbol(ctx.identifierOrListIndex().Identifier().getText()).type.equals(Main.integer))
            {
                returnType = Main.integer;
            }
            else if(Main.symbolTable.variables.getSymbol(ctx.identifierOrListIndex().Identifier().getText()).type.equals(Main.decimal))
            {
                returnType = Main.decimal;
            }
            //Else say incement or decrement can't be done on other types
            else
            {
                returnType = new ErrorType( "Increment or decrement can't be used on other types than Integer or Decimal");
            }
        }

        return returnType;
    }

    // TODO: needs further checking
    @Override
    public Type visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx) {
        Type returnType = new ErrorType("Variable method call went wrong");
        HOMEParser.FuncCallContext currctx = ctx.funcCall().get(0);

        //the name of the identifier and the name of the method.
        String variableIdentifier = ctx.identifierOrListIndex().getText();
        String methodName = currctx.identifierOrListIndex().getText();

        Type typeOfObject = null;
        Function method = null;

        //Get type the method might be associated to
        if(Main.symbolTable.variables.symbolExists(variableIdentifier))
            typeOfObject = Main.symbolTable.variables.getSymbol(variableIdentifier).type;
        else
            return new ErrorType(String.format("Variable \"%s\" is undefined.", methodName));

        //Get method from type object, and return if non found
        if((method = typeOfObject.getMethodByName(methodName)) == null)
        {
            return new ErrorType(String.format("Method \"%s\" didn't exist for object \"%s\"", methodName, typeOfObject.name));
        }

        ArrayList<Type> paramList = getFunctionParameters(currctx.funcParameters());

        //Check if the parameters inserted are compatible with the formal parameters
        if(Type.isListSubtypeOfList(paramList, method.parameters))
            returnType = method.returnType;
        else
            returnType = new ErrorType(String.format("The method \"%s\" doesn't support the parameters (wrong amount or type(s))", methodName));

//        //If there are more methods after the initial method: Example: x.somemethod(4,6).toString()
//        if(ctx.funcCall().size() > 1)
//        {
//            HOMEParser.FuncCallContext nextMethodCall;
//            //Starts at the method after the initial method.
//            for (int i = 1; i < ctx.funcCall().size(); i++) {
//
//                nextMethodCall = ctx.funcCall().get(i);
//                methodName = nextMethodCall.identifierOrListIndex().getText();
//
//                if(scope.symbolExistsMethod(methodName, returnType))
//                {
//                    paramList = (ArrayList<Type>)visitFuncParameters(nextMethodCall.funcParameters()).value;
//
//                    if(scope.getSymbol( methodName, returnType).type.parameters.equals(paramList))
//                        returnType = scope.getSymbol( methodName, returnType).type.returnTypeEnum;
//                    else if(scope.getSymbol(methodName,identifierType).type.checkParametersConvertToDecimal(paramList))
//                    {
//                        returnType = scope.getSymbol( methodName, returnType).type.returnTypeEnum;
//                    }
//                    else
//                        returnType = new Type("Error", String.format("The method \"%s\" doesn't support the parameters (wrong amount/type)", nextMethodCall.getText()));
//                }
//                else
//                    returnType = new Type("Error", String.format("%s doesn't implement the method %s", returnType, nextMethodCall.getText()));
//
//            }
//        }
        return returnType;
    }




    List<String> BooleanOperator = Arrays.asList("==", ">", "<", "<=", ">=", "!=", "AND", "OR");


    boolean isBooleanOperator(String str)
    {
        return BooleanOperator.contains(str);
    }




    //TODO: Methods on functioncalls
    //TODO: Collections[ Frederik ]
    //TODO: Indeksering(Done for lister, dictionary ikke tjekket.v  Vent pÃ†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃƒÂ¥ collection)
    //TODO: Klasser
    //TODO: Lav bedre error message til metodekald, nÃ†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃƒÂ¥r en variabel ikke er blevet deklareret[Vent pÃ†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃƒÂ¥ Dennis' listener]
    //TODO: Beslut: passing by references vs value
    //TODO: Methods on collection[venter pÃ†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã¢â‚¬Å¡Ãƒâ€šÃƒÂ¥ Frederik]
    //TODO: Nothing functions can use: "return hej()" if hej() also returns Nothing
    //TODO: Boolean x = 3=={4}
    //TODO: String hash.... hash() works?!
    //TODO: List<Integer> faef = {1, 2, 3}
    //TODO: List<Decimal> l = {1,2,3} doesn't work.
    //List<Integer> adfadf = {4, 5 }
    //faef = adfadf
    //TODO: Remove method loading, and load as whole class instead
    //TODO: Make a "use" statement
    // ------- NEW GRAMMAR -------
    //TODO: int i = -2

    // --------- Til 2. iteration --------
    //TODO: [lav prioritet]del visitExpression op, sÃƒÆ’Ã†â€™Ã¢â‚¬Â ÃƒÂ¢Ã¢â€šÂ¬Ã¢â€žÂ¢ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã‚Â ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬ÃƒÂ¢Ã¢â‚¬Å¾Ã‚Â¢ÃƒÆ’Ã†â€™Ãƒâ€ Ã¢â‚¬â„¢ÃƒÆ’Ã‚Â¢ÃƒÂ¢Ã¢â‚¬Å¡Ã‚Â¬Ãƒâ€¦Ã‚Â¡ÃƒÆ’Ã†â€™ÃƒÂ¢Ã¢â€šÂ¬Ã…Â¡ÃƒÆ’Ãƒâ€šÃ‚Â¥ det er mere overskueligt.
    //TODO: Foreach (Vent til collection)
    //TODO: Events

}