package functionalInterface.staticMethods;

public interface Animal {
    
    public default void eat(){
        System.out.println("eating from Animal Interface");
    }

    public static void speak(){
        System.out.println("speaking from Animal Interface");
    };
}
