import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertyAssessmentTest {

    private PropertyAssessment property1;
    private PropertyAssessment property2;
    private PropertyAssessment property3;

    @BeforeEach
    void setUp() {
        property1 = new PropertyAssessment("1001", 500000, "Main St", "123", "Apt 4B", "Downtown", "Ward 6", "53.5461", "-113.4938",
                List.of(new AssessmentClass("Residential", "100")));

        property2 = new PropertyAssessment("1002", 750000, "Broadway", "456", "", "Suburb", "Ward 3", "53.5500", "-113.5000",
                List.of(new AssessmentClass("Commercial", "100")));

        property3 = new PropertyAssessment("1003", 300000, "Elm St", "789", "", "Downtown", "Ward 6", "53.5400", "-113.4800",
                List.of(new AssessmentClass("Residential", "50"), new AssessmentClass("Commercial", "50")));
    }

    @Test
    void getAccountNumber() {
        assertEquals("1001", property1.getAccountNumber());
        assertEquals("1002", property2.getAccountNumber());
    }

    @Test
    void getAssessedValue() {
        assertEquals(500000, property1.getAssessedValue());
        assertEquals(750000, property2.getAssessedValue());
        assertEquals(300000, property3.getAssessedValue());
    }

    @Test
    void getAddress() {
        assertEquals("Main St 123 Apt 4B", property1.getAddress().getFullAddress());
        assertEquals("Broadway 456", property2.getAddress().getFullAddress());
    }

    @Test
    void getNeighbourhood() {
        assertEquals("Downtown", property1.getNeighbourhood().getName());
        assertEquals("Ward 6", property1.getNeighbourhood().getWard());

        assertEquals("Suburb", property2.getNeighbourhood().getName());
        assertEquals("Ward 3", property2.getNeighbourhood().getWard());
    }

    @Test
    void getLocation() {
        assertEquals(53.5461, property1.getLocation().getLatitude());
        assertEquals(-113.4938, property1.getLocation().getLongitude());

        assertEquals(53.5500, property2.getLocation().getLatitude());
        assertEquals(-113.5000, property2.getLocation().getLongitude());
    }

    @Test
    void getAssessmentClasses() {
        assertEquals(1, property1.getAssessmentClasses().size());
        assertEquals("Residential", property1.getAssessmentClasses().get(0).getClassName());

        assertEquals(2, property3.getAssessmentClasses().size());
        assertEquals("Residential", property3.getAssessmentClasses().get(0).getClassName());
        assertEquals("Commercial", property3.getAssessmentClasses().get(1).getClassName());
    }

    @Test
    void compareTo() {
        assertTrue(property1.compareTo(property2) < 0);
        assertTrue(property2.compareTo(property1) > 0);
        assertTrue(property1.compareTo(property1) == 0);
    }

    @Test
    void testToString() {
        String expected1 = "Account Number = 1001\n" +
                "Address = Main St 123 Apt 4B\n" +
                "Assessed Value = $500000\n" +
                "Assessment Class = [Residential 100%]\n" +
                "Neighbourhood = Downtown (Ward 6)\n" +
                "Location = (53.5461, -113.4938)";

        assertEquals(expected1, property1.toString());

        String expected2 = "Account Number = 1002\n" +
                "Address = Broadway 456\n" +
                "Assessed Value = $750000\n" +
                "Assessment Class = [Commercial 100%]\n" +
                "Neighbourhood = Suburb (Ward 3)\n" +
                "Location = (53.55, -113.5)";

        assertEquals(expected2, property2.toString());
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(property1, property1);
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(property1.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(property1.equals("Not a PropertyAssessment"));
    }

    @Test
    void testEquals_SameAccountNumber() {
        // Create a duplicate property with same account number as property1 but different other data
        PropertyAssessment duplicateProperty = new PropertyAssessment("1001", 600000, "Different St", "999", "",
                "OtherNeighbourhood", "Ward 9", "40.0", "-100.0", List.of(new AssessmentClass("Commercial", "100")));
        assertTrue(property1.equals(duplicateProperty));
        // Their hash codes should be equal
        assertEquals(property1.hashCode(), duplicateProperty.hashCode());
    }

    @Test
    void testEquals_DifferentAccountNumber() {
        assertNotEquals(property1, property2);
    }
}