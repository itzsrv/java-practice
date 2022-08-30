package algo;

public class InsertionSort {
    
    public static int[] sort(int[] arr){

        for(int i=1; i<arr.length;i++){
            int current=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>current){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=current;



            System.out.print("Iteration "+ (i)+ " : ");
            for (int a : arr) {
                System.out.print(a+ " ");
            }
            System.out.println();
        }

        /*
     * 
     * 
     * time complexity
     * 
     * loop -> 2
     * 
     * O(n^2)
     */

        return arr;
    } 
}
