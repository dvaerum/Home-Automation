package HOME;

import HOME.SymbolTable.SymbolTable;
import HOME.Type.Type;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileReader
{
    private SymbolTable symbolTable = Main.symbolTable;

    //Insert prototype of classes
    public void loadClassPrototypes()
    {
        File standardDir = new File("src/HOME/classes/standard");
        File customDir = new File("src/HOME/classes/custom");
        String files;
        //System.out.println(standardDir.getAbsolutePath());
        //Get list of standard and custom-classses
        List<File> listOfFiles = new ArrayList(Arrays.asList(standardDir.listFiles()));
        List<File> listOfFiles2 = new ArrayList(Arrays.asList(customDir.listFiles()));

        //Combine lists
        for (File tmpfile : listOfFiles2)
        {
            listOfFiles.add(tmpfile);
        }

        Type type;
        String name;

        //Run through all .def files, and create a prototype type
        for (File file : listOfFiles)
        {
            files = file.getName();
            name = files.replaceFirst(".def", "");
            if (files.toLowerCase().endsWith(".def"))
            {
                type = new Type(name);
                symbolTable.types.addSymbol(name, type);
            }
        }
    }

    public void expandTypes()
    {
        try
        {
            loadClasses("standard");
            loadClasses("custom");
        } catch (IOException e)
        {
            System.err.println(e.initCause(e.getCause()));
        }
    }

    void loadClasses(String folderName) throws IOException
    {
        File standardDir = new File("src/HOME/classes/" + folderName);

        //Get all files that ends with .def, to prevent both processing .txt and .def files
        List<File> expectedClasses = new ArrayList(Arrays.asList(standardDir.listFiles(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(".def");
            }
        })));

        //Run through all standard, and update the prototype type with all info
        for (File importclass : expectedClasses)
        {
            String fileName = importclass.getName().replaceFirst(".def", "");
            File classfile = new File(standardDir + File.separator + fileName + ".class");
            //Check if java .class file for the type exists, if not give a warning
            if (!classfile.exists() && !classfile.isDirectory())
            {
                System.out.println(String.format("Error: The class %s doesn't have a .class file", fileName));
                System.exit(1);
            }
            else //read file if no problems
            {
                try
                {
                    readClassDef(standardDir + File.separator + fileName + ".def");
                } catch (FileNotFoundException e)
                {
                    System.err.println(e.initCause(e.getCause()));
                }
            }
        }
    }

    //Read the class.def files, and convert the content into a Type
    void readClassDef(String fullPath) throws IOException
    {
        //Create a file scanner, and check if the scanner can read the file
        String str;
        if (!new Scanner(new File(fullPath)).useDelimiter("\\Z").hasNext())
        {
            System.out.println(String.format("Warning: Class reader failed at path: %s", fullPath));
            return;
        }
        //Convert the file of multiple lines into a single string
        str = new Scanner(new File(fullPath)).useDelimiter("\\Z").next();

        //Define the pattern, that is used to recognize the class.def file
        Pattern classPtrn = Pattern.compile("class\\s([a-zA-Z_][a-zA-Z0-9_]*)\\sfields\\s((?:\\-\\s[a-zA-Z_][a-zA-Z0-9_]*\\s[a-zA-Z_][a-zA-Z0-9_]*\\s)*)endfields\\sconstructor\\s(?:(\\-\\s[a-zA-Z_][a-zA-Z0-9_]*)\\(((?:[a-zA-Z_][a-zA-Z0-9_]*(?:, )?)*)\\)\\s)?endconstructor\\smethods\\s((?:\\-\\s(?:[a-zA-Z_][a-zA-Z0-9_]*)\\((?:(?:[a-zA-Z_][a-zA-Z0-9_]*(?:, )?)*)\\)\\s+>\\s+[a-zA-Z_][a-zA-Z0-9_]*\\s*)*)\\sendmethods\\sbytecode\\s(\\-\\s.+)\\sendbytecode\\sendclass");

        //Convert multiple whitespaces into single whitesspaces, and remove newline and caret return to ease the regex
        str = str.replaceAll("\\s+", " ");
        str = str.replaceAll("[\\n|\\r]]", "");

        Matcher mtchr = classPtrn.matcher(str);
        //Try to match, and check if a match is found
        if (mtchr.matches())
        {
            String className = mtchr.group(1);
            String fields = mtchr.group(2);
            String constrName = mtchr.group(3);
            String constrArgs = mtchr.group(4);

            String methods = mtchr.group(5);

            String bytecode = mtchr.group(6).replace("-", "").trim();

            try
            {
                //Update the existing type with fields, constructors and methods
                symbolTable.types.getSymbol(className).Update(className, fields, constrName, constrArgs, methods, bytecode);
            } catch (Exception e)
            {
                System.out.println(className);
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println(String.format("The file at path \"%s\" isn't recognized", fullPath));
        }

    }
}
