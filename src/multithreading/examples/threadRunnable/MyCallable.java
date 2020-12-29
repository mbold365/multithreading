package multithreading.examples.threadRunnable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private MyCallable() throws Exception {
        this.call();
    }

    @Override
    public String call() throws Exception {
        System.out.println("This is callable example!");
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        new MyCallable();
    }
}
