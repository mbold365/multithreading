package multithreading.examples.concurrent.object.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyCyclicBarrier { // пример парома, перевозящего машины, но паром и машина - разные потоки

    private static CyclicBarrier barrier;
    private static final int FERRY_SIZE = 5;

    public static class Ferry implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Cars are loading on the ferry");
                Thread.sleep(1000);
                System.out.println("All cars are om the ferry, we are ready to start");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Car implements Runnable {

        private final int carNum;

        public Car(int carNum) {
            this.carNum = carNum;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Car-%d is near ferry\n", carNum);
                barrier.await(); // достигли парома (барьера), уведомляем об этом
                System.out.printf("Car-%d get out from ferry and ride away\n", carNum);
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        barrier = new CyclicBarrier(FERRY_SIZE, new Ferry());

        for (int i = 0; i < 15; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(500);
        }
    }
}
