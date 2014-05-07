package HOME;
import HOME.CodeGene.ByteCodeVisitor;
import HOME.Grammar.*;
import HOME.SymbolTable.SymbolTable;
import HOME.Type.*;

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
    public static SymbolTable symbolTable = new SymbolTable();

    public static Type nothing = new Type("Nothing");
    public static Type generic = new Type("#Generic");

    public static Type integer;
    public static Type decimal;
    public static Type bool;
    public static Type string;
    public static Type list;
    public static Type dictionary;
    public static Type variable = new Type("variable");
    public static Type anything = new Type("Anything");
    public static Type event = new Type("Event");
    public static Type functionType = new Type("Function");

    public static TypeChecker typeChecker;

    public static void main(String[] args) throws IOException
    {
        HOMELexer lexer = new HOMELexer(new ANTLRFileStream("NotInput"));
        HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();

        //Read files, to include classes
        FileReader fileR = new FileReader();
        fileR.loadClassPrototypes();
        fileR.expandTypes();

        //Create shortcuts to common types
        integer = symbolTable.types.getSymbol("Integer");
        decimal = symbolTable.types.getSymbol("Decimal");
        bool = symbolTable.types.getSymbol("Boolean");
        string = symbolTable.types.getSymbol("String");

        //Create generic list and dictionary
        list = new Type("List");
        list.methods.add(new Function("add", nothing, generic.toList()));
        list.methods.add(new Function("remove", nothing, generic.toList()));
        list.methods.add(new Function("lol", integer, new ArrayList<Type>()));
        dictionary = new Type("Dictionary");
        dictionary.methods.add(new Function("add", nothing, new ArrayList<Type>(Arrays.asList(string, generic))));
        dictionary.methods.add(new Function("remove", nothing, string.toList()));
        dictionary.methods.add(new Function("lol", integer, new ArrayList<Type>()));
        //TODO: Allow collections as parameters/return types. Also, constructors/fields don't work for collections atm.

        symbolTable.functions.addSymbol("RegisterEvent", new Function("RegisterEvent", nothing,  new ArrayList<>(Arrays.asList(event, functionType))));

        //Instantiate typechecker, because this is used in firstrun
        typeChecker = new TypeChecker();

        //System.out.println("\n-----------------------------FirstRun-----------------------\n");
        //Firstrun is the first pass in the compiler, and this reads the functions and global variables, and adds to symboltable
        FirstRun firstVisit = new FirstRun();

        //Visit globals
        Type returnType = firstVisit.visitGlobal(((HOMEParser.ProgramContext)tree).global());

        //Check if errors, if not visitblock
        if(!(returnType instanceof ErrorType))
            returnType = firstVisit.visitBlock(((HOMEParser.ProgramContext)tree).block());

        //If error print it, if not visit typechecker
        if (!(returnType instanceof ErrorType))
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
