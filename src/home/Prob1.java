package home;

class Tv{
	String color = "black";
	boolean power = false;
	int channel = 0;

	public Tv() {
	}

	public void power() {
		if (power == false) {
			power = true;
		} else {
			power = false;
		}
	}

	public void channelUp() {
		channel++;
	}
	public void channelDown() {
		channel--;
	}

	public void print() {
		System.out.printf("cokor :%s\tpower:%b\tchanne1:%d%n", color, power, channel);
	}

}


public class Prob1 {
	public static void main(String[] args) {
		Tv t = new Tv();
		t.print();  // 첫번째 출력문
		t.power();
		t.print();  // 두번째 출력문
		t.channelUp();
		t.channelUp();
		t.print(); // 세번째 출력문

	}
}
