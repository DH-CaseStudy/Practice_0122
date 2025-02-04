package wheelerEX;

public class Truck extends Wheeler{

    public Truck(String carName, int velocity, int wheelNumber){
        this.carName = carName;
        this.velocity = velocity;
        this.wheelNumber = wheelNumber;
        System.out.println("트럭 바퀴 " + this.wheelNumber + "개 입니다.");
    }

    @Override
    public void speedUp(int speed) {
        this.velocity += speed * 5;
        if(velocity > 100){
            velocity = 100;
            System.out.println("트럭의 현재 속도는 100 입니다");
        } else {
            System.out.println("트럭의 현재 속도는" + this.velocity + " 입니다");
        }
    }

    @Override
    public void speedDown(int speed) {
        this.velocity -= speed * 5;
        if(velocity < 50){
            velocity = 50;
            System.out.println("트럭의 최저속도 위반으로 속도를 50으로 올립니다.");
        }

    }
}
