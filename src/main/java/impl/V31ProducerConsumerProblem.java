import Helper.V31SharedResource;

public class V31ProducerConsumerProblem {
    public static void main(String[] args) {
        V31SharedResource sharedBuffer = new V31SharedResource(3);

        // creating producer thread using Lambda expression
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedBuffer.produce(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // creating consumer thread using lambda expression
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++){
                    sharedBuffer.consume();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
