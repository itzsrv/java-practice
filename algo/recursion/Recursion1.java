package algo.recursion;

public class Recursion1 {
    
    public static void main(String[] args) {
        printNumb(5);
    }

    public static void printNumb(int n){
        if(n==0)
        return;

        System.out.println(n);
        printNumb(n-1);
    }
}
