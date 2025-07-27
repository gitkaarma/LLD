package Problems.ParkingLot.VehicleFactory.ConcreteVehicles;

import Problems.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleType;

public class Car extends Vehicle {

    public Car(String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleNumber, parkingFeeStrategy);
        super.setVehicleType(VehicleType.CAR);
    }
}
