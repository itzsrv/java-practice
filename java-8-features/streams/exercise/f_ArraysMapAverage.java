package streams.exercise;

import java.util.Arrays;

public class f_ArraysMapAverage {
    
    public static void main(String[] args) {
        
        Arrays.stream(new int[] {2,4,8,6,10})
            .map(x->x*x)
            .average()
            .ifPresent(System.out::println);
    }
}
