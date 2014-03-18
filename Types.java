/**
 * Created by Jacob on 14-03-14.
 */
public class Types {
    public enum Type{
        Integer, Decimal, Boolean, String, None, Integer2Decimal, Function
    }

    final Type type;
    final Object value;

    public Types(Type type)
    {
        this.type = type;
        this.value = null;
    }

    public Types(Type type, Object value)
    {
        this.type = type;
        this.value = value;
    }

    public boolean equals(Type t)
    {
        if(type == t)
            return true;
        else
            return false;
    }

    public boolean equals(Types t)
    {
        if(type == t.type)
            return true;
        else
            return false;
    }

    @Override
    public String toString()
    {
        if(this.value != null)
            return "(" + this.type.toString() + ") " + this.value.toString();
        else
            return type.toString();
    }
}
