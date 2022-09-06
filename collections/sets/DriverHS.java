package collections.sets;

import java.util.HashSet;

public class DriverHS {
    
    public static void main(String[] args) {
        



        HashSet<String> hset = new HashSet<>();

        hset.add("saurav");
        hset.add("no");
        hset.add(null);
        hset.add("saurav");
        hset.add(null);

        System.out.println(hset.add("check"));
        System.out.println(hset.add("saurav"));


        System.out.println(hset);
        

        /*
         * 
         * main highlights for HashSet methods
         * 
         * 
         * all methods that Collection Interface has
         * 
         *   - no methods in Set Interface
         *   - no methods in HashSet class as well
         */
        
         
        /* 
         * Constructors
         */ 

        HashSet hset1 = new HashSet<>();

        //HashSet hset2 = new HashSet<>(int initialCapacity);    //default 16

        //HashSet hset3 = new HashSet<>(int initialCap, float, loadfactor);             // default 16, 0.75

        HashSet hset4 = new HashSet<>(hset);

    }
}
