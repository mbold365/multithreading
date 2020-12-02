package multithreading.examples.concurrent.object.phaser;

import java.util.concurrent.Phaser;

public class MyPhaser implements Runnable {

    private Phaser phaser;

    public MyPhaser(Phaser phaser) {
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
//
//        System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
//        phaser.arriveAndAwaitAdvance();
//
//        System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
//        phaser.arriveAndAwaitAdvance();
//
//        System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
//        phaser.arriveAndDeregister();
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
            if (i == 2) {
                phaser.arriveAndDeregister();
            }
            phaser.arriveAndAwaitAdvance();
        }
    }
}
