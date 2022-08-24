package functionalInterface.staticMethods;

public class Driver {
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        Dog.speak();                //Class method static access with Class name
        Animal.speak();             //Interface method static access with Interface name
    }
}
