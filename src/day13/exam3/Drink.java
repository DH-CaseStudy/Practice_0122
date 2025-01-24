package day13.exam3;

public class Drink {
    String name;
    int price;
    int count;

    public Drink(){

    }

    public Drink(String _name, int _price, int _count){
        this.name = _name;
        this.price = _price;
        this.count = _count;
    }

    public int getTotalPrice(){
        return this.price * this.count;
    }

    public void printTitle(){
        System.out.println("***** 매출전표 *****");
        System.out.println("상품명   단가   수량   금액");
    }

    public void printData(String _name, int _price, int _count){
        this.name = _name;
        this.price = _price;
        this.count = _count;
        System.out.println(this.name + "   " + this.price + "     " + this.count + "    " +  getTotalPrice());
    }
}
