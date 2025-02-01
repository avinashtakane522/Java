import java.util.Arrays;

public class javaArray1 {

    public static void main(String[] args) {
        // 1. Declaration and Initialization
        int[] array; // Declaration
        array = new int[5]; // Allocation with default values (0)

        // Alternative way to declare and initialize
        int[] array2 = {1, 2, 3, 4, 5};

        // 2. Accessing elements
        System.out.println("First element: " + array2[0]); // Output: 1
        System.out.println("Second element: " + array2[1]); // Output: 2

        // 3. Modifying elements
        array2[0] = 10; // Change the first element to 10
        System.out.println("Modified first element: " + array2[0]); // Output: 10

        // 4. Iterating over an array
        System.out.println("Iterating using a for loop:");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

        System.out.println("Iterating using a for-each loop:");
        for (int element : array2) {
            System.out.println(element);
        }

        // 5. Common operations
        // Filling an array with a specific value
        Arrays.fill(array, 42);
        System.out.println("Array filled with 42: " + Arrays.toString(array));

        // Sorting an array
        int[] unsortedArray = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        Arrays.sort(unsortedArray);
        System.out.println("Sorted array: " + Arrays.toString(unsortedArray));

        // Searching in an array
        int searchKey = 5;
        int index = Arrays.binarySearch(unsortedArray, searchKey);
        if (index >= 0) {
            System.out.println("Element " + searchKey + " found at index: " + index);
        } else {
            System.out.println("Element " + searchKey + " not found");
        }

        // 6. Multidimensional arrays
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Multidimensional array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 7. Array Length
        System.out.println("Length of array2: " + array2.length); // Output: 5
    }
}
