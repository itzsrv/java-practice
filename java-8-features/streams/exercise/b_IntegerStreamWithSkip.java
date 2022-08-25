package streams.exercise;

import java.util.stream.IntStream;

public class b_IntegerStreamWithSkip {
    
    public static void main(String[] args) {
        
        IntStream
        .range(1,10)
        .skip(5)
        .forEach(System.out::print);
        
        
        System.out.println();
    }
}
