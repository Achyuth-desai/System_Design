package parkingSpot;

import enums.SpotType;
import enums.VehicleType;
import vehicle.Vehicle;

public class Compact extends ParkingSpot {
    SpotType spotType;
    VehicleType vehicleType;

    public Compact(int id) {
        super(id);
        this.spotType = SpotType.COMPACT;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        // definition
        super.setIsFree(false);
        super.setVehicle(vehicle);
        this.vehicleType = vehicle.getVehicleType();

        return true;
    }
}
