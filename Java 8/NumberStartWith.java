import java.util.Arrays;
import java.util.List;

public class NumberStartWith {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 22, 234, 567, 890, 423, 236, 211, 78, 222);
        list.stream().map(e -> String.valueOf(e)).filter(e -> e.startsWith("2"))
                .map(e -> Integer.valueOf(e)).forEach(e -> System.out.print(e + " "));
                //u can use valueOf or parseInt
    }
}
