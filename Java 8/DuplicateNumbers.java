import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class DuplicateNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,10,20,30,15,1,13,1,2,2,10,30,19,3);

    Set<Integer> dup = list.stream().filter(e -> Collections.frequency(list, e) > 1).
            collect(Collectors.toSet());
    System.out.println("Duplicates are: "+dup);

    //Another way
    Set<Integer> dup1 = new HashSet<>();
    Set<Integer> set = list.stream().filter(e -> !dup1.add(e)).collect(Collectors.toSet());
    System.out.println("Duplicate num are : "+set);
    }
}
