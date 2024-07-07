package parkingSpot;

import enums.SpotType;
import enums.VehicleType;
import vehicle.Vehicle;

public class Large extends ParkingSpot {
    SpotType spotType;
    VehicleType vehicleType;

    public Large(int id){
        super(id);
        this.spotType = SpotType.LARGE;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        // definition
        super.setIsFree(false);
        super.setVehicle(vehicle);
        this.vehicleType = vehicle.getVehicleType();

        return true;
    }
}
