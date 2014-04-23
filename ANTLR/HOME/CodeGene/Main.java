package HOME.CodeGene;

import HOME.Grammar.HOMELexer;
import HOME.Grammar.HOMEParser;
import HOME.Type.Type;
import HOME.TypeChecker;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        HOMELexer lexer = new HOMELexer(new ANTLRFileStream("HOME/CodeGene/HomeTestFile"));
        HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();

        ByteCodeVisitor visitor = new ByteCodeVisitor();
        visitor.visit(tree);
        visitor.build();

    }
}