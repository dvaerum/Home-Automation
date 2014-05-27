package HOME.SymbolTable; /**
 * Created by Frederik on 09-04-2014.
 */

import HOME.Type.*;

import java.lang.Boolean;import java.lang.String;
import java.util.HashMap;

/**
 * Created by Frederik on 13-03-14.
 */
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
        return table.containsKey(symbol);
    }

    public Type getSymbol(String symbol)
    {
        return table.get(symbol);
    }
}