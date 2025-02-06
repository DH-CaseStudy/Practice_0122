package VehicleEx;

public class DriverMain {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Vehicle vehicle = new Bus();
        //driver.drive(bus);

        Vehicle vehicle1 = new Taxi();
        // driver.drive(taxi);
        //  Hourse hourse = new Hourse();
        //  driver.drive(Hourse);
        vehicle.run();
        vehicle1.run();
    }
}
