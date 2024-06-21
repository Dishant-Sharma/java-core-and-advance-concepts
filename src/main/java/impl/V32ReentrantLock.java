import Helper.V32SharedResourceReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class V32ReentrantLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        V32SharedResourceReentrantLock resource1 = new V32SharedResourceReentrantLock();
        Thread t1 = new Thread(() -> {
            resource1.producer(lock);
        });
        V32SharedResourceReentrantLock resource2 = new V32SharedResourceReentrantLock();
        Thread t2 = new Thread(() -> {
            resource2.producer(lock);
        });

        t1.start();
        t2.start();

        // we are using different objects but at a time only one thread is getting inside the critical section
    }
}
