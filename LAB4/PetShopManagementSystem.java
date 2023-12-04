import petshop.interfaces.Pet;
import petshop.pets.Dog;
import petshop.pets.Cat;

public class PetShopManagementSystem {
    public static void main(String[] args) {
        // Create instances of pets
        Pet dog = new Dog();
        Pet cat = new Cat();

        // Perform actions on pets
        System.out.println("Pet 1:");
        dog.makeSound();
        dog.eat();
        dog.move();

        System.out.println("\nPet 2:");
        cat.makeSound();
        cat.eat();
        cat.move();
    }
}