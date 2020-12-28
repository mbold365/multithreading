package multithreading.examples.volatileYield;

public class MyYield extends Thread{

    public MyYield() {
        this.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " yield to another thread");
        Thread.yield();     //поток уступает место
        System.out.println(Thread.currentThread().getName() + " finished his work");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new MyYield();      //создаем 3 потока
        }
    }
}
