package multithreading.examples.join;

import java.util.Date;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Start of the run() : " + new Date());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of the run() : " + new Date());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();     //запускаем поток

        try {
            thread.join();      //дожидаемся его выполнения
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of the main : " + new Date());
    }
}
