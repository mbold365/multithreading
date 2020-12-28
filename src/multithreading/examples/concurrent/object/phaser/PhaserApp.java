package multithreading.examples.concurrent.object.phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        for (int i = 0; i < 2; i++) {
            new Thread(new MyPhaser(phaser)).start(); //создаем фазер, передавая ему родительсикй объект
        }
        
        int phase;
        for (int i = 0; i < 3; i++) {
            phase = phaser.getPhase(); //получаем номер текущей фазы
            phaser.arriveAndAwaitAdvance(); //завершили фазу, ждем остальных
            System.out.printf("Phase %d is done\n", phase);
        }
        phaser.arriveAndDeregister(); //завершили все фазы, снимаем сторону с регистрации
    }
}
