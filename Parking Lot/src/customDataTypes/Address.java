package customDataTypes;

public class Address {
    private int zipCode;
    private String address;
    private String city;
    private String state;
    private String country;

    public Address(){
        this.zipCode = 100001;
        this.address = "RandomAddress";
        this.city = "RandomCity";
        this.state = "RandomState";
        this.country = "RandomCountry";
    }
}
