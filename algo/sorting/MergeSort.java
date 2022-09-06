package algo.sorting;

public class MergeSort {

    public static int[] sort(int[] arr) {
        divide(arr, 0, arr.length-1);
        return arr;
    }

    public static void divide(int[] arr, int si, int ei){
        //int mid = (si + ei) / 2;
        int mid = si + (ei - si)/2;

        if(si >= ei){
            return;
        }

        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr, si, mid, ei);

    }

    private static void conquer(int[] arr, int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];

        int index1=si;

        int index2=mid+1;

        int x = 0;

        while(index1<=mid && index2<=ei){
            if(arr[index1]<=arr[index2]){
                merged[x] = arr[index1];
                x++;
                index1++;
            }
            else {
                merged[x]=arr[index2];
                x++;
                index2++;
            }
        }

        while(index1<=mid){
            merged[x] = arr[index1];
            x++;
            index1++;
        }

        while(index2<=ei){
            merged[x]=arr[index2];
            x++;
            index2++;            
        }


        for(int i=0,j=si; i<merged.length; i++,j++){
            arr[j]=merged[i];
        }

    }

    /*
     * 
     * time complexity
     * 
     * O(n log n )
     * 
     * 
     * O(log n) from division 
     * O(n) from conquer
     */
    

}
