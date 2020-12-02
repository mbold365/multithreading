package multithreading.examples.waitNotify;

public class Store {

    private int counter = 0;

    public synchronized void get() {
        while (counter < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println("Took one from the store\nAmount: " + counter);
        notify();
    }

    public synchronized void put() {
        while (counter >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println("Add one to the store\nAmount: " + counter);
        notify();
    }
}
