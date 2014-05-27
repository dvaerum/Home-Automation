package HOME.SymbolTable;

public class SymbolTable
{
    public FunctionTable functions = new FunctionTable();
    public TypeTable types = new TypeTable();
    public VariableTable variables = new VariableTable();
    private Integer lineNumber = 1;
    private Integer labelNumber = 0;

    public String newLabel() {
        //Returns new label for jumps.
        labelNumber++;
        return "Label" + labelNumber;
    }

    public String getLabel() {
        //Gets the current label
        return "Label" + labelNumber + ":";
    }

    public void newLine() {
        //Increments the line number
        lineNumber++;
    }

    public String getLineNumberText() {
        //Gives the line of the code
        return ".line " + lineNumber;
    }

    public void resetVariableTable(){
        //Resets the entire variable table.
        variables= new VariableTable();
    }

    public void openScope()
    {
        variables.openScope();
    }
    public void closeScope()
    {
        variables.closeScope();
    }
}