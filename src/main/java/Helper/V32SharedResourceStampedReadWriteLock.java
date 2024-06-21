package Helper;

import java.util.concurrent.locks.ReadWriteLock;

public class V32SharedResourceReadWriteLock {
    /**
     *  used in V32ReadWriteLock
     */

    boolean isAvailable = false;

    public void producer(ReadWriteLock lock){ // producer method without synchronized because we are implementing custom lock
        try {
            lock.readLock().lock(); // acquire the lock
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            Thread.sleep(8000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock(); // lock should be released eventually even if there are errors that's why finally block
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock){ // producer method without synchronized because we are implementing custom lock
        try {
            lock.writeLock().lock(); // acquire the lock
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(8000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock(); // lock should be released eventually even if there are errors that's why finally block
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
        }
    }
}
