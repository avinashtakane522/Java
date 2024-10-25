import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Conversion {
    public static void main(String[] args) {
        // List of primitive int
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        // Convert int to Integer
        List<Integer> convertedIntegers = integerList.stream()
                .mapToInt(i -> i) // Convert to int stream
                .boxed() // Convert int to Integer
                .collect(Collectors.toList());

        System.out.println("Converted List of Integers: " + convertedIntegers);

        // Convert Integer to String
        List<String> stringFromIntegers = integerList.stream()
                .map(String::valueOf) // Convert Integer to String
                .collect(Collectors.toList());

        System.out.println("Converted List of Strings from Integers: " + stringFromIntegers);

        // List of primitive double
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);

        // Convert double to Double (not really necessary since it's already Double, but shown for completeness)
        List<Double> convertedDoubles = doubleList.stream()
                .mapToDouble(d -> d) // Convert to double stream
                .boxed() // Convert double to Double
                .collect(Collectors.toList());

        System.out.println("Converted List of Doubles: " + convertedDoubles);

        // Convert Double to String
        List<String> stringFromDoubles = doubleList.stream()
                .map(String::valueOf) // Convert Double to String
                .collect(Collectors.toList());

        System.out.println("Converted List of Strings from Doubles: " + stringFromDoubles);

        // List of primitive boolean
        List<Boolean> booleanList = Arrays.asList(true, false, true, false);

        // Convert Boolean to String
        List<String> stringFromBooleans = booleanList.stream()
                .map(String::valueOf) // Convert Boolean to String
                .collect(Collectors.toList());

        System.out.println("Converted List of Strings from Booleans: " + stringFromBooleans);

        // Convert String to Boolean (demonstration)
        List<Boolean> booleanFromStrings = stringFromBooleans.stream()
                .map(Boolean::valueOf) // Convert String to Boolean
                .collect(Collectors.toList());

        System.out.println("Converted List of Booleans from Strings: " + booleanFromStrings);
    }
}
