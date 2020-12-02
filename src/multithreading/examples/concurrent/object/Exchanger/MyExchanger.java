package multithreading.examples.concurrent.object.Exchanger;

import java.util.concurrent.Exchanger;

public class MyExchanger {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new MessageSetter(exchanger, "Message from setter")).start();
        new Thread(new MessageGetter(exchanger, "Message from getter")).start();
    }
}
