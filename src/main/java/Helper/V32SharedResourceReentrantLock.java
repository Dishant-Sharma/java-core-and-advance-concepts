package Helper;

import java.util.concurrent.locks.ReentrantLock;

public class V32SharedResourceCustomLocks {


    boolean isAvailable = false;
    ReentrantLock lock = new ReentrantLock();

    public void producer(){
        try {
            lock.lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }
}
