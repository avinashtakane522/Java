// Write a program to print the count of each character in a String?
// Input: String s = "string data to count each character";
// Output: {s=1, t=5, r=3, i=1, n=2, g=1,  =5, d=1, a=5, o=2, c=4, u=1, e=2, h=2}

// Reverse each word of a string using Java 8 streams?
// String str = "Java Concept Of The Day";
// Output : avaJ tpecnoC fO ehT yaD

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        String str = "Java Concept Of The Day";

        String reversedStr = Arrays.stream(str.split(" ")).collect(Collectors.joining(" "));

        System.out.println(reversedStr);
    }
}
