import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;

public class TestGit {
    public static void main(String[] args) {
        List<String> strlist = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<Integer> intlist = Arrays.asList(10, 8, 3, 5, 2, 7, 1, 6, 9, 4, 10, 1);
        String str = "Java Concept Of The Day";
        int[] arr = new int[]{10, 8, 3, 5, 2, 7, 1, 6, 9, 4, 10, 1};
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        //1. Separate odd and even numbers in a list of integers
        //Given a list of integers, write a Java 8 program to separate the odd and even numbers
        // into two separate lists
        System.out.print("Even numbers are: ");
        intlist.stream().filter(n -> n%2==0).forEach(n -> System.out.print(n+" "));
        System.out.print("\nOdd numbers are: ");
        intlist.stream().filter(n -> n%2!=0).forEach(n -> System.out.print(n+" "));

        //2. Remove duplicate elements from a list using Java 8 streams
        System.out.print("\nRemove duplicate elements from a list using Java 8 streams: ");
        intlist.stream().distinct().sorted().forEach(n -> System.out.print(n+" "));
        System.out.print("\nRemove duplicate elements from a list using Java 8 streams: ");
        strlist.stream().distinct().sorted().forEach(n -> System.out.print(n+" "));

        //3.Find the frequency of each character in a string using Java 8 streams
        System.out.println("\nFind the frequency of each character in a string using Java 8 streams: ");
        Map<Character, Long> mapChar = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        mapChar.entrySet().stream().forEach(e -> System.out.print(e.getKey()+" : "+e.getValue()+", "));

        //4.Find the frequency of each element in an array or a list
        System.out.print("\nFind the frequency of each element in an array : ");
        Map<Integer, Long> mapArr = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapChar.entrySet().stream().forEach(e -> System.out.print(e.getKey()+" : "+e.getValue()+", "));

        System.out.print("\nFind the frequency of each element in an list : ");
        Map<Integer, Long> mapInt = intlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapInt.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> System.out.print(e.getKey()+" : "+e.getValue()+", "));

        //5.Sort a given list of decimals in reverse order
        System.out.print("\nSort a given list of decimals in reverse order: ");
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n+", "));

        //6.Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
        System.out.print("\nJoin a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter: ");
        String str1 = Stream.of(str.split(" ")).collect(Collectors.joining(",","[","]"));
        System.out.print(str1);

        //7.Print the numbers from a given list of integers that are multiples of 5

        //8.Find the maximum and minimum of a list of integers
        System.out.println("\nFind the maximum and minimum of a list of integers: ");
        System.out.print("Max: ");
        intlist.stream().max(Comparator.naturalOrder()).ifPresent(System.out::print);
        System.out.print("\nMin: ");
        intlist.stream().min(Integer::compare).ifPresent(System.out::print);
    }
}
