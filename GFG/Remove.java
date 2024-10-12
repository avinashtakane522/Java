import java.util.ArrayList;
import java.util.List;

public class Remove {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();

        // Inserting % elements to it
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(1);
        al.add(2);
        System.out.println("List: " + al);

        // remove using index: lets remove 1'st index element which is 20
        al.remove(1);
        System.out.println("Now list is "+al);

        // remove using object: lets remove 30
        // al.remove(new Integer(30));
        // Note: Sometimes it does throw a warning of using deprecated function call or
        // object. One can recompile like to figure out where it is occurring.
        // Generally, it is a bad idea to use deprecated libraries that may go away in
        // the next release.
    }
}
