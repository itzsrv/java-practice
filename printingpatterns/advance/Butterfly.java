package printingpatterns.advance;

public class Butterfly {
    /*
       *             *
       * *         * *
       * * *     * * *
       * * * * * * * *
       * * * * * * * *
       * * *     * * *
       * *         * *
       *             *
     */

     //rows 8; increasing regular; 
     // columns max=8; dynamic;  { regular increasing 4, regular decreasing 4} ; on rows

     public static void main(String[] args) {
        int n =8;
    
        for(int i=0; i<n/2; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*"+" ");
            }
            for(int j=0; j<n+5-4*i;j++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1;j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        for(int i=n/2; i<n; i++){
            for(int j=0; j<n-i; j++){
                System.out.print("*" + " ");
            }
            for(int j=0; j<n+5-2*i-4;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        
     }
}
