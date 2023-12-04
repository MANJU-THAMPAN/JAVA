
package petshop.pets;

import petshop.interfaces.Pet;

public class Cat implements Pet {
    @Override
    public void makeSound() {
        System.out.println("Cat meows");
    }

    @Override
    public void eat() {
        System.out.println("Cat eats fish");
    }

    @Override
    public void move() {
        System.out.println("Cat walks");
    }
}
