import java.util.concurrent.*;

public class V35FutureInterfaceMethod {
    public static void main(String[] args) {
        // Main thread
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(  // Thread t1 will be assigned task here
                1,
                1,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Future<?> futureObj = poolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("this is the main task which thread will execute");
            } catch (Exception e) {

            }
        });

        System.out.println("is Done: " + futureObj.isDone());
        try {
            futureObj.get(2, TimeUnit.SECONDS);
        }catch (TimeoutException e){
            System.out.println("TimeoutException happened");
        }catch (Exception e){

        }

        try {
            futureObj.get(); // waits indefinitely . main will go to next statement only after task 1 is completed
        }catch (Exception e){

        }
        System.out.println("is Done: " + futureObj.isDone());
        System.out.println("is Cancelled : " + futureObj.isCancelled());
    }
}
