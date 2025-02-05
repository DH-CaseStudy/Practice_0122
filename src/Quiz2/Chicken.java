package Quiz2;

public class Chicken extends Animal implements Cheatable{

    public Chicken(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        setDistance(getSpeed() * hours);
    }

    @Override
    public void fly() {
        setSpeed(getSpeed() * 2);
    }
}
