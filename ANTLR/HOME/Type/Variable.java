package HOME.Type;

/**
 * Created by Frederik on 09-04-2014.
 */
public class Variable
{
    public String name;
    public Type type;
    public int location;

    private void setVals(String name, Type type, int location){
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public Variable(String name, Type type, int location)
    {
        setVals(name, type, location);
    }

    public Variable(String name, Type type)
    {
        setVals(name, type, 0);
    }
}
