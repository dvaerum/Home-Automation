package HOME;

class ForkReturnCheck {
    private int forks = 0;
    private int returns = 0;

    public void addFork(){
        //Add a fork
        forks++;
    }

    public void addReturn(){
        //Add a return
        returns++;
    }

    public int getReturn(){
        //Return the number of returns
        return returns;
    }

    public boolean closed(){
        //Return true if the number of forks equals the number of returns, otherwise return false
        return forks == returns;
    }
}