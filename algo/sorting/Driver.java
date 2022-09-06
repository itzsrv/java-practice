package algo.sorting;

public class Driver {
    
    public static void main(String[] args) {
        
        //int[] arr = {7,8,3,1,2};
        int[] anotherarr = {6,3,9,5,2,8};

        System.out.print("Initial Array : ");
        for (int i : anotherarr) {
            System.out.print(i+ " ");
        }
        System.out.println();


        //int[] sortedarr = BubbleSort.sort(arr);
        //int[] sortedarr = SelectionSort.sort(arr);
        //int[] sortedarr = InsertionSort.sort(arr);

        
        //int[] sortedarr = MergeSort.sort(anotherarr);

        int[] sortedarr = QuickSort.sort(anotherarr, 0, anotherarr.length-1);

        System.out.print("Sorted Array  : ");
        for (int i : sortedarr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }


    
}
