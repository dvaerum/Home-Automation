package HOME.Type;

import HOME.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Frederik on 09-04-2014.
 */

public class Type
{
    public boolean isFinal = true;
    public String name;
    public List<Variable> fields = new ArrayList<>();
    public Function constructor;
    public List<Function> methods = new ArrayList<>();


    public Type()
    {
    }

    public Type(String name) {
        this.isFinal = false;
        this.name = name;
    }

    public void Update(String name, String fields, String constructorName, String constructorArgs, String methods) throws Exception
    {
        this.isFinal = true;
        //Add classname into name field
        this.name = name;

        //--------------Field parsing---------------------
        List<String> fieldNames = new ArrayList(Arrays.asList(fields.split("- ")));
        //String[] fieldNames = constructorArgs.split("- ");
        fieldNames.remove(0);
        for(String singleField : fieldNames)
        {
            String[] field = singleField.trim().split(" ");
            this.fields.add( new Variable(field[1], Main.symbolTable.types.getSymbol(field[0])));
        }

        //--------------Constructor parsing---------------------
        if(constructorName != null)
        {
            constructorName = constructorName.replaceAll("- ", "");
            String[] constrParamsStr = constructorArgs.replaceAll("\\s", "").split(",");

            //Prepares list of parameters for constructor.
            ArrayList<Type> constrParams = new ArrayList<>();
            for(String paramStr : constrParamsStr)
            {
                if(Main.symbolTable.types.symbolExists(paramStr))
                    constrParams.add(Main.symbolTable.types.getSymbol(paramStr));
                else
                    throw new Exception(String.format("Class %s didn't exist!", paramStr));
            }

            constructor = new Function(constructorName, this, constrParams);
            //Create function-type
            //And insert into constructor field
        }

        //--------------Method parsing---------------------
        Pattern methodPattern = Pattern.compile("([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");
        List<String> methodList = new ArrayList(Arrays.asList(methods.split("-")));
        methodList.remove(0);

        //Loop through all methods, and apply them to the method-list
        for(String method : methodList)
        {
            //Match the pattern, and trim whitespace in both ends
            Matcher methodMatcher = methodPattern.matcher(method.trim());

            if(methodMatcher.matches())
            {
                //Get method name
                String methodName = methodMatcher.group(1);

                //Get method returnType
                String returnTypeString = methodMatcher.group(3);
                Type returnType;
                if(!Main.symbolTable.types.symbolExists(returnTypeString))
                    throw new Exception(String.format("Class %s didn't exist!", returnTypeString));
                else
                    returnType = Main.symbolTable.types.getSymbol(returnTypeString);

                //Get method parameters
                List<Type> methodParams = new ArrayList<>();

                for(String paramType : Arrays.asList(methodMatcher.group(2).replaceAll("\\s", "").split(",")))
                {
                    if(!Main.symbolTable.types.symbolExists(paramType))
                        throw new Exception(String.format("Class %s didn't exist!", paramType));
                    else
                        methodParams.add(Main.symbolTable.types.getSymbol(paramType));
                }

                //Add the current method to the type's method list
                this.methods.add(new Function(methodName, returnType, methodParams));
            }
        }

        //--------------End of constructor---------------------
    }

    public Type(String name, List<Variable> fields, Function constructor, List<Function> methods)
    {
        this.name = name;
        this.fields = fields;
        this.constructor = constructor;
        this.methods = methods;
    }

    @Override
    public String toString() {
        return name;
    }
}
