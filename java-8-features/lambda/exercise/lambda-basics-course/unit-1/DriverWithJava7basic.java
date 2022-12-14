import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DriverWithJava7basic {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Charles", "Dickens", 60),
            new Person("Lewis", "Carroll", 42),
            new Person("Thomas", "Carlyle", 51),
            new Person("Charlotte", "Bronte", 45),
            new Person("Matthew", "Arnold", 39)
        );

        //1. sort list by last name

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.toString());
            }
        });
        

        //2. create a method that prints all elements in the list
        printAll(people);

        //3. create a method that prints all people that have last name beginning with C
        printLastNameBeginningWithC(people);

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
}
