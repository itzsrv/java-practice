package printingpatterns;

public class InvertedHalfPyramidWithNumbers {

    /*
       1 2 3 4 5
       1 2 3 4
       1 2 3 
       1 2 
       1 

     */
    public static void main(String[] args) {
        
        // rows = 5
        // columns = dynamic --> dependent on rows; min row max column; column decreasing as row increasing

        int n = 5;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i;j++){
                System.out.print(j+ 1 + " ");
            }
            System.out.println();
        }
    }
}
