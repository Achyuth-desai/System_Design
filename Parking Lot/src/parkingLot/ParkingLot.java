package parkingLot;

import customDataTypes.Address;
import displayBoard.DisplayBoard;
import entrance.Entrance;
import enums.SpotType;
import enums.VehicleType;
import exit.Exit;
import messages.Messages;
import parkingRate.ParkingRate;
import parkingSpot.ParkingSpot;
import parkingTicket.ParkingTicket;
import vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class ParkingLot {
    private int id;
    private String name;
    private Address address;
    private ParkingRate parkingRate;

    private HashMap<Integer, Entrance> entrance;
    private HashMap<Integer, Exit> exit;

    // Create a hashmap that identifies all currently generated tickets using their ticket number
    private HashMap<Integer, ParkingTicket> tickets;

    // The ParkingLot is a singleton class that ensures it will have only one active instance at a time
    // Both the Entrance and Exit classes use this class to create and close parking tickets
    private static ParkingLot parkingLot = null;

    public Entrance getEntrance(int id){
        return this.entrance.get(id);
    }
    public Exit getExit(int id){ return this.exit.get(id); }
    public ParkingTicket getTicket(int id){ return this.tickets.get(id); }

    // Created a private constructor to add a restriction (due to Singleton)
    private ParkingLot() {
        // Call the name, address and parking_rate
        this.id = 1;
        this.name = "GARRISON PARKING LOT";
        this.address = new Address();
        parkingRate = new ParkingRate();

        // Create initial entrance and exit hashmaps respectively
        entrance = new HashMap<Integer, Entrance>();
        Entrance firstEntrance = new Entrance(1);
        entrance.put(1, firstEntrance);
        exit = new HashMap<Integer, Exit>();
        Exit firstExit = new Exit(1);
        exit.put(1, firstExit);
        tickets = new HashMap<>();
    }

    // Created a static method to access the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    // NOT IMPLEMENTED YET
    public boolean addEntrance(Entrance entrance){ return false;}
    // NOT IMPLEMENTED YET
    public boolean addExit(Exit exit){return false; }

    // This function allows parking tickets to be available at multiple entrances
    public ParkingTicket getParkingTicket(Vehicle vehicle, Entrance entrance) {
        DisplayBoard displayBoard = entrance.getDisplayBoard();
        VehicleType vehicleType = vehicle.getVehicleType();
        SpotType spotType = null;
        ParkingSpot parkingSpot;
        ParkingTicket parkingTicket;
        if(vehicleType == VehicleType.HANDICAPPED)
            spotType = SpotType.HANDICAPPED;
        else if(vehicleType == VehicleType.CAR)
            spotType = SpotType.COMPACT;
        else if(vehicleType == VehicleType.VAN || vehicleType == VehicleType.TRUCK)
            spotType = SpotType.LARGE;
        else if (vehicleType == VehicleType.MOTORCYCLE)
            spotType = SpotType.MOTORBIKE;

        // CHECK IF PARKING SPOT IS FULL FOR THE VEHICLE TYPE
        if(isFull(displayBoard, spotType)){
            System.out.print("SORRY, THE SPOT IS FULL.");
            exit(0);
        }
        //int ticketNo = displayBoard.getOccupiedSpots(spotType) + 1;
        int ticketNo = tickets.size() + 1;
        parkingSpot = displayBoard.getParkingSpot(ticketNo, spotType);
        parkingSpot.assignVehicle(vehicle);
        parkingTicket = new ParkingTicket(ticketNo, vehicle, entrance, parkingSpot);

        tickets.put(ticketNo, parkingTicket);

        return parkingTicket;
    }

    public boolean isFull(DisplayBoard displayBoard, SpotType type) {
        return displayBoard.checkIsFull(type);
    }

    public void showTickets(){
        ParkingTicket ticket = null;
        System.out.println("TOTAL NUMBER OF TICKET ISSUED : " + tickets.size());
        System.out.print("------------------------LIST OF ALL TICKETS------------------------\n");
        for(Map.Entry<Integer, ParkingTicket> set: tickets.entrySet() ) {
            ticket = set.getValue();
            System.out.println("HERE ARE YOUR TICKET DETAILS : ");
            System.out.println("TICKET NUMBER   : " + ticket.getTicketNo());
            System.out.println("LICENSE NUMBER  : " + ticket.getVehicleNo());
            System.out.println("ENTRY TIMESTAMP : " + ticket.getTimestamp());
            System.out.println("AMOUNT DUE      : " + ticket.getAmount());
            System.out.println("TICKET STATUS   : " + ticket.getStatus());
            System.out.println();
        }
    }
}