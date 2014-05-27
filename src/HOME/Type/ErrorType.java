package HOME.Type;

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
