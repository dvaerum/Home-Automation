package SymbolTableNew; /**
* Created by Frederik on 13-03-14.
*/
import HOME.Type.*;

public class SymbolInfo
{
    public Variable var;
    int depth;


    public SymbolInfo() {
    }

    public SymbolInfo(String name, Type type, int depth)
    {
        this.var = new Variable(name, type);
        this.depth = depth;
    }


}
