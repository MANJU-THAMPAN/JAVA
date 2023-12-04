package petshop.pets;

import petshop.interfaces.Pet;

public class Dog implements Pet {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats bones");
    }

    @Override
    public void move() {
        System.out.println("Dog runs");
    }
}