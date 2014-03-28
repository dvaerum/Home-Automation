import java.util.*;

/**
 * Created by Frederik on 13-03-14.
 */
public class SymbolTable
{
    //ArrayList<HashMap<String, Object>> table;
    //HashMap<String, ArrayList<Object>> table;
    //HashMap<String, Object> table;
    HashMap<String, SymbolInfo> table = new HashMap<String, SymbolInfo>();
    int currentScope = 0;

    public void openScope()
    {
        currentScope++;
        System.out.println("Opening scope: " + currentScope);
    }

    public void closeScope()
    {
        if (currentScope <= 0)
            throw new RuntimeException("Closing nonexistant scope");
        List<String> keysToRemove = new ArrayList<String>();
        for(String key : table.keySet())
        {
            SymbolInfo info = table.get(key);
            if (info.depth == currentScope)
            {
                keysToRemove.add(key);
            }
        }

        for(String key : keysToRemove)
        {
            table.remove(key);
        }
        System.out.println("Closing scope: " + currentScope);
        currentScope--;
    }

    public Boolean addSymbol(String symbol, Type.TypeEnum type)
    {
        return addSymbol(symbol, new Type(type));
    }

    public Boolean addSymbol(String symbol, Type type)
    {
        if (table.containsKey(symbol))
        {
            return false;
        }
        else
        {
            table.put(symbol, new SymbolInfo(symbol, type, currentScope));
        }
        return true;
    }

<<<<<<< HEAD
    public Boolean addSymbolMethod(String symbol, Type type)
    {
        return addSymbol(symbol + type.objectType.toString(), type);
    }


=======
>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f
    public Boolean symbolExists(String symbol)
    {
        if (table.containsKey(symbol))
        {
            // Already declared
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    public Boolean symbolExists(String symbol, Type.TypeEnum objectType)
    {
        return symbolExists(symbol + objectType.toString());
    }

=======
>>>>>>> 0e7e74e3a376e1aafe7243f066f2c8d782a9863f
    public SymbolInfo getSymbol(String symbol)
    {
        return table.get(symbol);
    }

    public SymbolInfo getSymbol(String symbol, Type.TypeEnum objectType)
    {
        return table.get(symbol + objectType.toString());
    }
}
