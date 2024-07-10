package parkingRate;

public class ParkingRate {
    // Data members
    private double hours;
    private double rate;

    public ParkingRate(){
        this.hours = 0;
        this.rate = 0;
    }

    public void setHours(double hours){
        this.hours = hours;
    }
    public void setRate(double rate){
        this.rate = rate;
    }

    // Member function
    public void calculate(double hours){
        this.rate = 10 * hours;
    };

    public double getRate(double hours){
        calculate(hours);
        return this.rate;
    }
}