package HOME;

import HOME.CodeGene.ByteCodeVisitor;
import HOME.Grammar.*;
import HOME.SymbolTable.SymbolTable;
import HOME.Type.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;
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
    public static Type object = new Type("Object");

    public static Type integer;
    public static Type decimal;
    public static Type bool;
    public static Type string;
    public static Type list;
    public static Type dictionary;
    public static Type variable = new Type("Variable");
    public static Type anything = new Type("Anything");
    public static Type event = new Type("Event");
    public static Type functionType = new Type("Function");

    public static TypeChecker typeChecker;

    public static void main(String[] args) throws IOException
    {
        HOMELexer lexer = new HOMELexer(new ANTLRFileStream("NotInput"));
        HOMEParser parser = new HOMEParser(new CommonTokenStream(lexer));

        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0)
        {
            System.out.println("Syntax error, please check your program, and correct the errors above.");
            Runtime.getRuntime().exit(1);
        }

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
        list.bytecode = "LJava/Lang/ArrayList;";
        list.methods.add(new Function("add", nothing, generic.toList()));
        list.methods.add(new Function("remove", nothing, generic.toList()));
        list.methods.add(new Function("lol", integer, new ArrayList<Type>()));
        dictionary = new Type("Dictionary");
        dictionary.methods.add(new Function("put", object, new ArrayList<Type>(Arrays.asList(string, generic))));
        dictionary.methods.add(new Function("remove", nothing, string.toList()));
        dictionary.methods.add(new Function("lol", integer, new ArrayList<Type>()));
        //TODO: Allow collections as parameters/return types. Also, constructors/fields don't work for collections atm.

        symbolTable.functions.addSymbol("RegisterEvent", new Function("RegisterEvent", nothing, new ArrayList<>(Arrays.asList(event, functionType))));

        //Instantiate typechecker, because this is used in firstrun
        typeChecker = new TypeChecker();

        //System.out.println("\n-----------------------------FirstRun-----------------------\n");
        //Firstrun is the first pass in the compiler, and this reads the functions and global variables, and adds to symboltable
        FirstRun firstVisit = new FirstRun();

        //Visit functions
        Type returnType = firstVisit.visitBlock(((HOMEParser.ProgramContext)tree).block());

        //Check if errors, if not visitGlobal
        if (!(returnType instanceof ErrorType))
            returnType = firstVisit.visitGlobal(((HOMEParser.ProgramContext)tree).global());

        if(returnType instanceof ErrorType)
        {
            System.out.println("Error, halting!");
            System.exit(1);
        }

        System.out.println("-----------------------------Typechecker-----------------------");
        Type type = typeChecker.visitBlock(((HOMEParser.ProgramContext) tree).block());
        if (type instanceof ErrorType)
        {
            System.out.println("Error, halting!");
            System.exit(1);
        }
        else
        {
            System.out.println("Success");
        }

        nothing.bytecode = "V";
        System.out.println("-----------------------------Code Generation-----------------------");
        //ByteCodeVisitor bytecode = new ByteCodeVisitor();
        //bytecode.visit(tree);
        File file = new File("HOME.class");
        if (file.exists())
        {
            file.delete();
        }
        // TODO change
        symbolTable.resetVariableTable();

//        HOME.CodeGene.Main codeGeneration = new HOME.CodeGene.Main();
//        codeGeneration.main(null);
        object.bytecode = "Ljava/lang/Object;";
        symbolTable.types.addSymbol(object.name, object);
        list.bytecode = "Ljava/util/ArrayList;";
        symbolTable.types.addSymbol(list.name, list);
        dictionary.bytecode = "Ljava/util/HashMap;";
        symbolTable.types.addSymbol(dictionary.name, dictionary);
        ByteCodeVisitor visitor = new ByteCodeVisitor();
        visitor.visit(tree);
        visitor.build();

        try
        {
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("java -jar jar/jasmin.jar HOME/CodeGene/Output_test.j");
            proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            BufferedReader bIn = new BufferedReader(new InputStreamReader(in));
            BufferedReader bErr = new BufferedReader(new InputStreamReader(err));
            String s;
            while ((s = bIn.readLine()) != null)
            {
                System.out.println(s);
            }
            while ((s = bErr.readLine()) != null)
            {
                System.out.println(s);
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }


        System.out.println("-----------------------------Decompiling-----------------------");
        try
        {
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("javap -c -v -private HOME.class");
            //proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            BufferedReader bIn = new BufferedReader(new InputStreamReader(in));
            BufferedReader bErr = new BufferedReader(new InputStreamReader(err));
            String s;
            while ((s = bIn.readLine()) != null)
            {
                System.out.println(s);
            }
            while ((s = bErr.readLine()) != null)
            {
                System.out.println(s);
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }


        System.out.println("-----------------------------Running-----------------------");
        try
        {
            // Run a java app in a separate system process
            Process proc = Runtime.getRuntime().exec("java HOME");
            //proc.waitFor();
            // Then retreive the process output
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            BufferedReader bIn = new BufferedReader(new InputStreamReader(in));
            BufferedReader bErr = new BufferedReader(new InputStreamReader(err));
            String s;
            while ((s = bIn.readLine()) != null)
            {
                System.out.println(s);
            }
            while ((s = bErr.readLine()) != null)
            {
                System.out.println(s);
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }

        // System.out.println("omagmward");
//==============  UNCOMMENT THIS IF YOU WANT TO SEE THE TREE <-----------------------------------
//        HOMEParser.ProgramContext lol = ((HOMEParser.ProgramContext)tree);
//        lol.inspect(parser);
//=================================================================================

    }
}
