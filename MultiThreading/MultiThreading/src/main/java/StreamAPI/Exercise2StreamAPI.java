package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class Exercise2StreamAPI {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4,5);

        List<List<Integer>> list3 = list1.stream().flatMap(i -> list2.stream().map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
        System.out.println(list3);
    }
}
