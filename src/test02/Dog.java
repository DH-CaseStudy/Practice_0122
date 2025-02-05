package test02;

public class Dog extends Animal{

    public Dog(int speed) {
        super(speed);
    }

    @Override
    void run(int hours) {
        setDistance((double) (getSpeed() * hours) / 2);
        System.out.println("개의 이동거리 = " + getDistance());
    }
}
