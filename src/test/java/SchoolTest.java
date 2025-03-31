import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    private School school;

    @BeforeEach
    void setUp() {
        school = new School("Central High", "101 Main St", "12345", "555-555-5555",
                "9-12", "53.1234", "-113.9876");
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
    void getLocation() {
        assertNotNull(school.getLocation());
        assertEquals(53.1234, school.getLocation().getLatitude(), 0.0001);
        assertEquals(-113.9876, school.getLocation().getLongitude(), 0.0001);
    }

    @Test
    void getGradeLevel() {
        assertEquals("9-12", school.getGradeLevel());
    }
}
