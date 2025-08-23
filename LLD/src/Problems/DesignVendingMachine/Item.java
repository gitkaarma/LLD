package Problems.DesignVendingMachine;

public class Item {
    private ItemType type;
    private int price;
    
    public Item() {
        // Default constructor
    }
    
    public Item(ItemType type, int price) {
        setType(type);
        setPrice(price);
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        if (type == null) {
            throw new IllegalArgumentException("Item type cannot be null");
        }
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
    
    @Override
    public String toString() {
        return String.format("Item{type=%s, price=%d}", type, price);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return price == item.price && type == item.type;
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(type, price);
    }
}
