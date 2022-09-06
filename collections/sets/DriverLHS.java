package collections.sets;

import java.util.LinkedHashSet;

public class DriverLHS {
    
    public static void main(String[] args) {
        
        LinkedHashSet<String> lhSet = new LinkedHashSet<>();

        lhSet.add("saurav");
        lhSet.add("no");
        lhSet.add(null);
        lhSet.add("saurav");
        lhSet.add(null);

        System.out.println(lhSet.add("check"));
        System.out.println(lhSet.add("saurav"));

        System.out.println(lhSet);
        // Insertion order is preserved

         /*
         * 
         * main highlights for LinkedHashSet methods
         * 
         * 
         * all methods that Collection Interface has
         * 
         *   - no methods in Set Interface
         *   - no methods in LinkedHashSet class as well
         */
        
         
        /* 
         * Constructors
         */ 

    }
}
