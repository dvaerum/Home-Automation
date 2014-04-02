import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by Kentora on 20-03-14.
 */
public class ForkReturnStack{
    private Deque<ForkReturnCheck> stack = new ArrayDeque<ForkReturnCheck>();
    public void newStack(){
        stack.add(new ForkReturnCheck());
    }

    public void addFork(){
        stack.peekLast().addFork();
    }

    public void addReturn(){
        stack.peekLast().addReturn();
    }

    public boolean closed(){
        return stack.peekLast().closed();
    }

    public void dispose(){
        stack.removeLast();
    }
}
