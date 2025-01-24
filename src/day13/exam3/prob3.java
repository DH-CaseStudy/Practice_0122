package day13.exam3;

public class prob3 {
    public static void main(String[] args) {
        Drink drink = new Drink();
        int sum = 0;

        drink.printTitle();
        drink.printData("커피", 1500, 4);
        sum += drink.getTotalPrice();
        drink.printData("녹차", 1100, 7);
        sum += drink.getTotalPrice();

        Alcohol alcohol = new Alcohol();

        alcohol.printTitle();
        alcohol.printData("와인", 5000, 3);
        sum += alcohol.getTotalPrice();

        System.out.println("*** 총금액" + sum + " ***");
    }
}
