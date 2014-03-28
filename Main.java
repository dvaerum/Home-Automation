//import org.antlr.runtime.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
<<<<<<< HEAD

import java.io.IOException;
import java.util.ArrayList;
//import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;

=======

import java.util.ArrayList;
//import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;

>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f

/**
 * Created by Jacob on 12-03-14.
 */
public class Main {

    public static SymbolTable scope = new SymbolTable();

<<<<<<< HEAD
    public static void main(String[] args) throws IOException
    {
 //       try{
=======
    public static void main(String[] args) {
        try{
>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f
            HOMELexer lexer = new HOMELexer(new ANTLRFileStream("NotInput"));
            HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.program();

            FileReader fileR = new FileReader();
            fileR.loadMethods();

<<<<<<< HEAD
=======
            ArrayList<Type> paramTypes = new ArrayList<Type>();
            Type symbol = new Type(Type.TypeEnum.Function, paramTypes, new Type(Type.TypeEnum.String));
            scope.addSymbol("toString", symbol);

>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f
            FirstRun firstVisit = new FirstRun();
            Type returnType = firstVisit.visitBlock((HOMEParser.BlockContext)tree.getChild(1));
            if(returnType.equals(Type.TypeEnum.Error))
            {
                System.out.println(String.format("Error: %s", returnType.value));
            }
            else
            {
                TypeChecker visitor = new TypeChecker();
                visitor.visit(tree);
            }
<<<<<<< HEAD
/*
        }catch(Exception e)
        {
            e.printStackTrace();
            //System.err.println(e.initCause(e.getCause()));
        }
        */
=======

        }catch(Exception e)
        {
            System.err.println(e.initCause(e.getCause()));
        }
>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f
    }
}
