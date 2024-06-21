import Helper.V31SharedResourceDeadLock;

public class V31DeadLockSuspendedMethod {
    public static void main(String[] args) {
        V31SharedResourceDeadLock resource = new V31SharedResourceDeadLock();
        System.out.println("Main thread started");

        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 calling produce method.");
            resource.produce();
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //handle
            }
            System.out.println("Thread2 calling produce method");
            resource.produce();
        });

        t1.start();
        t2.start();
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            //handle
        }
        System.out.println("Thread1 is suspended");
        t1.suspend();
//        try{
//            Thread.sleep(3000);
//        }catch (Exception e){
//            //handle
//        }
//        t1.resume(); just see how resume() works once you see the deadlock condition
        System.out.println("Main thread is finishing it's work");

    }
}
