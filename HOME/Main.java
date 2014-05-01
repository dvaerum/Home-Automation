package HOME;
import HOME.CodeGene.ByteCodeVisitor;
import HOME.Grammar.*;
import HOME.Type.*;

import SymbolTableNew.SymbolTableNew;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    public static Type anything = new Type("Anything");
    public static Type event = new Type("Event");

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
        dictionary = new Type("Dictionary");
        dictionary.methods.add(new Function("add", nothing, new ArrayList<Type>(Arrays.asList(string, generic))));
        dictionary.methods.add(new Function("remove", nothing, string.toList()));
        dictionary.methods.add(new Function("lol", integer, new ArrayList<Type>()));
        //TODO: Allow collections as parameters/return types. Also, constructors/fields don't work for collections atm.


//        Integer[][][] lol = new Integer[2][2][2];
//        lol[1][1][1][1] = 2;

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


        System.out.println("-----------------------------Code Generation-----------------------");
        //ByteCodeVisitor bytecode = new ByteCodeVisitor();
        //bytecode.visit(tree);

        // TODO change
        symbolTable.resetVariableTable();
        HOME.CodeGene.Main codeGeneration = new HOME.CodeGene.Main();
        codeGeneration.main(null);

        try{
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("java -jar ../jar/jasmin.jar codeGene/Output_test.j");
            proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();
            while(in.available() > 0){
                System.out.write(in.read());
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }


        System.out.println("-----------------------------Decompiling-----------------------");
        try{
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("javap -c -v -private HOME/CodeGene/HOME.class");
            //proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            BufferedReader bIn =new BufferedReader(new InputStreamReader(in));
            String s;
            while((s = bIn.readLine()) != null){
                System.out.println(s);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }

        System.out.println("-----------------------------Running-----------------------");
        try{
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("java HOME/CodeGene/HOME.class");
            //proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            BufferedReader bIn =new BufferedReader(new InputStreamReader(in));
            String s;
            while((s = bIn.readLine()) != null){
                System.out.println(s);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }

       // System.out.println("omagmward");
//==============  UNCOMMENT THIS IF YOU WANT TO SEE THE TREE <-----------------------------------
        //HOMEParser.BlockContext lol = (HOMEParser.BlockContext) tree.getChild(1);
        //lol.inspect(parser);
//=================================================================================

        /*
        }catch(Exception e)
        {
            e.printStackTrace();
            //System.err.println(e.initCause(e.getCause()));
        }
        */
    }
}
