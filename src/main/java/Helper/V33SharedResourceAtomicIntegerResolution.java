package Helper;

public class V33SharedResourceAtomicIssue {
    /**
     *  used in V33AtomicIssue
     */
    int counter;

    public void increment(){
        counter++;
    }
    public int get(){
        return counter;
    }
}
