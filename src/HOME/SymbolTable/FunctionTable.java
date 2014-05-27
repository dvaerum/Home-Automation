package HOME.SymbolTable;

import HOME.Main;
import HOME.Type.*;

import java.lang.Boolean;
import java.lang.String;
import java.util.HashMap;

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
        //Returns true or false for whether symbol exists.
        return table.containsKey(symbol);
    }

    public Function getSymbol(String symbol)
    {
        //Returns the symbol
        return table.get(symbol);
    }

    public boolean isFunctionConstructor(String symbol)
    {
        //Checks whether function is constructor.
        return Main.symbolTable.types.symbolExists(symbol);
    }
}