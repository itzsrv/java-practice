package printingpatterns;

public class InvertedHalfPyramid {
    
    /*
           *
         * * 
       * * *
     * * * * 
     */

    public static void main(String[] args) {
        // rows = 4
        // columns = max 4; when row min, column only max
        
        for(int i=0; i<4; i++){
            for(int j=0; j<4-i-1;j++){
                System.out.print(" ");
            }
            for(int j=0; j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
