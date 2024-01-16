import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Pet {
    private String name;
    private String species;
    private double price;

    public Pet(String name, String species, double price) {
        this.name = name;
        this.species = species;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return name.equals(pet.name) && species.equals(pet.species);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + species.hashCode();
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + "', species='" + species + "', price=" + price + '}';
    }
}

class Inventory {
    private Map<Pet, Integer> stock;       // Map to store pet stock by Pet object
    private Set<String> uniqueSpecies;     // Set to store unique pet species
    private List<Pet> pets;                // List to store all pets

    public Inventory() {
        this.stock = new HashMap<>();
        this.uniqueSpecies = new HashSet<>();
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet, int quantity) {
        pets.add(pet);
        stock.put(pet, stock.getOrDefault(pet, 0) + quantity);
        uniqueSpecies.add(pet.getSpecies());
    }

    public void removePet(Pet pet, int quantity) {
        if (stock.containsKey(pet)) {
            int currentQuantity = stock.get(pet);
            if (currentQuantity - quantity <= 0) {
                stock.remove(pet);
                pets.remove(pet);
                uniqueSpecies.remove(pet.getSpecies());
            } else {
                stock.put(pet, currentQuantity - quantity);
            }
        }
    }

    public void displayInventory() {
        System.out.println("Pet Inventory:");
        for (Pet pet : pets) {
            int quantity = stock.get(pet);
            System.out.println(pet + " - Quantity: " + quantity);
        }
        System.out.println("Unique Species: " + uniqueSpecies);
    }
}

class PetShop {
    private String shopName;
    private Inventory inventory;

    public PetShop(String shopName) {
        this.shopName = shopName;
        this.inventory = new Inventory();
    }

    public void addPetToInventory(Pet pet, int quantity) {
        inventory.addPet(pet, quantity);
    }

    public void removePetFromInventory(Pet pet, int quantity) {
        inventory.removePet(pet, quantity);
    }

    public void displayPetShopInventory() {
        System.out.println("Welcome to " + shopName);
        inventory.displayInventory();
    }

    public static void main(String[] args) {
        PetShop myPetShop = new PetShop("My Pet Shop");

        Pet dog = new Pet("Buddy", "Dog", 500.0);
        Pet cat = new Pet("Whiskers", "Cat", 300.0);

        myPetShop.addPetToInventory(dog, 5);
        myPetShop.addPetToInventory(cat, 3);

        myPetShop.displayPetShopInventory();

        myPetShop.removePetFromInventory(dog, 2);

        myPetShop.displayPetShopInventory();
    }
}
