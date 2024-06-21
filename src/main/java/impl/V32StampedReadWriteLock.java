import Helper.V32SharedResourceReadWriteLock;
import Helper.V32SharedResourceStampedReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class V32StampedReadWriteLock {
    public static void main(String[] args) {

        V32SharedResourceStampedReadWriteLock resource = new V32SharedResourceStampedReadWriteLock();

        Thread t1 = new Thread(() -> {
            resource.producer(); // putting a shared lock
        });

        Thread t2 = new Thread(() -> {
            resource.producer(); // t2 will be allowed to put a shared lock because t1 has also put only a shared lock
        });

        Thread t3 = new Thread(() -> {
            resource.consume(); // t3 is trying to put a write lock using the same lock object so once t1 and t2 will release the shared lock then only exclusive lock will be acquired
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
