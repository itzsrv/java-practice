package printingpatterns;

public class HalfPyramid {


    /*
     * 
     * *
     * * *
     * * * *
     */
    public static void main(String[] args) {

        // rows = 4;
        // columns = dynamic --> first row 1, second row 2, third row 3 --> dependent on row, condition: row + 1 
        for(int i=0; i<4; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
