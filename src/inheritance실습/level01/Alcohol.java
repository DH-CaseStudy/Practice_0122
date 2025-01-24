package day13.inheritance실습.level01;

public class Alcohol extends Drink {
    private double alcpor;
    private String name;
    private int price;
    private int count;

    public Alcohol(String name, int price, int count, double alcpor) {
        super(name, price, count);
        this.alcpor = alcpor;
    }


    public static void printTitle() {
        System.out.println("상품명(도수[%])\t단가 \t수량 \t금액");
    }


    @Override
    public void printData() {
        System.out.println(getName() + "(" + alcpor + "%)\t\t" + getPrice() + "\t" + getCount() + "\t\t" + getTotalPrice());
    }
}
