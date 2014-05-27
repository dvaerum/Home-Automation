package HOME.Type;

import java.util.List;


public class Function
{
    public String name;
    public Type returnType;
    public List<Type> parameters;

    //Constructor for function type
    public Function(String name, Type returnType, List<Type> parameters)
    {
        this.name = name;
        this.returnType = returnType;
        this.parameters = parameters;
    }

    public Function()
    {

    }

}
