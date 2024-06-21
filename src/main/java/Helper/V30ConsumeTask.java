package Helper;

public class V30ProduceTask implements Runnable{
    /**
     *  used in V30Threads
     */

    // could have not created this class and used lambda expression directly but this is for better clearity

    V30SharedResource sharedResource;
    V30ProduceTask(V30SharedResource resource){
        this.sharedResource = resource;
    }

    @Override
    public void run(){
        System.out.println("Producer Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sharedResource.addItem();
    }
}

