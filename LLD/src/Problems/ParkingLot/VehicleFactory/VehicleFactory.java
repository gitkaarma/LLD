package Problems.ParkingLot.VehicleFactory;

import Problems.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Problems.ParkingLot.ParkingFeeStrategy.impl.BusParkingFeeStrategy;
import Problems.ParkingLot.ParkingFeeStrategy.impl.CarParkingFeeStrategy;
import Problems.ParkingLot.VehicleFactory.ConcreteVehicles.Bus;
import Problems.ParkingLot.VehicleFactory.ConcreteVehicles.Car;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy){
        switch (vehicleType){
            case CAR:
                return new Car(vehicleNumber, parkingFeeStrategy); // don't insert new CarParkingFeeStrategy();
            case BUS:
                return new Bus(vehicleNumber, parkingFeeStrategy);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + vehicleType);
        }
    }
}
