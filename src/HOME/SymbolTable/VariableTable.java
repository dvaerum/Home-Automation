package HOME.SymbolTable;

import java.lang.Boolean;import java.lang.RuntimeException;import java.lang.String;import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import HOME.Type.*;

public class VariableTable
{
    private HashMap<String, Deque<SymbolInfo>> table = new HashMap<String, Deque<SymbolInfo>>();
    private int currentScope = 0;

    public void openScope()
    {
        currentScope++;
    }

    public void closeScope()
    {
        if (currentScope <= 0)
            throw new RuntimeException("Closing nonexistent scope");

        //Removes all the variables on this scope. Goes through all the stacks for the variables.
        for (Deque<SymbolInfo> stack : table.values())
        {
            if (stack.peek() != null && stack.peek().depth == currentScope)
            {
                stack.pop();
            }
        }
        currentScope--;
    }

    // Returns false if the symbol already exists in the current scope.
    public Boolean addSymbol(String symbol, Type type) {
        SymbolInfo info = new SymbolInfo(symbol, type, currentScope);
        return addSymbol(symbol, info);
    }

    // Returns false if the symbol already exists in the current scope.
    public Boolean addSymbol(String symbol, Type type, int location) {
        SymbolInfo info = new SymbolInfo(symbol, type, location, currentScope);
        return addSymbol(symbol, info);
    }

    private boolean addSymbol(String symbol, SymbolInfo info){
        Deque<SymbolInfo> stack = addSymbolIfNotExisting(symbol);

        if (stack.peek() != null && stack.peek().depth == currentScope)
        {
            // Symbol already exists in current scope;
            return false;
        }
        stack.push(info);
        return true;
    }

    private Deque<SymbolInfo> addSymbolIfNotExisting(String symbol){
        Deque<SymbolInfo> stack;

        //If symbol already exists, return it.
        if (table.containsKey(symbol))
            return table.get(symbol);
        else {
            //Otherwise, make new stack for the symbol.
            stack = new ArrayDeque<SymbolInfo>();
            table.put(symbol, stack);
            return stack;
        }
    }

    public SymbolInfo addAndGetSymbol(String symbol, Type type, int location){
        SymbolInfo info = new SymbolInfo(symbol, type, location, currentScope);

        //Adds to stack
        Deque<SymbolInfo> stack = addSymbolIfNotExisting(symbol);
        stack.push(info);

        //Return same symbol(which is now on top of stack)
        return stack.peek();
    }

    public Type getType(String symbol) {
        return getSymbol(symbol).var.type;
    }

    public Boolean symbolExists(String symbol)
    {
        //Checks whether the symbol exists.
        Deque<SymbolInfo> stack = table.get(symbol);
        SymbolInfo info;

        if (stack == null)
            return false;
        info = stack.peek();

        if (info == null)
            return false;

        return true;
    }

    public SymbolInfo getSymbol(String symbol)
    {
        Deque<SymbolInfo> stack = table.get(symbol);

        if (stack == null)
            return null;
        return stack.peek();
    }
}