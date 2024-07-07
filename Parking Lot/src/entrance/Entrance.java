package entrance;

import displayBoard.DisplayBoard;
import enums.VehicleType;
import messages.Messages;
import parkingLot.ParkingLot;
import parkingTicket.ParkingTicket;
import vehicle.*;

import java.util.Scanner;

import static java.lang.System.exit;

public class Entrance {
    // Data members
    private int id;
    private DisplayBoard displayBoard;
    private Messages messages;

    public Entrance(int id){
        this.id = id;
        displayBoard = new DisplayBoard(this.id);
    }
    // Member function
    public void showEntryMessage(){
        System.out.println(messages.getWelcomeMessage());
        this.displayBoard.showFreeSlot();
        System.out.println(messages.getVehicleTypeMessage());
    }

    public ParkingTicket getTicket(){
        ParkingLot parkingLot = ParkingLot.getInstance();
        Vehicle vehicle = getVehicle();
        ParkingTicket parkingTicket = parkingLot.getParkingTicket(vehicle, this);
        return parkingTicket;
    };

    public Vehicle getVehicle(){
        Vehicle vehicle = null;
        VehicleType vehicleType;
        Messages messages = new Messages();
        Scanner input = new Scanner(System.in);

        System.out.print(messages.getVehicleTypeMessage());
        int vehicleChoice = input.nextInt();
        System.out.print("ENTER LICENSE NUMBER : ");// GET THE VEHICLE TYPE
        int licenseNo = input.nextInt(); //FIXING THIS. HAS TO BE USER INPUT.
        switch (vehicleChoice){
            case 1: vehicleType = VehicleType.CAR;
                vehicle = new Car(licenseNo, vehicleType);
                break;
            case 2: vehicleType = VehicleType.TRUCK;
                vehicle = new Truck(licenseNo, vehicleType);
                break;
            case 3: vehicleType = VehicleType.VAN;
                vehicle = new Van(licenseNo, vehicleType);
                break;
            case 4: vehicleType = VehicleType.MOTORCYCLE;
                vehicle = new MotorCycle(licenseNo, vehicleType);
                break;
            default: System.out.println("WRONG CHOICE");
                exit(0);
        }
        System.out.println(messages.getHandicappedEligible());
        int isHandicapped = input.nextInt();
        if(isHandicapped == 1)
            vehicle.setVehicleType(VehicleType.HANDICAPPED);
        return vehicle;
    }

    public DisplayBoard getDisplayBoard(){
        return this.displayBoard;
    }

    public void displayTicket(ParkingTicket ticket){
        this.displayBoard.showTicket(ticket);
    }
}
