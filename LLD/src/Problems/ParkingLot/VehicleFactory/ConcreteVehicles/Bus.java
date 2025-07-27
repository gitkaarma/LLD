package Problems.ParkingLot.VehicleFactory.ConcreteVehicles;

import Problems.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleType;

public class Bus extends Vehicle {
    public Bus(String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy) {
        super(vehicleNumber, parkingFeeStrategy);
        super.setVehicleType(VehicleType.BUS);
    }
}
