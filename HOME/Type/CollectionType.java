package HOME.Type;

import HOME.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Frederik on 14-04-14.
 */
public class CollectionType extends Type
{
    public Type primaryType;
    public Type innerType;

    public CollectionType(String name, Type primaryType, Type innerType)
    {
        this.name = name;
        this.primaryType = primaryType;
        this.innerType = innerType;

        // Copy methods
        for(Function meth : primaryType.methods)
        {
            Function newMeth = replaceGenericFunction(meth);
            this.methods.add(newMeth);
        }

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

    // Returns a copy of the specified List<Type> where all elements of type 'generic' have been replaced with innerType
//    private List<Type> replaceGenericList(List<Type> list)
//    {
//        List<Type> newList = new ArrayList<>(list);
//        for(Type t : newList)
//        {
//            if (t.equals(Main.generic))
//            {
//                t = this.innerType;
//            }
//        }
//        return newList;
//    }

    // Searches recursively through the inner Types of a Type and replaces all 'generic'-Types with replacementType;
//    private void replaceGeneric(Type replacementType)
//    {
//        if (innerType.equals(Main.generic))
//        {
//            innerType = replacementType;
//        }
//        else if(innerType instanceof CollectionType)
//        {
//            ((CollectionType)innerType).replaceGeneric(replacementType);
//        }
//    }
//
//    private Type replaceGenericType(Type t)
//    {
//        if (t.equals(Main.generic))
//            return innerType;
//        return t;
//    }

//    private List<Type> replaceGenericList(List<Type> methodParms)
//    {
//        for(Type t : methodParms)
//        {
//            t = replaceGeneric(t);
//        }
//    }
//
//    private Type replaceGeneric(Type t)
//    {
//        if(t.equals(Main.generic))
//        {
//            return this.innerType;
//        }
//        else if(t instanceof CollectionType)
//        {
//            return replaceGeneric(t);
//        }
//        return t;
//    }

}

