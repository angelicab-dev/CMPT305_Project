import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CatholicSchoolTest {

    private CatholicSchool school;

    @BeforeEach
    void setUp() {
        school = new CatholicSchool("St. John", "123 Main St", "A1B2C3", "123-456-7890",
                "K-12", "Arts, Sports", "53.5461", "-113.4938");
    }

    @Test
    void getSchoolName() {
        assertEquals("St. John", school.getSchoolName());
    }

    @Test
    void getStreet() {
        assertEquals("123 Main St", school.getStreet());
    }

    @Test
    void getPostalCode() {
        assertEquals("A1B2C3", school.getPostalCode());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("123-456-7890", school.getPhoneNumber());
    }

    @Test
    void getGradeLevel() {
        assertEquals("K-12", school.getGradeLevel());
    }

    @Test
    void getPrograms() {
        assertEquals("Arts, Sports", school.getPrograms());
    }

    @Test
    void getLocation() {
        assertNotNull(school.getLocation());
        assertEquals(53.5461, school.getLocation().getLatitude(), 0.0001);
        assertEquals(-113.4938, school.getLocation().getLongitude(), 0.0001);
    }

    @Test
    void testToString() {
        String toString = school.toString();
        assertTrue(toString.contains("St. John"));
        assertTrue(toString.contains("123 Main St"));
        assertTrue(toString.contains("A1B2C3"));
        assertTrue(toString.contains("123-456-7890"));
        assertTrue(toString.contains("K-12"));
        assertTrue(toString.contains("Arts, Sports"));
        assertTrue(toString.contains("53.5461") || toString.contains("113.4938"));
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(school, school);
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(school.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(school.equals("Not a CatholicSchool"));
    }

    @Test
    void testEquals_SameSchoolName() {
        CatholicSchool sameSchool = new CatholicSchool("St. John", "456 Other St", "D4E5F6", "987-654-3210",
                "K-8", "STEM", "53.0000", "-113.0000");
        assertEquals(school, sameSchool);
    }

    @Test
    void testEquals_DifferentSchoolName() {
        // Create an instance with a different school name.
        CatholicSchool differentSchool = new CatholicSchool("St. Mary", "123 Main St", "A1B2C3", "123-456-7890",
                "K-12", "Arts, Sports", "53.5461", "-113.4938");
        assertNotEquals(school, differentSchool, "Schools with different names should not be equal.");
    }
    @Test
    void testHashCode() {
        CatholicSchool sameSchool = new CatholicSchool("St. John", "456 Other St", "D4E5F6", "987-654-3210",
                "K-8", "STEM", "53.0000", "-113.0000");
        assertEquals(school.hashCode(), sameSchool.hashCode());
    }
}
