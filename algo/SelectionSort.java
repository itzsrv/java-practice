package algo;

public class SelectionSort {
    
    public static int[] sort(int[] arr){
        
        // outer loop n-1 iteration
        for(int i=0;i<arr.length-1;i++){
            int smallestPos=i;

            // inner loop to pick smallest  
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[smallestPos])
                    smallestPos=j;
            }
            if(arr[smallestPos]<arr[i])
                swap(arr,smallestPos,i);

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
     * outer loop --> n-1 times
     * inner loop --> n
     * 
     * O(n^2)
     */
}
