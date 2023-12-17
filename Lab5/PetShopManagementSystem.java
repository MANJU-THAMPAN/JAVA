import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Pet {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Inventory {
    private List<Pet> pets;

    public Inventory() {
        this.pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }
    }
}

class Order {
    private String customerName;
    private Pet pet;

    public Order(String customerName, Pet pet) {
        this.customerName = customerName;
        this.pet = pet;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Pet getPet() {
        return pet;
    }
}

class OrderProcessor implements Runnable {
    private Inventory inventory;
    private Order order;

    public OrderProcessor(Inventory inventory, Order order) {
        this.inventory = inventory;
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("Processing order for " + order.getCustomerName() + " - " + order.getPet().getName());
        // Simulate order processing time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inventory.removePet(order.getPet());
        System.out.println("Order processed for " + order.getCustomerName() + " - " + order.getPet().getName());
    }
}

public class PetShopManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addPet(new Pet("Dog"));
        inventory.addPet(new Pet("Cat"));
        inventory.addPet(new Pet("Fish"));

        inventory.displayInventory();

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Customer1", new Pet("Dog")));
        orders.add(new Order("Customer2", new Pet("Cat")));
        orders.add(new Order("Customer3", new Pet("Fish")));

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Order order : orders) {
            executorService.execute(new OrderProcessor(inventory, order));
        }

        executorService.shutdown();
    }
}
