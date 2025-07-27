package Problems.ParkingLot.ParkingSpots;

import Problems.ParkingLot.PaymentStrategy.PaymentStrategy;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleType;

public abstract class ParkingSpot {
    private int spotNumber; // id of the spot

    private boolean isOccupied;

    private Vehicle vehicle;

    private VehicleType vehicleType;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpot(int spotNumber){
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }


    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) {
        // Check if the spot is already occupied
        if (isOccupied) {
            throw new IllegalStateException("Spot is already occupied.");
        }
        // Check if the vehicle can be parked in this spot
        if (!canParkVehicle(vehicle)) {
            throw new IllegalArgumentException(
                    "This spot is not suitable for" + vehicle.getVehicleType());
        }
        this.vehicle = vehicle;
        this.vehicle.setParkingTime(System.currentTimeMillis());
        this.isOccupied = true;
    }
    // Method to vacate the parking spot
    public void vacate(PaymentStrategy paymentStrategy) {
        // Check if the spot is already vacant
        if (!isOccupied) {
            throw new IllegalStateException("Spot is already vacant.");
        }
        long parkingDurationInSeconds = (System.currentTimeMillis() - vehicle.getParkingTime())/1000;
        double parkingFee = vehicle.calculateParkingFee(parkingDurationInSeconds);
        paymentStrategy.processPayment(parkingFee);
        this.vehicle = null;
        this.isOccupied = false;
        System.out.println("Parking Spot " + spotNumber + "successfully vacated!");
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
