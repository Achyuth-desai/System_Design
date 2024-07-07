package parkingSpot;

import vehicle.Vehicle;

public abstract class ParkingSpot {
    private int id;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(int id){
        this.id = id;
        this.isFree = true;
        this.vehicle = null;
    }

    public boolean getIsFree(){
        return this.isFree;
    };
    public void setIsFree(boolean value){
        this.isFree = value;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public abstract boolean assignVehicle(Vehicle vehicle);

    public boolean removeVehicle(){
        // definition
        this.isFree = true;
        this.vehicle = null;
        return true;
    }
}
