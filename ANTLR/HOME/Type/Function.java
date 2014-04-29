package HOME.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frederik on 09-04-2014.
 */
public class Function
{
    public String name;
    public Type returnType;
    public List<Type> parameters;

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
