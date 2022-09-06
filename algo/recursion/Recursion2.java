package algo.recursion;

public class Recursion2 {
    
    public static void main(String[] args) {
        
       printSum(1, 5, 0);
    }

    public static void printSum(int i, int n, int sum){
        

        if (i == n){
            sum = sum +i;
            System.out.println(sum);
            return ;
        }
        
        // 1. work
        sum += i;

        
        printSum(i+1, n, sum);
    }

}
