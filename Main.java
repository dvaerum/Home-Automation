//import org.antlr.runtime.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.util.ArrayList;
//import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;


/**
 * Created by Jacob on 12-03-14.
 */
public class Main {

    public static SymbolTable scope = new SymbolTable();

    public static void main(String[] args) throws IOException
    {
 //       try{
            ANTLRFileStream stream = new ANTLRFileStream("Input");
            HOMELexer lexer = new HOMELexer(stream);
            HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));


            // Removes Antlr4 own error output in terminal
            // http://stackoverflow.com/questions/18132078/handling-errors-in-antlr4
            parser.removeErrorListeners();

            // Custom error handler format output print
            // http://stackoverflow.com/questions/22325445/how-to-grab-antlr4-error-output
            CustomErrorListener errorListener = new CustomErrorListener(false, stream.toString());
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.program();

            System.out.println("---------------------------------- Error Messages ----------------------------------");
            for (String s : errorListener.ErrorMessages()) {
                System.out.println(s);
            }
            System.out.print("\n");

            FileReader fileR = new FileReader();
            fileR.loadMethods();

            FirstRun firstVisit = new FirstRun();

            /* Virker ikke når der er parser fejl
             *
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
            */
        /*
        }catch(Exception e)
        {
            e.printStackTrace();
            //System.err.println(e.initCause(e.getCause()));
        }
        */
    }
}
