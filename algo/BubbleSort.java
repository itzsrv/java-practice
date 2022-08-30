package algo;

public class BubbleSort {

    public static int[] sort(int[] arr) {

        // outer loop for n-1 iterations
        for(int i=0; i<arr.length-1;i++){

            // inner loop for n-1 decreasing (with row (-i)) comparisions
            for(int k=0;k<arr.length-1-i;k++){
                if (arr[k]>arr[k+1])
                    swap(arr,k,k+1);
            }
            System.out.print("Iteration "+ (i+1)+ " : ");
            for (int a : arr) {
                System.out.print(a+ " ");
            }
            System.out.println();
        }

        return arr;
    }

    public static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }


    /*
     * time complexity
     * 
     * outer loop -> n-1 times
     * inner loop -> n, n-1, n-2, 1
     * 
     * O(n^2)
     * 
     * not a good sorting actually
     * 
     * there are other sorting techniques with ( n logn ) time complexity available
     * 
     */
}
