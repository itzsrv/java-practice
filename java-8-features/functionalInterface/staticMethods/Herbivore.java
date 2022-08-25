package functionalInterface.staticMethods;

public interface Herbivore {
    default void eat(){
        System.out.println("eating plants from Herbivore Interface");
    }
}
