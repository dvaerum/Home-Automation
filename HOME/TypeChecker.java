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
                System.out.println(String.format("WARNING line %d: Reached unreachable code!", ctx.getStart().getLine()));
                //ctx.removeLastChild();
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
            System.out.println(String.format("ERROR line %d: %s", ctx.getStart().getLine(), returnType.toString()));
            return returnType;
        }

        Type stmtsType = null;
        if(ctx.stmts() != null && ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());

        if(stmtsType instanceof ErrorType)
            return stmtsType;

        return returnType;
    }

    @Override
    public Type visitBlock(@NotNull HOMEParser.BlockContext ctx)
    {
        Type returnType = Main.nothing;
        Type blockType;

        //Checks if function exists
        if(ctx.function() != null)
        {
            returnType = visitFunction(ctx.function());
        }

        if(returnType instanceof ErrorType)
        {
            return returnType;
        }

        //Calls visitBlock recursively if it hasn't failed already.
        if(ctx.moreFunctions().block() != null && ctx.moreFunctions().block().getChildCount() > 0)
        {
            blockType = visitBlock(ctx.moreFunctions().block());
            if(!blockType.equals(Main.nothing))
                returnType = blockType;
        }

        return returnType;
    }

    @Override
    public Type visitListIndex(@NotNull HOMEParser.ListIndexContext ctx)
    {
        String symbol = ctx.IdentifierExact().getText();

        Type collectionType = Main.symbolTable.variables.getSymbol(symbol).var.type;
        Type indexType = null;
        Type innerType = null;
        int count = 0;

        if (collectionType instanceof CollectionType)
        {
            if (((CollectionType) collectionType).primaryType.equals(Main.list))
                indexType = Main.integer;
            else if (((CollectionType) collectionType).primaryType.equals(Main.dictionary))
                indexType = Main.string;
        }
        else
            return new ErrorType(String.format("Type %s is not a collection.", collectionType));

        for(HOMEParser.ExpressionContext expr : ctx.expression())
        {
            count++;
            if (!indexType.equals(visitExpression(expr)))
            {
                return new ErrorType(String.format("Invalid index type. Expected %s, got %s.", indexType, visitExpression(expr)));
            }
        }
        innerType = collectionType;
        for(int i=0; i < count; i++)
        {
            if (innerType instanceof CollectionType)
                innerType = ((CollectionType)innerType).innerType;
            else
                return new ErrorType(String.format("Type %s is not a collection.", innerType));
        }
        return innerType;

    }

    @Override
    public Type visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx)
    {
        Type returnType;
        String symbol = ctx.IdentifierExact().getText();

        if(!Main.symbolTable.variables.symbolExists(symbol))
        {
            returnType = new ErrorType(String.format("Unknown identifier. Symbol \"%s\" doesn't exist in the current context", symbol));
        }
        else
            returnType = Main.symbolTable.variables.getSymbol(symbol).var.type;

        return returnType;
    }

    @Override
    public Type visitField(@NotNull HOMEParser.FieldContext ctx)
    {
        Type returnType = new ErrorType("Variable method call went wrong");

        Type typeOfObject = visitIdentifier(ctx.identifier());

        if (typeOfObject instanceof ErrorType)
            return typeOfObject;
        Variable field;
        String fieldName = ctx.IdentifierExact().getText();

        //Get method from type object, and return if not found
        if((field = typeOfObject.getFieldByName(fieldName)) == null)
        {
            return new ErrorType(String.format("Field \"%s\" doesn't exist for class \"%s\"", fieldName, typeOfObject.name));
        }

        return field.type;
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
        else if(stmtsType instanceof ErrorType)
            returnType = stmtsType;

        forkReturnStack.dispose();

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitFuncCall(@NotNull HOMEParser.FuncCallContext ctx)
    {
        Type returnType;
        String funcName = ctx.identifier().getText();

        ArrayList<Type> paramList = getFunctionParameters(ctx.funcParameters());  //(ArrayList<Type>)visitFuncParameters(ctx.funcParameters()).value;

        if(funcName.equals("RegisterEvent") && paramList.size() == 2 && paramList.get(1) instanceof ErrorType)
        {
            String eventFunctionName = ctx.funcParameters().expression(1).getText();
            if(Main.symbolTable.functions.symbolExists(eventFunctionName))
            {
                Function eventFunction = Main.symbolTable.functions.getSymbol(eventFunctionName);

                if(eventFunction.parameters.size() != 0)
                    return new ErrorType("A function for events can't contain any parameters");
                if(!eventFunction.returnType.equals(Main.nothing))
                    return new ErrorType("A function for events can't return other types than Nothing");

                paramList.set(1, Main.functionType);
            }
            else
                return new ErrorType(String.format("The function \"%s\" didn't exist", eventFunctionName));
        }

        StringBuilder errorString = new StringBuilder();

        for(Type t : paramList)
        {
            if(errorString.length() > 0)
                errorString.append("\n");
            if(t instanceof ErrorType)
                errorString.append(((ErrorType) t).message);

        }

        if(errorString.length() > 0)
            return new ErrorType(errorString.toString());

        if(funcName.equals("Setup"))
        {
            returnType = new ErrorType("\"Setup\" function can't be called.");
        }
        else if(Main.symbolTable.functions.symbolExists(funcName))
        {
            List<Type> expectedParameters = Main.symbolTable.functions.getSymbol(funcName).parameters;
            if(Type.isListSubtypeOfList(paramList, expectedParameters))
            {
                for(int i=0; i < paramList.size(); i++)
                {
                    addConversionNode(expectedParameters.get(i), paramList.get(i), ctx.funcParameters().expression(i));
                }
                returnType = Main.symbolTable.functions.getSymbol(funcName).returnType;
            }
                //returnType = new HOME.Type("Nothing");
            else
            {
                errorString = new StringBuilder("Function parameters didn't match:");

                if(paramList.size() < expectedParameters.size())
                {
                    errorString.append(String.format("\n - Too few arguments provided, function expects %d parameters, got %d.", expectedParameters.size(), paramList.size()));
                    return new ErrorType(errorString.toString());
                }

                if(paramList.size() > expectedParameters.size())
                {
                    errorString.append(String.format("\n - Too many arguments provided, function expects %d parameters, got %d.", expectedParameters.size(), paramList.size()));
                    return new ErrorType(errorString.toString());
                }

                for(int i = 0; i < paramList.size(); i++)
                {
                    if(!paramList.get(i).isSubtypeOf(expectedParameters.get(i)))
                    {
                        errorString.append(String.format("\n - Parameter %d: \"%s\" isn't compatible with \"%s\".", i+1, expectedParameters.get(i), paramList.get(i)));
                    }
                }
                returnType = new ErrorType(errorString.toString());
//                returnType = new ErrorType(String.format("Function parameters doesn't match target function " +
//                        "(too many/invalid type(s))"));
            }
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

    @Override
    public Type visitDeclarationParameters(@NotNull HOMEParser.DeclarationParametersContext ctx)
    {
        Type returnType = Main.nothing;

        for(HOMEParser.DeclarationContext currCtx : ctx.declaration())
        {
            Main.symbolTable.variables.addSymbol(currCtx.identifier().getText(), visitType(currCtx.type()));
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
                addConversionNode(functionType, expressionType, ctx.expression());
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
        Type LHSType = null;
        Type returnType;

        if (ctx.identifier() != null)
            LHSType = visitIdentifier(ctx.identifier());
        else if (ctx.listIndex() != null)
            LHSType = visitListIndex(ctx.listIndex());
        else if (ctx.field() != null)
            LHSType = visitField(ctx.field());


        if (LHSType instanceof ErrorType)
            return LHSType;

        Type expression = visitExpression(ctx.expression());
        if(expression instanceof ErrorType)
            return expression;


        if(expression.isSubtypeOf(LHSType))      //LHSType.compatibleWith(expression)
        {
            String operator = ctx.getChild(1).getText();
            //Check if assign got a combined assignment operator like +=
            if(operator.length() > 1)
            {
                //If variable is not integer or decimal, check if other object may use combined assignment operator
                if( !(LHSType.equals(Main.integer) || LHSType.equals(Main.decimal)) )
                {
                    if(!(LHSType.equals(Main.string) && operator.equals("+=")))
                        return new ErrorType(String.format("Can't use the operator \"%s\" with %s", operator, LHSType));
                }
            }

            addConversionNode(LHSType, expression, ctx.expression());
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
        if(expression == null || expression.isSubtypeOf(type))       //type.compatibleWith(expression)
        {
            if (expression != null)
                addConversionNode(type, expression, ctx.expression());
            returnType = type;
        }
//        }
        else
            returnType = new ErrorType(String.format("Incompatible types. Expected %s, got %s", type, expression));

        return returnType;
    }

    public Type checkInnerExpressions(@NotNull HOMEParser.ExpressionContext ctx)
    {
        Type returnType;
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
                    returnType = new ErrorType(String.format("Unary \"%s\" can only be used in front of integer or decimal", ctx.getChild(0).getText()));
                }
            }

            return returnType;
        }
        else //else two expressions
        {
            r1 = visitExpression(ctx.expression(0));
            operator = ctx.getChild(1).getText();
            r2 = visitExpression(ctx.expression(1));

            if (r1 instanceof ErrorType)
                return r1;
            else if (r2 instanceof ErrorType)
                return r2;

            if(isBooleanOperator(operator))
            {
                //If AND or OR is used, check that both sides are boolean, else throw an error
                if((operator.equals("AND") || operator.equals("OR")) && !(r1.equals(Main.bool) && r1.equals(r2)))
                    returnType = new ErrorType(String.format("AND/OR can't be used with other types than boolean"));
                    //If comparison is used, and both sides are not numbers, throw an error
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
            else if(r1.equals(r2))
            {
                if(r1.equals(Main.bool))
                    returnType = new ErrorType("Can't use this operator with Booleans");
                else if(r1.equals(Main.string) && !operator.equals("+"))
                    returnType = new ErrorType("String can only be concatenated with \"+\", no other operations allowed");
                else
                    returnType = r1;            //new Type(r1.type, r1.value + operator + r2.value);
            }
            //Check if it is possible to convert from Int to Dec
            else if((r1.equals(Main.integer) && r2.equals(Main.decimal)))
            {
                addIntToDecNode(ctx.expression(0));
                returnType = Main.decimal;
            }
            else if((r1.equals(Main.decimal) && r2.equals(Main.integer)))
            {
                addIntToDecNode(ctx.expression(1));
                returnType = Main.decimal;
            }
            else
            {
                returnType = new ErrorType(String.format("Incompatible types %s and %s", r1, r2));
            }
        }
        return returnType;
    }

    @Override
    public Type visitExpression(@NotNull HOMEParser.ExpressionContext ctx)
    {
        Type returnType = new ErrorType("Unknown expression");

        //Check the expression consists of additional expressions.
        if(ctx.expression().size() > 0)
            returnType = checkInnerExpressions(ctx);
        // If expression doesn't contain any expressions, use one of the following:
        else if(ctx.funcCall() != null)
            returnType = visitFuncCall(ctx.funcCall());
        else if(ctx.literal() != null)
            returnType = visitLiteral(ctx.literal());
        else if(ctx.variableMethodCall() != null)
            returnType = visitVariableMethodCall(ctx.variableMethodCall());
        else if(ctx.identifier() != null)
            returnType = visitIdentifier(ctx.identifier());
        else if(ctx.listIndex() != null)
            returnType = visitListIndex(ctx.listIndex());
        else if(ctx.field() != null)
            returnType = visitField(ctx.field());

        return returnType;
    }

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
        else if(ctx.listLiteral() != null)
            returnType = visitListLiteral(ctx.listLiteral());
        else if(ctx.dictionaryLiteral() != null)
            returnType = visitDictionaryLiteral(ctx.dictionaryLiteral());

        return returnType;
    }

    @Override
    public Type visitListLiteral(@NotNull HOMEParser.ListLiteralContext ctx)
    {
        Type innerType;

        if (ctx.expression().size() == 0)
        {
            return getCollectionType("List", Main.anything);
            // return something that can be anything
        }
        innerType = visitExpression(ctx.expression(0));

        Type current;
        for(HOMEParser.ExpressionContext expr : ctx.expression())
        {
            current = visitExpression(expr);
            if (innerType.isSubtypeOf(current))
            {
                innerType = current;
            }
            else if (!current.isSubtypeOf(innerType))
            {
                // Invalid literal.
                return new ErrorType("Invalid List literal, types do not match");
            }
        }
        if(innerType.equals(Main.decimal))
        {
            for(HOMEParser.ExpressionContext expr : ctx.expression())
            {
                if(visitExpression(expr).equals(Main.integer))
                    addIntToDecNode(expr);
            }
        }
        return getCollectionType("List" + "<" + innerType.name + ">", innerType);
    }

    public Type visitDictionaryLiteral(@NotNull HOMEParser.DictionaryLiteralContext ctx)
    {
        Type innerType;

        if (ctx.dictionaryEntry().size() == 0)
        {
            // empty literal, meaning this can be any type of collection
            return getCollectionType("List", Main.anything);
        }
        innerType = visitExpression(ctx.dictionaryEntry(0).expression(1));

        Type current;
        for(HOMEParser.DictionaryEntryContext entry : ctx.dictionaryEntry())
        {
            Type keyType = visitExpression(entry.expression(0));
            if (keyType instanceof ErrorType)
                return keyType;
            else if(!keyType.equals(Main.string))
                return new ErrorType("Invalid Dictionary literal, key must be of type String.");
            current = visitExpression(entry.expression(1));
            if (innerType.isSubtypeOf(current))
            {
                innerType = current;
            }
            else if (!current.isSubtypeOf(innerType))
            {
                // Invalid literal.
                return new ErrorType("Invalid Dictionary literal, types do not match.");
            }

        }
        if(innerType.equals(Main.decimal))
        {
            for(HOMEParser.DictionaryEntryContext entry : ctx.dictionaryEntry())
            {
                if(visitExpression(entry.expression(1)).equals(Main.integer))
                    addIntToDecNode(entry.expression(1));
            }
        }
        return getCollectionType("Dictionary" + "<" + innerType.name + ">", innerType);
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

    public Type getCollectionType(String typeName, Type innerType)
    {
        Type t;
        if (typeName.startsWith("List"))
            t = Main.list;
        else if (typeName.startsWith("Dictionary"))
            t = Main.dictionary;
        else
            return new ErrorType("Invalid collection Type");

        if (innerType instanceof ErrorType)
            return innerType;

        if (!Main.symbolTable.types.symbolExists(typeName))
            Main.symbolTable.types.addSymbol(typeName, new CollectionType(typeName, t, innerType));

        return Main.symbolTable.types.getSymbol(typeName);
    }

    @Override
    public Type visitCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx)
    {
        String primaryTypeText = ctx.getText().split("<")[0];
        Type innerType = visitType(ctx.type());
        String typeName = primaryTypeText + "<" + innerType.name + ">";

        return getCollectionType(typeName, innerType);
    }

    @Override
    public Type visitClasses(@NotNull HOMEParser.ClassesContext ctx)
    {
        String className = ctx.getText();

        if (Main.symbolTable.types.symbolExists(className))
        {
            return Main.symbolTable.types.getSymbol(className);
        }

        return new ErrorType(String.format("Undefined Type, \"%s\" isn't defined", className));
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
            returnType = visitLoopForeach(ctx.loopForeach());

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

    //TODO: Needs more checking, not done at all
    public Type visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx)
    {
        Main.symbolTable.openScope();
        Type returnType;

        returnType = visitType(ctx.type());
        Type collectionType;

        collectionType = visitExpression(ctx.expression());
        if (collectionType instanceof ErrorType)
            return collectionType;
        if (!(collectionType instanceof CollectionType))
            return new ErrorType(String.format("Foreach loops must operate on collection types, got %s.", collectionType));

        if (!returnType.equals(((CollectionType) collectionType).innerType))
            return new ErrorType(String.format("Collection type doesn't match type of %s.", ctx.identifier().getText()));

        Main.symbolTable.variables.addSymbol(ctx.identifier().getText(), returnType);

        if(ctx.stmts().getChildCount() > 0)
            visitStmts(ctx.stmts());

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitIncDec(@NotNull HOMEParser.IncDecContext ctx)
    {
        Type returnType = null;

        if(ctx.identifier() != null)
        {
            returnType = visitIdentifier(ctx.identifier());
        }
        else if (ctx.listIndex() != null)
        {
            returnType = visitListIndex(ctx.listIndex());
        }
        else if (ctx.field() != null)
        {
            returnType = visitField(ctx.field());
        }

        if (returnType instanceof ErrorType)
            return returnType;

        if (!(returnType.equals(Main.integer) || returnType.equals(Main.decimal)))
            return new ErrorType( "Increment or decrement can't be used on other types than Integer or Decimal.");

        return returnType;
    }

    // TODO: needs further checking
    @Override
    public Type visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx) {
        Type returnType = new ErrorType("Variable method call went wrong");
        HOMEParser.FuncCallContext currctx = ctx.funcCall();

        Type typeOfObject = visitIdentifier(ctx.identifier());
        Function method;
        String methodName = ctx.funcCall().identifier().getText();

        //Get method from type object, and return if not found
        if((method = typeOfObject.getMethodByName(methodName)) == null)
        {
            return new ErrorType(String.format("Method \"%s\" doesn't exist for class \"%s\"", methodName, typeOfObject.name));
        }

        ArrayList<Type> paramList = getFunctionParameters(currctx.funcParameters());
        StringBuilder errorString = new StringBuilder();

        for(Type t : paramList)
        {
            if(errorString.length() > 0)
                errorString.append("\n");
            if(t instanceof ErrorType)
                errorString.append(((ErrorType) t).message);
        }

        if(errorString.length() > 0)
            return new ErrorType(errorString.toString());

        //Check if the parameters inserted are compatible with the formal parameters
        if(Type.isListSubtypeOfList(paramList, method.parameters))
        {
            for (int i = 0; i < paramList.size(); i++)
            {
                addConversionNode(method.parameters.get(i), paramList.get(i), currctx.funcParameters().expression(i));
            }
            returnType = method.returnType;
        }
        else
            returnType = new ErrorType(String.format("The method \"%s\" doesn't support the parameters (wrong amount or type(s))", methodName));

        return returnType;
    }

    void addIntToDecNode(HOMEParser.ExpressionContext ctx)
    {
        System.out.println(String.format("\t(Line %d) Integer should be converted", ctx.getStart().getLine()));
        if(ctx.int2dec() == null)
            ctx.addChild(new HOMEParser.Int2decContext(ctx, ctx.invokingState));
        else
            System.out.println("DEBUG: Attempt to add conversion node multiple times.");
    }

    public boolean addConversionNode(Type expectedType, Type exprType, HOMEParser.ExpressionContext expr)
    {
        if (expectedType.equals(Main.decimal) && exprType.equals(Main.integer))
        {
            addIntToDecNode(expr);
            return true;
        }
        else if (expectedType instanceof CollectionType && exprType instanceof CollectionType)
        {
            if (((CollectionType) expectedType).getInnermostType().equals(Main.decimal) && ((CollectionType) exprType).getInnermostType().equals(Main.integer))
            {
                addIntToDecNode(expr);
            }
        }
        return false;
    }


    List<String> BooleanOperator = Arrays.asList("==", ">", "<", "<=", ">=", "!=", "AND", "OR");


    boolean isBooleanOperator(String str)
    {
        return BooleanOperator.contains(str);
    }


    //TODO: Nothing functions can use: "return hej()" if hej() also returns Nothing
    //TODO: When CollectionTypes are initialized, only the methods are copied, but neither the fields nor the constructor are copied.
    // ------- NEW GRAMMAR -------

    // --------- Til 2. iteration --------
    //TODO: Events

}