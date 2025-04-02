import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttractionTest {

    private Attraction attraction;

    @BeforeEach
    void setUp() {
        attraction = new Attraction("KinsmenTwinArenas", "53.45124394828186",
                "-113.5138927", "Arena", "1979 111 St NW, Edmonton, AB T6J 7C6",
                "SW", "https://www.edmonton.ca/kinsmentwinarenas/");
    }

    @Test
    void getFacilityName() {
        assertEquals("KinsmenTwinArenas", attraction.getFacilityName());
    }

    @Test
    void getAttractionAddress() {
        assertEquals("1979 111 St NW, Edmonton, AB T6J 7C6", attraction.getAttractionAddress());
    }

    @Test
    void getAttractionQuadrant() {
        assertEquals("SW", attraction.getAttractionQuadrant());
    }

    @Test
    void getAttractionURL() {
        assertEquals("https://www.edmonton.ca/kinsmentwinarenas/", attraction.getAttractionURL());
    }

    @Test
    void getAttractionType() {
        assertEquals("Arena", attraction.getAttractionType());
    }

    @Test
    void getAttractionLocation() {
        Location expectedLocation = new Location("53.45124394828186", "-113.5138927");
        assertEquals(expectedLocation, attraction.getAttractionLocation());
    }

    @Test
    void testToString() {
        String toString = attraction.toString();
        assertTrue(toString.contains("KinsmenTwinArenas"));
        assertTrue(toString.contains("1979 111 St NW, Edmonton, AB T6J 7C6"));
        assertTrue(toString.contains("Arena"));
    }

    @Test
    void testEqualsSameObject() {
        assertEquals(attraction, attraction);
    }

    @Test
    void testEqualsNull() {
        assertNotEquals(null, attraction);
    }

    @Test
    void testEqualsSameFacilityName() {
        Attraction sameAttraction = new Attraction("KinsmenTwinArenas", "53.0000", "-113.0000",
                "DifferentType", "Another Address", "NW", "https://example.com/");
        assertEquals(attraction, sameAttraction);
    }

    @Test
    void testEqualsDifferentFacilityName() {
        Attraction differentAttraction = new Attraction("WestEdMall", "53.5225", "-113.6242",
                "Mall", "8882 170 St NW, Edmonton, AB T5T 4J2", "NW", "https://www.wem.ca/");
        assertNotEquals(attraction, differentAttraction);
    }

    @Test
    void testHashCode() {
        Attraction sameAttraction = new Attraction("KinsmenTwinArenas", "53.0000", "-113.0000",
                "DifferentType", "Another Address", "NW", "https://example.com/");
        assertEquals(attraction.hashCode(), sameAttraction.hashCode());
    }
}