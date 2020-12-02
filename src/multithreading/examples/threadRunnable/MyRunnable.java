package multithreading.examples.threadRunnable;

public class MyRunnable implements Runnable{

    public MyRunnable() {
        this.run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("This is a runnable example!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new MyRunnable());
    }
}
