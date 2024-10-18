
//Q:  How to Iterate HashMap in Java?
import java.util.*;
import java.util.Map.Entry;

public class IterateHashMap {
    public static void main(String[] args) {
        
        Map<String, String> foodTable = new HashMap<String, String>();
        foodTable.put("A", "Angular");
        foodTable.put("J", "Java");
        foodTable.put("P", "Python");
        foodTable.put("H", "Hibernate");

        // 1.Iterate through a HashMap EntrySet using Iterators.
        for (Map.Entry<String, String> set : foodTable.entrySet()) {
            System.out.println(set.getKey()+" = "+set.getValue());
        }

        // 2. (Efficient)second method, the forEach function to iterate the key-value pairs.
        System.out.println("Using forEach() method ");
        foodTable.forEach((k, v) -> System.out.println(k+" = "+v));

        // 3.Using an iterator to iterate through a HashMap.
        Iterator<Entry<String, String>> itr = foodTable.entrySet().iterator();
        System.out.println("Using iterator ");
        while (itr.hasNext()) {
            Map.Entry<String, String> nm = (Map.Entry<String, String>) itr.next();
            System.out.println(nm.getKey()+" = "+nm.getValue());
        }

        // 4. (Efficient)Iterating through a HashMap using Lambda Expressions 
        System.out.println("Using Lambda Expressions ");
        foodTable.forEach((k, v) -> System.out.println(k+" = "+v));

        // 5.Loop through a HashMap using Stream API.
        System.out.println("Using Stream API ");
        foodTable.entrySet().stream().
        forEach(i -> System.out.println(i.getKey()+" = "+i.getValue()));
    }
}
