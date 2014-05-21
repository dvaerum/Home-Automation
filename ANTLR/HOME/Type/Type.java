package HOME.Type;

import HOME.*;
import HOME.CodeGene.ByteCodeVisitor;

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
    public String name;
    public List<Variable> fields = new ArrayList<>();
    public Function constructor;
    public List<Function> methods = new ArrayList<>();
    public String bytecode;


    public Type() {
    }

    public Type(Type t) {
        name = new String(t.name);
        fields = new ArrayList<Variable>(t.fields);
        constructor = t.constructor;
        methods = new ArrayList<Function>(t.methods);
    }

    public Type(String name) {
        this.name = name;
    }

    public ArrayList<Type> toList() {
        ArrayList<Type> list = new ArrayList<Type>();
        list.add(this);
        return list;
    }

    public void Update(String name, String fields, String constructorName, String constructorArgs, String methods, String bytecode) throws Exception
    {
        //Add classname into name field
        this.name = name;

        //--------------Field parsing---------------------
        List<String> fieldNames = new ArrayList(Arrays.asList(fields.split("- ")));
        //String[] fieldNames = constructorArgs.split("- ");
        fieldNames.remove(0);
        for (String singleField : fieldNames) {
            String[] field = singleField.trim().split(" ");
            if (field[0].equals("Event"))
                this.fields.add(new Variable(field[1], Main.event));
            else
                this.fields.add(new Variable(field[1], Main.symbolTable.types.getSymbol(field[0])));
        }

        //--------------Constructor parsing---------------------
        if(constructorName != null)
            constructorName = constructorName.replaceAll("- ", "");

        if(constructorName != null && constructorName.equals(name))
        {
            String[] constrParamsStr = constructorArgs.replaceAll("\\s", "").split(",");

            //Prepares list of parameters for constructor.
            ArrayList<Type> constrParams = new ArrayList<>();
            for (String paramStr : constrParamsStr) {
                if (paramStr.equals(""))
                    continue;

                if (Main.symbolTable.types.symbolExists(paramStr))
                    constrParams.add(Main.symbolTable.types.getSymbol(paramStr));
                else
                    throw new Exception(String.format("Class %s didn't exist!", paramStr));
            }

            constructor = new Function(constructorName, this, constrParams);
            Main.symbolTable.functions.addSymbol(constructorName, constructor);
            //Create function-type
            //And insert into constructor field
        }
        else if(constructorName != null)
            System.out.println(String.format("WARNING: The constructor \"%s\" for the class \"%s\" got a different name!", constructorName, name));



        //--------------Method parsing---------------------
        Pattern methodPattern = Pattern.compile("([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");
        List<String> methodList = new ArrayList(Arrays.asList(methods.split("-")));
        methodList.remove(0);

        //Loop through all methods, and apply them to the method-list
        for (String method : methodList) {
            //Match the pattern, and trim whitespace in both ends
            Matcher methodMatcher = methodPattern.matcher(method.trim());

            if (methodMatcher.matches()) {
                //Get method name
                String methodName = methodMatcher.group(1);

                //Get method returnType
                String returnTypeString = methodMatcher.group(3);
                Type returnType;
                if(!Main.symbolTable.types.symbolExists(returnTypeString))
                    if (returnTypeString.equals("Nothing"))
                        returnType = Main.nothing;
                    else
                        throw new Exception(String.format("Class %s didn't exist!", returnTypeString));
                else
                    returnType = Main.symbolTable.types.getSymbol(returnTypeString);

                //Get method parameters
                List<Type> methodParams = new ArrayList<>();

                for (String paramType : Arrays.asList(methodMatcher.group(2).replaceAll("\\s", "").split(","))) {
                    if (paramType.equals(""))
                        continue;

                    if (!Main.symbolTable.types.symbolExists(paramType))
                        throw new Exception(String.format("Class %s didn't exist!", paramType));
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

    public static boolean isListSubtypeOfList(List<Type> l1, List<Type> l2) {
        if (l1.size() == l2.size())
            for (int i = 0; i < l1.size(); i++) {
                if (!l1.get(i).isSubtypeOf(l2.get(i))) {
                    return false;
                }
            }
        else {
            return false;
        }
        return true;
    }

    public static List<Type> copyTypeList(List<Type> list) {
        List<Type> newList = new ArrayList<Type>(list);

        for (Type t : newList) {
            t = new Type(t);
        }
        return newList;
    }

    public boolean isSubtypeOf(Type otherType) {
        if (this.equals(Main.integer)) {
            if (otherType.equals(Main.decimal))
                return true;
        } else if (this.equals(Main.anything))
            return true;


        return this.equals(otherType);
    }

    public Function getMethodByName(String name) {
        for (Function func : methods) {
            if (name.equals(func.name)) {
                return func;
            }
        }
        return null;
    }

    public Variable getFieldByName(String name) {
        for (Variable var : fields) {
            if (name.equals(var.name)) {
                return var;
            }
        }
        return null;
    }

    public Type(String name, List<Variable> fields, Function constructor, List<Function> methods) {
        this.name = name;
        this.fields = fields;
        this.constructor = constructor;
        this.methods = methods;
    }

    @Override
    public String toString() {
        return name;
    }

    public void invokeToObject(ByteCodeVisitor.Statements stmts)
    {
        switch (this.name)
        {
            case "Integer":
                stmts.addStatement("invokestatic  java/lang/Integer.valueOf(I)Ljava/lang/Integer;");
                break;
            case "Decimal":
                stmts.addStatement("invokestatic  java/lang/Double.valueOf(D)Ljava/lang/Double;");
                break;
            case "Boolean":
                stmts.addStatement("invokestatic  java/lang/Boolean.valueOf(Z)Ljava/lang/Boolean;");
                break;
        }
    }

    public void invokeToSimpleType(ByteCodeVisitor.Statements stmts)
    {
        switch (this.name)
        {
            case "Integer":
                stmts.addStatement("invokevirtual java/lang/Integer.intValue()I");
                break;
            case "Decimal":
                stmts.addStatement("invokevirtual java/lang/Double.doubleValue()D");
                break;
            case "Boolean":
                stmts.addStatement("invokevirtual java/lang/Boolean.booleanValue()Z");
                break;
        }
    }

    public String getObjectByteCode() {
        if (this.equals(Main.nothing)) {
            return "V";
        } else if (this.equals(Main.integer)) {
            return "Ljava/lang/Integer;";
        } else if (this.equals(Main.decimal)) {
            return "Ljava/lang/Double;";
        } else if (this.equals(Main.bool)) {
            return "Ljava/lang/Boolean;";
        } else if (this.equals(Main.string)) {
            return "Ljava/lang/String;";
        }if (this.equals(Main.list)){
            return "Ljava/util/ArrayList;";
        } else if (this.equals(Main.dictionary)){
            return "Ljava/util/HashMap;";
        } else {
            return "Lclasses/" + this.bytecode + ";";
        }
    }

    public String getSimpleByteCode() {

        if (this.equals(Main.nothing)) {
            return "V";
        } else if (this.equals(Main.integer)) {
            return this.bytecode;
        } else if (this.equals(Main.decimal)) {
            return this.bytecode;
        } else if (this.equals(Main.bool)) {
            return this.bytecode;
        } else if (this.equals(Main.string)) {
            return "Ljava/lang/String;";
        }if (this.equals(Main.list)){
            return "Ljava/util/ArrayList;";
        } else if (this.equals(Main.dictionary)){
            return "Ljava/util/HashMap;";
        } else {
            //return "LHOME/" + this.bytecode + ";";
            return "Lclasses/" + this.bytecode + ";";
        }
    }

    public String getClassByteCode() {

        if (this.equals(Main.integer)) {
            return "java/lang/Integer";
        } else if (this.equals(Main.decimal)) {
            return "java/lang/Double";
        } else if (this.equals(Main.bool)) {
            return "java/lang/Boolean";
        } else if (this.equals(Main.string)) {
            return "java/lang/String";
        }if (this.equals(Main.list)){
            return "java/util/ArrayList";
        } else if (this.equals(Main.dictionary)){
            return "java/util/HashMap";
        } else {
            //return "HOME/" + this.bytecode;
            return "classes/" + this.bytecode;
        }
    }

    public String getByteCode() {
        if(this.equals(Main.integer))
            return this.bytecode;
        if(this.equals(Main.decimal))
            return this.bytecode;
        if(this.equals(Main.bool))
            return this.bytecode;
        if(this.equals(Main.string))
            return this.bytecode;
        else
            return "classes/" + this.bytecode;
    }

/*    public String getUndecoratedByteCode(){
        String s = getObjectByteCode();
        if(s.charAt(0) == 'L'){
            s = s.substring(1);
        }
        if(s.charAt(s.length() - 1) == ';'){
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }*/
}
