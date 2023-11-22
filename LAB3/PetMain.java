import java.util.ArrayList;
import java.util.List;

// Abstract class representing a pet
abstract class Pet {
    private String name;
    private int age;

    // Constructor for initializing common attributes
    Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods for encapsulation
    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    // Abstract method for getting the category of the pet
    abstract String getCategory();
}

// Concrete class representing a Dog, inheriting from Pet
class Dog extends Pet {
    private String breed;

    // Constructor for initializing Dog-specific attributes
    Dog(String name, int age, String breed) {
        super(name, age); // calling the constructor of the base class (Pet)
        this.breed = breed;
    }

    // Overriding the getCategory method for Dogs
    String getCategory() {
        return "Dog - Breed: " + breed;
    }
}

// Concrete class representing a Cat, inheriting from Pet
class Cat extends Pet {
    private String furColor;

    // Constructor for initializing Cat-specific attributes
    Cat(String name, int age, String furColor) {
        super(name, age); // calling the constructor of the base class (Pet)
        this.furColor = furColor;
    }

    // Overriding the getCategory method for Cats
    String getCategory() {
        return "Cat - Fur Color: " + furColor;
    }
}

// Enum representing different categories of pets
enum PetCategory {
    DOG,
    CAT
}

// Final class representing a PetShop
final class PetShop {
    private List<Pet> inventory;

    // Constructor for initializing the PetShop
    PetShop() {
        this.inventory = new ArrayList<>();
    }

    // Method for adding a pet to the pet shop
    void addPet(Pet pet) {
        inventory.add(pet);
    }

    // Method for displaying all pets in the pet shop
    void displayPets() {
        for (Pet pet : inventory) {
            System.out.println("Name: " + pet.getName() + ", Age: " + pet.getAge() + ", Category: " + pet.getCategory());
        }
    }

    // Method for displaying pets by category
    void displayPetsByCategory(PetCategory category) {
        for (Pet pet : inventory) {
            if ((pet instanceof Dog && category == PetCategory.DOG) ||
                (pet instanceof Cat && category == PetCategory.CAT)) {
                System.out.println("Name: " + pet.getName() + ", Age: " + pet.getAge() + ", Category: " + pet.getCategory());
            }
        }
    }
}

// Example usage
public class PetMain {
    public static void main(String[] args) {
        PetShop myPetShop = new PetShop();
        Dog myDog = new Dog("Buddy", 3, "Golden Retriever");
        Cat myCat = new Cat("Whiskers", 2, "Calico");

        myPetShop.addPet(myDog);
        myPetShop.addPet(myCat);

        System.out.println("All Pets in the Pet Shop:");
        myPetShop.displayPets();

        System.out.println("\nDogs in the Pet Shop:");
        myPetShop.displayPetsByCategory(PetCategory.DOG);
    }
}
