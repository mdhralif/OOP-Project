import java.util.List;

public interface InventoryRepository {
    void addProduct(Product product);
    void addOrder(Order order);

    List<Product> getProducts();
    List<Order> getOrders();
}
