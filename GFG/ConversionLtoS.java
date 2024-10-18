
//Q: Given a list (ArrayList or LinkedList), convert it into a set 
//(HashSet or TreeSet) of strings in Java.
import java.util.*;

public class ConversionLtoS {
    public static void main(String[] args) {
        // 1.We traverse the given set and one by one add elements to the list.
        List<String> l = Arrays.asList("Geeks", "for", 
                     "GeeksQuiz", "GeeksforGeeks", "GFG");
        Set<String> s = new HashSet<>();
        System.out.println("Set values are: "+s);
        for (String string : l) {
            s.add(string);
        }

        System.out.println("Set values are: "+s);

        //2. (Using HashSet or TreeSet Constructor)
        List<String> l2 = Arrays.asList("Geeks", "for", 
                     "GeeksQuiz", "GeeksforGeeks", "GFG");
        Set<String> s1 = new HashSet<>(l2);
        System.out.println("HashSet values are: "+s1);

        Set<String> t1 = new TreeSet<>(l2);
        System.out.println("TreeSet values are: "+t1);

        //3.(Using addAll method)
        List<String> l3 = Arrays.asList("Geeks", "for", 
                     "GeeksQuiz", "GeeksforGeeks", "GFG");
        Set<String> s2 = new HashSet<>(l3);
        s2.addAll(l3);
        System.out.println("HashSet values are: "+s2);

        Set<String> t2 = new TreeSet<>(l3);
        t2.addAll(l3);
        System.out.println("TreeSet values are: "+t2);        
    }
}