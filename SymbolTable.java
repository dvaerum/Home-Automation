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

    public Boolean addSymbol(String symbol, String type)
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

    public Boolean addSymbolMethod(String symbol, Type type)
    {
        return addSymbol(symbol + "#" + type.classType.toString(), type);
    }

    public Boolean addSymbolFunction(String symbol, Type type)
    {
        return addSymbol(symbol + "#function", type);
    }

    public Boolean addSymbolClass(String symbol, Type type)
    {
        return addSymbol(symbol + "#class", type);
    }

    public Boolean symbolExists(String symbol)
    {
        if (table.containsKey(symbol))
        {
            // Already declared
            return true;
        }
        return false;
    }

    public Boolean symbolExists(String symbol, Type type)
    {
        return symbolExists(symbol + "#" + type.classType.toString());
    }

    public Boolean symbolExistsFunction(String symbol)
    {
        return symbolExists(symbol + "#function");
    }

    public Boolean symbolExistsClass(String symbol)
    {
        return symbolExists(symbol + "#class");
    }


    public SymbolInfo getSymbol(String symbol)
    {
        return table.get(symbol);
    }

    public SymbolInfo getSymbol(String symbol, Type type)
    {
        return table.get(symbol + "#" + type.classType.toString());
    }

    public SymbolInfo getSymbolFunction(String symbol)
    {
        return table.get(symbol + "#function");
    }

    public SymbolInfo getSymbolClass(String symbol) {
        return table.get(symbol + "#class");
    }


}
