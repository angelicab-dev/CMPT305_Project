import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PropertyAssessmentsTest {

    private PropertyAssessments propertyAssessments;
    private PropertyAssessment sampleAssessment1;
    private PropertyAssessment sampleAssessment2;
    private PropertyAssessment sampleAssessment3;

    @BeforeEach
    void setUp() {
        sampleAssessment1 = new PropertyAssessment("1001", 500000, "Main St", "123", "Apt 4B", "Downtown", "Ward 6", "53.5461", "-113.4938",
                List.of(new AssessmentClass("Residential", "100")));
        sampleAssessment2 = new PropertyAssessment("1002", 750000, "Broadway", "456", "", "Suburb", "Ward 3", "53.5500", "-113.5000",
                List.of(new AssessmentClass("Commercial", "100")));
        sampleAssessment3 = new PropertyAssessment("1003", 300000, "Elm St", "789", "", "Downtown", "Ward 6", "53.5400", "-113.4800",
                List.of(new AssessmentClass("Residential", "50"), new AssessmentClass("Commercial", "50")));

        propertyAssessments = new PropertyAssessments(List.of(sampleAssessment1, sampleAssessment2, sampleAssessment3));
    }

    @Test
    void readData() {
        try {
            PropertyAssessments assessmentsFromFile = new PropertyAssessments();
            assertTrue(assessmentsFromFile.getTotalRecords() > 0);
        } catch (IOException e) {
            fail("IOException occurred while reading CSV");
        }
    }

    @Test
    void filterByNeighbourhood() {
        PropertyAssessments downtownAssessments = propertyAssessments.filterByNeighbourhood("Downtown");
        assertEquals(2, downtownAssessments.getTotalRecords());
    }

    @Test
    void filterByAssessmentClass() {
        PropertyAssessments residentialAssessments = propertyAssessments.filterByAssessmentClass("Residential");
        assertEquals(2, residentialAssessments.getTotalRecords());
    }

    @Test
    void addPropertyAssessment() {
        PropertyAssessment newAssessment = new PropertyAssessment("1004", 600000, "Maple St", "321", "", "Suburb", "Ward 3", "53.5600", "-113.5100", List.of(new AssessmentClass("Residential", "100")));
        propertyAssessments.addPropertyAssessment(newAssessment);
        assertEquals(4, propertyAssessments.getTotalRecords());
    }

    @Test
    void findByAccountNumber() {
        PropertyAssessment found = propertyAssessments.findByAccountNumber("1002");
        assertNotNull(found);
        assertEquals("Broadway 456", found.getAddress().getFullAddress());
    }

    @Test
    void findByAccountNumberNotFound() {
        PropertyAssessment result = propertyAssessments.findByAccountNumber("9999"); // Account number that does not exist
        assertNull(result);
    }

    @Test
    void getTotalRecords() {
        assertEquals(3, propertyAssessments.getTotalRecords());
    }

    @Test
    void calculateMinAssessedValue() {
        assertEquals(300000, propertyAssessments.calculateMinAssessedValue());
    }

    @Test
    void calculateMaxAssessedValue() {
        assertEquals(750000, propertyAssessments.calculateMaxAssessedValue());
    }

    @Test
    void calculateMeanAssessedValue() {
        assertEquals(516666, propertyAssessments.calculateMeanAssessedValue());
    }

    @Test
    void calculateMeanAssessedValueWithEmptyList() {
        PropertyAssessments emptyAssessments = new PropertyAssessments(List.of());
        assertEquals(0, emptyAssessments.calculateMeanAssessedValue());
    }

    @Test
    void calculateMedianAssessedValue() {
        assertEquals(500000, propertyAssessments.calculateMedianAssessedValue());
    }

    @Test
    void calculateMedianAssessedValueWithEvenSize() {
        PropertyAssessments evenAssessments = new PropertyAssessments(List.of(
                new PropertyAssessment("1001", 100000, "Street A", "1", "", "N1", "W1", "53.1", "-113.1", List.of()),
                new PropertyAssessment("1002", 200000, "Street B", "2", "", "N2", "W2", "53.2", "-113.2", List.of()),
                new PropertyAssessment("1003", 300000, "Street C", "3", "", "N3", "W3", "53.3", "-113.3", List.of()),
                new PropertyAssessment("1004", 400000, "Street D", "4", "", "N4", "W4", "53.4", "-113.4", List.of())
        ));

        assertEquals(250000, evenAssessments.calculateMedianAssessedValue());
    }

    @Test
    void calculateMedianAssessedValueWithEmptyList() {
        PropertyAssessments emptyAssessments = new PropertyAssessments(List.of()); // Empty list

        assertEquals(0, emptyAssessments.calculateMedianAssessedValue());
    }

    @Test
    void calculateRangeAssessedValue() {
        assertEquals(450000, propertyAssessments.calculateRangeAssessedValue());
    }

    @Test
    void testGetAssessments() {
        List<PropertyAssessment> assessments = propertyAssessments.getAssessments();
        assertNotNull(assessments);
        assertEquals(propertyAssessments.getTotalRecords(), assessments.size());
        assertEquals(sampleAssessment1, assessments.get(0));
    }

    @Test
    void testDefaultConstructor() {
        try {
            PropertyAssessments pa = new PropertyAssessments();
            assertNotNull(pa.getAssessments());
        } catch (IOException e) {
            fail("Default constructor threw an IOException");
        }
    }
}
