import java.util.Arrays;
import java.util.List;

public class LimitNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //get first 5 numbers
        System.out.println("get first 5 numbers: ");
        list.stream().limit(5).forEach(e -> System.out.print(e+" "));

        //get first 5 numbers --> sum of 5 numbers
        System.out.println("\nget first 5 numbers --> sum of 5 numbers: ");
        list.stream().limit(5).reduce((a,b) -> a+b).
                    ifPresent(e -> System.out.print(e+" "));

        //skip some first 5 and then add remaining
        System.out.println("\nskip some first 5 and then add remaining: ");
        list.stream().skip(5).reduce((a,b) -> a+b).
                    ifPresent(e -> System.out.print(e+" "));
        
        //skip some first 5 and then add only 2 element after first 5
        System.out.println("\nskip some first 5 and then add only 2 element after first 5: ");
        list.stream().skip(5).limit(2).reduce((a,b) -> a+b).
                    ifPresent(e -> System.out.print(e+" "));
    }
}
