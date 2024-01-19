import java.time.LocalDate;

public class OrderProcessor implements Displayable {
    private final Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return order.getProduct();
    }

    public int getQuantity() {
        return order.getQuantity();
    }

    public LocalDate getOrderDate() {
        return order.getOrderDate();
    }

    public boolean isReceived() {
        return order.isReceived();
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        System.out.println("Product: " + getProduct().getName()); // Assuming there's a getName() method in the Product class
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Order Date: " + getOrderDate());
        System.out.println("Received: " + (isReceived() ? "Yes" : "No"));
    }
    @Override
    public void displayDetails() {
        displayOrderDetails();
    }

    @Override
    public void displayStatus() {
        System.out.println("Order Status: " + (isReceived() ? "Received" : "Pending"));
    }
}
