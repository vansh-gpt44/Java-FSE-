class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }
}

public class SortingOrders {

    // Bubble Sort
    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    static void display(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o.orderId + " " + o.customerName + " ₹" + o.totalPrice);
        }
    }

    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Aman", 2500),
                new Order(102, "Riya", 1200),
                new Order(103, "Vansh", 4500),
                new Order(104, "Neha", 1800)
        };

        System.out.println("Bubble Sort:");
        bubbleSort(orders);
        display(orders);

        Order[] orders2 = {
                new Order(101, "Aman", 2500),
                new Order(102, "Riya", 1200),
                new Order(103, "Vansh", 4500),
                new Order(104, "Neha", 1800)
        };

        System.out.println("\nQuick Sort:");
        quickSort(orders2, 0, orders2.length - 1);
        display(orders2);
    }
}
