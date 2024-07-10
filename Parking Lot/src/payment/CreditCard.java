package payment;

import enums.PaymentStatus;

import java.util.Scanner;

public class CreditCard extends Payment {
    int pin;

    public CreditCard(double amount){
        super(amount);
        this.pin = 0;
    }
    public boolean initiateTransaction() {
        // definition
        System.out.print("SWIPE CREDIT CARD AND ENTER PIN : ");
        Scanner scanner = new Scanner(System.in);
        this.pin = scanner.nextInt();
        System.out.println("YOU HAVE PAID THE DUE AMOUNT " + super.getAmount() + " VIA CREDIT CARD.");
        super.setStatus(PaymentStatus.COMPLETED);
        return true;
    }
}
