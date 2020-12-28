package multithreading.examples.concurrent.object.exchanger;

import java.util.concurrent.Exchanger;

public class MessageGetter implements Runnable { //пример получателя

    private Exchanger<String> exchanger; //параметр-ый типом строка обменник
    private String message;

    public MessageGetter(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message); //передаем ссылку на обмениваемые данные
            System.out.println("Message getter received: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
