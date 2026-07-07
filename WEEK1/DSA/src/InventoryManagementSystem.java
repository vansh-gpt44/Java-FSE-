import java.util.HashMap;

class Prod {
    int productId;
    String productName;
    int quantity;
    double price;

    Prod(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " " + productName + " Qty:" + quantity + " Price:" + price;
    }
}

public class InventoryManagementSystem {

    public static void main(String[] args) {

        HashMap<Integer, Prod> inventory = new HashMap<>();


        inventory.put(101, new Prod(101, "Laptop", 10, 50000));
        inventory.put(102, new Prod(102, "Mouse", 25, 500));


        System.out.println("Inventory:");
        System.out.println(inventory);

        inventory.put(101, new Prod(101, "Laptop", 15, 52000));
        System.out.println("\nAfter Update:");
        System.out.println(inventory);

        inventory.remove(102);
        System.out.println("\nAfter Delete:");
        System.out.println(inventory);
    }
}
