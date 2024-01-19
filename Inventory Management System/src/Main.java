import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        // Initialize the repository with in-memory storage
        InventoryRepository repository = new InMemoryInventoryRepository();

        // Create an instance of the InventoryManager, passing the repository
        InventoryManager inventoryManager = new InventoryManager(repository.getProducts(), repository.getOrders());

        // Console app logic here, use Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        inventoryManager.listProducts();
                        break;
                    case 2:
                        placeOrder(inventoryManager, repository, scanner);
                        break;
                    case 3:
                        displayOrders(inventoryManager);
                        break;
                    case 4:
                        addProduct(inventoryManager, scanner);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        System.out.println("Exiting the application.");
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("1. List Products");
        System.out.println("2. Place Order");
        System.out.println("3. Display Orders");
        System.out.println("4. Add Product");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
    }

    private static void placeOrder(InventoryManager inventoryManager, InventoryRepository repository, Scanner scanner) {
        System.out.println("Placing Your Order--------->");
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = repository.getProducts().stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(new Product(productName, id, ProductCategory.OTHER, 0));
        Order order = new Order(product, quantity, LocalDate.parse("2024-01-15"));
        inventoryManager.placeOrder(order);
        //System.out.println("Order placed successfully.");
    }

    private static void displayOrders(InventoryManager inventoryManager) {
        System.out.println("Displaying Orders--------->");
        inventoryManager.listOrders();
    }

    private static void addProduct(InventoryManager inventoryManager, Scanner scanner) {
        System.out.println("Adding Product...");

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Product Category (ELECTRONICS, CLOTHING, FOOD, BOOKS, TOYS, OTHERS): ");
        String categoryString = scanner.nextLine();

        ProductCategory category;
        try {
            category = ProductCategory.valueOf(categoryString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid category. Defaulting to OTHER.");
            category = ProductCategory.OTHER;
        }

        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        Product newProduct = new Product(productName, id, category, quantity);
        inventoryManager.addProduct(newProduct);
        System.out.println("Product Added Successfully");
    }
}
