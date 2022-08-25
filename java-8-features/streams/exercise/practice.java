package streams.exercise;

import java.util.Arrays;
import java.util.List;

public class practice {
    
    public static void main(String[] args) {
        
        Arrays.stream(new int[] {2,4,8,6,10})
            .average()
            .ifPresent(System.out::println);

        List<String> people = Arrays.asList("Abraham", "Jack Sparrow", "James", "Captain America", "Amanda", "Wakanda", "Iron Man", "Batman", "Supreman");

        people.stream()
            .map(String::toLowerCase)
            .filter(p->p.startsWith("a"))

            ;
            
        // Arrays.stream(new int[] {2,4,8,6,10})
        //     .map(p->p*p)
        //     .
        
    }
    

}
