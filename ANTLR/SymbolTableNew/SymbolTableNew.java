package SymbolTableNew; /**
 * Created by Frederik on 09-04-2014.
 */

/**
 * Created by Frederik on 13-03-14.
 */
public class SymbolTableNew
{
    public FunctionTable functions = new FunctionTable();
    public TypeTable types = new TypeTable();
    public VariableTable variables = new VariableTable();
    public Integer lineNumber = 1;
    public Integer labelNumber = 0;

    public String newLabel() {
        labelNumber++;
        return "Label" + labelNumber;
    }

    public String getLabel() {
        return "Label" + labelNumber + ":";
    }

    public void newLine() {
        lineNumber++;
    }

    public String getLineNumber() {
        return ".line " + lineNumber;
    }

    public void resetVariableTable(){
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