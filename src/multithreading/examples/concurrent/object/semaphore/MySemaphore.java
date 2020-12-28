package multithreading.examples.concurrent.object.semaphore;

import java.util.concurrent.Semaphore;

public class MySemaphore { // пример кпп для автомобилей

    private static final int CHECKPOINTS_COUNT = 4;
    private static final int CARS_COUNT = 8;
    private static boolean [] CHECKPOINTS = null;

    private static Semaphore semaphore = null;

    public static class Car implements Runnable {

        private final int carNum;

        public Car(int carNum) {
            this.carNum = carNum;
        }

        @Override
        public void run() {
            System.out.printf("Car-%d near checkpoint zone\n", carNum);

            try {
                semaphore.acquire(); // получаем разрешение
                System.out.printf("Car-%d checks for free checkpoint\n", carNum);

                int checkpointNum = -1;

                synchronized (CHECKPOINTS) {
                    for (int i = 0; i < CHECKPOINTS_COUNT; i++) {
                        if (CHECKPOINTS[i]) {
                            CHECKPOINTS[i] = false; //занимаем кпп
                            checkpointNum = i;
                            System.out.printf("Car-%d near checkpoint №%d\n", carNum, checkpointNum);
                            break;
                        }
                    }
                }
                Thread.sleep(2000);

                synchronized (CHECKPOINTS) {
                    CHECKPOINTS[checkpointNum] = true; //освобождаем кпп
                }
                semaphore.release(); // освобождаем ресурс
                System.out.printf("Car-%d successfully pass checkpoint\n", carNum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CHECKPOINTS = new boolean[CHECKPOINTS_COUNT];

        for (int i = 0; i < CHECKPOINTS_COUNT; i++) {
            CHECKPOINTS[i] = true;
        }

        semaphore = new Semaphore(CHECKPOINTS.length, true);

        for (int i = 0; i < CARS_COUNT; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(500);
        }
    }
}
