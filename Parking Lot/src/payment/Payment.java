package payment;

import enums.PaymentStatus;

import java.util.Date;

public abstract class Payment {
    private double amount;
    private PaymentStatus status;
    private Date timestamp;

    public Payment(double amount){
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
        this.timestamp = new Date();
    }
    public double getAmount(){ return this.amount;}
    public void setStatus(PaymentStatus status){
        this.status = status;
    }
    public abstract boolean initiateTransaction();
}
