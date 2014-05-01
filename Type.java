import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jacob on 14-03-14.
 */
public class Type {
    public enum TypeEnum {
        Integer, Decimal, Boolean, String, Integer2Decimal, Function, Error, Nothing, List, Dictionary, Method, ListListOrDictionary, Anything, ObjectType;
    }

    public boolean isSubTypeOf(Type t)
    {
        // If t is a ListListOrDictionary, then return true if this is a List<List<Type>> or Dictionary<Type>
        if ( ((this.typeParameters.size() > 0 && t.typeParameters.size() > 0 && t.primaryType.equals("ListListOrDictionary")) &&
                ((this.typeParameters.get(0).typeParameters.size() > 0 && this.primaryType.equals("List") && this.typeParameters.get(0).primaryType.equals("List") &&
                        this.typeParameters.get(0).typeParameters.get(0).primaryType.equals(t.typeParameters.get(0).primaryType)) ||
                        (this.primaryType.equals("Dictionary") && this.typeParameters.get(0).primaryType.equals(t.typeParameters.get(0).primaryType)))))
            return true;
            // For dealing with empty list initializers (for example: List<Integer> = {})
        else if (t.primaryType.equals("List") && t.typeParameters.size() > 0 && t.typeParameters.get(0).primaryType.equals("Anything") && (this.primaryType.equals("Dictionary") || this.primaryType.equals("List")))
            return true;
        else if (t.primaryType.equals("Anything"))
            return true;
        if (this.primaryType.equals(t.primaryType))
        {
            // Check if typeParameters are a subtype as well.
            if (this.typeParameters.size() == t.typeParameters.size())
            {
                for(int i = 0; i < typeParameters.size(); i++)
                {
                    if (!(this.typeParameters.get(i).isSubTypeOf(t.typeParameters.get(i))))
                    {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

    public ArrayList<Type> toList()
    {
        ArrayList<Type> list = new ArrayList<Type>();
        list.add(this);
        return list;
    }

    public static List<String> BooleanOperator = Arrays.asList("==", ">", "<", "<=", ">=", "!=", "AND", "OR");

    ArrayList<Type> parameters = new ArrayList<Type>();
    Type returnTypeEnum;
    ArrayList<Type> typeParameters = new ArrayList<Type>();
    Type objectType;

    String classType;
    String primaryType;
    Object value;

    // Integer i = 2
    // function test(Integer i, Boolean b) returns Nothing
    // Dictionary<Integer> ints = {{"Test",2},{"Three",3}}


    public boolean equals(String t)
    {
        return this.primaryType.equals(t);
    }

    public boolean compatibleWith(Type t)
    {
        if (this.isSubTypeOf(t))
        {
            return true;
        }
        return equals(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (objectType != null ? !objectType.equals(type.objectType) : type.objectType != null) return false;
        if (parameters != null ? !parameters.equals(type.parameters) : type.parameters != null) return false;
        if (returnTypeEnum != null ? !returnTypeEnum.equals(type.returnTypeEnum) : type.returnTypeEnum != null)
            return false;
        if (primaryType != type.primaryType) return false;
        if (typeParameters != null ? !typeParameters.equals(type.typeParameters) : type.typeParameters != null)
            return false;

        return true;
    }

    public boolean checkParametersConvertToDecimal(ArrayList<Type> paramList) {

        if(parameters.size() != paramList.size()){
            return false;
        }

        for (int i = 0; i < paramList.size(); i++)
        {
            Type inputParam = paramList.get(i);
            Type methodParam = parameters.get(i);
            if(!methodParam.equals(inputParam))
            {
                if(methodParam.equals("Decimal") && inputParam.equals("Integer"))
                {

                }
                else
                    return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = parameters != null ? parameters.hashCode() : 0;
        result = 31 * result + (returnTypeEnum != null ? returnTypeEnum.hashCode() : 0);
        result = 31 * result + (typeParameters != null ? typeParameters.hashCode() : 0);
        result = 31 * result + (objectType != null ? objectType.hashCode() : 0);
        result = 31 * result + (primaryType != null ? primaryType.hashCode() : 0);
        return result;
    }

    public Type(String primaryType) {
        this.primaryType = primaryType;
        this.value = null;
    }

    public Type(String primaryType, ArrayList<Type> parameters, Type returnTypeEnum) {
        this.primaryType = primaryType;
        this.parameters = parameters;
        this.returnTypeEnum = returnTypeEnum;
    }

    public Type(String primaryType, Type objectType, ArrayList<Type> parameters, Type returnTypeEnum) {
        this.primaryType = primaryType;
        this.objectType = objectType;
        this.parameters = parameters;
        this.returnTypeEnum = returnTypeEnum;
    }

    public Type(String primaryType, Type objectType, String classType, ArrayList<Type> parameters, Type returnTypeEnum) {
        this.primaryType = primaryType;
        this.objectType = objectType;
        this.parameters = parameters;
        this.returnTypeEnum = returnTypeEnum;
        this.classType = classType;
    }

    public Type(String primaryType, ArrayList<Type> typeParameters) {
        this.primaryType = primaryType;
        this.typeParameters = typeParameters;
    }

    public Type(String primaryType, Object value)
    {
        this.primaryType = primaryType;
        this.value = value;
    }

    @Override
    public String toString()
    {
        String s;
        s = primaryType.toString();
        if (typeParameters.size() > 0)
        {
            s += "<" + typeParameters.get(0).toString() + ">";
        }
        if(this.value != null)
            return "(" + s + ") " + this.value.toString();
        else
            return s;
    }

    public static boolean isBooleanOperator(String str)
    {
        return BooleanOperator.contains(str);
    }
}
