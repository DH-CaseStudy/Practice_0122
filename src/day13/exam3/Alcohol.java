package day13.exam3;

public class Alcohol extends Drink{
    String name;
    int price;
    int count;
    double alcper;

    public Alcohol(String name, int price, int count, double alcper){
        this.name = name;
        this.price = price;
        this.count = count;
        this.alcper = alcper;
    }

    public double getAlcper() {
        return alcper;
    }

    public int getTotalPrice(){
        return this.price * this.count;
    }

    public static void printTitle() {
        System.out.println("상품명(도수[%])   단가   수량   금액");
    }

    public void printData() {

        System.out.println(this.name + "(" + alcper + ")" + "   " + this.price + "     " + this.count + "    " +  getTotalPrice());
    }
}
