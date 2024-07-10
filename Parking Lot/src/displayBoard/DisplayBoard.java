package displayBoard;

import enums.SpotType;
import parkingLot.ParkingLot;
import parkingSpot.*;
import parkingTicket.ParkingTicket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayBoard {
    // Data members
    private int id;
    private HashMap<SpotType, List<ParkingSpot>> parkingSpots;
    private HashMap<SpotType, Integer> maxSpotCount;
    List<ParkingSpot> handicappedSpots;
    List<ParkingSpot> compactSpots;
    List<ParkingSpot> largeSpots;
    List<ParkingSpot> motorcycleSpots;

    // Constructor
    public DisplayBoard(int id) {
        this.id = id;
        this.parkingSpots = new HashMap<>();
        this.maxSpotCount = new HashMap<>();
        initializeMaxSpots();

        this.handicappedSpots = new ArrayList<>(maxSpotCount.get(SpotType.HANDICAPPED));
        this.compactSpots = new ArrayList<>(maxSpotCount.get(SpotType.COMPACT));
        this.largeSpots = new ArrayList<>(maxSpotCount.get(SpotType.LARGE));
        this.motorcycleSpots = new ArrayList<>(maxSpotCount.get(SpotType.MOTORBIKE));
        this.parkingSpots.put(SpotType.HANDICAPPED, handicappedSpots);
        this.parkingSpots.put(SpotType.COMPACT, compactSpots);
        this.parkingSpots.put(SpotType.LARGE, largeSpots);
        this.parkingSpots.put(SpotType.MOTORBIKE, motorcycleSpots);

        //showFreeSlot();
    }

    // Get a parking spot to assign to a vehicle based on its type
    public ParkingSpot getParkingSpot(int ticketNo, SpotType spotType){
        ParkingSpot parkingSpot = null;
        switch (spotType){
            case LARGE          :   parkingSpot = new Large(ticketNo);
                                    largeSpots.add(parkingSpot);
                                    break;
            case HANDICAPPED    :   parkingSpot = new Handicapped(ticketNo);
                                    handicappedSpots.add(parkingSpot);
                                    break;
            case COMPACT        :   parkingSpot = new Compact(ticketNo);
                                    compactSpots.add(parkingSpot);
                                    break;
            case MOTORBIKE      :   parkingSpot = new Motorcycle(ticketNo);
                                    motorcycleSpots.add(parkingSpot);
                                    break;
        }
        return parkingSpot;
    }
    public void freeParkingSpot(ParkingSpot parkingSpot){
        parkingSpot.removeVehicle();
        largeSpots.remove(parkingSpot);
        handicappedSpots.remove(parkingSpot);
        compactSpots.remove(parkingSpot);
        motorcycleSpots.remove(parkingSpot);
    }

    // Member function
    public void addParkingSpot(String spotType, List<ParkingSpot> spots){}; //NOT IMPLEMENTED
    public void showFreeSlot(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("YOU ARE AT ENTRANCE NO " + this.id);
        System.out.println("AVAILABLE FREE SLOT TYPE : NUMBER OF SLOTS");
        System.out.println("HANDICAPPED              : " + getFreeSpots(SpotType.HANDICAPPED));
        System.out.println("CAR                      : " + getFreeSpots(SpotType.COMPACT));
        System.out.println("LARGE (VAN/TRUCK)        : " + getFreeSpots(SpotType.LARGE));
        System.out.println("MOTORCYCLE               : " + getFreeSpots(SpotType.MOTORBIKE));
        System.out.println("---------------------------------------------------------------\n");
    };
    private int getFreeSpots(SpotType spotType){
        List<ParkingSpot> parkingSpot = parkingSpots.get(spotType);
        int maxSpots = maxSpotCount.get(spotType);
        return maxSpots - parkingSpot.size();
    };
    public int getOccupiedSpots(SpotType spotType){
        List<ParkingSpot> parkingSpot = parkingSpots.get(spotType);

        return parkingSpot.size();
    };

    public void showTicket(ParkingTicket ticket){
        System.out.println("HERE ARE YOUR TICKET DETAILS : ");
        System.out.println("TICKET NUMBER   : " + ticket.getTicketNo());
        System.out.println("LICENSE NUMBER  : " + ticket.getVehicleNo());
        System.out.println("ENTRY TIMESTAMP : " + ticket.getTimestamp());
        System.out.println("EXIT TIMESTAMP  : " + ticket.getExit());
        System.out.println("AMOUNT DUE      : " + ticket.getAmount());
        System.out.println("TICKET STATUS   : " + ticket.getStatus());
        System.out.println();
    }

    public void initializeMaxSpots(){
        maxSpotCount.put(SpotType.HANDICAPPED, 2);
        maxSpotCount.put(SpotType.LARGE, 2);
        maxSpotCount.put(SpotType.COMPACT, 2);
        maxSpotCount.put(SpotType.MOTORBIKE, 2);
    }

    public boolean checkIsFull(SpotType type){
        return getFreeSpots(type) == 0;
    }
}