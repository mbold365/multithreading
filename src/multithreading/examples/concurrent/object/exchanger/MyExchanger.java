package multithreading.examples.concurrent.object.exchanger;

import java.util.concurrent.Exchanger;

public class MyExchanger { //пример простого обмена сообщениями

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new MessageSetter(exchanger, "Message from setter")).start();
        new Thread(new MessageGetter(exchanger, "Message from getter")).start();
    }
}
