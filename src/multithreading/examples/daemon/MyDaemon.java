package multithreading.examples.daemon;

class MyDaemon extends Thread {

    int counter;

    public MyDaemon(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < counter; i++) {
            try {
                sleep(1000);
                System.out.println(this.getName() + " :" + i + " " + this.isDaemon());
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyDaemon example;
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                example = new MyDaemon(6);
                example.setDaemon(true);    // делаем поток с номером 2 демоном
            } else {
                example = new MyDaemon(3);
            }
            example.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of the main method");
    }
}