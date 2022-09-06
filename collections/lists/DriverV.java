package collections.lists;

import java.util.Enumeration;
import java.util.Vector;

public class DriverV {
    
    public static void main(String[] args) {
        
        Vector<String> vector = new Vector<>();

        vector.addElement("saurav");
        vector.addElement("no");
        vector.addElement(null);
        vector.add(null);
        vector.add(null);

        System.out.println(vector.size());
        System.out.println(vector);
        

        //Enum enum1;
        




        System.out.println( vector.capacity());

        /*
         * 
         * main highlights for Vector methods
         * 
         * 
         * rest all methods that Collection Interface has
         * 
         *   ++ List Interface methods (having implemetations to support index based operations)
         * 
         *   ++ old methods with big names in Vector Class 
         * 
         *  void addElement(Object o)
         * 
         *  boolean removeElement(Object o)
         *  void removeElementAt(int index)
         *  void removeAllElements()
         * 
         *  E elementAt(int index)
         *  E firstElement()
         *  E lastElement()
         * 
         *  int size()
         *  int capacity()
         *  
         *  Enumeration<E> elements();
         */ 
            Enumeration enumeration = vector.elements();

            System.out.println(enumeration.hasMoreElements());
            System.out.println(enumeration.nextElement());

            
         /*  
         *  enumeration has below mehtods:
         *      boolean hasMoreElements()
         *      Object nextElement();
         *  
         * 
         */
        


        /*
         * 
         * Constructors : 3
         * 
         * Vector vector1 = new Vectory();
         * 
         * Vector vector2 = new Vectory(int initialCapacity);
         * 
         * Vector vector1 = new Vectory(int ic, int incrementalCap);
         * 
         * Vector vector1 = new Vectory(Collection c);
         */


    }
}
