package programmingquestions;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class CheckDuplicatesArray {
    public static void main(String[] args) {

        //int arr[] = {10,20,20,30,30,40,50,50,10};  

        int[] arr = {4,1,3,2,4,2,3,3,1,2,1,2,4,2,5,1,2,4};

        //int[] arr = {10,10,20,20,30,30,40,50,50,10};

        LinkedHashSet lhset = new LinkedHashSet<Integer>();

        for(int i = 0; i < arr.length; i++){
            lhset.add(arr[i]);
        }
    
        Integer[] newarr = (Integer[]) lhset.toArray(new Integer[lhset.size()]);

        int[] intArr = Arrays.stream(newarr).mapToInt(Integer::intValue).toArray();

        for(int i : intArr){
            System.out.print(i + " ");
        }

        

         
    }  
			
    
}