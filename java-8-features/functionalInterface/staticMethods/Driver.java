package functionalInterface.staticMethods;

public class Driver {
    
    public static void main(String[] args) {
        Dog dog = new Dog();

        
        dog.eat();                  //default method in Animal interface and Omnivore interface
        
        Dog.speak();                //static method in Animal interface and Dog Class       //Class method static access with Class name
        Animal.speak();             //Interface method static access with Interface name
    }
}
