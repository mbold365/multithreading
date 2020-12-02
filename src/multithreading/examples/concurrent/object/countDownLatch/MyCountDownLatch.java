package multithreading.examples.concurrent.object.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {

    private static final int CARS_COUNT = 6;
    private static CountDownLatch latch;

    public static class Car implements Runnable {

        private final int carNum;

        public Car(int carNum) {
            this.carNum = carNum;
        }

        @Override
        public void run() {
            System.out.printf("Car №%d get in the ferry\n", carNum);
            latch.countDown();
            try {
                latch.await();
                Thread.sleep(1700);
                System.out.printf("Car №%d get out from the ferry and ride away\n", carNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(CARS_COUNT);

        for (int i = 0; i < CARS_COUNT; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(1000);
        }
        while (true) {
            if (latch.getCount() == 0) {
                System.out.println("All cars are on the ferry, we are ready to start!");
                break;
            }
        }
    }
}
