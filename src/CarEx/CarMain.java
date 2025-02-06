package CarEx;


//필드 다형성
public class CarMain {
    public static void main(String[] args) {
        Car mycar = new Car();
        //자동차에 타이어를 장착
        mycar.run();

        //KumohoTire 교환
        mycar.tire1 = new KumhoTire();
        mycar.tire2 = new KumhoTire();

        mycar.run();

    }
}