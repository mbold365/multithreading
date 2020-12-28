package multithreading.examples.concurrent.object.exchanger;

import java.util.concurrent.Exchanger;

public class MessageSetter implements Runnable { //пример отправителя

    private Exchanger<String> exchanger; //параметр-ый типом строка обменник
    private String message;

    public MessageSetter(Exchanger<String> exchanger, String message) {
        this.exchanger = exchanger;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message); // передаем ссылку на обмениваемые данные
            System.out.println("Message setter received: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
