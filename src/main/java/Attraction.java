
public class Attraction {

    private String facilityName;
    private String attractionAddress;
    private String attractionQuadrant;
    private String attractionURL;
    private String attractionType;
    private Location attractionLocation;

    // Constructor for Attraction
    public Attraction(String facilityName, String attractionLatitude, String attractionLongitude, String type, String address, String quadrant, String attractionURL) {
        this.facilityName = facilityName;
        this.attractionLocation = new Location(attractionLatitude, attractionLongitude);
        this.attractionType = type;
        this.attractionAddress = address;
        this.attractionQuadrant = quadrant;
        this.attractionURL = attractionURL;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getAttractionAddress() {
        return attractionAddress;
    }

    public String getAttractionQuadrant() {return attractionQuadrant;}

    public String getAttractionURL() { return attractionURL;}

    public String getAttractionType() {
        return attractionType;
    }

    public Location getAttractionLocation() {
        return attractionLocation;
    }

    @Override
    public String toString() {
        return "Facility: " + facilityName + "\n" +
                "Address: " + attractionAddress + "\n" +
                "Type:" + attractionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return facilityName.equals(that.facilityName);
    }

}
