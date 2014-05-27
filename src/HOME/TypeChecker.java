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
    private String currentFunction = "";
    private ForkReturnStack forkReturnStack = new ForkReturnStack();

    @Override
    public Type visitStmts(@NotNull HOMEParser.StmtsContext ctx)
    {
        Type returnType = null;

        if (ctx.stmt() == null)
            return Main.nothing;

        //Checks the various cases for the nodes in Stmts
        if (ctx.stmt().declaration() != null)
            returnType = visitDeclaration(ctx.stmt().declaration());
        else if (ctx.stmt().assignment() != null)
            returnType = visitAssignment(ctx.stmt().assignment());
        else if (ctx.stmt().ifStmt() != null)
        {
            returnType = visitIfStmt(ctx.stmt().ifStmt());

            //Checks for unreachable code
            if (forkReturnStack.closed() && ctx.stmt().ifStmt().elseStmt() != null)
            {
                if (ctx.stmts().getChildCount() > 0)
                {
                    //Unreachable code found
                    System.out.println(String.format("WARNING line %d: Reached unreachable code!", ctx.getStart().getLine()));
                    ctx.removeLastChild();
                }

                forkReturnStack.dispose();
                forkReturnStack.addReturn();
            }
            else
            {
                forkReturnStack.dispose();
            }

        }
        else if (ctx.stmt().loop() != null)
        {
            returnType = visitLoop(ctx.stmt().loop());
        }
        else if (ctx.stmt().funcCall() != null)
            returnType = visitFuncCall(ctx.stmt().funcCall());
        else if (ctx.stmt().returnFunction() != null)
        {
            returnType = visitReturnFunction((ctx.stmt().returnFunction()));
            if (returnType == null)
                returnType = new ErrorType(String.format("Missing return statement at function: %s", currentFunction), false);
            else if (ctx.stmts().getChildCount() > 0)
            {
                System.out.println(String.format("WARNING line %d: Reached unreachable code!", ctx.getStart().getLine()));
                ctx.removeLastChild();
            }
        }
        else if (ctx.stmt().variableMethodCall() != null)
            returnType = visitVariableMethodCall(ctx.stmt().variableMethodCall());
        else if (ctx.stmt().incDec() != null)
        {
            returnType = visitIncDec(ctx.stmt().incDec());
        }

        //if error is found.
        if (returnType instanceof ErrorType)
        {
            if (!((ErrorType) returnType).isPrinted)
            {
                System.out.println(String.format("ERROR line %d: %s", ctx.getStart().getLine(), returnType.toString()));
                ((ErrorType) returnType).isPrinted = true;
            }
            return returnType;
        }

        //Visits any additional stmts nodes
        Type stmtsType = null;
        if (ctx.stmts() != null && ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());

        if (stmtsType instanceof ErrorType)
            return stmtsType;

        return returnType;
    }

    @Override
    public Type visitBlock(@NotNull HOMEParser.BlockContext ctx)
    {
        Type returnType = Main.nothing;
        Type blockType;

        //Checks if function exists
        if (ctx.function() != null)
        {
            returnType = visitFunction(ctx.function());
        }

        //If error is found
        if (returnType instanceof ErrorType)
        {
            if (!((ErrorType) returnType).isPrinted)
            {
                System.out.println(String.format("ERROR line %d: %s", ctx.getStart().getLine(), returnType.toString()));
                ((ErrorType) returnType).isPrinted = true;
            }
            return returnType;
        }

        //Calls visitBlock recursively if it hasn't failed already.
        if (ctx.moreFunctions().block() != null && ctx.moreFunctions().block().getChildCount() > 0)
        {
            blockType = visitBlock(ctx.moreFunctions().block());
            if (!blockType.equals(Main.nothing))
                returnType = blockType;
        }

        return returnType;
    }

    @Override
    public Type visitListIndex(@NotNull HOMEParser.ListIndexContext ctx)
    {
        String symbol = ctx.identifier().getText();
        //check if identifier exists
        if (!Main.symbolTable.variables.symbolExists(symbol))
            return new ErrorType(String.format("The variable \"%s\" is undefined.", symbol), false);

        Type collectionType = Main.symbolTable.variables.getSymbol(symbol).var.type;
        Type indexType = null;
        Type innerType;
        int count = 0;
        //Check if collection
        if (collectionType instanceof CollectionType)
        {
            if (((CollectionType) collectionType).primaryType.equals(Main.list))
                indexType = Main.integer;
            else if (((CollectionType) collectionType).primaryType.equals(Main.dictionary))
                indexType = Main.string;
        }
        else
            return new ErrorType(String.format("Type %s is not a collection.", collectionType), false);

        //checks all expressions. Each expression for each bracket.
        for (HOMEParser.ExpressionContext expr : ctx.expression())
        {
            count++;
            if (!indexType.equals(visitExpression(expr)))
            {
                return new ErrorType(String.format("Invalid index type. Expected %s, got %s.", indexType, visitExpression(expr)), false);
            }
        }
        //Goes "count" times down in the collection if possible.
        innerType = collectionType;
        for (int i = 0; i < count; i++)
        {
            if (innerType instanceof CollectionType)
                innerType = ((CollectionType) innerType).innerType;
            else
                return new ErrorType(String.format("Type %s is not a collection.", innerType), false);
        }
        return innerType;

    }

    @Override
    public Type visitIdentifier(@NotNull HOMEParser.IdentifierContext ctx)
    {
        Type returnType;
        String symbol = ctx.IdentifierExact().getText();

        //Checks for identifier in symbol table
        if (!Main.symbolTable.variables.symbolExists(symbol))
        {
            returnType = new ErrorType(String.format("Unknown identifier. Symbol \"%s\" doesn't exist in the current context", symbol), false);
        }
        else
            returnType = Main.symbolTable.variables.getSymbol(symbol).var.type;

        return returnType;
    }

    @Override
    public Type visitField(@NotNull HOMEParser.FieldContext ctx)
    {
        Type typeOfObject = visitIdentifier(ctx.identifier(0));

        if (typeOfObject instanceof ErrorType)
            return typeOfObject;
        Variable field;
        String fieldName = ctx.identifier(1).getText();

        //Get method from type object, and return if not found
        if ((field = typeOfObject.getFieldByName(fieldName)) == null)
        {
            return new ErrorType(String.format("Field \"%s\" doesn't exist for class \"%s\"", fieldName, typeOfObject.name), false);
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

        if (ctx.type() != null)
            returnType = visitType(ctx.type());
        else
            returnType = Main.nothing;

        Main.symbolTable.openScope();

        //Initializes stack for counting returns
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        //Adds parameters to current function. Can now be used in scope of function.
        visitFunctionParameters(ctx.functionParameters());

        Type stmtsType = null;

        //Checks for stmts before visiting
        if (ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());
        else if (!returnType.equals(Main.nothing))
        {
            return new ErrorType(String.format("The function \"%s\" isn't complete, please provide a return statement.", name), false);
        }

        if (stmtsType != null && !(stmtsType instanceof ErrorType) && !returnType.equals(Main.nothing))
        {

            if (!forkReturnStack.closed())
                return new ErrorType(String.format("Function doesn't contain sufficient return statements"), false);
        }
        else if (stmtsType instanceof ErrorType)
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

        ArrayList<Type> paramList = getFunctionParameters(ctx.funcParameters());

        //Checks for the registerEvent method
        if (funcName.equals("RegisterEvent") && paramList.size() == 2 && paramList.get(1) instanceof ErrorType)
        {
            String eventFunctionName = ctx.funcParameters().expression(1).getText();
            if (Main.symbolTable.functions.symbolExists(eventFunctionName))
            {
                Function eventFunction = Main.symbolTable.functions.getSymbol(eventFunctionName);

                if (eventFunction.parameters.size() != 0)
                    return new ErrorType("A function for events can't contain any parameters", false);
                if (!eventFunction.returnType.equals(Main.nothing))
                    return new ErrorType("A function for events can't return other types than Nothing", false);

                paramList.set(1, Main.functionType);
            }
            else
                return new ErrorType(String.format("The function \"%s\" didn't exist", eventFunctionName), false);
        }

        StringBuilder errorString = new StringBuilder();

        //Constructs correct error messages.
        for (Type t : paramList)
        {
            if (errorString.length() > 0)
                errorString.append("\n");
            if (t instanceof ErrorType)
                errorString.append(((ErrorType) t).message);

        }

        if (errorString.length() > 0)
            return new ErrorType(errorString.toString(), false);

        if (funcName.equals("Setup"))
        {
            returnType = new ErrorType("\"Setup\" function can't be called.", false);
        }
        else if (Main.symbolTable.functions.symbolExists(funcName))
        {
            //Checks if the function is called correctly.
            List<Type> expectedParameters = Main.symbolTable.functions.getSymbol(funcName).parameters;
            if (Type.isListSubtypeOfList(paramList, expectedParameters))
            {
                for (int i = 0; i < paramList.size(); i++)
                {
                    addConversionNode(expectedParameters.get(i), paramList.get(i), ctx.funcParameters().expression(i));
                }
                returnType = Main.symbolTable.functions.getSymbol(funcName).returnType;
            }
            else
            {
                //Constructs correct error.
                errorString = new StringBuilder("Function parameters didn't match:");

                if (paramList.size() < expectedParameters.size())
                {
                    errorString.append(String.format("\n - Too few arguments provided, function expects %d parameters, got %d.", expectedParameters.size(), paramList.size()));
                    return new ErrorType(errorString.toString(), false);
                }

                if (paramList.size() > expectedParameters.size())
                {
                    errorString.append(String.format("\n - Too many arguments provided, function expects %d parameters, got %d.", expectedParameters.size(), paramList.size()));
                    return new ErrorType(errorString.toString(), false);
                }

                for (int i = 0; i < paramList.size(); i++)
                {
                    if (!paramList.get(i).isSubtypeOf(expectedParameters.get(i)))
                    {
                        errorString.append(String.format("\n - Parameter %d: \"%s\" isn't compatible with \"%s\".", i + 1, expectedParameters.get(i), paramList.get(i)));
                    }
                }
                returnType = new ErrorType(errorString.toString(), false);
            }
        }
        else
            returnType = new ErrorType(String.format("Function %s isn't defined", funcName), false);

        return returnType;
    }

    //Creates list of the parameters.
    ArrayList<Type> getFunctionParameters(@NotNull HOMEParser.FuncParametersContext ctx)
    {

        ArrayList<Type> returnList = new ArrayList<>();

        for (HOMEParser.ExpressionContext currExpr : ctx.expression())
        {
            if (currExpr.expression() != null)
                returnList.add(visitExpression(currExpr));
        }

        return returnList;
    }

    //Adding formal parameters to symbol table
    public Type visitFunctionParameters(@NotNull HOMEParser.FunctionParametersContext ctx)
    {
        Type returnType = Main.nothing;

        for (HOMEParser.FuncParamDeclarationContext currCtx : ctx.funcParamDeclaration())
        {
            Main.symbolTable.variables.addSymbol(currCtx.identifier().getText(), visitType(currCtx.type()));
        }

        return returnType;
    }


    @Override
    public Type visitReturnFunction(@NotNull HOMEParser.ReturnFunctionContext ctx)
    {
        Type returnType = null;
        if (Main.symbolTable.functions.symbolExists(currentFunction))
        {
            Type expressionType;
            if (ctx.expression() == null)
            {
                expressionType = Main.nothing;
            }
            else
            {
                expressionType = visitExpression(ctx.expression());
            }

            Type functionType = Main.symbolTable.functions.getSymbol(currentFunction).returnType;

            if (expressionType instanceof ErrorType)
                return expressionType;

            //Check that the user don't return from a function that returns Nothing. This isn't logical.
            if (functionType.equals(Main.nothing) && expressionType.equals(Main.nothing) && ctx.expression() != null)
                return new ErrorType("Cant call a function that returns Nothing inside a return-statement", false);

            if (functionType.equals(expressionType))
            {
                returnType = functionType;
                forkReturnStack.addReturn();
            }
            else if (expressionType.isSubtypeOf(functionType))
            {
                addConversionNode(functionType, expressionType, ctx.expression());
                returnType = functionType;
                forkReturnStack.addReturn();
            }
            else
                returnType = new ErrorType(String.format("Expected return-statement of type: %s, got %s", functionType, expressionType), false);
        }

        return returnType;
    }

    @Override
    public Type visitAssignment(@NotNull HOMEParser.AssignmentContext ctx)
    {
        Type LHSType = null;
        Type returnType;

        //visits left-hand-side
        if (ctx.identifier() != null)
            LHSType = visitIdentifier(ctx.identifier());
        else if (ctx.listIndex() != null)
            LHSType = visitListIndex(ctx.listIndex());
        else if (ctx.field() != null)
            LHSType = visitField(ctx.field());


        if (LHSType instanceof ErrorType)
            return LHSType;

        Type expression = visitExpression(ctx.expression());
        if (expression instanceof ErrorType)
            return expression;

        //If expression is same type as left-hand-side...
        if (expression.isSubtypeOf(LHSType))
        {
            String operator = ctx.getChild(1).getText();
            //Check if assign got a combined assignment operator like +=
            if (operator.length() > 1)
            {
                //If variable is not integer or decimal, check if other object may use combined assignment operator
                if (!(LHSType.equals(Main.integer) || LHSType.equals(Main.decimal)))
                {
                    if (!(LHSType.equals(Main.string) && operator.equals("+=")))
                        return new ErrorType(String.format("Can't use the operator \"%s\" with %s", operator, LHSType), false);
                }
            }

            addConversionNode(LHSType, expression, ctx.expression());
            returnType = LHSType;
        }
        else
        {
            returnType = new ErrorType(String.format("Incompatible types. Expected %s, got %s", LHSType, expression), false);
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

        if (type instanceof ErrorType)
            return type;

        //if expression found: integer i = something
        if (ctx.expression() != null)
        {
            expression = visitExpression(ctx.expression());
            if (expression instanceof ErrorType)
                return expression;
        }

        //Adds symbol to symbol table. Error if already exists in this scope.
        if (!Main.symbolTable.variables.addSymbol(identifier, type))
            return new ErrorType(String.format("Can't declare symbol. %s already exists!", identifier), false);


        //if "Integer i", return no value back. If "Integer i = 3" return value
        if (expression == null || expression.isSubtypeOf(type))
        {
            if (expression != null)
                addConversionNode(type, expression, ctx.expression());
            returnType = type;
        }
        else
            returnType = new ErrorType(String.format("Incompatible types. Expected %s, got %s", type, expression), false);

        return returnType;
    }

    Type checkInnerExpressions(@NotNull HOMEParser.ExpressionContext ctx)
    {
        Type returnType;
        Type r1, r2;
        String operator;

        //1 expr = expression in parenteses
        if (ctx.expression().size() == 1)
        {
            returnType = visitExpression(ctx.expression().get(0));
            if (ctx.getChild(0).getText().equals("-"))
            {
                //unary + or - can only be in front of integer and decimal
                if (!(returnType.equals(Main.integer) || returnType.equals(Main.decimal)))
                {
                    returnType = new ErrorType(String.format("Unary \"%s\" can only be used in front of integer or decimal", ctx.getChild(0).getText()), false);
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

            if (isBooleanOperator(operator))
            {
                //If AND or OR is used, check that both sides are boolean, else throw an error
                if ((operator.equals("AND") || operator.equals("OR")) && !(r1.equals(Main.bool) && r1.equals(r2)))
                    returnType = new ErrorType(String.format("AND/OR can't be used with other types than boolean"), false);
                    //If comparison is used, and both sides are not numbers, throw an error
                else if ((operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=")) && !((r1.isSubtypeOf(r2) || r2.isSubtypeOf(r1)) && (r1.equals(Main.integer) || r1.equals(Main.decimal))))
                    returnType = new ErrorType(String.format("Comparison can only be used with integers and decimals"), false);
                    //check if both sides of expression is boolean
                else if (((operator.equals("==") || operator.equals("!=")) && !(r1.isSubtypeOf(r2) || r2.isSubtypeOf(r1))))
                    returnType = new ErrorType("Can't use equals on different types", false);
                    //Else accept the expression
                else
                    returnType = Main.bool;

                if ((r1.equals(Main.integer) && r2.equals(Main.decimal)))
                    addIntToDecNode(ctx.expression(0));
                else if ((r1.equals(Main.decimal) && r2.equals(Main.integer)))
                    addIntToDecNode(ctx.expression(1));
            }
            // Check for a single literal
            //Check if type is equal
            else if (r1.equals(r2))
            {
                if (r1.equals(Main.bool))
                    returnType = new ErrorType("Can't use this operator with Booleans", false);
                else if (r1.equals(Main.string) && !operator.equals("+"))
                    returnType = new ErrorType("String can only be concatenated with \"+\", no other operations allowed", false);
                else
                    returnType = r1;
            }
            //Check if it is possible to convert from Int to Dec
            else if ((r1.equals(Main.integer) && r2.equals(Main.decimal)))
            {
                addIntToDecNode(ctx.expression(0));
                returnType = Main.decimal;
            }
            else if ((r1.equals(Main.decimal) && r2.equals(Main.integer)))
            {
                addIntToDecNode(ctx.expression(1));
                returnType = Main.decimal;
            }
            else
            {
                returnType = new ErrorType(String.format("Incompatible types %s and %s", r1, r2), false);
            }
        }
        return returnType;
    }

    @Override
    public Type visitExpression(@NotNull HOMEParser.ExpressionContext ctx)
    {
        Type returnType = new ErrorType("Unknown expression", false);

        //Check the expression consists of additional expressions.
        if (ctx.expression().size() > 0)
            returnType = checkInnerExpressions(ctx);
            // If expression doesn't contain any expressions, use one of the following:
        else if (ctx.funcCall() != null)
            returnType = visitFuncCall(ctx.funcCall());
        else if (ctx.literal() != null)
            returnType = visitLiteral(ctx.literal());
        else if (ctx.variableMethodCall() != null)
            returnType = visitVariableMethodCall(ctx.variableMethodCall());
        else if (ctx.identifier() != null)
            returnType = visitIdentifier(ctx.identifier());
        else if (ctx.listIndex() != null)
            returnType = visitListIndex(ctx.listIndex());
        else if (ctx.field() != null)
            returnType = visitField(ctx.field());

        return returnType;
    }

    @Override
    public Type visitLiteral(@NotNull HOMEParser.LiteralContext ctx)
    {
        Type returnType = null;

        if (ctx.IntegerLiteral() != null)
            returnType = Main.integer;
        else if (ctx.booleanLiteral() != null)
            returnType = Main.bool;
        else if (ctx.DecimalLiteral() != null)
            returnType = Main.decimal;
        else if (ctx.StringLiteral() != null)
            returnType = Main.string;
        else if (ctx.listLiteral() != null)
            returnType = visitListLiteral(ctx.listLiteral());
        else if (ctx.dictionaryLiteral() != null)
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
        for (HOMEParser.ExpressionContext expr : ctx.expression())
        {
            current = visitExpression(expr);
            if (innerType.isSubtypeOf(current))
            {
                innerType = current;
            }
            else if (!current.isSubtypeOf(innerType))
            {
                // Invalid literal.
                return new ErrorType("Invalid List literal, types do not match", false);
            }
        }
        if (innerType.equals(Main.decimal))
        {
            for (HOMEParser.ExpressionContext expr : ctx.expression())
            {
                if (visitExpression(expr).equals(Main.integer))
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

        //Goes through all dictionary entries
        Type current;
        for (HOMEParser.DictionaryEntryContext entry : ctx.dictionaryEntry())
        {
            Type keyType = visitExpression(entry.expression(0));
            if (keyType instanceof ErrorType)
                return keyType;
            else if (!keyType.equals(Main.string))
                return new ErrorType("Invalid Dictionary literal, key must be of type String.", false);
            current = visitExpression(entry.expression(1));
            if (innerType.isSubtypeOf(current))
            {
                innerType = current;
            }
            else if (!current.isSubtypeOf(innerType))
            {
                // Invalid literal.
                return new ErrorType("Invalid Dictionary literal, types do not match.", false);
            }

        } //potentially adds conversion node
        if (innerType.equals(Main.decimal))
        {
            for (HOMEParser.DictionaryEntryContext entry : ctx.dictionaryEntry())
            {
                if (visitExpression(entry.expression(1)).equals(Main.integer))
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
        return visitClasses(ctx.classes());
    }

    Type getCollectionType(String typeName, Type innerType)
    {
        Type t;
        if (typeName.startsWith("List"))
            t = Main.list;
        else if (typeName.startsWith("Dictionary"))
            t = Main.dictionary;
        else
            return new ErrorType("Invalid collection Type", false);

        if (innerType instanceof ErrorType)
            return innerType;

        //if not already there, it's added to the symbol table.
        if (!Main.symbolTable.types.symbolExists(typeName))
            Main.symbolTable.types.addSymbol(typeName, new CollectionType(typeName, t, innerType, t.bytecode));

        return Main.symbolTable.types.getSymbol(typeName);
    }

    @Override
    public Type visitCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx)
    {
        //Visits the collection. Goes through collections within collections.
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

        return new ErrorType(String.format("Undefined Type, \"%s\" isn't defined", className), false);
    }

    @Override
    public Type visitIfStmt(@NotNull HOMEParser.IfStmtContext ctx)
    {
        Main.symbolTable.openScope();

        //Fork stack created to maintain returns and braches.
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        Type returnType = null;

        //Checks conditional expression.
        if (ctx.expression() != null)
            returnType = visitExpression(ctx.expression());

        if (returnType instanceof ErrorType)
            return returnType;

        if (!returnType.equals(Main.bool))
            return new ErrorType("Statement in if-condition must be of type Boolean, got: " + returnType, false);

        Type stmtsType = null;
        if (ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());

        if (stmtsType instanceof ErrorType)
            return stmtsType;

        Main.symbolTable.closeScope();

        if (!returnType.equals(Main.bool))
            return new ErrorType("Statement in if-condition must be of type Boolean, got: " + returnType, false);

        //Visits all potential else if statements
        if (ctx.elseIfStmt().size() > 0)
        {
            for (HOMEParser.ElseIfStmtContext currCtx : ctx.elseIfStmt())
            {
                forkReturnStack.addFork();
                if (visitElseIfStmt(currCtx) instanceof ErrorType)
                    return new ErrorType("Error", false);
            }
        }

        //Visits potential else statement
        if (ctx.elseStmt() != null)
        {
            forkReturnStack.addFork();
            if (visitElseStmt(ctx.elseStmt()) instanceof ErrorType)
            {
                return new ErrorType("Error", false);
            }
        }

        return returnType;
    }

    @Override
    public Type visitElseIfStmt(@NotNull HOMEParser.ElseIfStmtContext ctx)
    {
        //Opens scope, checks expression, and visits statement.
        Main.symbolTable.openScope();
        Type returnType = null;

        if (ctx.expression() != null)
            returnType = visitExpression(ctx.expression());

        if (returnType instanceof ErrorType)
            return returnType;

        Type stmtsType = null;

        if (ctx.stmts() != null)
            stmtsType = visitStmts(ctx.stmts());

        if (stmtsType instanceof ErrorType)
            return stmtsType;

        Main.symbolTable.closeScope();
        return returnType;
    }


    @Override
    public Type visitElseStmt(@NotNull HOMEParser.ElseStmtContext ctx)
    {
        //Opens scope and visit statements
        Main.symbolTable.openScope();

        Type returnType = Main.bool;

        Type stmtsType = null;
        if (ctx.stmts() != null)
            stmtsType = visitStmts(ctx.stmts());

        if (stmtsType instanceof ErrorType)
            return stmtsType;

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitLoop(@NotNull HOMEParser.LoopContext ctx)
    {
        forkReturnStack.newStack();
        forkReturnStack.addFork();

        Type returnType = null;

        //Goes into one of the specific loops.
        if (ctx.loopWhileOrUntil() != null)
            returnType = visitLoopWhileOrUntil(ctx.loopWhileOrUntil());
        else if (ctx.loopForeach() != null)
            returnType = visitLoopForeach(ctx.loopForeach());

        forkReturnStack.dispose();
        return returnType;
    }

    public Type visitLoopWhileOrUntil(@NotNull HOMEParser.LoopWhileOrUntilContext ctx)
    {
        Main.symbolTable.openScope();

        //Checks expression of loop.
        Type returnType = visitExpression(ctx.expression());

        if (ctx.expression() != null && ctx.expression().literal() != null && ctx.expression().literal().booleanLiteral() != null)
            returnType = new ErrorType("Illegal loop expression booleanLiteral", false);
        else if (!(returnType instanceof ErrorType) && !returnType.equals(Main.bool))
            returnType = new ErrorType(String.format("Loop expressions should be of type Boolean - got %s", returnType), false);

        //Visits statements within loop body
        Type stmtsType = null;
        if (ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());

        if (stmtsType instanceof ErrorType)
            return stmtsType;

        Main.symbolTable.closeScope();
        return returnType;
    }

    public Type visitLoopForeach(@NotNull HOMEParser.LoopForeachContext ctx)
    {
        Main.symbolTable.openScope();
        Type returnType;

        returnType = visitType(ctx.type());
        Type collectionType;

        //Checks expression in foreach
        collectionType = visitExpression(ctx.expression());
        if (collectionType instanceof ErrorType)
            return collectionType;
        if (!(collectionType instanceof CollectionType))
            return new ErrorType(String.format("Foreach loops must operate on collection types, got %s.", collectionType), false);

        if (!returnType.equals(((CollectionType) collectionType).innerType))
            return new ErrorType(String.format("Collection type doesn't match type of %s.", ctx.identifier().getText()), false);

        //Adds variable in foreach loop to symboltable.
        Main.symbolTable.variables.addSymbol(ctx.identifier().getText(), returnType);

        Type stmtsType = null;
        if (ctx.stmts().getChildCount() > 0)
            stmtsType = visitStmts(ctx.stmts());

        if (stmtsType instanceof ErrorType)
            return stmtsType;

        Main.symbolTable.closeScope();
        return returnType;
    }

    @Override
    public Type visitIncDec(@NotNull HOMEParser.IncDecContext ctx)
    {
        Type returnType = null;

        //Visits the different cases.
        if (ctx.identifier() != null)
            returnType = visitIdentifier(ctx.identifier());
        else if (ctx.listIndex() != null)
            returnType = visitListIndex(ctx.listIndex());
        else if (ctx.field() != null)
            returnType = visitField(ctx.field());

        if (returnType instanceof ErrorType)
            return returnType;

        if (!(returnType.equals(Main.integer) || returnType.equals(Main.decimal)))
            return new ErrorType("Increment or decrement can't be used on other types than Integer or Decimal.", false);

        return returnType;
    }

    @Override
    public Type visitVariableMethodCall(@NotNull HOMEParser.VariableMethodCallContext ctx)
    {
        Type returnType;
        HOMEParser.FuncCallContext currCtx = ctx.funcCall();

        Type typeOfObject = visitIdentifier(ctx.identifier());
        Function method;
        String methodName = ctx.funcCall().identifier().getText();

        if (typeOfObject instanceof ErrorType)
            return typeOfObject;

        //Get method from type object, and return if not found
        if ((method = typeOfObject.getMethodByName(methodName)) == null)
            return new ErrorType(String.format("Method \"%s\" doesn't exist for class \"%s\"", methodName, typeOfObject.name), false);

        ArrayList<Type> paramList = getFunctionParameters(currCtx.funcParameters());
        StringBuilder errorString = new StringBuilder();

        //Constructs correct error
        for (Type t : paramList)
        {
            if (errorString.length() > 0)
                errorString.append("\n");
            if (t instanceof ErrorType)
                errorString.append(((ErrorType) t).message);
        }

        if (errorString.length() > 0)
            return new ErrorType(errorString.toString(), false);

        //Check if the parameters inserted are compatible with the formal parameters
        if (Type.isListSubtypeOfList(paramList, method.parameters))
        {
            for (int i = 0; i < paramList.size(); i++)
            {
                addConversionNode(method.parameters.get(i), paramList.get(i), currCtx.funcParameters().expression(i));
            }
            returnType = method.returnType;
        }
        else
            returnType = new ErrorType(String.format("The method \"%s\" doesn't support the parameters (wrong amount or type(s))", methodName), false);

        return returnType;
    }

    //Adds conversion node
    void addIntToDecNode(HOMEParser.ExpressionContext ctx)
    {
        int lastChild = ctx.getChildCount() - 1;
        if (!(ctx.getChild(lastChild) instanceof HOMEParser.Int2decContext))
            ctx.addChild(new HOMEParser.Int2decContext(ctx, ctx.invokingState));
    }

    //Checks if conversion node is neccesary, then adds it if so.
    boolean addConversionNode(Type expectedType, Type exprType, HOMEParser.ExpressionContext expr)
    {
        if (expectedType.equals(Main.decimal) && exprType.equals(Main.integer))
        {
            addIntToDecNode(expr);
            return true;
        }
        else if (expectedType instanceof CollectionType && exprType instanceof CollectionType)
        {
            if (((CollectionType) expectedType).getInnermostType().equals(Main.decimal) && ((CollectionType) exprType).getInnermostType().equals(Main.integer))
                addIntToDecNode(expr);
        }
        return false;
    }


    private List<String> BooleanOperator = Arrays.asList("==", ">", "<", "<=", ">=", "!=", "AND", "OR");

    boolean isBooleanOperator(String str)
    {
        return BooleanOperator.contains(str);
    }
}