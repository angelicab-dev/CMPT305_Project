import java.util.Objects;

/**
 * Represents the location with latitude and longitude.
 */
public class Location {
    private double latitude;
    private double longitude;

    /**
     * Parses latitude and longitude into doubles.
     * If strings cannot be parsed to double, they are set to 0.0.
     * @param lat String representation of the latitude.
     * @param lon String representation of the longitude.
     */
    public Location(String lat, String lon) {
        try {
            this.latitude = Double.parseDouble(lat);
            this.longitude = Double.parseDouble(lon);
        } catch (NumberFormatException e) {
            this.latitude = 0.0;
            this.longitude = 0.0;
        }
    }

    /**
     * Returns the latitude location.
     * @return Latitude value.
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Returns the longitude location.
     * @return Longitude value.
     */
    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.latitude, latitude) == 0 && Double.compare(location.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
