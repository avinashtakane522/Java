import java.util.Arrays;

public class javaArray2 {
    static void printarr(int array1[]) {
        // for(int i=0; i < array1.length; i++){
        // System.out.print(array1[i]+" ");
        // }

        // Using foreach
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Anonymous array
        printarr(new int[] { 10, 20, 30, 40 });

        // Decleration of an array

        // 1.
        int arr[] = { 90, 11, 21, 2, 14, 35 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 2.
        int arr1[] = new int[5];
        arr1[0] = 111;
        arr1[1] = 222;
        arr1[4] = 444;
        System.out.println("arr1 elements : " + Arrays.toString(arr1));

        // 3.
        int arr0[] = new int[] { 101, 202, 303 };
        System.out.println("arr0 elements : " + Arrays.toString(arr0));

        // Multi-dimensional array
        String arr2[][] = { { "cow", "cat", "rabbit" }, { "lion", "monkey", "tiger" },
                { "parrot", "sparrow", "pigon" } };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.printf("%1d%1d|%-9s", i, j, arr2[i][j]);
            }
            System.out.println();
        }
        System.out.println("Size: " + arr2.length);

        System.out.println("\n  ----------- Calling Array functions -----------\n");
        // ARRAY USEFUL FUNCTIONS
        ArrayFunctions.arrayfun();
        System.out.println();

        // Returning array as function
        String favouriteFood[] = ArrayFunctions.returnArray();
        // for (String str : favouriteFood) {
        // System.out.print(str + " ");
        // }
        ArrayFunctions.printArray(favouriteFood);
        System.out.println();
    }
}

class ArrayFunctions {
    static void arrayfun() {

        // 1. Sort
        int arr1[] = { 34, 12, 2, 89, 13, 90 };
        Arrays.sort(arr1);
        System.out.println("Sorted array is : " + Arrays.toString(arr1));

        // 2. Searching
        int[] arr2 = { 11, 22, 33, 44, 55, 66 };
        System.out.println("Element 33 found at index : " + Arrays.binarySearch(arr2, 33));

        // 3. Fill
        int arr3[] = new int[3];
        Arrays.fill(arr3, 42);
        System.out.println("Array3 filled with elements : " + Arrays.toString(arr3));

        // 4. Copying an array
        double[] arr4 = { 12, 89, 78 };
        double[] copyarr4 = Arrays.copyOf(arr4, arr4.length);
        System.out.println("Original array4 is: " + Arrays.toString(arr4));
        System.out.println("Copy of array4 is: " + Arrays.toString(copyarr4));

        // 5. Compare to another array
        int[] arr5 = { 1, 2, 3 };
        int arr6[] = { 1, 2, 3 };
        int arr7[] = { 3, 2, 1 };

        System.out.println("array5 is same as array6 : " + Arrays.equals(arr5, arr6));
        System.out.println("array5 is same as array7 : " + Arrays.equals(arr5, arr7));
    }

    static String[] returnArray() {
        return new String[] { "ice-cream", "coffe", "pastie", "chocklet" };
    }

    static void printArray(String[] arr) {
        try {
            for (int i = 0; i<=arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Extra element not found...");
        }
    }
}