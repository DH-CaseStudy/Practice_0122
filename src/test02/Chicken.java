package test02;

public class Chicken extends Animal implements Cheatable {
    public static int cnt = 1;

    public Chicken(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        setDistance(getSpeed() * hours);
        System.out.println("닭의 이동거리 = " + getDistance());
    }

    @Override
    public void fly() {
        setDistance(getSpeed() * 2 * (cnt++));
        System.out.println("날으는 닭의 이동거리 = " + getDistance());
    }
}
