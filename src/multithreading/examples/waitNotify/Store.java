package multithreading.examples.waitNotify;

public class Store {

    private int counter = 0;

    public synchronized void get() {//синхронизированный метод
        while (counter < 1) {
            try {
                wait();             // кол-во товара < 1? Тогда ждем, пока не появится
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println("Took one from the store\nAmount: " + counter);
        notify();                  // уведомляем ожидающий поток
    }

    public synchronized void put() {//синхронизированный метод
        while (counter >= 3) {
            try {
                wait();             // кол-во товара больше или равно 3? Ждем, пока не заберут хоть один
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println("Add one to the store\nAmount: " + counter);
        notify();                   // уведомляем ожидающий поток
    }
}
