package interface03;

public class Dog extends Animal {
    public Dog(int speed) {
        super(speed);

    }

    @Override
    void run(int hours) {
        setDistance((this.getSpeed()*hours)/2.0);

    }
}
