package cheatableEX;

public class Dog extends Animal{

    public Dog(int speed){
        this.setSpeed(speed);

    }

    @Override
    public void run(int hours) {
        this.setDistance(((double) (hours * getSpeed()) / 2));
    }
}
