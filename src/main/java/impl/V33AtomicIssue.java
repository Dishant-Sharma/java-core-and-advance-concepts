import Helper.V33SharedResourceAtomicIssue;

public class V33AtomicIssue {
    public static void main(String[] args) {

//        for (int k = 0; k < 70; k++) {
            V33SharedResourceAtomicIssue resource = new V33SharedResourceAtomicIssue();

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
            System.out.println(resource.get()); // output should be 400 but incorrect output comes sometimes because counter() is not atomic because of counter++
//        }
    }
}
