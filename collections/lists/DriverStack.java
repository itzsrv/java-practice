package collections.lists;

import java.util.Stack;

public class DriverStack {
    
    public static void main(String[] args) {


        Stack<String> stack = new Stack<>();

        stack.add("saurav");  // Collection Interface method
        stack.add(1, "no"); // List Interface method


        stack.push(null);

        stack.push(null);

        stack.push(null);

        System.out.println(stack);

        System.out.println(stack.size());

        System.out.println(stack.capacity());


        stack.elements();   // Vector class method
        
        
        /*
         * 
         * main highlights for Stack methods
         * 
         * 
         * rest all methods that Collection Interface has
         * 
         *   ++ List Interface methods (having implemetations to support index based operations)
         * 
         *   ++ old methods with big names in Vector Class 
         * 
         *  
         *  E push(E item)
         *  E pop(E item)
         *  E peek(E item)
         *  boolean empty()
         *  int search(E item)      returns offset from the top of the stack starts from 1 or returns -1
         * 
         *  
         * 
         *  
         *  
         * 
         */
        
        /*
         * 
         * Constructors : 1
         * 
         * Stack<E> s = new Stack<>();
         */ 
    }
}
