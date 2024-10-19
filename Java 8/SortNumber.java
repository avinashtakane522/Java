import java.util.*;

public class SortNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 22, 234, 567, 890, 423, 236, 211, 78, 222);

        list.stream().sorted().forEach(e -> System.out.print(e+" ")); //Asc order

        //for Desc order
        System.out.print("\nDecending order : ");
        list.stream().sorted(Collections.reverseOrder()).forEach(e -> System.out.print(e+" "));
    }
}
