package parkingRate;

public class ParkingRate {
    // Data members
    private double hours;
    private double rate;

    public void setHours(double hours){
        this.hours = hours;
    }
    public void setRate(double rate){
        this.rate = rate;
    }

    // Member function
    public void calculate(){
        this.rate = 10 * this.hours;
    };
}