
//Q: Conversion of Array To ArrayList in Java
import java.util.*;

public class ALConvert {
    public static void main(String[] args) {
        // Method 1: Using Arrays.asList() method
        String[] geeks = { "Rahul", "Utkarsh",
                "Shubham", "Neelam" };
        List al = Arrays.asList(geeks);
        al.set(1, "HI");
        // al.add("Hello"); Not allowed: Returns a fixed-size list backed by the
        // specified array{ An attempt of adding more elements would cause
        // UnsupportedOperationException.}
        System.out.println(al);

        // sol on above problem
        // It is therefore recommended to create new ArrayList and pass
        // Arrays.asList(array reference) as an argument to it (i.e. as an constructor
        // argument of ArrayList).

        List<String> ak = new ArrayList<String>(Arrays.asList(geeks));
        ak.add("Shashank");
        ak.add("Nishant");

        System.out.println("\nArrayList After adding two" +
                " more Geeks: " + ak);

        // Method 2: Using Collections.addAll() method
        String[] geek = { "Rahul", "Utkarsh",
                "Shubham", "Neelam" };

        List<String> aj = new ArrayList<String>();

        // adding elements of array to arrayList.
        Collections.addAll(aj, geek);

        System.out.println(aj);
        // It returns true if the collection changed as a result of the call.

        // Method 3: Using Manual method to convert Array using add() method

        String[] gee = { "Rahul", "Utkarsh",
                "Shubham", "Neelam" };

        List<String> ag = new ArrayList<String>();

        // Array to ArrayList Conversion
        for (String ge : gee)
            ag.add(ge);

        System.out.println(ag);
    }
}
