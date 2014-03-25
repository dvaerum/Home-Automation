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
            HOMELexer lexer = new HOMELexer(new ANTLRFileStream("NotInput"));
            HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.program();

            FileReader fileR = new FileReader();
            fileR.loadMethods();

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
/*
        }catch(Exception e)
        {
            e.printStackTrace();
            //System.err.println(e.initCause(e.getCause()));
        }
        */
    }
}
