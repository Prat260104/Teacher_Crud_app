import java.util.*;

abstract class Product {
    int id;
    String name;
    double price;
    int quantity;
    Product(int id, String name, double price, int quantity) {
        this.id = id; this.name = name; this.price = price; this.quantity = quantity;
    }
    abstract void display();
}

class Electronics extends Product {
    int warrantyInMonths;
    Electronics(int id, String name, double price, int quantity, int warranty) {
        super(id, name, price, quantity);
        this.warrantyInMonths = warranty;
    }
    void display() {
        System.out.println(id + " | " + name + " | ₹" + price + " | " + quantity + " pcs | Warranty: " + warrantyInMonths + " months");
    }
}

class Grocery extends Product {
    String expiryDate;
    Grocery(int id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }
    void display() {
        System.out.println(id + " | " + name + " | ₹" + price + " | " + quantity + " pcs | Expiry: " + expiryDate);
    }
}

public class Question9 {
    public static void main(String[] args) {
        List<Product> inventory = new ArrayList<>();
        inventory.add(new Electronics(1, "Laptop", 50000, 10, 24));
        inventory.add(new Grocery(2, "Rice", 60, 100, "12/2025"));

        System.out.println("\nAll Products:");
        for (Product p : inventory) p.display();

        double total = 0;
        for (Product p : inventory) total += p.price * p.quantity;
        System.out.println("\nTotal Inventory Value: ₹" + total);
    }
}
