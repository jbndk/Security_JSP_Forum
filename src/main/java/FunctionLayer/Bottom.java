package FunctionLayer;

public class Bottom {

    private int bottomID;
    private String name;
    private Double price;

    public Bottom(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Bottom(int bottomID, String name, Double price) {
        this.bottomID = bottomID;
        this.name = name;
        this.price = price;
    }

    public int getBottomID() {
        return bottomID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}