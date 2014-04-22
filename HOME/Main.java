package HOME;
import HOME.Grammar.*;
import HOME.Type.*;

import SymbolTableNew.SymbolTableNew;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jacob on 12-03-14.
 */
public class Main
{
    public static SymbolTableNew symbolTable = new SymbolTableNew();

    public static Type nothing = new Type("Nothing");
    public static Type generic = new Type("#Generic");

    public static Type integer;
    public static Type decimal;
    public static Type bool;
    public static Type string;
    public static Type list;
    public static Type dictionary;

    public static void main(String[] args) throws IOException
    {
        //System.out.println("\n-----------------------------Loader-----------------------\n");
        //       try{
        HOMELexer lexer = new HOMELexer(new ANTLRFileStream("NotInput"));
        HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();

        FileReader fileR = new FileReader();
        fileR.loadClassPrototypes();
        fileR.expandTypes();

        integer = symbolTable.types.getSymbol("Integer");
        decimal = symbolTable.types.getSymbol("Decimal");
        bool = symbolTable.types.getSymbol("Boolean");
        string = symbolTable.types.getSymbol("String");
        list = new Type("List");
        list.methods.add(new Function("add", nothing, generic.toList()));
        list.methods.add(new Function("remove", nothing, generic.toList()));
        list.methods.add(new Function("lol", integer, new ArrayList<Type>()));
        //TODO: Allow collections as parameters/return types. Also, constructors/fields don't work for collections atm.

        //System.out.println("\n-----------------------------FirstRun-----------------------\n");
        FirstRun firstVisit = new FirstRun();

        Type returnType = firstVisit.visitBlock((HOMEParser.BlockContext) tree.getChild(1));
        if (returnType instanceof ErrorType)
        {
            System.out.println(String.format("Error: %s", returnType));
        }
        else
        {
            System.out.println("-----------------------------Typechecker-----------------------");
            TypeChecker visitor = new TypeChecker();
            visitor.visit(tree);
        }
        /*
        }catch(Exception e)
        {
            e.printStackTrace();
            //System.err.println(e.initCause(e.getCause()));
        }
        */
    }
}
