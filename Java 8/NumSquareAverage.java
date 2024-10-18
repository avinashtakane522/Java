import java.util.*;

public class NumSquareAverage {
    public static void main(String[] args) {
        // Exclute or remove which are < 100. and then perform average action.

        List<Integer> list = Arrays.asList(1, 10, 20, 30, 15);
        double avg = list.stream().map(e -> e * e).filter(e -> e > 100).mapToInt(e -> e).average().getAsDouble();
        System.out.println("Avg of given num: " + avg);
    }
}
