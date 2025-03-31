/**
 * To calculate the distance between two geographical points using the Haversine formula.
 */
public class Radius {
    /**
     * Calculates the distance between two geographical points using the Haversine formula.
     * @param lat1 the latitude of the first point in degrees
     * @param lon1 the longitude of the first point in degrees
     * @param lat2 the latitude of the second point in degrees
     * @param lon2 the longitude of the second point in degrees
     * @return the distance between the two points in kilometers.
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth radius in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
