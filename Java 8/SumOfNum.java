import java.util.*;

public class SumOfNum{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Optional<Integer> sum = list.stream().reduce((a,b) -> a+b);
        sum.ifPresent(System.out::println);
    }
}