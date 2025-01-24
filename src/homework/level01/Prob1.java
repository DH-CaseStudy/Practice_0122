package homework.level01;

class Drink{
    private String name;
    private int price;
    private int count;

    public Drink() {
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public Drink(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public int getTotalPrice() {
        return price * count;
    }

    public static void printTitle() {
        System.out.println("상품명\t단가\t 수량\t 금액");
    }

    public void printData() {
        System.out.printf("%s\t%7d\t%3d\t%9d%n",name,price,count,getTotalPrice());

    }
}


class Alcohol extends Drink {
    private double alcper;

    public Alcohol(){
    }

    public Alcohol(String name, int price, int count, double alcper) {
        super(name, price, count);
        this.alcper = alcper;
    }

    public static void printTitle() {
        System.out.println("상품명(도수[%])\t단가 \t수량 \t금액");
    }

    @Override
    public void printData() {
        System.out.printf("%s\t%.1f\t%8d\t%d\t%9d%n",getName(),alcper,getPrice(),getCount(),getTotalPrice());
    }

}

public class Prob1 {

	public static void main(String[] args){

		Drink coffee = new Drink("커피",1500,4);
		Drink tea = new Drink("녹차",1100,7);
		Alcohol wine = new Alcohol("와인", 5000, 3, 15.1);

		System.out.println("***** 매 출 전 표 ***** ");
		Drink.printTitle();
		coffee.printData();
		tea.printData();
		System.out.println();

		Alcohol.printTitle();
		wine.printData();

		int sum = coffee.getTotalPrice()
				  + tea.getTotalPrice()
				  + wine.getTotalPrice();

		System.out.println();
		System.out.println("*** 총금액 " + sum + "원 ***");

	}
}
