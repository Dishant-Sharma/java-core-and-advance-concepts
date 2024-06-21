package Helper;

import java.util.concurrent.locks.ReentrantLock;

public class V32SharedResourceReentrantLock {
    /**
     *  used in V32ReentrantLock
     */

    boolean isAvailable = false;

    public void producer(ReentrantLock lock){ // producer method without synchronized because we are implementing custom lock
        try {
            lock.lock(); // acquire the lock
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock(); // lock should be released eventually even if there are errors that's why finally block
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }
}
