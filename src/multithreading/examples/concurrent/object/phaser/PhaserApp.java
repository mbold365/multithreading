package multithreading.examples.concurrent.object.phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        for (int i = 0; i < 2; i++) {
            new Thread(new MyPhaser(phaser)).start();
        }
        
        int phase;
        for (int i = 0; i < 3; i++) {
            phase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.printf("Phase %d is done\n", phase);
        }
        phaser.arriveAndDeregister();
    }
}
