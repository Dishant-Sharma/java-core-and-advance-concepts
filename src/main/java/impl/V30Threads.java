import Helper.V30ConsumeTask;
import Helper.V30ProduceTask;
import Helper.V30SharedResource;

public class V30Threads {
    public static void main(String[] args) {
        System.out.println("Main method start ");
        V30SharedResource sharedResource = new V30SharedResource();

        // producer thread
        Thread producerThread = new Thread(new V30ProduceTask(sharedResource));
        // consumer thread
        Thread consumerThread = new Thread(new V30ConsumeTask(sharedResource));

        // had we used Lambda expression instead of implementing runnable interface we could have defined consumerThread as
                   /** Thread consumerThread = new Thread(() -> {
                        System.out.println("Consumer Thread: " + Thread.currentThread().getName());
                        sharedResource.consumeItem();
                    }); */

        // thread is in "Runnable state"
        producerThread.start();
        consumerThread.start();
        System.out.println("Main method ends ");
    }
}
