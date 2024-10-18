
//Q:How to Copy One HashMap to Another HashMap in Java?
import java.util.*;

public class CopyHM1ToHM2 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Marcos");
        map1.put(2, "Para");
        map1.put(3, "Cobra");
        map1.put(4, "CRPF");
        Map<Integer, String> map2 = new HashMap<>();

        // By normally iterating and putting it to another HashMap using put(k, v)
        for (Map.Entry<Integer, String> m : map1.entrySet()) {
            map2.put(m.getKey(), m.getValue());
        }
        map2.forEach((k, v) -> System.out.println("Map2 using Normal way: \n"+k + " " + v));
        System.out.println();

        // Using putAll() method.
        Map<Integer, String> map3 = new HashMap<>();
        map3.putAll(map2);
        map3.forEach((k, v) -> System.out.println("Map3 using putAll(): \n"+k+" "+v));

        // Using copy constructor.
        Map<Integer, String> map4 = new HashMap<>(map3);
        map3.forEach((k, v) -> System.out.println("Map4 using copy constructor: \n"+k+" "+v));

        // Using assignment operator.
        Map<Integer, String> map5 = map4;
        map3.forEach((k, v) -> System.out.println("Map5 using assignment operator: \n"+k+" "+v));
    }
}
