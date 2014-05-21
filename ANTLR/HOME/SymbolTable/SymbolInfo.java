package HOME.SymbolTable;

import HOME.Main;
import HOME.Type.*;
import HOME.CodeGene.ByteCodeVisitor.*;

public class SymbolInfo
{
    public Variable var;
    public int depth;


    public SymbolInfo()
    {
    }

    public SymbolInfo(String name, Type type, int depth)
    {
        this.var = new Variable(name, type);
        this.depth = depth;
    }

    public SymbolInfo(String name, Type type, int location, int depth)
    {
        this.var = new Variable(name, type, location);
        this.depth = depth;
    }

    public void store(Statements stmts)
    {
        if (depth == 0)
        {
            var.type.invokeToObject(stmts);
            stmts.add("aload_0");
            stmts.add("swap");
            stmts.add("putfield HOME/" + var.name + " " + var.type.getObjectByteCode());
        }
        else
        {
            storeOptimaze(stmts);
        }
    }

    private void storeOptimaze(Statements stmts)
    {
        String typePrefix = "";

        if (var.type.equals(Main.integer))
        {
            typePrefix = "i";
        }
        else if (var.type.equals(Main.decimal))
        {
            typePrefix = "d";
        }
        else if (var.type.equals(Main.bool))
        {
            typePrefix = "i";
        }
        else
        {
            typePrefix = "a";
        }
        stmts.add(typePrefix + "store " + var.location);
    }

    public void load(Statements stmts)
    {
        if (depth == 0)
        {
            stmts.add("aload_0");
            stmts.add("getfield HOME/" + var.name + " " + var.type.getObjectByteCode());
            var.type.invokeToSimpleType(stmts);
        }
        else
        {
            loadOptimaze(stmts);
        }
    }

    private void loadOptimaze(Statements stmts)
    {
        String typePrefix = "";

        if (var.type.equals(Main.integer))
        {
            typePrefix = "i";
        }
        else if (var.type.equals(Main.decimal))
        {
            typePrefix = "d";
        }
        else if (var.type.equals(Main.bool))
        {
            typePrefix = "i";
        }
        else
        {
            typePrefix = "a";
        }
        stmts.add(typePrefix + "load " + var.location);
    }
}
