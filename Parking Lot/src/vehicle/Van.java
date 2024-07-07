package vehicle;

import enums.VehicleType;
import parkingTicket.ParkingTicket;

public class Van extends Vehicle {
    ParkingTicket parkingTicket;

    public Van(int licenseNo, VehicleType vehicleType){
        super(licenseNo, vehicleType);
    }
    public void assignTicket(ParkingTicket ticket) {
        // definition
        this.parkingTicket = ticket;
    }
}

