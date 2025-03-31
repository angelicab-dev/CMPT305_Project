import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RadiusTest {

    @BeforeEach
    void setUp() {
        // No setup needed for these tests.
    }

    @Test
    void calculateDistance_samePoint_returnsZero() {
        double lat = 40.7128;
        double lon = -74.0060;
        double distance = Radius.calculateDistance(lat, lon, lat, lon);
        assertEquals(0.0, distance, 0.001);
    }

    @Test
    void calculateDistance_nycToLa() {
        double nycLat = 40.7128, nycLon = -74.0060;
        double laLat = 34.0522, laLon = -118.2437;
        double distance = Radius.calculateDistance(nycLat, nycLon, laLat, laLon);
        assertEquals(3936, distance, 20);
    }

    @Test
    void calculateDistance_parisToLondon() {
        double parisLat = 48.8566, parisLon = 2.3522;
        double londonLat = 51.5074, londonLon = -0.1278;
        double distance = Radius.calculateDistance(parisLat, parisLon, londonLat, londonLon);
        assertEquals(343, distance, 5);
    }
}
