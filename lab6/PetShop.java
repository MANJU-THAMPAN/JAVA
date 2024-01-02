class Pet<T> {
    private T details;

    public Pet(T details) {
        this.details = details;
    }

    public T getDetails() {
        return details;
    }
}

interface Customer<T> {
    T getCustomerDetails();
}

class Order<T> {
    private T orderDetails;

    public Order(T orderDetails) {
        this.orderDetails = orderDetails;
    }

    public T getOrderDetails() {
        return orderDetails;
    }
}

class PetShop {
    public static void main(String[] args) {
        // Generic Pet
        Pet<String> dog = new Pet<>("Breed: Labrador, Age: 2 years");

        // Generic Customer
        class BasicCustomer implements Customer<String> {
            public String getCustomerDetails() {
                return "Name: John Doe, Email: john@example.com";
            }
        }

        // Generic Order
        Order<Integer> petFoodOrder = new Order<>(12345);

        // Example usage with concrete types
        System.out.println("Pet Details: " + dog.getDetails());

        BasicCustomer customer = new BasicCustomer();
        System.out.println("Customer Details: " + customer.getCustomerDetails());

        System.out.println("Order Details: " + petFoodOrder.getOrderDetails());
    }
}
