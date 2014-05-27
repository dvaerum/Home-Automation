package HOME.Type;

public class Variable
{
    public String name;
    public Type type;
    //Location in memory
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
