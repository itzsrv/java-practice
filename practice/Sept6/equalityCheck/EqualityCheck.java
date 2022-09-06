package practice.Sept6.equalityCheck;

public class EqualityCheck {
    public static void main(String[] args) {
        
        String s1 = new String("Test");

        String s2 = new String("Test");

        System.out.println(s1.equals(s2));
        // true

        System.out.println(s1==s2);
        //false
    }
}
