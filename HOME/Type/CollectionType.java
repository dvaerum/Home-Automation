package HOME.Type;

import HOME.Main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Frederik on 14-04-14.
 */
public class CollectionType extends Type
{
    public Type primaryType;
    public Type innerType;

    public CollectionType(String name, Type primaryType, Type innerType, String byteCode)
    {
        this.name = name;
        this.primaryType = primaryType;
        this.innerType = innerType;
        this.bytecode = byteCode;

        // Copy methods
        for(Function meth : primaryType.methods)
        {
            Function newMeth = replaceGenericFunction(meth);
            this.methods.add(newMeth);
        }
    }

    public Type getInnermostType()
    {
        if (innerType instanceof CollectionType)
            return ((CollectionType) innerType).getInnermostType();
        return innerType;
    }

    @Override
    public boolean isSubtypeOf(Type otherType)
    {
        if (otherType instanceof CollectionType)
        {
            if (this.innerType.equals(Main.anything))
                return true;
            else if (((CollectionType)otherType).primaryType.equals(primaryType))
            {
                return this.innerType.isSubtypeOf(((CollectionType) otherType).innerType);
            }
        }
        return false;
    }

    // Returns a copy of the specified function where all 'generic'-types have been replaced with innerType
    private Function replaceGenericFunction(Function func)
    {
        Function newFunc = new Function();

        newFunc.parameters = new ArrayList<Type>(func.parameters);//replaceGenericList(func.parameters);
        Collections.replaceAll(newFunc.parameters, Main.generic, innerType);
        newFunc.returnType = func.returnType;

        if(func.returnType.equals(Main.generic))
            newFunc.returnType = innerType;
        newFunc.name = func.name;

        return newFunc;
    }

    public String getObjectByteCode() {
        if (this.primaryType.equals(Main.list)){
            return "Ljava/util/ArrayList;";
        } else if (this.primaryType.equals(Main.dictionary)){
            return "Ljava/util/HashMap;";
        }

        return null;
    }

    //@Override
    public String getClassByteCode() {
        if (this.primaryType.equals(Main.list)){
            return "java/util/ArrayList";
        } else if (this.primaryType.equals(Main.dictionary)){
            return "java/util/HashMap";
        }

        return null;
    }

}

