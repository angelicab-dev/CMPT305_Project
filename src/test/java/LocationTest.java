import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    private Location validLocation;
    private Location zeroLocation;
    private Location invalidLocation;
    private Location sameAsValidLocation;

    @BeforeEach
    void setUp() {
        validLocation = new Location("53.5461", "-113.4938"); // Valid coordinates
        zeroLocation = new Location("0", "0"); // Zero coordinates
        invalidLocation = new Location("invalid", "invalid"); // Invalid coordinates
        sameAsValidLocation = new Location("53.5461", "-113.4938"); // Same as validLocation
    }

    @Test
    void getLatitude() {
        assertEquals(53.5461, validLocation.getLatitude());
        assertEquals(0.0, zeroLocation.getLatitude());
        assertEquals(0.0, invalidLocation.getLatitude());
    }

    @Test
    void getLongitude() {
        assertEquals(-113.4938, validLocation.getLongitude());
        assertEquals(0.0, zeroLocation.getLongitude());
        assertEquals(0.0, invalidLocation.getLongitude());
    }

    @Test
    void testToString() {
        assertEquals("(53.5461, -113.4938)", validLocation.toString());
        assertEquals("(0.0, 0.0)", zeroLocation.toString());
        assertEquals("(0.0, 0.0)", invalidLocation.toString());
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(validLocation, validLocation);
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(validLocation.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(validLocation.equals("Some String"));
    }

    @Test
    void testEquals_SameCoordinates() {
        assertEquals(validLocation, sameAsValidLocation);
        assertEquals(sameAsValidLocation, validLocation);
    }

    @Test
    void testEquals_DifferentLatitude() {
        Location differentLat = new Location("53.0000", "-113.4938");
        assertNotEquals(validLocation, differentLat);
    }

    @Test
    void testEquals_DifferentLongitude() {
        Location differentLon = new Location("53.5461", "-113.0000");
        assertNotEquals(validLocation, differentLon);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        assertEquals(validLocation.hashCode(), sameAsValidLocation.hashCode());
        assertNotEquals(validLocation.hashCode(), zeroLocation.hashCode());
    }
}