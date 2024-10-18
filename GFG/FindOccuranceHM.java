//Q: Java Program to Find the Occurrence of Words in a String using HashMap
import java.util.*;

public class FindOccuranceHM {
    public static void main(String[] args) {
        String str = "Alice is girl and Bob is boy"; 
        Map<String, Integer> map = new HashMap<>();
        String[] s = str.split(" ");

        // for (String st : s) {

        //     //FIrst way
        //     // Integer k = map.get(st);
        //     // if ( k == null ) {
        //     //     map.put(st, 1);
        //     // }
        //     // else{
        //     //     map.put(st, k+1);
        //     // }

        //     //Second way using containsKey
        //     if (map.containsKey(st)) {
        //         map.put(st, map.get(st)+1);
        //     }
        //     else{
        //         map.put(st, 1);
        //     }
        // }
        // map.forEach((k, v) -> System.out.println(k+" : "+v));

        //2. Using forEach() method shortcut
        Arrays.stream(s).forEach(st -> map.put(st, map.getOrDefault(st, 0)+1));

        map.forEach((k, v) -> System.out.println(k+" : "+v));
    }
}
