
import java.time.Period;
import java.util.*;
import java.util.Map.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.*;

public class Check {
    public static void main(String[] args) {
        String str = "Java Concept Of The Day";
        int i = 15623;
        List<Double> decimallist = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);


        String reverseStr = Arrays.stream(str.split(" ")).map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reverseStr);

        String j = Arrays.stream(String.valueOf(i).split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        System.out.println(j);

        IntStream.range(1, 11).filter(e -> e%2==0).forEach(System.out::print);

        List<Double> dl = decimallist.stream().map(String::valueOf).map(w -> new StringBuilder(w).reverse().toString()).map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println(dl);
    }
}
