import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    public String toString() {
        return productId + " " + productName +
               " Qty:" + quantity + " Price:" + price;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {

        HashMap<Integer, Product> inventory = new HashMap<>();
        inventory.put(101, new Product(101, "Laptop", 10, 50000));
        inventory.get(101).quantity = 15;
        inventory.remove(101);
        System.out.println(inventory);
    }
}