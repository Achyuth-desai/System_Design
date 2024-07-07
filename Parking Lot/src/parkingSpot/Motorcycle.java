package parkingSpot;

import enums.SpotType;
import enums.VehicleType;
import vehicle.Vehicle;

public class Motorcycle extends ParkingSpot {
    SpotType spotType;
    VehicleType vehicleType;

    public Motorcycle(int id){
        super(id);
        this.spotType = SpotType.HANDICAPPED;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        // definition
        super.setIsFree(false);
        super.setVehicle(vehicle);
        this.vehicleType = vehicle.getVehicleType();

        return true;
    }
}
