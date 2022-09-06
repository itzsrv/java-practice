package algo.recursion;

public class Recursion4 {

    /*
     * Fibonacci Sequence
     * 
     * a b c
     * c = a + b
     * 
     * 0 1 --> these are first 2 numbers in the sequence
     * 
     * 0 1 1 2 3 5 8 13
     * 
     * 
     * info given
     * a b and n
     * 
     * work
     * create the next term => c = a + b
     * 
     * base case
     * nth term
     * 
     */
    
    public static void main(String[] args) {
        System.out.print( "0 1 ");
        printFib(0,1, 5);
    }

    public static void printFib(int a, int b, int n){
        /*
         *  if(n==0)
         *      return ;
         * 
         * c = a + b
         * syso(c)
         * printFib(b,c,n-1)
         */

        if(n==0)
            return;

        int c = a + b;
        System.out.print(c + " ");
        printFib(b, c, n-1); 
    }
}
