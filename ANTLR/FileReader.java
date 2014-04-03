import org.stringtemplate.v4.compiler.STParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 * Created by Jacob on 26-03-14.
 */
public class FileReader {
    SymbolTable scope = Main.scope;
    public void loadMethods()
    {
        try {
            Scanner sc = new Scanner(new File("Methods"));
            String str;

            Pattern ptrn = Pattern.compile("^([A-Z][a-z]+).([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");

            while(sc.hasNextLine()){
                str = sc.nextLine();
                Matcher mtchr = ptrn.matcher(str);

                if(mtchr.matches())
                {
                    Type objType = String2Type(mtchr.group(1));
                    String methodName = mtchr.group(2);
                    String[] args = mtchr.group(3).replaceAll("\\s", "").split(",");
                    ArrayList<Type> params = new ArrayList<>();
                    Type returnType = String2Type(mtchr.group(4));

                    if(!args[0].equals(""))
                    {
                        for(String strParam : args)
                        {
                            params.add(String2Type(strParam));
                        }
                    }

                    Type symbol = new Type("Method", objType, params, returnType);
                    scope.addSymbolMethod(methodName, symbol);
//                    System.out.println(objType + " - " + methodName + " returns " + returnType);
                }
//                else
//                    System.out.println("No matches");
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.initCause(e.getCause()));

        }
    }

    public void loadStandardClasses() throws IOException
    {
        List<String> expectedClasses = Arrays.asList("Input", "Integer", "Output");

        File standardDir = new File("classes" + File.separator + "standard-classes");

        for(String importclass : expectedClasses)
        {
            File classfile = new File(standardDir + File.separator + importclass + ".txt");

            if(! classfile.exists() && !classfile.isDirectory() )
            {
                System.out.println("epic fail! " + importclass + " fejler!");
            }
            else //read file if no problems
            {
                try
                {
                    readClassDef(standardDir + File.separator + importclass + ".def");
                }
                catch (FileNotFoundException e)
                {
                    System.err.println(e.initCause(e.getCause()));

                }
            }
        }
    }

    void readClassDef(String fullPath) throws IOException
    {
        Scanner sc = new Scanner(new File(fullPath));
        String str = org.apache.commons.io.FileUtils.readFileToString(new File(fullPath));
        //Reads

        Pattern methodPtrn = Pattern.compile("([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");

        Pattern classPtrn = Pattern.compile("class\\s([a-zA-Z0-9_]+)\\sfields\\s((?:\\-\\s[\\w]+\\s\\w+\\s)*)endfields\\sconstructor\\s(\\-\\s[A-Z_]\\w*)\\(((?:\\w(?:, )?)*)\\)\\sendconstructor\\smethods\\s((?:\\-\\s(?:[a-zA-Z0-9_]+)\\((?:(?:\\w(?:, )?)*)\\)\\s+>\\s+\\w+\\s*)*)\\sendmethods\\sendclass");
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("[\\n|\\r]]", "");
        Matcher mtchr = classPtrn.matcher(str);

        System.out.println(mtchr.matches());

        if(mtchr.matches())
        {
            String className = mtchr.group(1);
            String fields = mtchr.group(2);
            String constrName = mtchr.group(3);
            String constrArgs = mtchr.group(4);
            String methods = mtchr.group(5);

            String[] methodList = methods.split("-");

            for(int i = 1; i <= methodList.length-1;  i++)
            {
                Matcher methodMtchr = methodPtrn.matcher(methodList[i].trim());
                if(methodMtchr.matches())
                {
                    String methodName = methodMtchr.group(1);
                    String[] args = methodMtchr.group(2).replaceAll("\\s", "").split(",");
                    ArrayList<Type> params = new ArrayList<>();
                    Type returnType = String2Type(methodMtchr.group(3));

                    if(!args[0].equals(""))
                    {
                        for(String strParam : args)
                        {
                            params.add(String2Type(strParam));
                        }
                    }

                    Type objType = new Type("ObjectType");
                    Type symbol = new Type("Method", objType, className, params, returnType);
                    scope.addSymbolMethod(methodName, symbol);
                }
            }

            System.out.println(String.format("Name: %s\nFields: %s\nContsr: %s\nArgs: %s\nMethods: %s", className, fields, constrName, constrArgs, methods));
        }

    }


    public Type String2Type(String str)
    {
       return new Type(str);
    }
}

