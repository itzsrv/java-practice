package functionalInterface.staticMethods;

public interface Omnivore {
    default void eat(){
        System.out.println("eating flesh and plants both from Omnivore Interface");
    }
}
