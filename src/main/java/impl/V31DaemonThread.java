import Helper.V31SharedResourceDeadLock;

public class V31DaemonThread {
    public static void main(String[] args) {


        /**
         *   DaemonThread
         */

        V31SharedResourceDeadLock resource = new V31SharedResourceDeadLock();
        System.out.println("Main thread started");

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method.");
            resource.produce();
        });
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main thread is finishing it's work");
    }
}
