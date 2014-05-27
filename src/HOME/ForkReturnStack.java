package HOME;
import java.util.*;

public class ForkReturnStack{
    private Deque<ForkReturnCheck> stack = new ArrayDeque<>();

    public void newStack(){
        //Add a new forkreturncheck to the stack
        stack.push(new ForkReturnCheck());
    }

    public void addFork(){
        //Add a fork to the top forkreturncheck
        stack.peek().addFork();
    }

    public int getReturns() {
        //Get the number of returns of the top forkreturncheck
        return stack.peek().getReturn();
    }

    public void addReturn(){
        //Add a return to the top forkreturncheck
        stack.peek().addReturn();
    }

    public boolean closed(){
        //Check if the top forkreturncheck is closed
        return stack.peek().closed();
    }

    public void dispose(){
        //Remove the top forkreturncheck
        stack.pop();
    }
}