import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMinNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 22, 234, 567, 890, 423, 236, 211, 78, 222);

        System.out.print("Max num is: ");
        list.stream().max(Comparator.comparing(Integer::valueOf))
            .ifPresent(e -> System.out.print(e+" "));
            //Here we can't use the forEach directly because: 
            //The max method returns an Optional<Integer>, which might be empty if 
            //the stream has no elements. The .get() method extracts the value from 
            //the Optional, but it will throw a NoSuchElementException if no value is
            //present (i.e., if the list is empty). To avoid this, you might want to use 
            //.orElse() or .ifPresent() for safer handling.

        System.out.print("\nMin num is: ");
        list.stream().min(Comparator.comparing(Integer::valueOf))
            .ifPresent(e -> System.out.print(e+" "));
    }
}
