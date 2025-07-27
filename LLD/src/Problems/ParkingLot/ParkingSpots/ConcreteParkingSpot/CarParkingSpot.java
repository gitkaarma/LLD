package Problems.ParkingLot.ParkingSpots.ConcreteParkingSpot;

import Problems.ParkingLot.ParkingSpots.ParkingSpot;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleType;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber) {
        super(spotNumber);
        super.setVehicleType(VehicleType.CAR);
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.CAR);
    }
}
