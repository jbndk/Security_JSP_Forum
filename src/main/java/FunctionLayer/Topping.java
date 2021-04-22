package FunctionLayer;

public class Topping {

    private int topID;
    private String name;
    private Double price;

    public Topping(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Topping(int topID, String name, Double price) {
        this.topID = topID;
        this.name = name;
        this.price = price;
    }

    public int getTopID() {
        return topID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}