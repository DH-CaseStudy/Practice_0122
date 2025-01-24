package day13.exam1;

public class Tv {
    private String color;
    private boolean power;
    private int channel;

    public Tv(){
        this.color = "black";
        this.power = false;
        this.channel = 0;
    }

    public void power(){
        if(this.power == false){
            this.power = true;
        } else{
            this.power = false;
        }

    }

    public void channelUp(){
        channel++;
    }

    public void channelDown(){
        if(channel != 0){
            channel--;
        } else {
            System.out.println("0 이하로 채널을 내릴 수 없습니다.");
        }

    }

    public void print(){
        System.out.printf("color : %s power : %b channel : %d\n", this.color, this.power, this.channel);
    }
}
