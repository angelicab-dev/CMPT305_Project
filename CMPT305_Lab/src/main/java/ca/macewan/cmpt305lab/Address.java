package ca.macewan.cmpt305lab;

public class Address {

    private String houseNo;
    private String streetName;

    public Address(String houseNo, String streetName) {
        this.houseNo = houseNo;
        this.streetName = streetName;
    }

    public String getHouseNo() {
        return houseNo;
    }
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String toString() {
        return this.houseNo + " " + this.streetName;
    }
}


