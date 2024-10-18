
//Q: How to check if a key exists in a HashMap in Java
import java.util.*;

public class KeyExistHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Marcos");
        map.put(2, "Para");
        map.put(3, "Cobra");
        map.put(null, "CRPF");

        int checkKey = 2;
        boolean isKeyPresent = false;
        // 1. Using Iterator (Not Efficient): may raise NULLPOINTEREXCEPTION

        try {
            Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry<Integer, String> m = (Map.Entry<Integer, String>) itr.next();
                if (checkKey == m.getKey()) {
                    isKeyPresent = true;
                }
            }
            System.out.println("Does key " + checkKey + " exist : " + isKeyPresent);
        } catch (Exception e) {
            System.out.println(e);
        }

        // 2. Using HashMap.containsKey method(Efficient):
        isKeyPresent = map.containsKey(checkKey);
        System.out.println("Does key " + checkKey + " exist : " + isKeyPresent);
    }
}
