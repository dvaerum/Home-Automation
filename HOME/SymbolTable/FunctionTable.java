package HOME.SymbolTable; /**
 * Created by Frederik on 09-04-2014.
 */
import HOME.Main;
import HOME.Type.*;

import java.lang.Boolean;
import java.lang.String;
import java.util.HashMap;
/**
 * Created by Frederik on 13-03-14.
 */
public class FunctionTable
{
    private HashMap<String, Function> table = new HashMap<String, Function>();

    // Returns false if the symbol already exists in the current scope.
    public Boolean addSymbol(String symbol, Function func) {

        if (table.containsKey(symbol))
        {
            return false;
            // Type already exists
        }
        else
        {
            table.put(symbol, func);
        }
        return true;
    }

    public Boolean symbolExists(String symbol)
    {
        return table.containsKey(symbol);
    }

    public Function getSymbol(String symbol)
    {
        return table.get(symbol);
    }

    public boolean isFunctionConstructor(String symbol)
    {
        return Main.symbolTable.types.symbolExists(symbol);
    }
}