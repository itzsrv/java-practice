package streams.exercise;

import java.util.stream.Stream;

public class d_StreamOfSortedFindFirst {
    
    public static void main(String[] args) {
        Stream.of("Amazon","Amsterdam","Alaska")
            .sorted()           //can pass Comparator
            .findFirst()
            .ifPresent(System.out::println);;
    }
}
