package algo.sorting;

public class QuickSort {
    

    //recursive function

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
        int i = low-1;

        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                //swap 
                swap(arr,j,i);
                // int temp = arr[i];
                // arr[i] = arr[j];
                // arr[j] = temp;
            }
        }
        i++;

        //swap
        swap(arr,i,high);
        
        
        return i;
    }

    public static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }
}
