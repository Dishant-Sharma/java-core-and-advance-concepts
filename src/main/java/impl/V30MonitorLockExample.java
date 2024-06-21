public class V30MonitorLockExample {
    public static void main(String[] args) {
        /**
         *  Monitor Lock
         */
        Helper.V30MonitorLockExample obj = new Helper.V30MonitorLockExample();
        Thread t1 = new Thread(() -> {obj.task1();}); // this is same as creating
                                                      // a runnable implementing class because
                                                      // runnable is a functional interface, and it can be invoked using functional interface
                                                      // {obj.task1();}  is the shortcut and is equivalent to implementing run()


        /*
                            public class MonitorThread1 implements Runnable{
                                V30MonitorLockExample obj;
                                MonitorThread1(V30MonitorLockExample obj){ // Constructor
                                    this.obj = obj;
                                }

                                @Override
                                public void run(){
                                    obj.task1();
                                }

                             }

                             then inside  V30ThreadsAndThreadLifecycle class
                             psvm(String args []){
                                 V30MonitorLockExample obj = new V30MonitorLockExample();
                                 MonitorThread1 runnableObj = new MonitorThread1();
                                 Thread t1 = new thread(runnableObj);
                                 }



         */
        Thread t2 = new Thread(() -> {obj.task2();});
        Thread t3 = new Thread(() -> {obj.task3();}); // all working on same object
        t1.start();
        t2.start();
        t3.start();
    }
}
