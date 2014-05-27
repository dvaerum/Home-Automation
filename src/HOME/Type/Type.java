package HOME.Type;

import HOME.*;
import HOME.CodeGene.ByteCodeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Type
{
    public String name;
    private List<Variable> fields = new ArrayList<>();
    private Function constructor;
    public List<Function> methods = new ArrayList<>();
    public String bytecode;


    Type()
    {
    }

    public Type(String name)
    {
        this.name = name;
    }

    public ArrayList<Type> toList()
    {
        ArrayList<Type> list = new ArrayList<Type>();
        list.add(this);
        return list;
    }

    public void Update(String name, String fields, String constructorName, String constructorArgs, String methods, String bytecode)
    {
        //Add classname into name field
        this.name = name;

        //--------------Field parsing---------------------
        List<String> fieldNames = new ArrayList(Arrays.asList(fields.split("- ")));

        fieldNames.remove(0);
        for (String singleField : fieldNames)
        {
            String[] field = singleField.trim().split(" ");
            if (field[0].equals("Event"))
                this.fields.add(new Variable(field[1], Main.event));
            else
            {
                if (Main.symbolTable.types.symbolExists(field[0]))
                    this.fields.add(new Variable(field[1], Main.symbolTable.types.getSymbol(field[0])));
                else
                {
                    System.out.println(String.format("Error in \"%s\".def: Type \"%s\" doesn't exist, please change the type, or make it.", name, field[0]));
                    System.exit(1);
                }
            }
        }

        //--------------Constructor parsing---------------------
        if (constructorName != null)
            constructorName = constructorName.replaceAll("- ", "");

        if (constructorName != null && constructorName.equals(name))
        {
            String[] constrParamsStr = constructorArgs.replaceAll("\\s", "").split(",");

            //Prepares list of parameters for constructor.
            ArrayList<Type> constrParams = new ArrayList<>();
            for (String paramStr : constrParamsStr)
            {
                if (paramStr.equals(""))
                    continue;

                if (Main.symbolTable.types.symbolExists(paramStr))
                    constrParams.add(Main.symbolTable.types.getSymbol(paramStr));
                else
                {
                    System.out.println(String.format("Error in \"%s\".def: Class \"%s\" didn't exist!", name, paramStr));
                    System.exit(1);
                }
            }

            constructor = new Function(constructorName, this, constrParams);
            Main.symbolTable.functions.addSymbol(constructorName, constructor);
            //Create function-type
            //And insert into constructor field
        }
        else if (constructorName != null)
        {
            System.out.println(String.format("Error in \"%s\".def: The constructor \"%s\" for the class \"%s\" got a different name!", name, constructorName, name));
            System.exit(1);
        }


        //--------------Method parsing---------------------
        Pattern methodPattern = Pattern.compile("([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");
        List<String> methodList = new ArrayList(Arrays.asList(methods.split("-")));
        methodList.remove(0);

        //Loop through all methods, and apply them to the method-list
        for (String method : methodList)
        {
            //Match the pattern, and trim whitespace in both ends
            Matcher methodMatcher = methodPattern.matcher(method.trim());

            if (methodMatcher.matches())
            {
                //Get method name
                String methodName = methodMatcher.group(1);

                //Get method returnType
                String returnTypeString = methodMatcher.group(3);
                Type returnType;
                if (!Main.symbolTable.types.symbolExists(returnTypeString))
                    if (returnTypeString.equals("Nothing"))
                        returnType = Main.nothing;
                    else
                    {
                        returnType = null;
                        System.out.println(String.format("Error in \"%s\".def: Class \"%s\" didn't exist!", name, returnTypeString));
                        System.exit(1);
                    }
                else
                    returnType = Main.symbolTable.types.getSymbol(returnTypeString);

                //Get method parameters
                List<Type> methodParams = new ArrayList<>();

                for (String paramType : Arrays.asList(methodMatcher.group(2).replaceAll("\\s", "").split(",")))
                {
                    if (paramType.equals(""))
                        continue;

                    if (!Main.symbolTable.types.symbolExists(paramType))
                    {
                        System.out.println(String.format("Error in \"%s\".def: Class \"%s\" didn't exist!", name, returnTypeString));
                        System.exit(1);
                    }
                    else
                        methodParams.add(Main.symbolTable.types.getSymbol(paramType));
                }

                //Add the current method to the type's method list
                this.methods.add(new Function(methodName, returnType, methodParams));
            }
        }

        this.bytecode = bytecode;
        //--------------End of constructor---------------------
    }

    //Compares types regarding lists.
    public static boolean isListSubtypeOfList(List<Type> l1, List<Type> l2)
    {
        if (l1.size() == l2.size())
            for (int i = 0; i < l1.size(); i++)
            {
                if (!l1.get(i).isSubtypeOf(l2.get(i)))
                {
                    return false;
                }
            }
        else
        {
            return false;
        }
        return true;
    }

    //Comparison of simpler types
    public boolean isSubtypeOf(Type otherType)
    {
        if (this.equals(Main.integer))
        {
            if (otherType.equals(Main.decimal))
                return true;
        }
        else if (this.equals(Main.anything))
            return true;


        return this.equals(otherType);
    }

    //Find a method by its name.
    public Function getMethodByName(String name)
    {
        for (Function func : methods)
        {
            if (name.equals(func.name))
            {
                return func;
            }
        }
        return null;
    }

    //Gets a field by its name.
    public Variable getFieldByName(String name)
    {
        for (Variable var : fields)
        {
            if (name.equals(var.name))
            {
                return var;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return name;
    }

    //Changes types to their java object implementation.
    public void invokeToObject(ParserRuleContext ctx, ByteCodeVisitor.Statements stmts)
    {
        switch (this.name)
        {
            case "Integer":
                stmts.add("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;", ctx);
                break;
            case "Decimal":
                stmts.add("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;", ctx);
                break;
            case "Boolean":
                stmts.add("invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;", ctx);
                break;
        }
    }

    //Changes objects back to their primitive type.
    public void invokeToSimpleType(ParserRuleContext ctx, ByteCodeVisitor.Statements stmts)
    {
        switch (this.name)
        {
            case "Integer":
                stmts.add("invokevirtual java/lang/Integer.intValue()I", ctx);
                break;
            case "Decimal":
                stmts.add("invokevirtual java/lang/Double.doubleValue()D", ctx);
                break;
            case "Boolean":
                stmts.add("invokevirtual java/lang/Boolean.booleanValue()Z", ctx);
                break;
        }
    }

    public String getObjectByteCode()
    {
        if (this.equals(Main.nothing))
        {
            return "V";
        }
        else if (this.equals(Main.integer))
        {
            return "Ljava/lang/Integer;";
        }
        else if (this.equals(Main.decimal))
        {
            return "Ljava/lang/Double;";
        }
        else if (this.equals(Main.bool))
        {
            return "Ljava/lang/Boolean;";
        }
        else if (this.equals(Main.string))
        {
            return "Ljava/lang/String;";
        }
        else if (this.equals(Main.list))
        {
            return "Ljava/util/ArrayList;";
        }
        else if (this.equals(Main.dictionary))
        {
            return "Ljava/util/HashMap;";
        }
        else if (this.equals(Main.object))
        {
            return "Ljava/lang/Object;";
        }
        else
        {
            return "LHOME/classes/" + this.bytecode + ";";
        }
    }

    public String getSimpleByteCode()
    {

        if (this.equals(Main.nothing))
        {
            return "V";
        }
        else if (this.equals(Main.integer))
        {
            return this.bytecode;
        }
        else if (this.equals(Main.decimal))
        {
            return this.bytecode;
        }
        else if (this.equals(Main.bool))
        {
            return this.bytecode;
        }
        else if (this.equals(Main.string))
        {
            return "Ljava/lang/String;";
        }
        else if (this.equals(Main.list))
        {
            return "Ljava/util/ArrayList;";
        }
        else if (this.equals(Main.dictionary))
        {
            return "Ljava/util/HashMap;";
        }
        else if (this.equals(Main.object))
        {
            return "Ljava/lang/Object;";
        }
        else
        {
            return "LHOME/classes/" + this.bytecode + ";";
        }
    }

    public String getClassByteCode()
    {

        if (this.equals(Main.integer))
        {
            return "java/lang/Integer";
        }
        else if (this.equals(Main.decimal))
        {
            return "java/lang/Double";
        }
        else if (this.equals(Main.bool))
        {
            return "java/lang/Boolean";
        }
        else if (this.equals(Main.string))
        {
            return "java/lang/String";
        }
        else if (this.equals(Main.list))
        {
            return "java/util/ArrayList";
        }
        else if (this.equals(Main.dictionary))
        {
            return "java/util/HashMap";
        }
        else if (this.equals(Main.object))
        {
            return "java/lang/Object";
        }
        else
        {
            return "HOME/classes/" + this.bytecode;
        }
    }
}
