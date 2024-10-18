import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenOdd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> even = list.stream().filter(e -> e%2==0).collect(Collectors.toList()); 
        System.out.println("Even num : "+even);
        
        //Or we can print like with space
        list.stream().filter(e -> e%2==0).collect(Collectors.toList()).
        forEach(e -> System.out.print(e + " "));  System.out.println();    
        
        //Or we can directly use forEach without collect
        list.stream().filter(e -> e%2==0).
        forEach(e -> System.out.print(e + " "));
    }
}
