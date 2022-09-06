package collections.sets;

import java.util.TreeSet;

public class DriverTS {
    
    public static void main(String[] args) {
        
        TreeSet tset = new TreeSet<>();

        tset.add("saurav");
        tset.add("no");
        //tset.add(null);         
        //tset.add(null);

        System.out.println(tset.add("saurav"));
        System.out.println(tset.add("check"));

        System.out.println(tset);

        /*
         * 
         * Exception in thread "main" java.lang.NullPointerException
                at java.base/java.util.Objects.requireNonNull(Objects.java:208)
                at java.base/java.util.TreeMap.put(TreeMap.java:809)
                at java.base/java.util.TreeMap.put(TreeMap.java:534)
                at java.base/java.util.TreeSet.add(TreeSet.java:255)
                at collections.sets.DriverTS.main(DriverTS.java:13)
         */


         System.out.println(tset.first());
         System.out.println(tset.last());
         System.out.println(tset.pollLast());
         System.out.println(tset.comparator());
         System.out.println(tset.headSet("no"));
         System.out.println(tset.tailSet("no"));
         System.out.println(tset.subSet("no", "saurav"));

         /*
          * 
          * constructors : 4
          *
          */

          TreeSet tset1 = new TreeSet<>();

          //TreeSet tset2 = new TreeSet<>(comparator)

          TreeSet tset3 = new TreeSet<>(tset);

          //TreeSet tset4 = new TreeSet(SortedSet s);

    }
}
