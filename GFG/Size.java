import java.util.ArrayList;
import java.util.List;

public class Size {
    public static void main(String[] args) {
        List<Integer> Array_List = new ArrayList<Integer>(); 
  
        // add elements  
        Array_List.add(1); 
        Array_List.add(2); 
        Array_List.add(3); 
        Array_List.add(3);

        System.out.println(Array_List);

        int size = Array_List.size();
        System.out.println("Size of Array_list is : "+size);
    }
}
