class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    // Linear Search
    static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id)
                return p;
        }
        return null;
    }

    // Binary Search
    static Product binarySearch(Product[] products, int id) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (products[mid].productId == id)
                return products[mid];
            else if (products[mid].productId < id)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {

        // Sorted array (required for Binary Search)
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Book", "Education")
        };

        int searchId = 104;

        Product p1 = linearSearch(products, searchId);
        System.out.println("Linear Search:");
        if (p1 != null)
            System.out.println(p1.productId + " " + p1.productName + " " + p1.category);
        else
            System.out.println("Product Not Found");

        Product p2 = binarySearch(products, searchId);
        System.out.println("\nBinary Search:");
        if (p2 != null)
            System.out.println(p2.productId + " " + p2.productName + " " + p2.category);
        else
            System.out.println("Product Not Found");
    }
}
