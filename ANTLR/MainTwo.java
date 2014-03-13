//import org.antlr.runtime.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
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
    public static void main(String[] args) {
        try{
            HelloLexer lexer = new HelloLexer(new ANTLRFileStream("NotINput"));
            HelloParser parser = new HelloParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.programtest();
            ParseTreeWalker.DEFAULT.walk(new VarListener(), tree);


//            ParseTree tree = parser.parse();
//            TreeVisitor visitor = new TreeVisitor();
//            visitor.visit(tree);

//            HelloParser.ProgramtestContext pts = parser.programtest();
//            ParseTree treeTwo = pts.getChild(1);
//
//TreeVisitor visitorTwo = new TreeVisitor();
//            visitorTwo.visitProgramtest(treeTwo);


//            //File fil = new File("NotInput");
//            HelloLexer lexer = new HelloLexer(new ANTLRFileStream("NotInput"));
//            HelloParser parser = new HelloParser(new CommonTokenStream(lexer));
//            //parser.setTree

        }catch(Exception e)
        {
            System.err.println(e.toString());
        }
    }
}
