package vehicle;

import enums.VehicleType;
import parkingTicket.ParkingTicket;

public class Truck extends Vehicle {
    ParkingTicket parkingTicket;

    public Truck(int licenseNo, VehicleType vehicleType){
        super(licenseNo, vehicleType);
    }
    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
        // definition
    }
}
