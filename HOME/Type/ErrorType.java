package HOME.Type;

/**
 * Created by Frederik on 09-04-2014.
 */
public class ErrorType extends Type
{
    public String message;

    public ErrorType(String message)
    {
        this.name = "Error";
        this.message = message;
    }
}
