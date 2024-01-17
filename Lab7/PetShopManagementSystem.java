import java.util.ArrayList;
import java.util.List;

class Pet {
    private String name;
    private String species;
    private int age;

    // Constructor
    public Pet(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                '}';
    }
}

public class PetShopManagementSystem {
    public static void main(String[] args) {
        // Create a list of pets
        List<Pet> petList = new ArrayList<>();
        petList.add(new Pet("Buddy", "Dog", 3));
        petList.add(new Pet("Whiskers", "Cat", 2));
        petList.add(new Pet("Nemo", "Fish", 1));

        // Use lambda expression to filter pets of a certain species
        List<Pet> dogs = filterPets(petList, pet -> pet.getSpecies().equals("Dog"));
        System.out.println("Dogs: " + dogs);

        // Use lambda expression to sort pets by age
        petList.sort((pet1, pet2) -> Integer.compare(pet1.getAge(), pet2.getAge()));
        System.out.println("Sorted by Age: " + petList);
    }

    // Lambda expression to filter pets based on a condition
    private static List<Pet> filterPets(List<Pet> petList, PetFilter filter) {
        List<Pet> result = new ArrayList<>();
        for (Pet pet : petList) {
            if (filter.test(pet)) {
                result.add(pet);
            }
        }
        return result;
    }

    // Functional interface for filtering pets
    @FunctionalInterface
    interface PetFilter {
        boolean test(Pet pet);
    }
}
