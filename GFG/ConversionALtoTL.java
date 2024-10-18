
//Q:  convert the given array list to a linked list in Java.
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConversionALtoTL {
    public static void main(String[] args) {
        // 1.Using Brute Force or Naive Method
        List<String> a = new ArrayList<>(Arrays.asList("Geeks",
                "forGeeks",
                "A computer Portal"));
        List<String> l = new LinkedList<>();
        System.out.println("Before convert using BF: "+l);
        for (String string : a) {
            l.add(string);
        }
        System.out.println("After convert using BF: "+l);
        l.clear();

        // 2.Using List Constructor
        System.out.println("Before convert using BF: "+l);
        l = new LinkedList<>(a);
        System.out.println("After convert using BF: "+l);
        l.clear();

        // 3.Using Java 8 Streams API
        System.out.println("Before convert using BF: "+l);
        l = a.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("After convert using BF: "+l);
        l.clear();

        // 4.Using Google’s Guava Library
        System.out.println("Before convert using BF: "+l);
        l = new LinkedList<>();
        l.addAll(a);
        System.out.println("After convert using BF: "+l);
        l.clear();

        // 5.Conversion between incompatible types
        List<Integer> aL = Arrays.asList(1, 2, 3, 4, 5); 
        List<String> tL = new LinkedList<>(); 
        System.out.println("Before convert using BF: "+tL);
        tL=aL.stream().map(String::valueOf).collect(Collectors.toCollection(LinkedList::new));
        System.out.println("After convert using BF: "+tL);
    }
}
