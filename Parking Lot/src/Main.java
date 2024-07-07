import displayBoard.DisplayBoard;

import entrance.Entrance;
import enums.VehicleType;
import exit.Exit;
import messages.Messages;
import parkingLot.ParkingLot;
import parkingTicket.ParkingTicket;
import vehicle.*;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        int loop = 1;
        Scanner input = new Scanner(System.in);
        ParkingLot parkingLot = ParkingLot.getInstance();
        Messages messages = new Messages();
        ParkingTicket ticket;
        Entrance entrance = parkingLot.getEntrance(1);
        Exit exit = parkingLot.getExit(1);
        DisplayBoard displayBoard = entrance.getDisplayBoard();

        while(loop == 1) {
            System.out.print("USE CASE : 1-ENTRY / 2-EXIT.\tCHOICE : ");
            int useCase = input.nextInt();
            // ENTRY USE CASE
            if(useCase==1) {
                displayBoard.showFreeSlot();
                ticket = entrance.getTicket();
                entrance.displayTicket(ticket);
                parkingLot.showTickets();
            }
            //EXIT USE CASE
            if(useCase==2){
                System.out.print("ENTER TICKET NUMBER : ");
                int ticketNo = input.nextInt();
                ticket = parkingLot.getTicket(ticketNo);
                displayBoard.showTicket(ticket);
            }
            System.out.print("\n\tCONTINUE? 1-YES/ 2-NO : ");
            loop = input.nextInt();
        }
    }
}