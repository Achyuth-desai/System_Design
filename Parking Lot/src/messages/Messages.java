package messages;
public class Messages {
    private String welcomeMessage = "\t\t\t----WELCOME TO THE GARRISON PARKING LOT----";
    private String vehicleTypeMessage = "ENTER YOUR VEHICLE TYPE\n1.CAR\n2.TRUCK\n3.VAN\n4.MOTORCYCLE\nENTER CHOICE : ";
    private String handicappedEligible = "ARE YOU ELIGIBLE FOR A HANDICAPPED PARKING SPACE? 1-YES/ 2-NO : ";

    public String getWelcomeMessage(){
        return this.welcomeMessage;
    }
    public String getVehicleTypeMessage() {
        return this.vehicleTypeMessage;
    }
    public String getHandicappedEligible(){
        return this.handicappedEligible;
    }
}
