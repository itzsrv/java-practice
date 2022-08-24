package streams.exercise;

import java.util.Arrays;

public class e_ArraysFilterSortPrint {
    
    public static void main(String[] args) {
        String[] names = {"Abraham", "Jack Sparrow", "James", "Captain America", "Amanda", "Wakanda", "Iron Man", "Batman", "Supreman"};

        Arrays.stream(names)
            .filter(p->p.startsWith("A"))
            .sorted()
            .forEach(System.out::println);
    }
}
