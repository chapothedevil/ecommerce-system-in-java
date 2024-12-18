import java.util.ArrayList;
import java.util.List;

// Define the Product class
class Product {
    private String productName;
    private int productID;
    private double price;

    // Constructor
    public Product(String productName, int productID, double price) {
        this.productName = productName;
        this.productID = productID;
        this.price = price;
    }

    // Getter and Setter methods
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

// Define the ShoppingCart class
class ShoppingCart {
    private List<Product> items;

    // Constructor
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to add an item
    public void addItem(Product product) {
        items.add(product);
    }

    // Method to remove an item
    public void removeItem(Product product) {
        items.remove(product);
    }

    // Method to checkout
    public Order checkout() {
        int orderID = (int) (Math.random() * 1000); // Generate a random order ID
        Order order = new Order(orderID, new ArrayList<>(items));
        items.clear(); // Clear the cart after checkout
        return order;
    }
}

// Define the Order class
class Order {
    private int orderID;
    private List<Product> products;
    private double totalAmount;

    // Constructor
    public Order(int orderID, List<Product> products) {
        this.orderID = orderID;
        this.products = products;
        this.totalAmount = computeTotalAmount();
    }

    // Compute total amount
    private double computeTotalAmount() {
        double total = 0;
        for (Product product : products) {  // For each loop to iterate through
            total += product.getPrice();    // the products in cart and sum up the price
        }
        return total;
    }

    // Getter and Setter methods
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        this.totalAmount = computeTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

// Define the Customer class
class Customer {
    private String customerName;
    private int customerID;
    private ShoppingCart cart;

    // Constructor
    public Customer(String customerName, int customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.cart = new ShoppingCart();
    }

    // Getter and Setter methods
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}

// Main class
public class ECommerceSystem {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product("Laptop", 101, 1200.50);
        Product product2 = new Product("Smartphone", 102, 800.00);
        Product product3 = new Product("Headphones", 103, 150.75);

        // Create a customer
        Customer customer = new Customer("Margarito", 1);

        // Add products to the customer's shopping cart
        customer.getCart().addItem(product1);
        customer.getCart().addItem(product2);
        customer.getCart().addItem(product3);

        // Customer checks out
        Order order = customer.getCart().checkout();

        // Print order details
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Products in the order:");
        for (Product product : order.getProducts()) {
            System.out.println("- " + product.getProductName() + ": $" + product.getPrice());
        }
        System.out.println("Total Amount: $" + order.getTotalAmount());
    }
}
