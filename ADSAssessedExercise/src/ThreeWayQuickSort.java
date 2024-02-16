public class ThreeWayQuickSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 7, 2, 8, 4, 1, 6, 33,4234234,12,3232,52,3,6262, 7, 5};
        threeWayQuickSort(array, 0, array.length - 1);

        // Print sorted array
        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    // 3-WAY-QUICKSORT algorithm
    public static void threeWayQuickSort(int[] array, int p, int r) {
        if (p < r) {
            // Choose the pivot element
            int pivot = array[p + (r - p) / 2];

            // Partition the array into three parts
            int[] indices = partitionThreeWay(array, p, r, pivot);
            int q1 = indices[0];
            int q2 = indices[1];

            // Recursively sort the three parts
            threeWayQuickSort(array, p, q1);
            threeWayQuickSort(array, q2, r);
        }
    }

    // Partition procedure for 3-WAY-QUICKSORT
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

    // Helper method to swap elements in an array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

