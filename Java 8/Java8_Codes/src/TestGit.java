import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;

public class TestGit {
    public static void main(String[] args) {
        List<String> strlist = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<Integer> intlist = Arrays.asList(10, 8, 3, 5, 2, 7, 1, 6, 9, 4, 10, 1, 10);
        String str = "Java Concept Of The Day";
        List<String> listOfString = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        int[] arr = new int[]{10, 8, 3, 5, 2, 7, 1, 6, 9, 4, 10, 1};
        int[] arr1 = new int[]{11, 16, 13, 15};
        int[] arr2 = new int[]{14, 15, 12};
        String s1 = "RaceCar";
        String s2 = "CarRace";
        String s3 = "madam";
        int i = 12345;
        int x;
        double y;
        StringBuilder z = new StringBuilder();
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

        //1. Separate odd and even numbers in a list of integers
        //Given a list of integers, write a Java 8 program to separate the odd and even numbers
        // into two separate lists
        System.out.print("Even numbers are: ");
        intlist.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.print("\nOdd numbers are: ");
        intlist.stream().filter(n -> n % 2 != 0).forEach(n -> System.out.print(n + " "));

        //2. Remove duplicate elements from a list using Java 8 streams
        System.out.print("\nRemove duplicate elements from a list using Java 8 streams: ");
        intlist.stream().distinct().sorted().forEach(n -> System.out.print(n + " "));
        System.out.print("\nRemove duplicate elements from a list using Java 8 streams: ");
        strlist.stream().distinct().sorted().forEach(n -> System.out.print(n + " "));

        //3.Find the frequency of each character in a string using Java 8 streams
        System.out.println("\nFind the frequency of each character in a string using Java 8 streams: ");
        Map<Character, Long> mapChar = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        mapChar.entrySet().stream().forEach(e -> System.out.print(e.getKey() + " : " + e.getValue() + ", "));

        //4.Find the frequency of each element in an array or a list
        System.out.print("\nFind the frequency of each element in an array : ");
        Map<Integer, Long> mapArr = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapChar.entrySet().stream().forEach(e -> System.out.print(e.getKey() + " : " + e.getValue() + ", "));

        System.out.print("\nFind the frequency of each element in an list : ");
        Map<Integer, Long> mapInt = intlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapInt.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(e -> System.out.print(e.getKey() + " : " + e.getValue() + ", "));

        //5.Sort a given list of decimals in reverse order
        System.out.print("\nSort a given list of decimals in reverse order: ");
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + ", "));

        //6.Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
        System.out.print("\nJoin a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter: ");
        String str1 = Stream.of(str.split(" ")).collect(Collectors.joining(",", "[", "]"));
        System.out.print(str1);

        //7.Print the numbers from a given list of integers that are multiples of 5
        intlist.stream().filter(e -> e % 5 == 0).forEach(e -> System.out.println(e + ", "));

        //8.Find the maximum and minimum of a list of integers
        System.out.println("\nFind the maximum and minimum of a list of integers: ");
        System.out.print("Max: ");
        intlist.stream().max(Comparator.naturalOrder()).ifPresent(System.out::print);
        System.out.print("\nMin: ");
        intlist.stream().min(Integer::compare).ifPresent(System.out::print);

        //9.Merge two unsorted arrays into a single sorted array using Java 8 streams
        System.out.println("\nMerge two unsorted arrays into a single sorted array using Java 8 streams");
        IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().forEach(e -> System.out.print(e + ", "));

        //11.Get the three maximum and three minimum numbers from a given list of integers
        System.out.println("\nGet the three maximum and three minimum numbers from a given list of integers");
        System.out.println("First 3 max: ");
        intlist.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(e -> System.out.print(e + ", "));
        System.out.println("First 3 min: ");
        intlist.stream().sorted().limit(3).forEach(e -> System.out.print(e + ", "));

        //12.Check if two strings are anagrams or not using Java 8 streams
        System.out.println("\nCheck if two strings are anagrams or not using Java 8 streams");
        String s11 = Arrays.stream(str.split("")).map(String::toUpperCase).collect(Collectors.joining());
        String s12 = Arrays.stream(str.split("")).map(String::toUpperCase).collect(Collectors.joining());
        if (s11.equals(s12)) {
            System.out.println("Two strings are anagrams");
        } else {
            System.out.println("Two strings are not anagrams");
        }

        //13.Find the sum of all digits of a number in Java 8
        int sum = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
        System.out.print("\nFind the sum of all digits of a number in Java 8: " + sum);

        //14.Find the second largest number in an integer array
        x = intlist.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.print("\nsecond largest number in an integer array :" + x);

        //15.Sort a list of strings according to the increasing order of their length
        strlist.stream().sorted().forEach(s -> System.out.print(s + ", "));

        //16.Find the sum and average of all elements in an integer array
        x = Arrays.stream(arr).sum();
        y = Arrays.stream(arr).average().getAsDouble();
        System.out.print("\nSum is: " + x + ", Average is : " + y);

        //17.Find the common elements between two arrays
        System.out.print("\nThe common elements between two arrays: ");
        List<Integer> arr1L = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> arr2L = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        arr1L.stream().filter(arr2L::contains).forEach(System.out::print);

        //18.Reverse each word of a string using Java 8 streams
        z = new StringBuilder(Arrays.stream(str.split(" ")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" ")));
        System.out.print("\nReverse each word of a string using Java 8 streams: " + z);

        //19.Find the sum of the first 10 natural numbers
        x = IntStream.range(1, 11).sum();
        System.out.print("\nthe sum of the first 10 natural numbers: " + x);

        //20.Reverse an integer array
        System.out.println();
        IntStream.range(0, arr1.length).map(a -> arr1[arr1.length - a - 1]).forEach(a -> System.out.print(a + ", "));

        //21.Print the first 10 even numbers
        System.out.print("\nPrint the first 10 even numbers: ");
        IntStream.rangeClosed(1, 10).map(e -> e * 2).forEach(e -> System.out.print(e + " "));

        //22.Find the most repeated element in an array
        mapInt = intlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Integer, Long> e1 = mapInt.entrySet().stream().max(Map.Entry.comparingByKey()).get();
        System.out.print("\nThe most repeated element in an array : " + e1.getValue());

        //23.Check if a string is a palindrome using Java 8 streams
        boolean b = IntStream.range(0, s3.length() / 2).allMatch(a -> s3.charAt(a) == s3.charAt(s3.length() - a -1));
        if (b)
            System.out.println("\nGiven string is palindrome.");
        else
            System.out.println("\nGiven string is NOT palindrome.");

        //24.Find strings in a list that start with a number
        System.out.print("\nstrings in a list that start with a number: ");
        listOfString.stream().filter(s -> Character.isDigit(s.charAt(0))).forEach(s -> System.out.print(s+", "));

        //25.Extract duplicate elements from an array
        System.out.print("\nExtract duplicate elements from an array: ");
        intlist.stream().distinct().forEach(s -> System.out.print(s+", "));

        //26.Print duplicate characters in a string
        System.out.print("\nPrint duplicate characters in a string: ");
        mapChar = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapChar.entrySet().stream().filter(e -> e.getValue()>1).forEach(s -> System.out.print(s.getKey()+", "));

        //27.Find the first repeated character in a string
        System.out.print("\nFind the first repeated character in a string: ");
        mapChar = str.chars().mapToObj(c -> (char)c).filter(c -> c !=' ').collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapChar.entrySet().stream().filter(e -> e.getValue()>1).limit(1).forEach(s -> System.out.print(s.getKey()+", "));

        //28.Find the first non-repeated character in a string
        System.out.print("\nFind the first non-repeated character in a string: ");
        mapChar = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mapChar.entrySet().stream().filter(e -> e.getValue()==1).limit(1).forEach(s -> System.out.print(s.getKey()+", "));

        //29.Generate the Fibonacci series
        System.out.print("\nGenerate the Fibonacci series: ");
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0]+f[1]}).limit(10)
                .map(f -> f[0]).forEach(f -> System.out.print(f+", "));

        //30.Print the first 10 odd numbers
        System.out.print("\nPrint the first 10 odd numbers: ");
        Stream.iterate(new int[]{1, 3}, f -> new int[]{f[1], f[1]+2}).limit(10)
                .map(f -> f[0]).forEach(f -> System.out.print(f+", "));

        //31.Get the last element of an array
        System.out.print("\nGet the last element of an array: ");
        Arrays.stream(arr).skip(arr.length-1).forEach(System.out::print);

        //32.Calculate the age of a person in years
        LocalDate pd = LocalDate.of(1987, 11, 1);
        LocalDate cd = LocalDate.now();
        x = Period.between(pd, cd).getYears();
        System.out.print("\nCalculate the age of a person in years: "+x);

    }
}
