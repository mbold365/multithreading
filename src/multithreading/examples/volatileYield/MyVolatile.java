package multithreading.examples.volatileYield;

public class MyVolatile extends Thread {

    private volatile long num = 4444444444444444444L;

    public MyVolatile() {
        this.start();
    }

    @Override
    public void run() {
        //...
        System.out.println(num);
    }

    public static void main(String[] args) {
        new MyVolatile();
        new MyVolatile();
    }
}
