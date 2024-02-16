import java.util.Arrays;

public class ThreeWayQuickSort {

    public static void main(String[] args) {
        int[] arrayToSort = {5, 3, 7, 2, 8, 4, 1, 6, 33,4234234,12,3232,52,3,6262, 7, 5};
        
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arrayToSort));
        
        sort(arrayToSort, 0, arrayToSort.length - 1);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arrayToSort));
    }

    public static void sort(int[] array, int p, int r) {
        if (p < r) {
            // Choose the pivot element
            int pivot = array[p + (r - p) / 2];
            System.out.println(pivot);

            int[] indices = partitionThreeWay(array, p, r, pivot);
            int q1 = indices[0];
            int q2 = indices[1];

            sort(array, p, q1);
            sort(array, q2, r);
        }
    }

    public static int[] partitionThreeWay(int[] array, int p, int r, int pivot) {
        int i = p - 1;
        int j = p;
        int k = r + 1;

        while (j < k) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                j++;
            } 
            
            else if (array[j] == pivot) {
                j++;
            }
            
            else {
                k--;
                swap(array, j, k);
            }
        }

        return new int[]{i, j};
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

