//Comparing two ArrayList In Java
//Java provides a method for comparing two Array List. The ArrayList.equals() 
//is the method used for comparing two Array List. It compares the Array lists as,
// both Array lists should have the same size, and all corresponding pairs of 
//elements in the two Array lists are equal.

import java.util.ArrayList;

public class ALComparing {
    public static void main(String[] args) {
        // create two Array List
        ArrayList<String> ArrayList1 = new ArrayList<String>();
        ArrayList<String> ArrayList2 = new ArrayList<String>();

        // insert items in ArrayList 1
        ArrayList1.add("item 1");
        ArrayList1.add("item 2");
        ArrayList1.add("item 3");
        ArrayList1.add("item 4");

        // insert items in ArrayList 2
        ArrayList2.add("item 1");
        ArrayList2.add("item 2");
        ArrayList2.add("item 3");
        ArrayList2.add("item 4");

        // Display both ArrayList
        System.out.println(" ArrayList1 = " + ArrayList2);
        System.out.println(" ArrayList1 = " + ArrayList1);

        // compare ArrayList1 with ArrayList2
        if (ArrayList1.equals(ArrayList2) == true) {
            System.out.println(" Array List are equal");
        } else
        // else block execute when
        // ArrayList are not equal
        {
            System.out.println(" Array List are not equal");
        }

        // insert one more item in ArrayList 1
        System.out.println(
                "\n Lets insert one more item in Array List 1");
        ArrayList1.add("item 5");

        // display both ArrayList
        System.out.println(" ArrayList1 = " + ArrayList1);
        System.out.println(" ArrayList = " + ArrayList2);

        // again compare ArrayList 1 with ArrayList 2
        if (ArrayList1.equals(ArrayList2) == true) {
            System.out.println(" Array List are equal");
        } else {
            System.out.println(" Array List are not equal");
        }
    }
}
