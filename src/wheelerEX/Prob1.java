package wheelerEX;

public class Prob1 {
    public static void main(String[] args) {
        Wheeler truck = new Truck("트럭", 0, 4);
        Wheeler bike = new Bike("자전거", 0, 2);

        truck.speedUp(101);
        bike.speedUp(41);

        truck.speedDown(100);
        bike.speedDown(40);

        truck.stop();
        bike.stop();

        truck.speedUp(10);

    }
}
