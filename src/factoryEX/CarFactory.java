package factoryEX;

public class CarFactory extends Factory implements IWorkingTogether{

    public CarFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    int makeProducts(char skill) {
        return switch (skill) {
            case 'A' -> 3 * getWorkingTime();
            case 'B' -> 2 * getWorkingTime();
            case 'C' -> getWorkingTime();
            default -> 0;
        };


    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        return makeProducts('B');
    }
}
