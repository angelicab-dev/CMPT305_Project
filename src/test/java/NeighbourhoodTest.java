import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourhoodTest {


    private Neighbourhood validNeighbourhood;
    private Neighbourhood neighbourhoodWithSpaces;

    @BeforeEach
    void setUp() {
        validNeighbourhood = new Neighbourhood("Downtown", "Ward 6");
        neighbourhoodWithSpaces = new Neighbourhood("  Suburban Area  ", "  Ward 3  ");
    }
    @Test
    void getName() {
        assertEquals("Downtown", validNeighbourhood.getName());
        assertEquals("Suburban Area", neighbourhoodWithSpaces.getName());
    }

    @Test
    void getWard() {
        assertEquals("Ward 6", validNeighbourhood.getWard());
        assertEquals("Ward 3", neighbourhoodWithSpaces.getWard());
    }
    @Test
    void testToString() {
        assertEquals("Downtown (Ward 6)", validNeighbourhood.toString());
        assertEquals("Suburban Area (Ward 3)", neighbourhoodWithSpaces.toString());
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(validNeighbourhood, validNeighbourhood);
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(validNeighbourhood.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(validNeighbourhood.equals("Not a Neighbourhood"));
    }

    @Test
    void testEquals_SameValues() {
        Neighbourhood anotherNeighbourhood = new Neighbourhood("Downtown", "Ward 6");
        assertEquals(validNeighbourhood, anotherNeighbourhood);
        assertEquals(anotherNeighbourhood, validNeighbourhood);
        assertEquals(validNeighbourhood.hashCode(), anotherNeighbourhood.hashCode());
    }

    @Test
    void testEquals_DifferentName() {
        Neighbourhood differentName = new Neighbourhood("Uptown", "Ward 6");
        assertNotEquals(validNeighbourhood, differentName);
    }

    @Test
    void testEquals_DifferentWard() {
        Neighbourhood differentWard = new Neighbourhood("Downtown", "Ward 7");
        assertNotEquals(validNeighbourhood, differentWard);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        Neighbourhood anotherNeighbourhood = new Neighbourhood("Downtown", "Ward 6");
        assertEquals(validNeighbourhood.hashCode(), anotherNeighbourhood.hashCode());
    }

    @Test
    void testEquals_TrimmedValues() {
        Neighbourhood trimmedNeighbourhood = new Neighbourhood("Suburban Area", "Ward 3");
        assertEquals(neighbourhoodWithSpaces, trimmedNeighbourhood);
    }
}