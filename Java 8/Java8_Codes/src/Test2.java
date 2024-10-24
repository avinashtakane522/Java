
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;

public class Test2 {
	public static void main(String[] args) {
		List<String> strlist = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
		List<Integer> intlist = Arrays.asList(71, 18, 42, 21, 67, 30, 42, 14, 56, 87, 18, 50);
		String str = "Java Concept Of The Day";
		int[] arr = new int[] { 4, 2, 5, 1, 4, 103, 987 };
		Map<String, Long> strmap;
		Map<Integer, Long> intmap;
		Map<Character, Long> charmap;
		List<Integer> arrtolist = Arrays.stream(arr).boxed().collect(Collectors.toList());
		List<Character> charlist = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		List<Double> decimallist = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);

		// 1 remove duplicate elements from a list
		strlist.stream().distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();
		intlist.stream().distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();
		Arrays.stream(arr).distinct().forEach(s -> System.out.print(s + " "));
		System.out.println("\nremove duplicate elements from a list");

		// 2. remove duplicate elements from a list
		// or we can use distict (.filter is optional here)
		strlist.stream().filter(s -> Collections.frequency(strlist, s) == 1).distinct()
				.forEach(s -> System.out.print(s + " "));
		System.out.println();
		intlist.stream().distinct().forEach(s -> System.out.print(s + " "));
		System.out.println();
		// For the array first it convert to the list and then perfome the operation.
		// For Ex: List<Integer> integerList =
		// Arrays.stream(arr).boxed().collect(Collectors.toList());
		arrtolist.stream().distinct().forEach(s -> System.out.print(s + " "));
		System.out.println("\nfind frequency of duplicate element in an array or a list");

		// 3.find frequency of duplicate element in an array or a list
		// If we want only duplicates count then use .filter only
		strmap = strlist.stream().filter(s -> Collections.frequency(strlist, s) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		strmap.entrySet().stream().forEach(s -> System.out.print(s.getKey() + " : " + s.getValue() + " "));
		System.out.println();
		intmap = intlist.stream().filter(s -> Collections.frequency(intlist, s) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		intmap.entrySet().stream().forEach(s -> System.out.print(s.getKey() + " : " + s.getValue() + " "));
		System.out.println();
		charmap = charlist.stream().filter(s -> Collections.frequency(charlist, s) > 1)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		charmap.entrySet().stream().forEach(s -> System.out.print(", " + s.getKey() + " : " + s.getValue()));
		System.out.println("\n \nsort the given list of decimals in reverse order");

		// 4. sort the given list of decimals in reverse order
		decimallist.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out
				.println("\nlist of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter");

		// 5. list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and
		// ‘,’ as delimiter
		String str1 = strlist.stream().collect(Collectors.joining(", ", "[", "]"));
		System.out.println(str1 + "\nthe given list of integers, print the numbers which are multiples of 5");

		// 6. the given list of integers, print the numbers which are multiples of 5
		intlist.stream().filter(s -> s % 5 == 0).forEach(s -> System.out.print(s + " "));
		System.out.println("\n list of integers, find maximum and minimum of those numbers");

		// 7. list of integers, find maximum and minimum of those numbers
		intlist.stream().max(Comparator.comparing(Integer::valueOf))
				.ifPresent(s -> System.out.print("max: " + s + " "));
		intlist.stream().min(Comparator.naturalOrder()).ifPresent(s -> System.out.print("min: " + s + " "));
		System.out.println("\n  merge two unsorted arrays into single sorted array using Java 8 streams");

		// 8. merge two unsorted arrays into single sorted array using Java 8 streams
		int[] a = new int[] { 4, 2, 7, 1 };

		int[] b = new int[] { 8, 3, 9, 5 , 5};
		int[] withDup = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
		System.out.println("\n Sorted array: " + Arrays.toString(withDup));
		int[] withoutDup = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
		System.out.println("\n Sorted array: " + Arrays.toString(withoutDup));
	}
}
