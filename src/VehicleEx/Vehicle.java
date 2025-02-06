package VehicleEx;

public interface Vehicle {
    default void run(){
        System.out.println("차량이 달립니다.");
    }
}
