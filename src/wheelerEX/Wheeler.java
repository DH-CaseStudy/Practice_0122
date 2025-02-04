package wheelerEX;

public abstract class Wheeler {
    protected int velocity;
    protected String carName;
    protected int wheelNumber;

    public abstract void speedUp(int speed);
    public abstract void speedDown(int speed);
    public void stop(){
        this.velocity = 0;
        System.out.println("정지상태로 속도를 " + this.velocity + "으로 초기화합니다.");
    }
}