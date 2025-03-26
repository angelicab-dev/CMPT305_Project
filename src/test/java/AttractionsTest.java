import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttractionsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void readData() {

        //Attraction result = new Attraction()
    }

    @Test
    void getTotalAttractions() throws IOException {
        List<Attraction> attractions = new ArrayList<>();
        Attractions test = new Attractions(attractions);
        test.readData();
        test.getTotalAttractions();


        assertEquals(56,  test.getTotalAttractions());
    }

    @Test
    void findByFacilityName() {
    }

    @Test
    void filterByAttractionType() {
    }

    @Test
    void getAttractions() {
    }
}