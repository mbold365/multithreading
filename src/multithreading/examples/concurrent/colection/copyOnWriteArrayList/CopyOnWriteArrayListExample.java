package multithreading.examples.concurrent.colection.copyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    List<String> list;

    public CopyOnWriteArrayListExample() {
        List<String> defaultList = new ArrayList<>();
        defaultList.add("Hello");
        defaultList.add("World");
        defaultList.add("I am using");
        defaultList.add("Concurrent");
        defaultList.add("Collection");

        list = new CopyOnWriteArrayList<>(defaultList);

        System.out.println("Result with changes after iteration:");
        printCollection(true);

        System.out.println("\nDefault result after iteration:");
        printCollection(false);

    }

    private void printCollection(boolean change) {
        for (String element : list) {

            System.out.println(element);

            if (change && element.equals("Collection")) {
                list.add("New string");
                list.remove(element);
            }
        }
    }

    public static void main(String[] args) {
        new CopyOnWriteArrayListExample();
    }
}