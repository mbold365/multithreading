package multithreading.examples.threadRunnable;

public class MyThread extends Thread {

    public MyThread() {
        this.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                sleep(1000);
                System.out.println("This is a thread example - " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyThread();
    }
}
