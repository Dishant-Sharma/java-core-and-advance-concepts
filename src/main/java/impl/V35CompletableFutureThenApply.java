import java.util.concurrent.*;

public class V35CompletableFutureThenApply {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                    1,
                    1,
                    1,
                    TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(10),
                    Executors.defaultThreadFactory(),
                    new ThreadPoolExecutor.AbortPolicy()
            );

            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                // this is the task which need to be completed by thread
                return "Concept and ";
            }, poolExecutor).thenApply((String val) -> {
                // functionality which can work on the result of previous async task
                return val + "Coding";
            });
            System.out.println(asyncTask1.get());
        } catch (Exception e) {

        }
    }
}
