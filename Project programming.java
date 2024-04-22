import java.util.Scanner;

// Product class
class Product {
    protected int productId;
    protected String name;
    protected float price;

    // Constructor
    public Product(int productId, String name, float price) {
        this.productId = Math.abs(productId);
        this.name = name;
        this.price = Math.abs(price);
    }

    // Setters and getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public float getPrice(){
        return price;
    }
}

// ElectronicProduct class
class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    // Constructor
    public ElectronicProduct(int productId, String name, float price, String brand, int warrantyPeriod) {
        super(productId, name, price);
        this.brand = brand;
        this.warrantyPeriod = Math.abs(warrantyPeriod);
    }

    // Setters and getters
    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }
}

// ClothingProduct class
class ClothingProduct extends Product {
    private String size;
    private String fabric;

    // Constructor
    public ClothingProduct(int productId, String name, float price, String size, String fabric) {
        super(productId, name, price);
        this.size = size;
        this.fabric = fabric;
    }

    // Setters and getters
    public String getSize() {
        return size;
    }

    public String getFabric() {
        return fabric;
    }
}

// BookProduct class
class BookProduct extends Product {
    private String author;
    private String publisher;

    // Constructor
    public BookProduct(int productId, String name, float price, String author, String publisher) {
        super(productId, name, price);
        this.author = author;
        this.publisher = publisher;
    }

    // Setters and getters
    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}

// Customer class
class Customer {
    private int customerId;
    private String name;
    private String address;

    // Constructor
    public Customer(int customerId, String name, String address) {
        this.customerId = Math.abs(customerId);
        this.name = name;
        this.address = address;
    }

    // Setters and getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

// Cart class
class Cart {
    private int customerId;
    private int numProducts;
    private Product[] products;

    // Constructor
    public Cart(int customerId, int numProducts) {
        this.customerId = Math.abs(customerId);
        this.numProducts = Math.abs(numProducts);
        this.products = new Product[numProducts];
    }

    // Setters and getters
    public int getCustomerId() {
        return customerId;
    }

    public int getNumProducts() {
        return numProducts;
    }

    public Product[] getProducts() {
        return products;
    }

    // Other methods
    public void addProduct(Product product, int index) {
        products[index] = product;
    }

    public void removeProduct(int index) {
        products[index] = null;
    }

    public float calculatePrice() {
        float totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void placeOrder() {
        System.out.println("Your Order Success "); 
    }
}

// Order class
class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    private float totalPrice;

    // Constructor
    public Order(int customerId, int orderId, Product[] products) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }

    // Other methods
    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (Product product : products){
          if (product != null){
            System.out.println("- " + product.getName() + ": $" + product.getPrice());
        }} 
        System.out.println("Total Price: $" + totalPrice);
    }

    private float calculateTotalPrice() {
        float total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }
}

// EcommerceSystem class
public class EcommerceSystem {
    public static void main(String[] args) {
        // Create products
        ElectronicProduct electronicProduct = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 1);
        ClothingProduct clothingProduct = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        BookProduct bookProduct = new BookProduct(3, "OOP", 39.99f, "O'Reilly", "X Publications");

        // Create customer
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer ID:");
        int customerId = Math.abs(scanner.nextInt());
        scanner.nextLine(); // Consume newline
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();
        System.out.println("Enter customer address:");
        String customerAddress = scanner.nextLine();
        Customer customer = new Customer(customerId, customerName, customerAddress);

        // Create shopping cart
        System.out.println("How many products do you want to order?");
        int numProducts = Math.abs(scanner.nextInt());
        Cart cart = new Cart(customer.getCustomerId(), numProducts);

        // Add products to cart
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter product type (1: Electronic, 2: Clothing, 3: Book):");
            int productType = Math.abs(scanner.nextInt());
            
            switch (productType) {
                case 1:
                    cart.addProduct(electronicProduct, i);
                    break;
                case 2:
                    cart.addProduct(clothingProduct, i);
                    break;
                case 3:
                    cart.addProduct(bookProduct, i);
                    break;
                default:
                    System.out.println("Invalid product type.");
                    break;
            }
        }
         

        // Ask user to place order
        System.out.println("Do you want to place an order? (yes/no)");
        String choice = scanner.next();
        Order order = new Order(customer. getCustomerId(), 1, cart.getProducts());
        if (choice.equals("yes")) {
            cart.placeOrder();
      // Assuming order placed, then print order info
            order.printOrderInfo();
        } else if(choice.equals("no")) {
            System.out.println("do you want to remove prudoct? (yes/no) ");
        String ans=scanner.next();
           if(ans.equals("yes")){
           System. out. println("what product you want to remove? "); 
           int ind=scanner. nextInt(); 
           cart. removeProduct(ind-1); 
           order. printOrderInfo(); 
           cart. placeOrder(); 
           } 
           else{
           System.out.println("order canceled ");	} 
        } 
    }
}