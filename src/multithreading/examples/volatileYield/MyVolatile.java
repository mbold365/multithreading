package multithreading.examples.volatileYield;

public class MyVolatile extends Thread {

    private volatile long num = 4444444444444444444L; //некая не атомарная переменная, с которой будут работать потоки

    public MyVolatile() {
        this.start();
    }

    @Override
    public void run() {
        //какая-то логика работы
        System.out.println(num);
    }

    public static void main(String[] args) {
        new MyVolatile();   //запустим несколько потоков
        new MyVolatile();
    }
}
