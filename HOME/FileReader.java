package HOME;

import HOME.Type.Type;
import SymbolTableNew.SymbolTableNew;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jacob on 26-03-14.
 */
public class FileReader {
    SymbolTableNew symbolTable = Main.symbolTable;

    //Insert prototype of classes
    public void loadClassPrototypes() throws IOException
    {
        File standardDir = new File("classes" + File.separator + "standard-classes");
        File customDir = new File("classes" + File.separator + "custom-classes");
        String files;


        List<File> listOfFiles = new ArrayList(Arrays.asList(standardDir.listFiles()));
        //TODO: Read custom classes

        List<File> listOfFiles2 = new ArrayList(Arrays.asList(customDir.listFiles()));
        for(File tmpfile : listOfFiles2)
        {
            listOfFiles.add(tmpfile);
        }

//        List<File> listOfFiles2 = Arrays.asList(customDir.listFiles());
//        listOfFiles.addAll(listOfFiles2);
//        File[] customClassFiles = customDir.listFiles();
//        .addAll(listOfFiles, customClassFiles);
        Type type;
        String name;

        for(File file : listOfFiles)
        {
            files = file.getName();
            name = files.replaceFirst(".def", "");
            if(files.toLowerCase().endsWith(".def"))
            {
                System.out.println("Read: " + files);
                type = new Type(name);
                symbolTable.types.addSymbol(name, type);
            }
        }

    }

    public void loadStandardClasses() throws IOException
    {
        List<String> expectedClasses = Arrays.asList("Input", "Integer", "Output", "Inputx");

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
        String str = null;
        if(!new Scanner(new File(fullPath)).useDelimiter("\\Z").hasNext())
        {
            System.out.println(String.format("Warning: Class reader failed at path: %s", fullPath));
            return;
        }
        str = new Scanner(new File(fullPath)).useDelimiter("\\Z").next();

        //Reads

        Pattern methodPtrn = Pattern.compile("([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");

        Pattern classPtrn = Pattern.compile("class\\s([a-zA-Z0-9_]+)\\sfields\\s((?:\\-\\s[\\w]+\\s\\w+\\s)*)endfields\\sconstructor\\s(?:(\\-\\s[A-Z_]\\w*)\\(((?:\\w(?:, )?)*)\\)\\s)?endconstructor\\smethods\\s((?:\\-\\s(?:[a-zA-Z0-9_]+)\\((?:(?:\\w(?:, )?)*)\\)\\s+>\\s+\\w+\\s*)*)\\sendmethods\\sendclass");
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("[\\n|\\r]]", "");
        Matcher mtchr = classPtrn.matcher(str);

        Type classObject;

        if(mtchr.matches())
        {
            String className = mtchr.group(1);
            String fields = mtchr.group(2);
            String constrName = mtchr.group(3);
            String constrArgs = mtchr.group(4);

      /*      if(constrName != null)
        {
            String[] constrParamsStr = constrArgs.replaceAll("\\s", "").split(",");
            ArrayList<HOME.Type> constrParams = new ArrayList<>();

            for(String paramStr : constrParamsStr)
            {
                constrParams.add(new HOME.Type(paramStr));
            }

            HOME.Type constr = new HOME.Type("Function", constrParams, new HOME.Type(className));
            scope.addSymbolFunction(constrName.replace("-", "").trim(), constr);
        }*/

            String methods = mtchr.group(5);

            //scope.addSymbolClass(className, new HOME.Type(className));

            String[] methodList = methods.split("-");
               /*
            for(int i = 1; i <= methodList.length-1;  i++)
            {
                Matcher methodMtchr = methodPtrn.matcher(methodList[i].trim());
                if(methodMtchr.matches())
                {
                    String methodName = methodMtchr.group(1);
                    String[] args = methodMtchr.group(2).replaceAll("\\s", "").split(",");
                    ArrayList<HOME.Type> params = new ArrayList<>();
                    HOME.Type returnType = String2Type(methodMtchr.group(3));

                    if(!args[0].equals(""))
                    {
                        for(String strParam : args)
                        {
                            params.add(String2Type(strParam));
                        }
                    }

                    //HOME.Type objType = new HOME.Type("ObjectType");
                    //HOME.Type symbol = new HOME.Type("Method", className, params, returnType);
                    //scope.addSymbolMethod(methodName, symbol);
                }
            }*/

            try
            {
//                classObject.Update(className, fields, constrName, constrArgs, methods);

                symbolTable.types.getSymbol(className).Update(className, fields, constrName, constrArgs, methods);
//                symbolObject.Update(className, fields, constrName, constrArgs, methods);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            //System.out.println(String.format("Name: %s\nFields: %s\nContsr: %s\nArgs: %s\nMethods: %s", className, fields, constrName, constrArgs, methods));
            System.out.println(String.format("Name: %s correctly loaded!", className));
        }
        else
        {
            System.out.println(String.format("The file at path \"%s\" isn't recognized", fullPath));
        }

    }


    public Type String2Type(String str)
    {
        return new Type(str);
    }
}

