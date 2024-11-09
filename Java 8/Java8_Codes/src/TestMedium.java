import java.util.*;
import java.io.*;
import java.util.stream.*;

public class TestMedium {
    public static void main(String[] args) {

        //1.Write a program to append char in char ex-input- {A, B, C} output->[A_X, B_Y, C_Z].
        Stream<Character> ch = Stream.of('A', 'B', 'C');
        ch.forEach(c -> {
            char newChar = (char) (c+23);
            System.out.println(c+"_"+newChar);
        });

        //2.Write a program to find Min And Max In an Array Without using the max function
        System.out.print("\nWrite a program to find Min And Max In an Array Without using the max function");
        int arr[] = { 2, 3, 1, 22, 11, 33, 5 };
        int max = Arrays.stream(arr).boxed().reduce(Integer::max).get();
        int min = Arrays.stream(arr).boxed().reduce(Integer::min).get();
        System.out.print("Max: "+max+", Min: "+min);

        //3.Write a Java Program to find whether a number is prime or not.
        System.out.print("\nWrite a Java Program to find whether a number is prime or not: ");
        for (int i = 2; i < 20; i++) {
            final int y = i;
            boolean b = IntStream.range(2, (y/2)+1).noneMatch(x -> y%x==0);
            if (b) {
                System.out.println(i + " is prime.");
            }
        }

        //4.Write a Java Program to check Armstrong numbers.
        int i = 153;
        int sum = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt)
                    .map(d -> (int)Math.pow(d, 3)).sum();
        if (i==sum)
            System.out.println("Is Armstrong Number : " + i);
    }
}
