package multithreading.examples.concurrent.colection.concurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
создадим две мапы - обычную и потокобезопасную
попробуем изменить их в процессе итерации и посмотрим на результат
спойлер - потокобезопасная мапа позволяет изменять ее в процессе итерации
подобное важно в многопоточности, тк это достаточно частое явление
*/

public class ConcurrentHashMapExample {

    Map<String, String> map;

    public ConcurrentHashMapExample() {
        System.out.println("ConcurrentHashMap");
        createMap(true);
        addValue ();

        System.out.println("\n\nHashMap");
        createMap(false);
        addValue ();
    }

    private void addValue() {
        System.out.println("Before iteration : " + map);
        Iterator<String> iterator = map.keySet().iterator();

        System.out.print("In cycle : ");
        while(iterator.hasNext()){
            String key = iterator.next();
            if (key.equals("2")) {
                map.put("newKey", "7");
            } else
                System.out.print("  " + key + "="
                        + map.get(key));
        }
        System.out.println();
        System.out.println("After iteration : " + map);
    }

    private void createMap(boolean concurrent) {
        if (concurrent)
            map = new ConcurrentHashMap<>();
        else
            map = new HashMap<>();

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
    }

    public static void main(String[] args) {
        new ConcurrentHashMapExample();
    }
}
