import displayBoard.DisplayBoard;

import entrance.Entrance;
import enums.VehicleType;
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
        DisplayBoard displayBoard = entrance.getDisplayBoard();
        while(loop == 1) {
            displayBoard.showFreeSlot();
            ticket = entrance.getTicket();
            entrance.displayTicket(ticket);

            System.out.print("\n\tCONTINUE? 1-YES/ 2-NO : ");
            loop = input.nextInt();
        }
    }
}