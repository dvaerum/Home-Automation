//import org.antlr.runtime.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import sun.awt.Symbol;
//import org.antlr.v4.runtime.ANTLRFileStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Jacob on 12-03-14.
 */
public class MainTwo {

    public static SymbolTable scope = new SymbolTable();

    public static void main(String[] args) {
        try{
            HelloLexer lexer = new HelloLexer(new ANTLRFileStream("NotInput"));
            HelloParser parser = new HelloParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.program();

            firstRun firstVisit = new firstRun();
            Type returnType = firstVisit.visitBlock((HelloParser.BlockContext)tree.getChild(1));
            if(returnType.equals(Type.TypeEnum.Error))
            {
                System.out.println(String.format("Error: %s", returnType.value));
            }
            else
           {
                ExtractHelloVisitor visitor = new ExtractHelloVisitor();
                visitor.visit(tree);
            }

        }catch(Exception e)
        {
            System.err.println(e.initCause(e.getCause()));
        }
    }
}
