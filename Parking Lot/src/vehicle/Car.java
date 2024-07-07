package vehicle;

import enums.VehicleType;
import parkingTicket.ParkingTicket;

public class Car extends Vehicle {
    ParkingTicket parkingTicket;

    public Car(int licenseNo, VehicleType vehicleType){
        super(licenseNo, vehicleType);
    }

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
        // definition
    }
}
