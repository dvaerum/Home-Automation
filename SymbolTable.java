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

    public void OpenScope()
    {
        currentScope++;
    }

    public void CloseScope()
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

        currentScope--;
    }

    public Boolean AddSymbol(String symbol, Type.TypeEnum type)
    {
        return AddSymbol(symbol, new Type(type));
    }

    public Boolean AddSymbol(String symbol, Type type)
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

    public Boolean SymbolExists(String symbol)
    {
        if (table.containsKey(symbol))
        {
            // Already declared
            return true;
        }
        return false;
    }

    public SymbolInfo GetSymbol(String symbol)
    {
        return table.get(symbol);
    }
}
