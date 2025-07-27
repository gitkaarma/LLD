package Problems.ParkingLot.ParkingFeeStrategy.impl;

import Problems.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;

public class CarParkingFeeStrategy implements ParkingFeeStrategy {
    private static final double SECOND_RATE = 10.0;
    @Override
    public double calculateFee(long durationInSeconds) {
        return Math.ceil(durationInSeconds) * SECOND_RATE;
    }

}
