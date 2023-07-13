package lk.ijse.dto;

public class Item {
    private String item_id;
    private String category;
    private String description;
    private String qty;
    private String unit_price;

    public Item(String item_id, String category, String description, String qty, String unit_price) {
        this.item_id = item_id;
        this.category = category;
        this.description = description;
        this.qty = qty;
        this.unit_price = unit_price;
    }

    public Item(String item_id, String description, String qty, String unit_price) {
        this.item_id = item_id;
        this.description = description;
        this.qty = qty;
        this.unit_price = unit_price;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id='" + item_id + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", unit_price='" + unit_price + '\'' +
                '}';
    }
}
