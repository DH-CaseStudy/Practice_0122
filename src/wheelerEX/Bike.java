package wheelerEX;

public class Bike extends Wheeler{

    public Bike(String carName, int velocity, int wheelNumber){
        this.carName = carName;
        this.velocity = velocity;
        this.wheelNumber = wheelNumber;
        System.out.println("자전거 바퀴 " + this.wheelNumber + "개 입니다.");
    }

    @Override
    public void speedUp(int speed) {
        this.velocity += speed;
        if(velocity > 40){
            velocity = 40;
            System.out.println("자전거의 현재 속도는 40 입니다.");
        } else {
            System.out.println("자전거의 현재 속도는" + this.velocity + " 입니다");
        }
    }

    @Override
    public void speedDown(int speed) {
        this.velocity -= speed;
        if(velocity < 10){
            velocity = 10;
            System.out.println("자전거의 최저속도위반으로 속도를 10으로 올립니다.");
        }

    }
}
