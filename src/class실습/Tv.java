package day13.class실습;

public class Tv {

    private String color = "black";
    private boolean power = false;
    private int channel = 0;

    public void power() {
        if (power == false) {
            power = true;
        } else
            power = false;
    }

    public void channelUp() {
        channel++;
    }

    public void channelDown() {
        channel--;
    }


    public void print() {
        System.out.printf("color : %s\tpower : %s\tchnnel : %d",color,power,channel);
        System.out.println();
    }
}
