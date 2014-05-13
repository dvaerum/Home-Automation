package HOME;
import HOME.Grammar.*;
import HOME.Type.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;

/**
 * Created by Jacob on 20-03-14.
 */
public class FirstRun extends HOMEBaseVisitor<Type> {

    //TODO: Determine if newline shall be removed or not
    @Override
    public Type visitNewline(@NotNull HOMEParser.NewlineContext ctx)
    {
        return Main.nothing;
    }

    @Override
    public Type visitGlobal(@NotNull HOMEParser.GlobalContext ctx)
    {
        Type returnType;
        if(ctx.declaration() != null)
        {
            returnType = Main.typeChecker.visitDeclaration(ctx.declaration());
            if(returnType instanceof ErrorType)
                return returnType;

            if(ctx.global() != null)
                returnType = visitGlobal(ctx.global());

            return returnType;
        }
        else
            return null;
    }

    @Override
    public Type visitBlock(@NotNull HOMEParser.BlockContext ctx)
    {
        Type returnType = Main.nothing;
        Type blockType;

        //Checks if function already exist
        if(ctx.function() != null)
        {
            returnType = visitFunction(ctx.function());
        }

        if(returnType instanceof ErrorType)
        {
            System.out.println(String.format("\tERROR line %d: %s", ctx.getStart().getLine(), returnType));
            return returnType;
        }

        //Calls visitBlock recursively if it hasn't failed already.
        if(ctx.moreFunctions().block() != null && ctx.moreFunctions().block().getChildCount() > 0)
        {
            blockType = visitBlock(ctx.moreFunctions().block());
            if(!blockType.equals(Main.nothing))
                returnType = blockType;
        }

        //TODO: Check if returning false positives
        //Checks if "setup" function has been found
        if(!Main.symbolTable.functions.symbolExists("Setup"))
        {
            returnType = new ErrorType("No \"Setup\" function found, please provide one.");
            System.out.println(String.format("\tERROR line %d: %s", ctx.getStart().getLine(), returnType));
        }

        return returnType;
    }

    @Override
    public Type visitFunction(@NotNull HOMEParser.FunctionContext ctx)
    {
        Type returnType;
        //If the function returns some identifier
        Type returns;
        if(ctx.type() != null)
            returns = visitType(ctx.type());
            //or the function returns nothing
        else if(ctx.nothing() != null)
            returns = Main.nothing;
        else //otherwise return error if other unexpected type
            returns = new ErrorType("Error");

        if(returns instanceof  ErrorType)
            return returns;

        String funcName = ctx.getChild(1).getText();

        //Gets the types of the parameters
        ArrayList<Type> paramTypes = getFunctionParameters(ctx.declarationParameters());
        for(Type t : paramTypes)
        {
            if(t instanceof ErrorType)
            {
                return t;
            }
        }
        Function symbol = new Function(funcName, returns, paramTypes);

        if(funcName.equals("Setup"))
            if(paramTypes.size() > 0)
                return new ErrorType("Function \"Setup\" doesn't accept any parameters, please remove these.");
            else if(!returns.equals(Main.nothing))
                return new ErrorType("Function \"Setup\" can't return anything but nothing");

        //adds function + parameter types to symbol table.
        if(!Main.symbolTable.functions.addSymbol(funcName, symbol))
            returnType = new ErrorType(String.format("Function \"%s\" already exists.",
                    funcName, ctx.getStart().getLine()));
        else
            returnType = Main.nothing;

        return returnType;
    }

    public ArrayList<Type> getFunctionParameters(@NotNull HOMEParser.DeclarationParametersContext ctx)
    {
        ArrayList<Type> returnLIst = new ArrayList<>();

        for(HOMEParser.DeclarationContext currCtx : ctx.declaration())
        {
            returnLIst.add(visitType(currCtx.type()));
        }

        return returnLIst;
    }


    @Override
    public Type visitType(@NotNull HOMEParser.TypeContext ctx)
    {
        if (ctx.collectionType() != null)
            return visitCollectionType(ctx.collectionType());
        //if (ctx.classes() != null)
        return visitClasses(ctx.classes());

        //return visitPrimitiveType(ctx.primitiveType());
    }

    @Override
    public Type visitClasses(@NotNull HOMEParser.ClassesContext ctx)
    {
        String className = ctx.getText();

        if (Main.symbolTable.types.symbolExists(className))
        {
            return Main.symbolTable.types.getSymbol(className);
        }

        return new ErrorType(String.format("Undefined Class \"%s\" isn't defined", className));
    }

    @Override
    public Type visitCollectionType(@NotNull HOMEParser.CollectionTypeContext ctx)
    {
        String primaryTypeText = ctx.getText().split("<")[0];
        Type innerType = visitType(ctx.type());
        String typeName = primaryTypeText + "<" + innerType.name + ">";
        Type t = null;

        if (primaryTypeText.equals("List"))
            t = Main.list;
        else if (primaryTypeText.equals("Dictionary"))
            t = Main.dictionary;
        else
            return new ErrorType("Invalid collection Type");

        if (Main.symbolTable.types.symbolExists(typeName))
            return Main.symbolTable.types.getSymbol(typeName);
        else
        {
            t = new CollectionType(typeName, t, innerType, t.bytecode);
            Main.symbolTable.types.addSymbol(typeName, t);
        }

        return t;
    }

//    @Override
//    public HOME.Type visitPrimitiveType(@NotNull HOMEParser.PrimitiveTypeContext ctx)
//    {
//        return new HOME.Type(ctx.getText());
//    }
}
