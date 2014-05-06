package HOME.CodeGene;

import HOME.FileReader;
import HOME.Grammar.HOMELexer;
import HOME.Grammar.HOMEParser;
import HOME.Type.Function;
import HOME.Type.Type;
import HOME.TypeChecker;
import SymbolTableNew.SymbolTableNew;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException
    {
        HOMELexer lexer = new HOMELexer(new ANTLRFileStream("HOME/CodeGene/HomeTestFile"));
        HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();

        ByteCodeVisitor visitor = new ByteCodeVisitor();
        visitor.visit(tree);
        visitor.build();
    }
}