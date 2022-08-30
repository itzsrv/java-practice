package algo;

public class Driver {
    
    public static void main(String[] args) {
        
        int[] arr = {7,8,3,1,2};
        //int[] mergearr = {6,3,9,5,2,8};

        System.out.print("Initial Array : ");
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();


        //int[] sortedarr = BubbleSort.sort(arr);
        //int[] sortedarr = SelectionSort.sort(arr);
        //int[] sortedarr = InsertionSort.sort(arr);

        
        int[] sortedarr = MergerSort.sort(arr);

        System.out.print("Sorted Array  : ");
        for (int i : sortedarr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }


    
}
