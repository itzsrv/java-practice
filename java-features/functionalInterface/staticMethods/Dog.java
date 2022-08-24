package functionalInterface.staticMethods;

public class Dog implements Animal, Omnivore {

    
    // public void eat() {    
    //     Omnivore.super.eat();
    //     Animal.super.eat();
    // }

    public static void speak(){
        System.out.println("bark from Dog's static speak()");
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        Animal.super.eat();
    };

    
}
