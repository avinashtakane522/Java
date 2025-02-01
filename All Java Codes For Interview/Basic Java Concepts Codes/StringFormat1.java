import java.util.*;
public class StringFormat1 {
    public static void main(String[] args) {
        String greeting = "Hello, World!";
        System.out.println("Original: " + greeting);
        
        // Length
        System.out.println("Length: " + greeting.length());
        
        // Character Access
        System.out.println("First Character: " + greeting.charAt(0));
        
        // Substring
        System.out.println("Substring: " + greeting.substring(7, 12));
        
        // Concatenation
        String newGreeting = greeting + " Welcome!";
        System.out.println("Concatenated: " + newGreeting);
        
        // Equality
        System.out.println("Equals 'Hello, World!': " + greeting.equals("Hello, World!"));
        
        // Ignore Case Equality
        System.out.println("Equals Ignore Case 'hello, world!': " + greeting.equalsIgnoreCase("hello, world!"));
        
        // Comparison
        System.out.println("Comparison to 'Hello': " + greeting.compareTo("Hello"));
        
        // Index Of
        System.out.println("Index Of 'World': " + greeting.indexOf("World"));
        
        // Trimming
        String paddedGreeting = "   Hello, World!   ";
        System.out.println("Trimmed: '" + paddedGreeting.trim() + "'");
        
        // Replacing
        System.out.println("Replaced: " + greeting.replace('l', 'p'));
        
        // Splitting
        String[] parts = greeting.split(", ");
        System.out.println("Split: ");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
