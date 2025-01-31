import Helper.V33SharedResourceAtomicIntegerResolution;
import Helper.V33SharedResourceAtomicIssue;

public class V33AtomicIntegerResolution {
    public static void main(String[] args) {

        V33SharedResourceAtomicIntegerResolution resource = new V33SharedResourceAtomicIntegerResolution();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                resource.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resource.get());
    }
}
