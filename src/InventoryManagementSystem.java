import java.util.ArrayList;

class Item {
    private String name;
    private int quantity;
    private double price;
    private String warehouse;

    public Item(String name, int quantity, double price, String warehouse) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
        System.out.println("Quantity of " + name + " updated to " + newQuantity);
    }
}

class Warehouse {
    private String name;
    private ArrayList<Item> items;

    public Warehouse(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getQuantity() + " " + item.getName() + "(s) added to " + name);
    }

    public void removeItem(Item item) {
        items.remove(item);
        System.out.println(item.getName() + " removed from " + name);
    }

    public void transferItem(Item item, Warehouse destinationWarehouse) {
        if (items.contains(item)) {
            items.remove(item);
            destinationWarehouse.addItem(item);
            System.out.println(item.getName() + " transferred from " + name + " to " + destinationWarehouse.getName());
        } else {
            System.out.println(item.getName() + " not found in " + name);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Item item1 = new Item("Laptop", 10, 800.0, "WarehouseA");
        Item item2 = new Item("Printer", 5, 200.0, "WarehouseB");

        Warehouse warehouseA = new Warehouse("WarehouseA");
        Warehouse warehouseB = new Warehouse("WarehouseB");

        warehouseA.addItem(item1);
        warehouseB.addItem(item2);

        warehouseA.transferItem(item1, warehouseB);

        System.out.println("Items in " + warehouseA.getName() + ": " + warehouseA.getItems().size());
        System.out.println("Items in " + warehouseB.getName() + ": " + warehouseB.getItems().size());
    }
}
