import java.util.ArrayList;

public class ALReplace {
    public static void main(String[] args) {
        try {
            //Replace with valid index
            ArrayList<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");

            System.out.println("List is "+list);
            list.set(1,"M");
            System.out.println("List after replace "+list);

            //Replace with in-valid index
            list.set(6,"N");
            System.out.println("List after in-valid replace "+list);

        } catch (Exception e) {
            System.out.println("Error is : " + e);
        }
    }
}
