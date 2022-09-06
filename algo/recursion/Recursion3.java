package algo.recursion;

public class Recursion3 {
    
    public static void main(String[] args) {

        printFactorial(1, 5, 1);

        int factorial = calcFactorial(5);
        System.out.println(factorial);
    }

    public static void printFactorial(int i, int n, int product){

        if(i==n){
            product *= i;
            System.out.println(product);
            return;
        }

        product *= i;
        printFactorial(i+1, n, product);

    }

    public static int calcFactorial(int n){

        if(n==1 || n==0)
            return 1;

        int factorialnm1 = calcFactorial(n-1);
        int factorialn = n * factorialnm1;

        return factorialn;
    }
}
