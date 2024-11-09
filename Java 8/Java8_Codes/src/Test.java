import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.Map.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        List<String> strlist = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<Integer> intlist = Arrays.asList(71, 18, 42, 21, 67, 30, 42, 14, 56, 87, 18, 50);
        String str = "Java Concept Of The Day";
        int[] arr = new int[]{4, 2, 5, 1, 4, 103, 987};
        List<String> listOfString = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        Map<String, Long> strmap;
        Map<Integer, Long> intmap;
        Map<Character, Long> charmap;
        Set<String> strSet = new HashSet<>();
        Set<Integer> intSet = new HashSet<>();
        Set<Character> charSet = new HashSet<>();

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

        //16.Reverse each word of a string using Java 8 streams
        System.out.println("\n Reverse each word of a string using Java 8 streams");
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

        //19. find the most repeated element in an array
        System.out.println("\n find the most repeated element in an array: ");
        Map<String, Long> map1 = strlist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Entry<String, Long> mapEntry = map1.entrySet().stream().max(Map.Entry.comparingByKey()).get();

        System.out.print("Most frequent element is: "+mapEntry.getKey()+" and Count is: "+mapEntry.getValue());

        //20.Palindrome program using Java 8 streams
        System.out.println("\nPalindrome program using Java 8 streams: ");
        String str2 = "ROTATOR";
        boolean isPalindrom = IntStream.range(0, str2.length()/2).
                                allMatch(p -> str2.charAt(p) == str2.charAt(str2.length() -1 - p));
        if (isPalindrom)
            System.out.println(str2+" is palindrome");
        else
            System.out.println(str2+" is not palindrome");

        //21. find out those strings which start with a number
        System.out.println("\nfind out those strings which start with a number: ");
        listOfString.stream().filter(str3 -> Character.isDigit(str3.charAt(0)))
                .forEach(System.out::println);

        //22.extract duplicate elements from an array
        System.out.println("\nextract duplicate elements from an array: ");
        intlist.stream().distinct().forEach(System.out::println);

        //23.Print duplicate characters in a string
        System.out.println("\nPrint  duplicate characters in a string: ");
        Arrays.stream(str.split("")).filter(ch -> !strSet.add(ch)).collect(Collectors.toSet())
                .forEach(System.out::println);

        //24. first repeated character in a string
        System.out.println("\n first repeated character in a string");
        Character firstRepeaChar = str.chars().mapToObj(en -> (char) en).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                Collectors.counting())).entrySet().stream().filter(en -> en.getValue()>1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println(firstRepeaChar);

        //25. first non-repeated character in a string
        System.out.println("\n first non-repeated character in a string: ");
        Character firstNonRepeaChar = str.chars().mapToObj(en -> (char) en).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,
                Collectors.counting())).entrySet().stream().filter(en -> en.getValue()==1)
                .map(Map.Entry::getKey).findFirst().orElse(null);
        //Or 2'nd approach
//        Map<String, Long> charCountMap =
//                Arrays.stream(inputString.split(""))
//                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
//        String firstNonRepeatedChar = charCountMap.entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == 1)
//                .map(entry -> entry.getKey())
//                .findFirst()
//                .get();

        System.out.println(firstNonRepeaChar);
        //26.Fibonacci series
        System.out.println("\nFibonacci series: ");
        Stream.iterate(new int[]{0, 1}, f -> new int[] {f[1], f[0] + f[1]}).limit(10)
                .map(f -> f[0])
                .forEach(fi -> System.out.print(fi+" "));

        //27.First 10 odd numbers
        System.out.println("\nFirst 10 odd numbers: ");
        Stream.iterate(new int[]{1, 3}, f -> new int[] {f[1], f[1]+2}).limit(10)
                .map(f -> f[0])
                .forEach(fi -> System.out.print(fi+" "));

        //28.get last element of an stringarray list.
        System.out.println("\nget last element of an stringarray list: ");
        strlist.stream().skip(strlist.size() - 1).forEach(System.out::println);

        //29.the age of a person in years if the birthday has given
        System.out.print("the age of a person in years if the birthday has given: ");
        LocalDate birthday = LocalDate.of(1972,04,20);
        LocalDate today = LocalDate.now();
        int yearsOld = Period.between(birthday, today).getYears();
        System.out.println(yearsOld);
    }
}
