package coffeEX;

public abstract class Beverage {
    private String name;
    protected int price;

    public Beverage(String name) {
        this.name = name;
    }

    public Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract void calcPrice();

    public void print(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
