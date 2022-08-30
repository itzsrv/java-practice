package printingpatterns;

public class HollowRectangle {
    /* 
    *****
    *   *
    *   *
    *****

    */

    // rows -> outer loops
    // columns -> inner loops

    // rows either 0
    // columns either 0
    // rows either upperlimit 3
    // columns either upperlimit 4
    // boundary is being tracked

    public static void main(String[] args) {
        for(int i=0; i<4; i++){
            for(int j=0; j<5; j++){
                // cell (i,j)

                if(i==0 || j==0 | i==3 || j==4)
                    System.out.print("*");
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
    }

}
