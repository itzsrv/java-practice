import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DriverWithJava7 {
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
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.toString());
            }
        });
        

        //2. create a method that prints all elements in the list
        System.out.println("Printing all elements");
        printAll(people);
        

        //3. create a method that prints all people that have last name beginning with C
        System.out.println("Printing all people having last name with C");
        printLastNameBeginningWithC(people);
        
        System.out.println("Printing by passing condition where people have last name with C");
        printConditionally(people, new Condition() {
            public boolean test(Person p){
                return p.getLastName().startsWith("C");
            }
        });

        System.out.println("Printing by passing condition where people have first name with C");
        printConditionally(people, new Condition() {
            public boolean test(Person p){
                return p.getFirstName().startsWith("C");
            }
        });

    }

    public static void printAll(List<Person> people){
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void printLastNameBeginningWithC(List<Person> persons){
        for (Person person : persons) {
            if(person.getLastName().startsWith("C"))
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


