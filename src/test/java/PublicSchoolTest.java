import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PublicSchoolTest {

    private PublicSchool school;

    @BeforeEach
    void setUp() {
        school = new PublicSchool("Central High", "101 Main St", "12345", "555-555-5555",
                "9-12", "STEM, Arts", "53.1234", "-113.9876");
    }

    @Test
    void getSchoolName() {
        assertEquals("Central High", school.getSchoolName());
    }

    @Test
    void getStreet() {
        assertEquals("101 Main St", school.getStreet());
    }

    @Test
    void getPostalCode() {
        assertEquals("12345", school.getPostalCode());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("555-555-5555", school.getPhoneNumber());
    }

    @Test
    void getGradeLevel() {
        assertEquals("9-12", school.getGradeLevel());
    }

    @Test
    void getPrograms() {
        assertEquals("STEM, Arts", school.getPrograms());
    }

    @Test
    void getLocation() {
        assertNotNull(school.getLocation());
        assertEquals(53.1234, school.getLocation().getLatitude(), 0.0001);
        assertEquals(-113.9876, school.getLocation().getLongitude(), 0.0001);
    }

    @Test
    void testToString() {
        String output = school.toString();
        assertTrue(output.contains("Central High"));
        assertTrue(output.contains("101 Main St"));
        assertTrue(output.contains("12345"));
        assertTrue(output.contains("555-555-5555"));
        assertTrue(output.contains("9-12"));
        assertTrue(output.contains("STEM, Arts"));
        assertTrue(output.contains("53.1234") || output.contains("-113.9876"));
    }

    @Test
    void testEquals() {
        assertEquals(school, school, "An object should equal itself.");


        PublicSchool sameSchool = new PublicSchool("Central High", "Different St", "54321", "000-000-0000",
                "K-8", "Music", "53.0000", "-113.0000");
        assertEquals(school, sameSchool);

        PublicSchool differentSchool = new PublicSchool("West High", "101 Main St", "12345", "555-555-5555",
                "9-12", "STEM, Arts", "53.1234", "-113.9876");
        assertNotEquals(school, differentSchool);

        assertFalse(school.equals(null));

        assertFalse(school.equals("Not a PublicSchool"));
    }

    @Test
    void testHashCode() {
        PublicSchool sameSchool = new PublicSchool("Central High", "Different St", "54321", "000-000-0000",
                "K-8", "Music", "53.0000", "-113.0000");
        assertEquals(school.hashCode(), sameSchool.hashCode());
    }
}
