package multithreading.examples.concurrent.object.Exchanger;

import java.util.concurrent.Exchanger;

public class MessageGetter implements Runnable {

    Exchanger<String> exchanger;
    String message;

    public MessageGetter(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println("Message getter received: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
