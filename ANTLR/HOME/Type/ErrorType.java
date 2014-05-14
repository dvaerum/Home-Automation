package HOME.Type;

/**
 * Created by Frederik on 09-04-2014.
 */
public class ErrorType extends Type
{
    public String message;
    public boolean isPrinted;

    public ErrorType(String message, boolean isPrinted)
    {
        this.name = "Error";
        this.message = message;
        this.isPrinted = isPrinted;
    }

    @Override
    public String toString() {
        return message;
    }
}
