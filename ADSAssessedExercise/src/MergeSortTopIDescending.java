import java.util.Arrays;

public class MergeSortTopIDescending {

    public static void main(String[] args) {
        int[] arrayToSort = {1, 5, 8, 2, 4, 2};
        int i = 3;

        System.out.println("original Array:");
        System.out.println(Arrays.toString(arrayToSort));

        int[] result = findTopILargestElements(arrayToSort, i);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arrayToSort));

        System.out.println("Top " + i + " largest elements in sorted order: " + Arrays.toString(result));
    }

    public static int[] findTopILargestElements(int[] array, int i) {
        if (i <= 0 || i > array.length) {
            throw new IllegalArgumentException("Invalid value of i");
        }

        mergeSortDescending(array, 0, array.length - 1, i);

        return Arrays.copyOfRange(array, 0, i);
    }

    private static void mergeSortDescending(int[] array, int left, int right, int i) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortDescending(array, left, mid, i);
            mergeSortDescending(array, mid + 1, right, i);

            mergeDescending(array, left, mid, right, i);
        }
    }

    private static void mergeDescending(int[] array, int left, int mid, int right, int i) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int iIndex = 0;
        int jIndex = 0;
        int k = left;

        while (iIndex < n1 && jIndex < n2 && k < left + i) {
            if (leftArray[iIndex] >= rightArray[jIndex]) {
                array[k] = leftArray[iIndex];
                iIndex++;
            } else {
                array[k] = rightArray[jIndex];
                jIndex++;
            }
            k++;
        }

        while (iIndex < n1 && k < left + i) {
            array[k] = leftArray[iIndex];
            iIndex++;
            k++;
        }

        while (jIndex < n2 && k < left + i) {
            array[k] = rightArray[jIndex];
            jIndex++;
            k++;
        }
    }
}
