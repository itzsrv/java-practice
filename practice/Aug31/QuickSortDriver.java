package practice.Aug31;

public class QuickSortDriver {
    public static void main(String[] args) {
        
        int[] arr = {6,3,9,5,2,8};

        //int[] arr2 = new int[]{6,3,9,5,2,8};

        System.out.print("Initial Array : ");
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();

        int[] sortedarr = QuickSort2.sort(arr, 0, arr.length-1);

        System.out.print("Sorted Array  : ");
        for (int i : sortedarr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}
