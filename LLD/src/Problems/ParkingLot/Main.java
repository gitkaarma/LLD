package Problems.ParkingLot;

import Problems.ParkingLot.ParkingFeeStrategy.ParkingFeeStrategy;
import Problems.ParkingLot.ParkingFeeStrategy.impl.BusParkingFeeStrategy;
import Problems.ParkingLot.ParkingFeeStrategy.impl.CarParkingFeeStrategy;
import Problems.ParkingLot.ParkingLotController.ParkingLot;
import Problems.ParkingLot.ParkingSpots.ConcreteParkingSpot.BusParkingSpot;
import Problems.ParkingLot.ParkingSpots.ConcreteParkingSpot.CarParkingSpot;
import Problems.ParkingLot.ParkingSpots.ParkingSpot;
import Problems.ParkingLot.PaymentStrategy.impl.CreditCardPayment;
import Problems.ParkingLot.PaymentStrategy.impl.UPIPayment;
import Problems.ParkingLot.VehicleFactory.Vehicle;
import Problems.ParkingLot.VehicleFactory.VehicleFactory;
import Problems.ParkingLot.VehicleFactory.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Initialize parking spots
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(new CarParkingSpot(1));
        parkingSpots.add(new CarParkingSpot(2));
        parkingSpots.add(new BusParkingSpot(3));
        parkingSpots.add(new BusParkingSpot(4));
        // Initialize parking lot
        ParkingLot parkingLot = new ParkingLot(parkingSpots);
        // Create fee strategies

        // Create vehicles using Factory Pattern with fee strategies
        Vehicle car1 = VehicleFactory.createVehicle(VehicleType.CAR, "CAR123", new CarParkingFeeStrategy());
        Vehicle car2 = VehicleFactory.createVehicle(VehicleType.CAR, "CAR345", new CarParkingFeeStrategy());

        Vehicle bus1 = VehicleFactory.createVehicle(VehicleType.BUS, "BUS123", new BusParkingFeeStrategy());
        Vehicle bus2 = VehicleFactory.createVehicle(VehicleType.BUS, "BUS345", new BusParkingFeeStrategy());


        // Park vehicles
        ParkingSpot carSpot1 = parkingLot.parkVehicle(car1);
        ParkingSpot bikeSpot1 = parkingLot.parkVehicle(bus1);

        ParkingSpot carSpot2 = parkingLot.parkVehicle(car2);
        ParkingSpot bikeSpot2 = parkingLot.parkVehicle(bus2);

        Thread.sleep(10000);
        carSpot1.vacate(new CreditCardPayment());
        carSpot2.vacate(new UPIPayment());
    }
}
