package functionalInterface.staticMethods;

public interface Carnivore {
    default void eat(){
        System.out.println("eating flesh from Carnivore Interface");
    }
}
