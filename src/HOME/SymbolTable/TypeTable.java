package HOME.SymbolTable;

import HOME.Type.*;

import java.lang.Boolean;import java.lang.String;
import java.util.HashMap;

public class TypeTable
{
    private HashMap<String, Type> table = new HashMap<String, Type>();

    // Returns false if the symbol already exists in the current scope.
    public Boolean addSymbol(String symbol, Type type) {

        if (table.containsKey(symbol))
        {
            return false;
            // Type already exists
        }
        else
        {
            table.put(symbol, type);
        }
        return true;
    }

    public Boolean symbolExists(String symbol)
    {
        //Returns true or false for whether symbol exists.
        return table.containsKey(symbol);
    }

    public Type getSymbol(String symbol)
    {
        //Returns the symbol
        return table.get(symbol);
    }
}