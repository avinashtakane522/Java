import java.util.*;

public class AverageOfAllNum {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        double avg = list.stream().mapToInt(e -> e).average().getAsDouble();
        System.out.println("Avg of given num: "+avg);
    }
}