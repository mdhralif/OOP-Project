import java.util.List;
import java.util.ArrayList;
public class InMemoryInventoryRepository implements InventoryRepository {
    private List<Product> products;
    private List<Order> orders;

    public InMemoryInventoryRepository() {
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
    @Override
    public List<Order> getOrders() {
        return orders;
    }
}