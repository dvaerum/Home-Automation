package HOME;
import java.util.*;

/**
 * Created by Kentora on 20-03-14.
 */
public class ForkReturnStack{
    private Deque<ForkReturnCheck> stack = new ArrayDeque<ForkReturnCheck>();
    public void newStack(){
        stack.push(new ForkReturnCheck());
    }

    public void addFork(){
        stack.peek().addFork();
    }

    public int getReturns() {
        return stack.peek().getReturn();
    }

    public void addReturn(){
        stack.peek().addReturn();
    }

    public boolean closed(){
        return stack.peek().closed();
    }

    public void dispose(){
        stack.pop();
    }
}
