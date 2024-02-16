import java.util.Arrays;

public class QuickSortVariant {
    public static void main(String[] args) {
        int[] arrayToSort = {5, 3, 7, 2, 8, 4, 1, 6,32,5,123,5,35,345,53452,62,253,4532,34};
        int k = 10; 

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arrayToSort));

        sort(arrayToSort, 0, arrayToSort.length - 1, k);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arrayToSort));
    }

    public static void sort(int[] array, int p, int r, int k) {
        if (r - p + 1 > k) {
            int q = partition(array, p, r);
            sort(array, p, q - 1, k);
            sort(array, q + 1, r, k);
        }
        
        else {
            insertionSort(array, p, r);
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

        swap(array, i + 1, r);
        return i + 1;
    }

    public static void insertionSort(int[] array, int p, int r) {
        for (int i = p + 1; i <= r; i++) {
            int k = array[i];
            int j = i - 1;

            while (j >= p && array[j] > k) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = k;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}