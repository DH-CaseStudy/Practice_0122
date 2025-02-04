package coffeEX;

public class Coffee extends Beverage{
    static int amount;

    public Coffee(String name, int price) {
        super(name, price);
        amount++;
    }

    @Override
    public void calcPrice() {
        //창선님은 여기에 스위치 케이스를 쓰고 setprice(금액) 사용함.
    }

    public static int getAmount() {
        return amount;
    }

    public static void setAmount(int amount) {
        Coffee.amount = amount;
    }
}
