import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DriverWithJava8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Carroll", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person("Charlotte", "Bronte", 45),
            new Person("Matthew", "Arnold", 39)
        );

        //1. sort list by last name
        
        System.out.println("Sorting all elements in list by their last Name");
        Collections.sort(people, (p1,  p2) -> p1.getLastName().compareTo(p2.toString()));
        

        //2. create a method that prints all elements in the list
        System.out.println("Printing all elements");
        //printAll(people);
        printConditionally(people, p -> true);
        

        //3. create a method that prints all people that have last name beginning with C
        
        System.out.println("Printing by passing condition where people have last name with C");
        printConditionally(people, (p) -> p.getLastName().startsWith("C"));

        System.out.println("Printing by passing condition where people have first name with C");
        printConditionally(people, (p) -> p.getFirstName().startsWith("C"));

    }

    public static void printAll(List<Person> people){
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void printConditionally(List<Person> persons, Condition condition){
        for (Person person : persons) {
            if(condition.test(person))
            System.out.println(person);
        }
    }
}


