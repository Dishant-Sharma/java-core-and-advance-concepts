import Helper.V32SharedResourceReadWriteLock;
import Helper.V32SharedResourceReentrantLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class V32ReadWriteLock {
    public static void main(String[] args) {

        V32SharedResourceReadWriteLock resource = new V32SharedResourceReadWriteLock();
        ReadWriteLock lock = new ReentrantReadWriteLock(); // ReadWriteLock is an interface and ReentrantReadWriteLock implements it.
        Thread t1 = new Thread(() -> {
            resource.producer(lock); // putting a shared lock
        });

        Thread t2 = new Thread(() -> {
            resource.producer(lock); // t2 will be allowed to put a shared lock because t1 has also put only a shared lock
        });

        V32SharedResourceReadWriteLock resource2 = new V32SharedResourceReadWriteLock();
        Thread t3 = new Thread(() -> {
            resource2.consume(lock); // t3 is trying to put a write lock using the same lock object so once t1 and t2 will release the shared lock then only exclusive lock will be acquired
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
