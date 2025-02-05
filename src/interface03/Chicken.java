package interface03;

public class Chicken extends Animal implements Cheatable {
    private boolean isFlying = false;

    public Chicken(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        setDistance(getDistance() + getSpeed() * hours);

    }

    @Override
    public void fly() {
        setSpeed(getSpeed() * 2);
    }
}
