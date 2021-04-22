
package FunctionLayer;

public class Item {

    private String topping;
    private String bottom;
    private int quantity;
    private Double itemPrice;

    public Item(String topping, String bottom, int quantity, Double itemPrice) {
        this.topping = topping;
        this.bottom = bottom;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public Item(String topping, String bottom, int quantity) {
        this.topping = topping;
        this.bottom = bottom;
        this.quantity = quantity;
    }

    public String getTopping() {
        return topping;
    }

    public String getBottom() {
        return bottom;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }
}