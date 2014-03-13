import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {
        try{
            File fil = new File("NotInput");
            FileInputStream fs = new FileInputStream(fil);
            DataInputStream input = new DataInputStream(fs);
            CharStream cs = new ANTLRInputStream(input);
            HelloLexer lexer = new HelloLexer(cs);

            CommonTokenStream tS = new CommonTokenStream(lexer);

            HelloParser parser = new HelloParser(tS);

            HelloParser.ProgramtestContext pts = parser.programtest();
            System.out.println(pts.toStringTree());

            System.out.println("Helllo");
        }catch(Exception e)
        {
            System.err.println(e.toString());
        }
    }
}