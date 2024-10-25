import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        List<String> strlist = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<Integer> intlist = Arrays.asList(71, 18, 42, 21, 67, 30, 42, 14, 56, 87, 18, 50);
        String str = "Java Concept Of The Day";
        int[] arr = new int[]{4, 2, 5, 1, 4, 103, 987};
        Map<String, Long> strmap;
        Map<Integer, Long> intmap;
        Map<Character, Long> charmap;

        String s1 = "RaceCar";
        String s2 = "CarRace";
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().
                collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().
                collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.println("Two strings are anagrams");
        } else {
            System.out.println("Two strings are not anagrams");
        }

        //11. Find sum of all digits of a number
        System.out.println("\n Find sum of all digits of a number");
        int i = 15623;
        int sumi = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sumi + " \nOr 2'nd way");
        sumi = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sumi);

        //12.Find second largest number in an integer array
        System.out.println("\nFind second largest number in an integer array");
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst()
                .ifPresent(System.out::println);

        //13.a list of strings, sort them according to increasing order of their length
        System.out.println("\nA list of strings, sort them according to increasing order of their length");
        System.out.print("Asending Order : ");
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        System.out.print("\nDecending Order : ");
        listOfStrings.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);

        //14.an integer array, find sum and average of all elements
        System.out.println("\nan integer array, find sum and average of all elements");
        int sum1 = Arrays.stream(arr).sum();
        System.out.print("Sum: "+sum1);
        double avg1 = Arrays.stream(arr).average().getAsDouble();
        System.out.print("\nAvg: "+avg1);

        //15. find common elements between two arrays
        System.out.println("\nfind common elements between two arrays");
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);

        //16. each word of a string using Java 8 streams
        System.out.println("\n each word of a string using Java 8 streams");
        String reverseStr = Arrays.stream(str.split(" ")).map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reverseStr);

        //17. find sum of first 10 natural numbers
        System.out.println("\nFind sum of first 10 natural numbers");
        int sum2 = IntStream.range(1, 11).sum();
        System.out.println(sum2);

        //18.Reverse an integer array
        System.out.println("\nReverse an integer array : ");
        Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //Or int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();

        //19.Print first 10 even numbers
        System.out.println("\nPrint first 10 even numbers: ");
        IntStream.rangeClosed(1, 11).map(e -> e * 2).forEach(System.out::println);
    }
}
