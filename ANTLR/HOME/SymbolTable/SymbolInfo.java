package HOME.SymbolTable;

import HOME.Main;
import HOME.Type.*;
import HOME.CodeGene.ByteCodeVisitor.*;
import org.antlr.v4.runtime.ParserRuleContext;

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

    public void store(ParserRuleContext ctx, Statements stmts)
    {
        if (depth == 0)
        {
            var.type.invokeToObject(ctx, stmts);
            stmts.add("aload_0", ctx);
            stmts.add("swap", ctx);
            stmts.add("putfield HOME/" + var.name + " " + var.type.getObjectByteCode(), ctx);
        }
        else
        {
            storeOptimaze(ctx, stmts);
        }
    }

    private void storeOptimaze(ParserRuleContext ctx, Statements stmts)
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
        stmts.add(typePrefix + "store " + var.location, ctx);
    }

    public void load(ParserRuleContext ctx, Statements stmts)
    {
        if (depth == 0)
        {
            stmts.add("aload_0", ctx);
            stmts.add("getfield HOME/" + var.name + " " + var.type.getObjectByteCode(), ctx);
            var.type.invokeToSimpleType(ctx, stmts);
        }
        else
        {
            loadOptimaze(ctx, stmts);
        }
    }

    private void loadOptimaze(ParserRuleContext ctx, Statements stmts)
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
        stmts.add(typePrefix + "load " + var.location, ctx);
    }
}
