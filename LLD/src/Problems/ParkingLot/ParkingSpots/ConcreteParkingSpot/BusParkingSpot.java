package Problems.ParkingLot.ParkingSpots.ConcreteParkingSpot;

import Problems.ParkingLot.ParkingSpots.ParkingSpot;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleType;

public class BusParkingSpot extends ParkingSpot {
    public BusParkingSpot(int spotNumber) {
        super(spotNumber);
        super.setVehicleType(VehicleType.BUS);
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equals(VehicleType.BUS);
    }
}
