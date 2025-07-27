package Problems.ParkingLot.VehicleFactory;

import Problems.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;

public abstract class Vehicle {
    private final String vehicleNumber;
    protected ParkingFeeStrategy parkingFeeStrategy;
    private VehicleType vehicleType;

    private long parkingTime;
    public long getParkingTime() {
        return parkingTime;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public void setParkingTime(long parkingTime) {
        this.parkingTime = parkingTime;
    }

    protected Vehicle(String vehicleNumber, ParkingFeeStrategy parkingFeeStrategy) {
        this.vehicleNumber = vehicleNumber;
        this.parkingFeeStrategy = parkingFeeStrategy;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public double calculateParkingFee(long parkingDurationInSeconds){
        return this.parkingFeeStrategy.calculateFee(parkingDurationInSeconds);
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
