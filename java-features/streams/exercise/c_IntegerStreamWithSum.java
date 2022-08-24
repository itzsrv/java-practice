package streams.exercise;

import java.util.stream.IntStream;

public class c_IntegerStreamWithSum {
    
    public static void main(String[] args) {
        
        System.out.println(
            IntStream
            .range(1,5)
            .sum()
        );
        System.out.println();
    }
}
