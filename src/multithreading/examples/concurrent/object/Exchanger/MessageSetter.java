package multithreading.examples.concurrent.object.Exchanger;

import java.util.concurrent.Exchanger;

public class MessageSetter implements Runnable {

    Exchanger<String> exchanger;
    String message;

    public MessageSetter(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println("Message setter received: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
