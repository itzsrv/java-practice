package practice.Sept6.equalityCheck;

public class Driver {
    
    public static void main(String[] args) {
        

        // Lets clear equality check

        String person1 = new String();
        person1 = "Saurav";

        String person2 = new String("Gaurav");

        //System.out.println(person1);

        //System.out.println(person2);
        
        //System.out.println(person1.equals(person2));
        //false

        String person3 = "Saurav";

        String person4 = "Gaurav";

        //System.out.println(person3.equals(person1));

        //System.out.println(person4.equals(person2));

        String person5 = new String("Gaurav");

        System.out.println(person2.equals(person5));

        System.out.println(person2==person5);
        

        //equals checks object equality(string values in case of String instances) and == checks reference equality


        /*
         * 
         * 
         
                 Person p1 = new Person("Saurav", 28, "tanman");
                 Person p2 = new Person("Gaurav", 24, "manman");
                 Person p3 = new Person("Saurav", 4, "tanu");
                 Person p4 = new Person("Gaurav", 1, "manu");
         
                 System.out.println( p1.equals(p2));
         
                 System.out.println( p2.equals(p4));
         * 
         * 
         */

         //System.out.println(person2==person5);

    }
}
