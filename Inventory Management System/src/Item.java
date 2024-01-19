public abstract class Item implements Displayable {
    private String name;
    private String id;

    public Item(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return id;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ProductID: " + id);
    }

    @Override
    public abstract void displayStatus();
}
