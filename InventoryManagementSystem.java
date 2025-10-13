
class Product {
    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + 
                           ", Price: " + price + ", Stock: " + quantity);
    }
}


class Warehouse {
    Product[] products;
    int size;

    Warehouse(int capacity) {
        products = new Product[capacity];
        size = 0;
    }

    void addProduct(Product p) {
        if (size < products.length) {
            products[size++] = p;
        } else {
            System.out.println("Warehouse is full! Cannot add more products.");
        }
    }

    Product findProductById(int id) {
        for (int i = 0; i < size; i++) {
            if (products[i].id == id) {
                return products[i];
            }
        }
        return null;
    }

    void displayAllProducts() {
        System.out.println("\n--- Warehouse Stock ---");
        for (int i = 0; i < size; i++) {
            products[i].display();
        }
    }
}


class Order {
    Product[] orderedProducts;
    int[] orderedQuantities;
    int count;
    Warehouse warehouse;

    Order(Warehouse warehouse, int maxItems) {
        this.warehouse = warehouse;
        orderedProducts = new Product[maxItems];
        orderedQuantities = new int[maxItems];
        count = 0;
    }

    void addToOrder(int productId, int quantity) {
        Product p = warehouse.findProductById(productId);
        if (p == null) {
            System.out.println("Product ID " + productId + " not found!");
            return;
        }

        if (p.quantity >= quantity) {
            orderedProducts[count] = p;
            orderedQuantities[count] = quantity;
            count++;
            System.out.println(quantity + " x " + p.name + " added to order.");
        } else {
            System.out.println("Not enough stock for " + p.name);
        }
    }

    void confirmOrder() {
        double total = 0;
        System.out.println("\n--- Order Summary ---");
        for (int i = 0; i < count; i++) {
            Product p = orderedProducts[i];
            int q = orderedQuantities[i];
            p.quantity -= q; // reduce stock
            double subtotal = p.price * q;
            total += subtotal;
            System.out.println(p.name + " x " + q + " = " + subtotal);
        }
        System.out.println("Total Amount: " + total);
    }
}


public class InventoryManagementSystem {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(5);

        warehouse.addProduct(new Product(1, "Laptop", 55000, 10));
        warehouse.addProduct(new Product(2, "Phone", 30000, 5));
        warehouse.addProduct(new Product(3, "Mouse", 500, 20));

        warehouse.displayAllProducts();

        Order order = new Order(warehouse, 3);
        order.addToOrder(1, 2); 
        order.addToOrder(3, 5);  
        order.addToOrder(2, 6); 

        order.confirmOrder();

        warehouse.displayAllProducts();
    }
}
