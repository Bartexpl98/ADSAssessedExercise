import java.util.Arrays;

public class MergeSort{

    public static void main(String[] args) {
        int[] arrayToSort = {5, 33, 7, 21, 452, 133, 6242,51,32};
        
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arrayToSort));

        MergeSort.sort(arrayToSort, 0, arrayToSort.length - 1);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arrayToSort));
    }    

    static void merge(int a[], int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
       
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];
        
       
        for (int i=0; i<n1; i++)
            leftArray[i] = a[left + i];
        for (int j=0; j<n2; j++)
            rightArray[j] = a[mid + 1+ j];
       
        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;
    
        int i = 0;
        int j = 0;
        for (int k=left; k<= right; k++){
            if(leftArray[i] <= rightArray[j]){
                a[k] = leftArray[i];
                i++;
            }
            else{
                a[k] = rightArray[j];
                j++;}
            }
}

    public static void sort(int[] array, int left, int right){
        if (left < right){
            int mid = (left+right)/2;
            sort(array, left, mid);
            sort(array , mid+1, right);
            merge(array, left, mid, right);}
}
}