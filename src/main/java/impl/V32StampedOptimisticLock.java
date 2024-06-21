import Helper.V32SharedResourceStampedOptimisticLock;
import Helper.V32SharedResourceStampedReadWriteLock;

public class V32StampedOptimisticLock {
    public static void main(String[] args) {

        V32SharedResourceStampedOptimisticLock resource = new V32SharedResourceStampedOptimisticLock();

        Thread t1 = new Thread(() -> {
            resource.producer(); // putting a shared lock
        });


        Thread t2 = new Thread(() -> {
            resource.consume(); // t2 is trying to put a write lock
        });

        t1.start();
        t2.start();
    }
}
