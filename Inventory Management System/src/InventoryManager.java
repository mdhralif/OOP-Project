import java.util.List;

public class InventoryManager {
    private List<Product> products;
    private List<Order> orders;
    OrderProcessor orderProcessor;

    public InventoryManager(List<Product> products, List<Order> orders) {//Dependency Injection
        this.products = products;
        this.orders = orders;
    }
    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void listProducts() {
        System.out.println("List of Products:");
        for (Product product : products) {
            product.displayDetails();
            product.displayStatus();
            System.out.println("------------------------");
        }
    }
    public void listOrders() {
        System.out.println("List of Orders:");
        for (Order order : orders) {
            OrderProcessor orderProcessor = new OrderProcessor(order);
            orderProcessor.displayDetails();
            orderProcessor.displayStatus();
            System.out.println("------------------------");
        }
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void placeOrder(Order order) {
        Product product = order.getProduct();
        int orderQuantity = order.getQuantity();

        Product existingProduct = findProductByName(product.getName());

        if (existingProduct != null && existingProduct.getQuantity() >= orderQuantity) {
            existingProduct.updateQuantity(-orderQuantity);

            if (existingProduct.getQuantity() <= 0) {
                products.remove(existingProduct);
            }

            orders.add(order);

            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Product not found or insufficient quantity. Order not placed.");
        }
    }
    public Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
