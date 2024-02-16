import java.util.Arrays;

public class QuickSort {

    
    public static void main(String[] args) {
        int[] arrayToSort = {5, 3, 7, 2, 8, 4, 1, 6, 1,3,5,32,423,1,2,3,4,32,42,34,4};
        
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arrayToSort));
        
        sort(arrayToSort, 0, arrayToSort.length - 1);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arrayToSort));
    }

    public static void sort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            sort(array, p, q - 1);
            sort(array, q + 1, r);
        }
    }

    public static int partition(int[] array, int p, int r) {
        int x = array[r]; // Pivot element (right-most element)
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, r); // Place the pivot in its correct position
        return i + 1;
    }
    
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
}
