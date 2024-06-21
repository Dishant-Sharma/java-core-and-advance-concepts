import Helper.V32SharedResourceSemaphore;

public class V32SemaphoreLock {
    public static void main(String[] args) {

        V32SharedResourceSemaphore resource = new V32SharedResourceSemaphore();

        Thread t1 = new Thread(() -> {
            resource.producer();
        });

        Thread t2 = new Thread(() -> {
            resource.producer();
        });

        Thread t3 = new Thread(() -> {
            resource.producer();
        });

        Thread t4 = new Thread(() -> {
            resource.producer();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
