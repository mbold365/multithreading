package multithreading.examples.concurrent.object.phaser;

import java.util.concurrent.Phaser;

public class MyPhaser implements Runnable {

    private Phaser phaser; //родительский объект

    public MyPhaser(Phaser phaser) {
        this.phaser = phaser;
        phaser.register(); //регистрируем сторону, выполняющую фазу
    }

    @Override
    public void run() {

        System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); //завершили фазу, ждем остальных

        System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s on phase %d\n", Thread.currentThread().getName(), phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершении всех фаз и снимаем сторону с регистрации
    }
}
