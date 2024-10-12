import java .util.*;
public class ALAdd {
    public static void main(String[] args) {
        //Element added normal in the list
        //Time Complexity: O(1), Auxiliary Space: O(1)
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);

        System.out.println("List is : "+l);

        //Element added at the specific list index
        //Time Complexity: O(n), Auxiliary Space: O(1)
        l.add(1,11);
        l.add(2,12);
        l.add(3,13);

        System.out.println("After added at specific index: "+l);
    }    
}
