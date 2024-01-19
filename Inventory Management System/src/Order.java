import java.time.LocalDate;

public class Order {
    private Product product;
    private int quantity;
    private LocalDate orderDate;
    private boolean isReceived;

    public Order(Product product, int quantity, LocalDate orderDate) {
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.isReceived = false;
    }

    // Getter methods for Order class
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public boolean isReceived() {
        return isReceived;
    }

}
