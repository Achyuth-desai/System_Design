package vehicle;

import enums.VehicleType;
import parkingTicket.ParkingTicket;

public abstract class Vehicle {
    private int licenseNo;
    private VehicleType vehicleType;

    public Vehicle(int licenseNo, VehicleType vehicleType){
        this.licenseNo = licenseNo;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    public int getLicenseNo(){
        return this.licenseNo;
    }

    public abstract void assignTicket(ParkingTicket ticket);
}
