//Q: Input : List = [3, 5, 18, 4, 6]
// Output:
// Min value of our list : 3
// max value of our list : 18
//Time Complexity: O(N), where N is the length of the list.

import java.util.*;
public class Compare {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(3);
        l.add(5); 
        l.add(18); 
        l.add(4); 
        l.add(6);

        int min,max;
        min=Collections.min(l);
        max=Collections.max(l);

        if (min==max) {
            System.out.println("All elements are equal");
        }
        else{
            System.out.println("Min value of our list : "+min);
            System.out.println("Max value of our list : "+max);
        }
    }
}
