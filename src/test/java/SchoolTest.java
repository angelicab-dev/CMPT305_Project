import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    private School schoolPublic;
    private School schoolCatholic;

    @BeforeEach
    void setUp() {
        schoolPublic = new School("Central High", "101 Main St", "12345", "555-555-5555",
                "9-12", "53.1234", "-113.9876", "Public");
        schoolCatholic = new School("St. Joseph", "10830 109 ST NW", "T5H 3C1","7804262010",
                "Senior", "53.5538756", "-113.5094603", "Catholic");
    }

    @Test
    void getSchoolName() {
        assertEquals("Central High", schoolPublic.getSchoolName());
        assertEquals("St. Joseph", schoolCatholic.getSchoolName());
    }

    @Test
    void getStreet() {
        assertEquals("101 Main St", schoolPublic.getStreet());
        assertEquals("10830 109 ST NW", schoolCatholic.getStreet());
    }

    @Test
    void getPostalCode() {
        assertEquals("12345", schoolPublic.getPostalCode());
        assertEquals("T5H 3C1", schoolCatholic.getPostalCode());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("555-555-5555", schoolPublic.getPhoneNumber());
        assertEquals("7804262010", schoolCatholic.getPhoneNumber());
    }

    @Test
    void getLocation() {
        assertNotNull(schoolPublic.getLocation());
        assertEquals(53.1234, schoolPublic.getLocation().getLatitude(), 0.0001);
        assertEquals(-113.9876, schoolPublic.getLocation().getLongitude(), 0.0001);

        assertNotNull(schoolCatholic.getLocation());
        assertEquals(53.5538756, schoolCatholic.getLocation().getLatitude());
        assertEquals(-113.5094603, schoolCatholic.getLocation().getLongitude());

    }

    @Test
    void getGradeLevel() {
        assertEquals("9-12", schoolPublic.getGradeLevel());
        assertEquals("Senior", schoolCatholic.getGradeLevel());
    }

    @Test
    void getSchoolType(){
        assertEquals("Public", schoolPublic.getSchoolType());
        assertEquals("Catholic", schoolCatholic.getSchoolType());
    }
}
