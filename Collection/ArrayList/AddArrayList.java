import java.util.*;
class AddArrayList {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        // // This will add element at specific index 
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        System.out.println("The element at index two is " + list.get(1));

        System.out.println("The size of the List is  " + list.size());

        // 2. Add all the elements present in list to list.
        List<Integer> newList = new ArrayList<>();
        newList.add(10);
        newList.addAll(list);
        System.out.println(newList);

        // 3. Add all the elements present in list to sList atSpecific index.
        List<Integer> sList = new ArrayList<>();
        sList.add(10);
        sList.add(20);
        sList.add(30);
        sList.add(40);
        sList.addAll(1, list);

        System.out.println(sList);
    }
}