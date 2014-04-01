import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jacob on 26-03-14.
 */
public class FileReader {
    SymbolTable scope = Main.scope;
    public void loadMethods()
    {
        try {
            Scanner sc = new Scanner(new File("Methods"));
            String str;

            Pattern ptrn = Pattern.compile("^([A-Z][a-z]+).([a-zA-Z0-9_]+)\\(((?:\\w(?:, )?)*)\\) > (\\w+)");

            while(sc.hasNextLine()){
                str = sc.nextLine();
                Matcher mtchr = ptrn.matcher(str);

                if(mtchr.matches())
                {
                    Type objType = String2Type(mtchr.group(1));
                    String methodName = mtchr.group(2);
                    String[] args = mtchr.group(3).replaceAll("\\s", "").split(",");
                    ArrayList<Type> params = new ArrayList<>();
                    Type returnType = String2Type(mtchr.group(4));

                    if(!args[0].equals(""))
                    {
                        for(String strParam : args)
                        {
                            params.add(String2Type(strParam));
                        }
                    }

                    Type symbol = new Type(Type.TypeEnum.Method, objType, params, returnType);
                    scope.addSymbolMethod(methodName, symbol);
//                    System.out.println(objType + " - " + methodName + " returns " + returnType);
                }
//                else
//                    System.out.println("No matches");
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.initCause(e.getCause()));

        }
    }

    public Type String2Type(String str)
    {
        Type returnType;

        //TODO: Add more datatypes

        switch (str)
        {
            case "Boolean":
                returnType = new Type(Type.TypeEnum.Boolean);
                break;
            case "Integer":
                returnType = new Type(Type.TypeEnum.Integer);
                break;
            case "Decimal":
                returnType = new Type(Type.TypeEnum.Decimal);
                break;
            case "String":
                returnType = new Type(Type.TypeEnum.String);
                break;
            default:
                returnType = new Type(Type.TypeEnum.Error);
       }

        return returnType;
    }
}
