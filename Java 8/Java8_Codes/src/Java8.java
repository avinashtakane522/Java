//Q1: Write a program to print the count of each character in a String?
//			Input: String s = "string data to count each character";
//			Output: {s=1, t=5, r=3, i=1, n=2, g=1,  =5, d=1, a=5, o=2, c=4, u=1, e=2, h=2}

//Q2: Reverse each word of a string using Java 8 streams?
//String str = "Java Concept Of The Day";
//Output : avaJ tpecnoC fO ehT yaD

//Q3: Find first non-repeated character in a string?
//String inputString = "Java Concept Of The Day"
//Output : j

//Q4: Find the age of a person in years if the birthday has given?
// LocalDate birthDay = LocalDate.of(1985, 01, 23);

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;
import java.time.*;

public class Java8 {
    public static void main(String[] args) {
        List<String> strlist = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<Integer> intlist = Arrays.asList(10, 8, 3, 5, 2, 7, 1, 6, 9, 4, 10, 1, 10);
        String str1 = "Java Concept Of The Day";
//        String str = "string data to count each character";
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

        LocalDate birthDay = LocalDate.of(1985, 01, 23);
        LocalDate tdate = LocalDate.now();
        int age = Period.between(birthDay, tdate).getYears();
        System.out.println("Age of person is: "+age);


//        Map<Character, Long> mapChar = str.chars().mapToObj(c -> (char)c)
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()));
//        Map.Entry<Character, Long> e1 = mapChar.entrySet().stream().filter(e -> e.getValue()==1).findFirst().get();
//        System.out.println(e1.getKey());

//        String s11 = Arrays.stream(str.split(" ")).map(c -> new StringBuilder(c).reverse())
//                .collect(Collectors.joining(" "));
//        System.out.println("First str: "+str+"-> Output :"+s11);

//        Map<Character, Long> mapChar = str.chars().mapToObj(c -> (char) c).filter(c -> c!=' ')
//                .collect(Collectors.groupingBy(c->c, Collectors.counting()));
//        mapChar.entrySet().stream().forEach(s -> System.out.print(s+", "));
//        System.out.println();


    }
}
