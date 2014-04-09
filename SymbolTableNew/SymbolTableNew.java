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

    public void openScope()
    {
        variables.openScope();
    }
    public void closeScope()
    {
        variables.closeScope();
    }
}