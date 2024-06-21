import Helper.V32SharedResourceThreadCondition;

public class V32ThreadCondition {
    public static void main(String[] args) {

        V32SharedResourceThreadCondition resource = new V32SharedResourceThreadCondition();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                resource.producer();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                resource.consume();
            }
        });

        t1.start();
        t2.start();
    }
}
