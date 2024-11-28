package Collections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapFirstWorker implements Runnable {
    private ConcurrentMap<String, Integer> map;

    public MapFirstWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("K", 20);
            Thread.sleep(2000);
            map.put("S", 10);
            Thread.sleep(1000);
            map.put("A", 30);
            map.put("H", 40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MapSecondWorker implements Runnable {
    private ConcurrentMap<String, Integer> map;

    public MapSecondWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("K"));
            System.out.println(map.get("S"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        MapFirstWorker firstWorker = new MapFirstWorker(map);
        MapSecondWorker secondWorker = new MapSecondWorker(map);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}

//import java.util.concurrent.ConcurrentHashMap;
//
//public class ConcurrentMapExample {
//    public static void main(String[] args) {
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//
//        // Adding key-value pairs
//        map.put("Apple", 10);
//        map.put("Banana", 20);
//        map.put("Orange", 30);
//
//        // Retrieving a value
//        System.out.println("Value for 'Banana': " + map.get("Banana"));
//
//        // Concurrent modification by multiple threads
//        Runnable task = () -> {
//            map.put("Grapes", 40);
//            System.out.println("Added 'Grapes': " + map.get("Grapes"));
//        };
//
//        Thread thread1 = new Thread(task);
//        Thread thread2 = new Thread(task);
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println("Final Map: " + map);
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        // Printing the map
//        System.out.println("Final Map: " + map);
//    }
//}
