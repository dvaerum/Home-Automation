import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jacob on 14-03-14.
 */
public class Type {
    public enum TypeEnum {
<<<<<<< HEAD
        Integer, Decimal, Boolean, String, Integer2Decimal, Function, Error, Nothing, List, Dictionary, Method
=======
        Integer, Decimal, Boolean, String, Integer2Decimal, Function, Error, Nothing, List, Dictionary
>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f
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

    final TypeEnum typeEnum;
    Object value;

    // Integer i = 2
    // function test(Integer i, Boolean b) returns Nothing
    // Dictionary<Integer> ints = {{"Test",2},{"Three",3}}


    public boolean equals(TypeEnum t)
    {
        return this.typeEnum == t;
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
        if (typeEnum != type.typeEnum) return false;
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
                if(methodParam.equals(Type.TypeEnum.Decimal) && inputParam.equals(Type.TypeEnum.Integer))
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
        result = 31 * result + (typeEnum != null ? typeEnum.hashCode() : 0);
        return result;
    }

    public Type(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
        this.value = null;
    }

    public Type(TypeEnum typeEnum, ArrayList<Type> parameters, Type returnTypeEnum) {
        this.typeEnum = typeEnum;
        this.parameters = parameters;
        this.returnTypeEnum = returnTypeEnum;
    }

    public Type(TypeEnum typeEnum, Type objectType, ArrayList<Type> parameters, Type returnTypeEnum) {
        this.typeEnum = typeEnum;
        this.objectType = objectType;
        this.parameters = parameters;
        this.returnTypeEnum = returnTypeEnum;
    }

    public Type(TypeEnum typeEnum, ArrayList<Type> typeParameters) {
        this.typeEnum = typeEnum;
        this.typeParameters = typeParameters;
    }

    public Type(TypeEnum typeEnum, Object value)
    {
        this.typeEnum = typeEnum;
        this.value = value;
    }

    @Override
    public String toString()
    {
        if(this.value != null)
            return "(" + this.typeEnum.toString() + ") " + this.value.toString();
        else
            return typeEnum.toString();
    }

    public static boolean isBooleanOperator(String str)
    {
        return BooleanOperator.contains(str);
    }
}
