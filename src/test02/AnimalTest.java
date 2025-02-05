package test02;

public class AnimalTest {

	public static void main(String[] args) {
		Animal dog = new Dog(8);
		Animal chicken = new Chicken(3);
		Cheatable cheatableChicken = new Chicken(5);

		for (int i = 1; i <= 3; i++) {
			System.out.println(i + "시간 후");
			animalMove(dog, i);
			animalMove(chicken, i);
			cheatableMove(cheatableChicken);
		}
	}

	public static void animalMove(Animal animal, int hour) {
		animal.run(hour);
	}

	public static void cheatableMove(Cheatable cheatable) {
		cheatable.fly();
	}
}










