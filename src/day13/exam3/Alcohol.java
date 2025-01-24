package day13.exam3;

public class Alcohol extends Drink{
    String name;
    int price;
    int count;
    double alcper;

    public Alcohol(){
        this.alcper = 15.1;
    }

    public double getAlcper() {
        return alcper;
    }

    public int getTotalPrice(){
        return this.price * this.count;
    }

    @Override
    public void printTitle() {
        System.out.println("상품명(도수[%])   단가   수량   금액");
    }

    @Override
    public void printData(String _name, int _price, int _count) {
        this.name = _name;
        this.price = _price;
        this.count = _count;
        System.out.println(this.name + "(" + alcper + ")" + "   " + this.price + "     " + this.count + "    " +  getTotalPrice());
    }
}
