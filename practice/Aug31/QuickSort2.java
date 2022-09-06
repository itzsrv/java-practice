package practice.Aug31;

public class QuickSort2 {
    
    public static int[] sort(int[] arr, int low, int high){

        if(low<high){
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex-1);
            sort(arr, pivotIndex+1, high);
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for(int j=low; j<high; j++){
            if (arr[j]<pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        i++;
        swap(arr, i, high);
        return i;
    }

    public static int[] swap(int[] arr, int l, int m){
        int temp = arr[l];
        arr[l] = arr[m];
        arr[m] = temp;
        return arr;
    }
}
