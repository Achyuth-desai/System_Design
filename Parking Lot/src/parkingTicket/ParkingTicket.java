package parkingTicket;

import entrance.Entrance;
import enums.TicketStatus;
import exit.Exit;
import parkingSpot.ParkingSpot;
import payment.Payment;
import vehicle.Vehicle;

import java.util.Date;

public class ParkingTicket {
    private int ticketNo;
    private Date timestamp;
    private Date exit;
    private double amount;
    private TicketStatus status;

    // Following are the instances of their respective classes
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Payment payment;
    private Entrance entrance;
    private Exit exitIns;

    public ParkingTicket(int ticketNo, Vehicle vehicle, Entrance entrance, ParkingSpot parkingSpot){
        this.ticketNo = ticketNo;
        this.timestamp = new Date();
        this.exit = null;
        this.amount = 0;
        this.status = TicketStatus.ACTIVE;

        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.payment = null;
        this.entrance = entrance;
        this.exitIns = null;
    }

    public int getTicketNo(){
        return this.ticketNo;
    }
    public Date getTimestamp(){
        return this.timestamp;
    }
    public double getAmount(){
        return this.amount;
    }
    public TicketStatus getStatus(){
        return this.status;
    }
    public int getVehicleNo(){
        return this.vehicle.getLicenseNo();
    }
}