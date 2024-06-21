import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class V35RunnableAndCallableUseCases {
    public static void main(String[] args) {

        /**
         *  Three flavours of submit()
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        /**
         * USE CASE 1: submit(Runnable)
         */
        Future<?> futureObject1 = executor.submit(() -> {
            System.out.println("Task 1 with Runnable");
        });

        try {
            Object object = futureObject1.get(); // waiting for runnable task to get completed
            System.out.println(object == null);
        } catch (Exception e) {

        }


        /**
         *  USE CASE 2: submit(Runnable , T result)
         *  there is a lot of workaround in this
         *  whatever object we pass here in second parameter it will return the same
         *  we can play around with this object
         *  it is a little unclear but not that important
         */
        List<Integer> output = new ArrayList<>(); // Here T is the generic which we will set up as a list
        Future<List<Integer>> futureObject2 = executor.submit(() -> {
            output.add(100);
            System.out.println("Task 2 with Runnable and return object");
        }, output);

        try {
            List<Integer> outputFromFutureObject2 = futureObject2.get();
            System.out.println(outputFromFutureObject2.get(0));
        }catch (Exception e){

        }

        /**
         * USE CASE 3: runnable(Callable<T> task)
         * It is a cleaner way of use case 2 without workaround
         */
        Future<List<Integer>> futureObject3 = executor.submit(() -> {
            System.out.println("Task3 with callable");
            List<Integer> listObj = new ArrayList<>();
            listObj.add(200);
            return listObj;
        });

        try {
            List<Integer> outputFromFutureObject3 = futureObject3.get();
            System.out.println(outputFromFutureObject3.get(0));
        } catch (Exception e){

        }
    }
}
