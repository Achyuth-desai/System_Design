package vehicle;

import enums.VehicleType;
import parkingTicket.ParkingTicket;

public class MotorCycle extends Vehicle {
    ParkingTicket parkingTicket;

    public MotorCycle(int licenseNo, VehicleType vehicleType){
        super(licenseNo, vehicleType);
    }

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
        // definition
    }
}
