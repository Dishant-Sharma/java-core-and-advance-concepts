import java.util.concurrent.*;

public class V35RunnableVsCallable {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        Future<?> futureObj = executor.submit(() -> System.out.println("This submit is runnable")); // does not return anything
        Future<Integer> futureObj1 = executor.submit(() -> {
            System.out.println("This submit is callable");
            return 45;
        }); // returns 45

    }
}
