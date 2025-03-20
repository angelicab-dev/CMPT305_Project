
public class Attractions {

    private String facilityName;
    private String attractionAddress;
    private String attractionType;
    private Location attractionLocation;

    //We might or might not need this constructor
    public Attractions(String facilityName, String address, String type) {
        this.facilityName = facilityName;
        this.attractionAddress = address;
        this.attractionType = type;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getAttractionAddress() {
        return attractionAddress;
    }

    public String getAttractionType() {
        return attractionType;
    }

    public Location getAttractionLocation() {
        return attractionLocation;
    }

    @Override
    public String toString() {
        return facilityName + " " + "Address:" + attractionAddress + " Type:" + attractionType;
    }
}
