package homework.inheritance실습.level01;

public class Drink {

    public String name;
    public int price;
    public int count;

    public Drink(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getTotalPrice() {
        return price * count;
    }

    public static void printTitle() {
        System.out.println("상품명\t단가\t\t수량\t\t금액");
    }

    public void printData() {
        System.out.println(name + "\t\t" + price + "\t" + count + "\t\t" + getTotalPrice());
    }
}
