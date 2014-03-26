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
            List<String> lines = new ArrayList<String>();
            String str;

            Pattern ptrn = Pattern.compile("(\\w+).([a-zA-Z0-9_]+)(\\(\\)) > (\\w+)");

            while(sc.hasNextLine()){
                str = sc.nextLine();
                Matcher mtchr = ptrn.matcher(str);

                if(mtchr.matches())
                {

                    Type objType = String2Type(mtchr.group(1));
                    String methodName = mtchr.group(2);
                    Type returnType = String2Type(mtchr.group(4));

                    Type symbol = new Type(Type.TypeEnum.Function, new ArrayList<Type>(), returnType);
                    scope.addSymbol(methodName, symbol);
                    System.out.println(objType + " - " + methodName + " returns " + returnType);
                }
                else
                    System.out.println("No matches");
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

        //TODO: Benytte java 1.7 i stedet, og have string switches?

        if(str.equals("String"))
            returnType = new Type(Type.TypeEnum.String);
        else if(str.equals("Integer"))
            returnType = new Type(Type.TypeEnum.Integer);
        else
            returnType = new Type(Type.TypeEnum.Error);

        return returnType;
    }
}
