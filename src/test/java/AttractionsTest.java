import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttractionsTest {
    private Attractions dummyAttractions;

    @BeforeEach
    void setUp() {
        List<Attraction> attractionList = new ArrayList<>();
        attractionList.add(new Attraction("KinsmenTwinArenas", "53.45124394828186", "-113.5138927",
                "Arena", "1979 111 St NW, Edmonton, AB T6J 7C6", "SW",
                "https://www.edmonton.ca/kinsmentwinarenas/"));
        attractionList.add(new Attraction("Prince of Wales Armouries Heritage Centre", "53.55408799469411", "-113.500148",
                "Attraction", "", "NE",
                "https://www.edmonton.ca/princeofwales/"));
        attractionList.add(new Attraction("Crestwood Arena", "53.53874820408859", "-113.57575441072247",
                "Arena","9940 147 St NW, Edmonton, AB T5N 4A6", "NW", "https://www.edmonton.ca/crestwoodarena/"));

        dummyAttractions = new Attractions(attractionList);
    }

    @Test
    void readData() {
        try {
            Attractions attractionfile = new Attractions();
            assertTrue(attractionfile.getTotalAttractions() > 0);
        } catch (IOException e) {
            fail("IOException thrown during readData");
        }
    }

    @Test
    void getTotalAttractions(){
        assertEquals(3, dummyAttractions.getTotalAttractions());
    }

    @Test
    void findByFacilityName() {
        Attraction found = dummyAttractions.findByFacilityName("KinsmenTwinArenas");
        assertNotNull(found);
        assertEquals("KinsmenTwinArenas", found.getFacilityName());

        assertNull(dummyAttractions.findByFacilityName("Nonexistent Attraction"));
    }

    @Test
    void filterByAttractionType() {

        Attractions filtered = dummyAttractions.filterByAttractionType("Attraction");
        assertEquals(1, filtered.getTotalAttractions());

    }

    @Test
    void getAttractions() {
        assertEquals(dummyAttractions.getTotalAttractions(), Attractions.getAttractions().size());


        /*
        boolean containsValleyZoo = Attractions.getAttractions().stream()
                .anyMatch(s -> s.getFacilityName().equals("Valley Zoo"));
        assertTrue(containsValleyZoo);

         */

    }


}