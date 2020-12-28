package multithreading.examples.threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    private SimpleDateFormat dateFormat = null;
    private  final  int  COUNT = 5;

    private ExecutorServiceExample() {
        dateFormat = new SimpleDateFormat("HH:mm:ss.S");

        CountDownLatch cdl1 = new CountDownLatch(COUNT); // создаем 4 защелки, о которых мы говорили ранее
        CountDownLatch cdl2 = new CountDownLatch(COUNT); // используем их, чтобы раньше времени не вылетить на submit(),
        CountDownLatch cdl3 = new CountDownLatch(COUNT); // дожидаемся завершения всех потоков
        CountDownLatch cdl4 = new CountDownLatch(COUNT);

        ExecutorService executor;
        executor = Executors.newFixedThreadPool(2); // создаем фиксированный пул из двух потоков исполнения

        System.out.println("Threads start up");
        executor.execute(new MyThread(cdl1, "Thread.1")); // имплементации потоков принимают cdl
        executor.execute(new MyThread(cdl2, "Thread.2")); // стартуем все 4 потока на исполнения
        executor.execute(new MyThread(cdl3, "Thread.3"));
        executor.execute(new MyThread(cdl4, "Thread.4"));

        try {
            cdl1.await(); // дожидаемся завершения потоков, иначе заранее попадем на shutdown()
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch(InterruptedException ignored) {}

        executor.shutdown(); // задачи выполнили, закрываем пул, завершаем работу. Если закоментить, то все поломается
        System.out.println("Threads finished");
    }
    //-------------------------------------------------
    private void printMessage(final String message) {
        String text = dateFormat.format(new Date())+" : "+ message;
        System.out.println(text);
    }
    //-------------------------------------------------
    class MyThread implements Runnable {
        String         name;
        CountDownLatch latch;

        MyThread(CountDownLatch latch, String name) {
            this.latch = latch;
            this.name = name;
            new Thread(this);
        }

        public void run() { // небольшой цикл, где выводим дату, имя потока и итерацию, а потом ненадолго засыпаем
            try {
                for(int i = 0; i < COUNT; i++) {
                    printMessage(name + " - " + i);
                    latch.countDown();
                    Thread.sleep((long)(Math.random()*1500));
                }
                printMessage(name + " completed");
            } catch (InterruptedException ignored) {}
        }
    }
    //-------------------------------------------------
    public static void main(String args[]) {
        new ExecutorServiceExample();
    }
}
