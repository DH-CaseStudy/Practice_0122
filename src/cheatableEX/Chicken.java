package cheatableEX;

public class Chicken extends Animal implements Cheatable{

    public Chicken(int speed){
        this.setSpeed(speed);
    }
    @Override
    public void run(int hours){
        this.setDistance(hours * getSpeed());
    }

    @Override
    public void fly() {
        setSpeed(getSpeed() * 2);
    }
}
