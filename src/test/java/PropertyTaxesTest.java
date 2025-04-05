import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTaxesTest {

    PropertyTaxes propertyTaxesTest;
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

        propertyTaxesTest = new PropertyTaxes(List.of(sampleAssessment1, sampleAssessment2, sampleAssessment3));

    }
    @Test
    void readData() {
        try {
            PropertyTaxes assessmentsFromFile = new PropertyTaxes();
            assertTrue(assessmentsFromFile.getTotalRecords() > 0);
        } catch (IOException e) {
            fail("IOException occurred while reading CSV");
        }
    }

    @Test
    void getAssessments() {
        List<PropertyAssessment> assessments = propertyTaxesTest.getAssessments();
        assertNotNull(assessments);
        assertEquals(propertyTaxesTest.getTotalRecords(), assessments.size());
        assertEquals(sampleAssessment1, assessments.get(0));
    }



    @Test
    void addPropertyAssessment() {
        PropertyAssessment newAssessment = new PropertyAssessment("1004", 600000, "Maple St", "321", "", "Suburb", "Ward 3", "53.5600", "-113.5100", List.of(new AssessmentClass("Residential", "100")));
        propertyTaxesTest.addPropertyAssessment(newAssessment);
        assertEquals(4, propertyTaxesTest.getTotalRecords());
    }

    @Test
    void filterByAssessmentClass() {
        PropertyTaxes residentialAssessments = propertyTaxesTest.filterByAssessmentClass("Residential");
        assertEquals(2, residentialAssessments.getTotalRecords());
    }

    @Test
    void calculateMinPropertyTax() {
        assertEquals(26700, propertyTaxesTest.calculateMinPropertyTax());
    }

    @Test
    void calculateMaxPropertyTax() {
        assertEquals(66750, propertyTaxesTest.calculateMaxPropertyTax());
    }
}