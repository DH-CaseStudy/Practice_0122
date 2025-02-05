package test02;

public abstract class Animal {
    private int speed;
    private double distance;

    public Animal(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    abstract void run(int hours);
}
