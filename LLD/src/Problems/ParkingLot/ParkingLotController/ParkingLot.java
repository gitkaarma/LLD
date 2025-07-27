package Problems.ParkingLot.ParkingLotController;

import Problems.ParkingLot.ParkingSpots.ParkingSpot;
import Problems.ParkingLot.PaymentStrategy.PaymentStrategy;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleType;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    // Constructor to initialize the parking lot with parking spots
    public ParkingLot(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
    // Method to find an available spot based on vehicle type
    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && spot.getVehicleType().equals(vehicleType)) {
                return spot; // Found an available spot for the vehicle type
            }
        }
        return null; // No available spot found for the given vehicle type
    }
    // Method to park a vehicle
    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType());
        if (spot != null) {
            spot.parkVehicle(vehicle); // Mark the spot as occupied
            System.out.println(
                    "Vehicle parked successfully in spot: " + spot.getSpotNumber());
            return spot;
        }
        System.out.println(
                "No parking spots available for " + vehicle.getVehicleType() + "!");
        return null;
    }
    // Method to vacate a parking spot
    public void vacateSpot(ParkingSpot spot, Vehicle vehicle, PaymentStrategy paymentStrategy) {
        if (spot != null && spot.isOccupied()) {
            spot.vacate(paymentStrategy); // Free the spot
            System.out.println(vehicle.getVehicleType()
                    + " vacated the spot: " + spot.getSpotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant "
                    + "or the vehicle does not match.");
        }
    }
    // Method to find a spot by its number
    public ParkingSpot getSpotByNumber(int spotNumber) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getSpotNumber() == spotNumber) {
                return spot;
            }
        }
        return null; // Spot not found
    }
}
