package multithreading.examples.mutex;

public class MyMutex extends Thread {

    public MyMutex() {
        this.start();
    }

    @Override
    public void run() {
        Integer counter = 1;
//        synchronized (counter) {    //синхронизированный блок с монитором counter
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new MyMutex();  //создадим 5 потоков
        }
    }
}
