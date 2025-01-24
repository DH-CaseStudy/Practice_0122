package homework.inheritance실습.level01;

 class Drink {
    String name;
    int price;
    int count;

    Drink(){}


     Drink(String name ,int price,int count){
        this.name = name;
        this.price = price;
        this.count = count;

     }









//    Drink(String name,int price,int count){
//        this.name = name;
//        this.price = price;
//        this.count =count;
//
//    }

    public int getTotalPrice(){
        return count*price;
    }
    public void printData(){
        System.out.println("음료 이름 : " + name);
        System.out.println("음료 가격 : " + price);
        System.out.println("음료 갯수 : " + count);

    }

    static void printTite(){
        System.out.println("Drink");
    }

}

class Alcohol extends Drink{
    Alcohol(){
        super("A",3000,2);
    }
}

