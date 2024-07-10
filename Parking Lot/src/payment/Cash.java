package payment;

import enums.PaymentStatus;

public class Cash extends Payment {

    public Cash(double amount){
        super(amount);
    }
    public boolean initiateTransaction() {
        // definition
        System.out.println("YOU HAVE PAID THE DUE AMOUNT " + super.getAmount() + " IN CASH.");
        super.setStatus(PaymentStatus.COMPLETED);
        return true;
    }
}
