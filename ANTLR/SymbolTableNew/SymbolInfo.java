package SymbolTableNew; /**
* Created by Frederik on 13-03-14.
*/
import HOME.Type.*;

public class SymbolInfo
{
    public String name;
    public Type type;
    int depth;


    public SymbolInfo() {
    }

    public SymbolInfo(String name, Type type, int depth)
    {
        this.name = name;
        this.type = type;
        this.depth = depth;
    }


}
