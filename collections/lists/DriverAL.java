package collections.lists;

import java.util.ArrayList;

public class DriverAL {
    
    public static void main(String[] args) {
        
        //some operations you wanna check
        ArrayList<String> alist = new ArrayList<>();

        System.out.println(alist.size());

        alist.add("saurav");

        System.out.println(alist.size());

        //alist.add(5, "no"); //error

        alist.add(1, "no");

        alist.add(null);
        alist.add(null);
        alist.add(null);

        // now only possible max index to use in add is 2

        //alist.add(1, "might throw error");
        
        System.out.println(alist.size());
        System.out.println(alist.get(1));

        System.out.println(alist);

        //System.out.println(alist.get(2));  error


        /*
         *
         * main highlights for ArrayList methods
         * 
         * 
         * rest all methods that Collection Interface has
         * 
         *   ++ List Interface methods (having implemetations to support index based operations)
         * 
         *   no extra special methods in ArrayList Class
         *  
         * 
         * coming from List Interface (having implemetations to support index based operations)
         * 
         * add(index, element)
         * get(index)
         * listIterator(), with index
         * set(index, element)
         * sort(comparator)
         * 
         * other index based improvements on existing methods from Collection Interface
         * 
         * 
         * indexOf(Object o)
         * 
         * lastIndexOf(Object o)
         * 
         */



        /*
         *
         * constructors : 3
         *
         */

        ArrayList list1 = new ArrayList<>();

        ArrayList list2 = new ArrayList<>(20);

        ArrayList list3 = new ArrayList<>(alist);


        /*
         * 
         * 
         * List anotherList = Collections.synchronizedList(list1);
         */

        
        
    }
    
    

}
