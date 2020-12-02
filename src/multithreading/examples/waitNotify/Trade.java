package multithreading.examples.waitNotify;

public class Trade {

    public static void main(String[] args) {
        Store store = new Store();
        Customer customer = new Customer(store);
        Producer producer = new Producer(store);

        new Thread(customer).start();
        new Thread(producer).start();
    }
}
