package Helper;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class V32SharedResourceStampedReadWriteLock {
    /**
     *  used in V32StampedReadWriteLock
     */

    boolean isAvailable = false;
    StampedLock lock = new StampedLock(); // you can also pass it as a parameter in the method producer and consume

    public void producer(){ // producer method without synchronized because we are implementing custom lock
        long stamp = lock.readLock(); // here readLock() returns one stamp that you have to pass while unlocking,
        // we get this stamp because StampedLock also has optimistic locking functionality in which the state is shared  while reading that has to be stored and is used in unlocking just like row version in our example
        // here this stamp won't be useful because we are implementing readwrite lock functionality of StampedLock
        try {
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlockRead(stamp); // lock should be released eventually even if there are errors that's why finally block
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume(){ // producer method without synchronized because we are implementing custom lock
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlockWrite(stamp); // lock should be released eventually even if there are errors that's why finally block
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
        }
    }
}
