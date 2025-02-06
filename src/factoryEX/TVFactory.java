package factoryEX;

public class TVFactory extends Factory implements IWorkingTogether{

    public TVFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    int makeProducts(char skill) {
        return switch (skill) {
            case 'A' -> 8 * getWorkingTime();
            case 'B' -> 5 * getWorkingTime();
            case 'C' -> 3 * getWorkingTime();
            default -> getWorkingTime();
        };
    }

    @Override
    public int workTogether(IWorkingTogether partner) {
        return makeProducts('C');
    }
}
