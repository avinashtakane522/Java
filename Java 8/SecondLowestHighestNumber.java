import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondLowestHighestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 30, 19, 3);

        System.out.print("Second highest number: ");
        list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().ifPresent(System.out::print);
        // or we can do this way also - by using limit
        System.out.print("\nSecond highest number by using limit: ");
        list.stream().sorted(Collections.reverseOrder()).limit(2).skip(1).forEach(System.out::print);
        
        
        System.out.print("\nSecond lowest number: ");
        list.stream().sorted().skip(1).findFirst().ifPresent(System.out::print);
    }
}
