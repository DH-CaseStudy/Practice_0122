package homework.class실습;

public class Tv {
    String color = "black";
    boolean power;
    int channel;

    public Tv() {

    }

    public void power() {
        power = true;
    }

    public void channelUp() {
        channel = channel + 1;
    }

    public void channelDown() {
        channel = channel - 1;
    }

    public void print() {
        System.out.println("color :" + color + "    power:" + power + "     channel:" + channel);
    }
}
