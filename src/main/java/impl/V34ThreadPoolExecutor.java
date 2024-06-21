import java.util.concurrent.*;

public class V34ThreadPoolExecutor {
    /**
     *
     *  Use case 1
     */
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), //  Executors.defaultThreadFactory() there are some in built factory methods that can be used
                new CustomRejectHandler() //  new ThreadPoolExecutor.AbortPolicy() // in built handlers
        );

        for (int i = 1; i <= 4; i++) { // try with values i <= 5, i <= 7
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Task processed by: " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        th.setDaemon(false);
        return th;
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}
