package streams.exercise;

import java.util.Arrays;
import java.util.List;

public class g_ListMapFilter {
    
    public static void main(String[] args) {
        
        List<String> people = Arrays.asList("Abraham", "Jack Sparrow", "James", "Captain America", "Amanda", "Wakanda", "Iron Man", "Batman", "Supreman");

        people.stream()
            .map(p->p.toLowerCase())
            .filter(p->p.startsWith("a"))
            .forEach(System.out::println);
        
    }
}
