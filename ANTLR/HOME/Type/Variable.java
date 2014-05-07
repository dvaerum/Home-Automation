package HOME.Type;

/**
 * Created by Frederik on 09-04-2014.
 */
public class Variable
{
    public String name;
    public Type type;
    public int location;

    public Variable(String name, Type type)
    {
        this.name = name;
        this.type = type;
    }

    public Variable(String name, Type type, int location)
    {
        this.name = name;
        this.type = type;
        this.location = location;
    }
}
