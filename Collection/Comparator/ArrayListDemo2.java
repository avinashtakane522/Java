package Comparator;
import java.util.*;

// Approach to use comparator without external class and use an anonymous class in the sort method
public class ArrayListDemo2 {

	public static void main(String args[]) {
		List<Vehicle> list = new ArrayList<>();
		list.add(new Vehicle("Volkswagen", 2010));
		list.add(new Vehicle("Audi", 2009));
		list.add(new Vehicle("Ford", 2001));
		list.add(new Vehicle("BMW", 2015));

        System.out.println("Sorting by brand name.");
		Collections.sort(list, new Comparator<Vehicle>(){
            @Override
            public int compare(Vehicle o1, Vehicle o2){
                return o1.brand.compareTo(o2.brand);
            }
        });
		for (Vehicle vehicle : list) {
			System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
		}
		
		System.out.println("Sorting by make year.");
		Collections.sort(list, new Comparator<Vehicle>(){
            @Override
            public int compare(Vehicle o1, Vehicle o2){
                return o1.makeYear.compareTo(o2.makeYear);
            }
        });
		for (Vehicle vehicle : list) {
			System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
		}
	}
}
