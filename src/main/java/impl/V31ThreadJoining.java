import Helper.V31SharedResourceDeadLock;

public class V31ThreadJoining {
    public static void main(String[] args) {
        /* General thread scenario
        V31SharedResourceDeadLock resource = new V31SharedResourceDeadLock();
        System.out.println("Main thread started");

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method.");
            resource.produce();
        });
        t1.start();
        System.out.println("Main thread is finishing it's work"); // run till here to see the general flow

         */

        /**
         *  Thread with join()
         */

        V31SharedResourceDeadLock resource = new V31SharedResourceDeadLock();
        System.out.println("Main thread started");

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method.");
            resource.produce();
        });
        t1.start();
        try {
            System.out.println("Main thread is waiting for thread1 to finish.");
            t1.join();
            // similarly, we can do t2.join();
            // t3.join()
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Main thread is finishing it's work");

        /**
         *  Thread Priority
         */
//        Thread thread1 = new Thread(() -> {
//            System.out.println("Thread1 calling produce method.");
//            resource.produce();
//        });
//        thread1.setPriority(Thread.MIN_PRIORITY);
//        thread1.setPriority(1);
//        thread1.setPriority(Thread.NORM_PRIORITY);
//        thread1.setPriority(Thread.MAX_PRIORITY);
    }
}
