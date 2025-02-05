package interface03;

public class Chicken extends Animal implements Cheatable {
    public Chicken(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        setDistance(this.getSpeed() * hours);
    }

    @Override
    public void fly() {
        setSpeed(this.getSpeed()*2);

    }
}
