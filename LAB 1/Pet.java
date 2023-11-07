// Define the Pet class
public class Pet {
    // Define the data members of the class
    private String name;
    private int age;
    private String breed;
    private float price;

    // Define the default constructor
    public Pet() {
        name = "";
        age = 0;
        breed = "";
        price = 0.0f;
    }

    // Define the parameterized constructor with all data members
    public Pet(String name, int age, String breed, float price) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.price = price;
    }

    // Define the parameterized constructor with name, age, and breed
    public Pet(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.price = 0.0f;
    }

    // Define the method to set the name of the pet
    public void set_name(String name) {
        this.name = name;
    }

    // Define the method to set the age of the pet
    public void set_age(int age) {
        this.age = age;
    }

    // Define the method to set the breed of the pet
    public void set_breed(String breed) {
        this.breed = breed;
    }

    // Define the method to set the price of the pet
    public void set_price(float price) {
        this.price = price;
    }

    

   
    // Define the method to get the name of the pet
    public String get_name() {
        return name;
    }

    // Define the method to get the age of the pet
    public int get_age() {
        return age;
    }

    // Define the method to get the breed of the pet
    public String get_breed() {
        return breed;
    }

    // Define the method to get the price of the pet
    public float get_price() {
        return price;
    }

public static void main(String[] args) {
    // Create a new pet object using the default constructor
    Pet pet1 = new Pet();

    // Set the data members of the pet object
    pet1.set_name("Fluffy");
    pet1.set_age(2);
    pet1.set_breed("Persian");
    pet1.set_price(100.0f);

    // Print the details of the pet object
    System.out.println("Name: " + pet1.get_name());
    System.out.println("Age: " + pet1.get_age());
    System.out.println("Breed: " + pet1.get_breed());
    System.out.println("Price: " + pet1.get_price());

    // Create a new pet object using the parameterized constructor
    Pet pet2 = new Pet("Max", 3, "Labrador", 200.0f);

    // Print the details of the pet object
    System.out.println("Name: " + pet2.get_name());
    System.out.println("Age: " + pet2.get_age());
    System.out.println("Breed: " + pet2.get_breed());
    System.out.println("Price: " + pet2.get_price());

    // Call the overloaded method to set the price of the pet object
    pet2.set_price(10.0f);

    // Print the details of the pet object
    System.out.println("Name: " + pet2.get_name());
    System.out.println("Age: " + pet2.get_age());
    System.out.println("Breed: " + pet2.get_breed());
    System.out.println("Price: " + pet2.get_price());
}}



