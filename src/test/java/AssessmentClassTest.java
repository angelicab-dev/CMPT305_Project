import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssessmentClassTest {

    private AssessmentClass validClass;
    private AssessmentClass invalidPercentageClass;
    private AssessmentClass sameAsValidClass;

    @BeforeEach
    void setUp() {
        validClass = new AssessmentClass("Residential", "75");
        invalidPercentageClass = new AssessmentClass("Commercial", "invalid");
        sameAsValidClass = new AssessmentClass("Residential", "75");
    }

    @Test
    void getClassName() {
        assertEquals("Residential", validClass.getClassName());
        assertEquals("Commercial", invalidPercentageClass.getClassName());
    }

    @Test
    void getPercentage() {
        assertEquals(75, validClass.getPercentage());
        assertEquals(0, invalidPercentageClass.getPercentage());
    }

    @Test
    void testToString() {
        assertEquals("Residential 75%", validClass.toString());
        assertEquals("Commercial 0%", invalidPercentageClass.toString());
    }

    @Test
    void parseAssessmentClasses() {
        String[] row = new String[20];
        row[12] = "50";  row[15] = "Industrial";
        row[13] = "30";  row[16] = "Residential";
        row[14] = "20";  row[17] = "Commercial";

        List<AssessmentClass> classes = AssessmentClass.parseAssessmentClasses(row);

        assertEquals(3, classes.size());
        assertEquals("Industrial", classes.get(0).getClassName());
        assertEquals(50, classes.get(0).getPercentage());
        assertEquals("Residential", classes.get(1).getClassName());
        assertEquals(30, classes.get(1).getPercentage());
        assertEquals("Commercial", classes.get(2).getClassName());
        assertEquals(20, classes.get(2).getPercentage());
    }

    @Test
    void parseAssessmentClassesEmptyRow() {
        String[] row = new String[0];
        List<AssessmentClass> classes = AssessmentClass.parseAssessmentClasses(row);
        assertTrue(classes.isEmpty());
    }

    @Test
    void parseAssessmentClassesWithInvalidPercentage() {
        String[] row = new String[20];
        row[12] = "invalid"; row[15] = "Residential";

        List<AssessmentClass> classes = AssessmentClass.parseAssessmentClasses(row);
        assertEquals(1, classes.size());
        assertEquals(0, classes.get(0).getPercentage());
    }

    @Test
    void parseAssessmentClassesWithNullValues() {
        String[] row = new String[20];
        row[12] = null; row[15] = "Residential"; // Null percentage
        row[13] = "30"; row[16] = null; // Null class name

        List<AssessmentClass> classes = AssessmentClass.parseAssessmentClasses(row);

        assertEquals(1, classes.size());
        assertEquals("Residential", classes.get(0).getClassName());
        assertEquals(0, classes.get(0).getPercentage());
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(validClass, validClass);
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(validClass.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(validClass.equals("Some String"));
    }

    @Test
    void testEquals_SameValues() {
        assertEquals(validClass, sameAsValidClass);
        assertEquals(sameAsValidClass, validClass);
    }

    @Test
    void testEquals_DifferentValues() {
        assertNotEquals(validClass, invalidPercentageClass);
    }

    @Test
    void testHashCode_ConsistentWithEquals() {
        assertEquals(validClass.hashCode(), sameAsValidClass.hashCode());
        assertNotEquals(validClass.hashCode(), invalidPercentageClass.hashCode());
    }
}