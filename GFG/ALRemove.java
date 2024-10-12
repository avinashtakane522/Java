import java.util.*;

public class ALRemove {
    public static void main(String[] args) {

        // Remove elements from the ArrayList
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);

        // 1.Using remove() method by indexes(default)
        l.remove(1);
        l.remove(3);

        System.out.println("After removal elements using index: " + l);

        // 2.Using remove() method by values
        //l.remove(Integer.valueOf(10));
        // Note: It is not recommended to use ArrayList.remove() when iterating over
        // elements.
        // Also new Integer( int_value) has been deprecated since Java 9

        // 3.Using remove() method over iterators
        List<Integer> al = new ArrayList<>();

        al.add(10);
        al.add(20);
        al.add(30);
        al.add(1);
        al.add(2);

        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            if ((Integer) itr.next() < 10) {
                itr.remove();
            }
        }
        System.out.println("After performing removing operation using iterator list is " + al);
    }
}
