package collections.lists;

import java.util.LinkedList;

public class DriverLL {

    public static void main(String[] args) {
        
        LinkedList<String> llist = new LinkedList<>();

        llist.add("saurav");
        llist.add("no");

        llist.add(null);
        llist.add(null);
        llist.add(null);

        System.out.println(llist);
        
    
        /*
         * 
         * main highlights for LinkedList methods
         * 
         * 
         * rest all methods that Collection Interface has
         * 
         *   ++ List Interface methods (having implemetations to support index based operations)
         * 
         *   ++ 6 extra special methods in LinkedList Class 
         * 
         *  void addFirst(Object o)
         *  void addLast(Object o)
         *  Object getFirst()
         *  Object getLast()
         *  Object removeFirst()
         *  Object removeLast()
         */
        
        /*
         * 
         * Constructors : 2
         * 
         */

        LinkedList llist1 = new LinkedList<>();

        LinkedList llist2 = new LinkedList<>(llist);

    }


}
