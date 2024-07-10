package exit;

import displayBoard.DisplayBoard;
import entrance.Entrance;
import enums.PaymentStatus;
import enums.TicketStatus;
import parkingRate.ParkingRate;
import parkingSpot.ParkingSpot;
import parkingTicket.ParkingTicket;
import payment.Cash;
import payment.CreditCard;
import payment.Payment;

import java.util.Date;
import java.util.Scanner;

import static java.lang.System.exit;

public class Exit {
    // Data members
    private int id;

    public Exit(int id){
        this.id = id;
    }

    // Member function
    public boolean validateTicket(ParkingTicket ticket){
        // Perform validation logic for the parking ticket
        if(ticket == null || ticket.getStatus() != TicketStatus.ACTIVE){
            System.out.println("INVALID TICKET.");
            exit(0);
        }
        Entrance entrance = ticket.getEntrance();
        DisplayBoard displayBoard = entrance.getDisplayBoard();
        ParkingRate rate = new ParkingRate();
        Payment payment = null;
        Scanner input = new Scanner(System.in);

        ticket.setExitIns(this);
        // Calculate parking charges, if necessary
        Date exitTimestamp = new Date();
        ticket.setExit(exitTimestamp);
        double durationMilliS = ticket.getExit().getTime() - ticket.getTimestamp().getTime();
        double durationSec = (durationMilliS / 1000) - (durationMilliS % 1000)/1000; //Milliseconds to seconds and rounding down
        double amount = rate.getRate(durationSec); //Passing seconds as hours for testing purposes
        ticket.setAmount(amount);
        displayBoard.showTicket(ticket);
        // Handle the exit process
        System.out.print("HOW WOULD YOU LIKE TO PAY? 1-CASH/ 2-CARD : ");
        int paymentChoice = input.nextInt();
        if(paymentChoice == 1)
            payment = new Cash(amount);
        else if(paymentChoice == 2)
            payment = new CreditCard(amount);
        else {
            System.out.print("INVALID CHOICE");
            exit(0);
        }
        boolean transactionStatus = payment.initiateTransaction();
        if(transactionStatus){
            System.out.println("PAYMENT COMPLETE.");
            ticket.setPaid();
            ParkingSpot parkingSpot = ticket.getParkingSpot();
            displayBoard.freeParkingSpot(parkingSpot);
            return true;
        }
        return false;
    }
}