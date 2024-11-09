import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
        public static void main(String[] args) {
                List<Integer> list = Arrays.asList(1, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 30, 19, 3);
                List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 10, 20);
                String input = "Java articles are Awesome";
                List<String> list1 = Arrays.asList("Java", "8");
                List<String> list2 = Arrays.asList("explained", "through", "programs", "aa", "through");
                int arr[] = { 99, 55, 203, 99, 4, 91 };

                System.out.print("\n EvenOdd with: ");
                list.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.print(e + " "));

                System.out.print("\n Start with: ");
                list.stream().map(e -> String.valueOf(e)).filter(e -> e.startsWith("2")).map(e -> Integer.valueOf(e))
                                .distinct()
                                .forEach(e -> System.out.print(e + " "));

                System.out.print("\n Duplicates: ");
                list.stream().filter(e -> Collections.frequency(list, e) > 1).distinct()
                                .forEach(e -> System.out.print(e + " "));

                System.out.print("\n Find the first element of the list : ");
                list.stream().limit(1).forEach(System.out::print);

                System.out.print("\n Find the total number of elements present in the list : ");
                long l = list.stream().count(); // The issue in this line of code is that .count() returns a long value,
                                                // and not a Stream.
                // Therefore, you cannot call .forEach()
                System.out.print(l);

                System.out.print("\n Find the maximum value element present in it using Stream: ");
                list.stream().max(Comparator.comparing(Integer::valueOf)).ifPresent(e -> System.out.print(e + " "));

                // ---------------------######------------------------------------
                System.out.print("\n Find the first non-repeated character in it: ");
                Map<Character, Long> freq = input.chars().mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                freq.entrySet().stream().filter(e -> e.getValue() == 1).findFirst()
                                .ifPresent(e -> System.out.print(e.getKey() + " "));

                System.out.print("\n First repeated character in it using Stream: ");
                Map<Character, Long> freqGrater = input.chars().mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                freqGrater.entrySet().stream().filter(e -> e.getValue() > 1).findFirst()
                                .ifPresent(e -> System.out.print(e.getKey() + " "));

                // ---------------------######------------------------------------

                System.out.print("\n List of integers, sort all the values : ");
                list.stream().sorted().forEach(e -> System.out.print(e + " "));

                System.out.print("\n List of integers, sort all the values present in it in descending order : ");
                list.stream().sorted(Collections.reverseOrder()).forEach(e -> System.out.print(e + " "));

                System.out.print(
                                "\n Integer array nums, return true if any value appears at least twice in the array, and return false: ");
                boolean value = list.stream().anyMatch(e -> Collections.frequency(list, e) > 1);
                System.out.println("Contains duplicates: " + value);

                System.out.print("\nGet the current date and time using Java 8 Date and Time API: ");
                System.out.println("Current Local date: " + java.time.LocalDate.now());
                System.out.println("Current Local time: " + java.time.LocalTime.now());
                System.out.println("Current Local date and time: " + java.time.LocalDateTime.now());

                System.out.print("\nTo concatenate two Streams: ");
                Stream<String> str = Stream.concat(list1.stream(), list2.stream());
                str.forEach(s -> System.out.print(s + " "));

                System.out.print("\nTo perform cube on list elements and filter numbers greater than 50: ");
                li.stream().map(i -> Math.pow(i, 3)).filter(i -> i > 50).forEach(i -> System.out.print(i + " "));

                System.out.print("\nTo sort an array and then convert the sorted array into Stream: ");
                Arrays.sort(arr);
                Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

                System.out.print("\nTo use map to convert object into Uppercase in Java 8: ");
                list2.stream().map(String::toUpperCase).forEach(System.out::print);

                System.out.print(
                                "\nTo convert a List of objects into a Map by considering duplicated keys and store them in sorted order?: ");

                System.out.print("\n to count each element/word from the String ArrayList in Java8: ");
                Map<String, Long> map = list2.stream()
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                System.out.print("Count string-wise: " + map);

                System.out.print("\nTo find only duplicate elements with its count from the String ArrayList: ");
                list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                                .stream().filter(e -> e.getValue() > 1)
                                .forEach(e -> System.out.print(e.getKey() + " " + e.getValue()));

                System.out.print(
                                "\nTo check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object: ");
                Optional.ofNullable(list2).filter(lstr -> !lstr.isEmpty())
                                .ifPresent(lstr -> System.out.print(lstr + " "));

                System.out.print("\nFind the Maximum element in an array: ");
                int x = Arrays.stream(arr).max().getAsInt();
                System.out.print(x);

                System.out.print("\nTo print the count of each character in a String: ");
                Map<Character, Long> mapCh = input.chars().mapToObj(c -> (char) c).filter(c -> c != ' ')
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                mapCh.entrySet().stream().forEach(c -> System.out.print(c.getKey() + ": " + c.getValue() + ", "));

        }
}
