public class Product extends Item {
    private ProductCategory category;
    private int quantity;

    public Product(String name, String id, ProductCategory category, int quantity) {
        super(name, id);
        this.category = category;
        this.quantity = quantity;
    }

    @Override
    public void displayStatus() {
        if (quantity > 0) {
            System.out.println("Product Status: In Stock");
        } else {
            System.out.println("Product Status: Out of Stock");
        }
    }

    public void updateQuantity(int deltaQuantity) {
        this.quantity += deltaQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void updateStatus() {
        if (quantity > 0) {
            System.out.println("Product Status: In Stock");
        } else {
            System.out.println("Product Status: Out of Stock");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Product Details:");
        System.out.println("Name: " + getName());
        System.out.println("ProductID: " + getDescription());
        System.out.println("Category: " + category);
        System.out.println("Quantity: " + quantity);
        updateStatus(); // Display product status
        System.out.println("------------------------");
    }

}
