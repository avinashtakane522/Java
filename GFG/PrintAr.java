import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAr {
    public static void main(String[] args) {
        String[] geeks = { "Rahul", "Utkarsh", "Shubham", "Neelam" };

        List<String> al = new ArrayList<String>();

        // adding elements of array to arrayList.
        Collections.addAll(al, geeks);

        System.out.println(al);

        List<String> ar = new ArrayList<String>();

        // adding elements of array to arrayList.
        // ar.addAll(geeks);
        //The method addAll(Collection<? extends String>) in the type 
        //List<String> is not applicable for the arguments (String[])
    }
}