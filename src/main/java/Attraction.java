import java.util.Objects;

/*
 * Represents an attraction with associated facility and location details.
 */
public class Attraction {
    private String facilityName;
    private String attractionAddress;
    private String attractionQuadrant;
    private String attractionURL;
    private String attractionType;
    private Location attractionLocation;

    /**
     * Constructs a new Attraction.
     *
     * @param facilityName the name of the facility.
     * @param attractionLatitude the latitude coordinate for the attraction.
     * @param attractionLongitude the longitude coordinate for the attraction.
     * @param type the type of the attraction.
     * @param address the address of the attraction.
     * @param quadrant the quadrant where the attraction is located.
     * @param attractionURL the URL associated with the attraction.
     */
    public Attraction(String facilityName, String attractionLatitude,
                      String attractionLongitude, String type, String address,
                      String quadrant, String attractionURL) {
        this.facilityName = facilityName;
        this.attractionLocation = new Location(attractionLatitude, attractionLongitude);
        this.attractionType = type;
        this.attractionAddress = address;
        this.attractionQuadrant = quadrant;
        this.attractionURL = attractionURL;
    }

    /**
     * Returns the name of the facility.
     *
     * @return the facility name.
     */
    public String getFacilityName() {
        return facilityName;
    }

    /**
     * Returns the address of the attraction.
     *
     * @return the attraction address.
     */
    public String getAttractionAddress() {
        return this.attractionAddress;
    }

    /**
     * Returns the quadrant where the attraction is located.
     *
     * @return the attraction quadrant.
     */
    public String getAttractionQuadrant() {return attractionQuadrant;}

    /**
     * Returns the URL associated with the attraction.
     *
     * @return the attraction URL.
     */
    public String getAttractionURL() { return attractionURL;}

    /**
     * Returns the type of the attraction.
     *
     * @return the attraction type.
     */
    public String getAttractionType() {
        return attractionType;
    }

    /**
     * Returns the location details of the attraction.
     *
     * @return the attraction location.
     */
    public Location getAttractionLocation() {
        return attractionLocation;
    }

    @Override
    public String toString() {
        return "Facility: " + facilityName + "\n" +
                "Type: " + attractionType + "\n" +
                "Address: " + attractionAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return facilityName.equals(that.facilityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityName);
    }
}
