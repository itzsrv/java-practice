package printingpatterns;

public class Triangle01 {
    

    /*
       1
       0 1
       1 0 1
       0 1 0 1
       1 0 1 0 1


     */


     public static void main(String[] args) {
         //rows increasing normal max = 5
         //columns increasing dependent on row, max = 5

         int n = 5;

         for( int i=0; i<n; i++){
            for(int j=0; j<i+1; j++){
                if( (i + j) % 2 ==0)
                    System.out.print("1" + " ");
                else  
                    System.out.print("0" + " ");
            }
            System.out.println();
         }
     }
}
