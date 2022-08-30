package printingpatterns;

public class ReverseHalfPyramid {


    /*
     * * * *
     * * *
     * *
     * 
     */
    public static void main(String[] args) {
        
        // rows = 4
        // columns = dynamic --> dependent on row; min row then max column

        for(int i=0; i<4; i++){
            for(int j=0; j<4-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
