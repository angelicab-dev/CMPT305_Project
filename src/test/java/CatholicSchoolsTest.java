import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CatholicSchoolsTest {

    private CatholicSchools dummySchools;

    @BeforeEach
    void setUp() {
        List<CatholicSchool> schools = new ArrayList<>();
        schools.add(new CatholicSchool("St. John", "123 Main St", "A1B2C3", "123-456-7890",
                "K-12", "Arts, Sports", "53.5461", "-113.4938"));
        schools.add(new CatholicSchool("St. Mary", "456 Side St", "D4E5F6", "987-654-3210",
                "K-8", "STEM", "53.0000", "-113.0000"));
        schools.add(new CatholicSchool("St. Peter", "789 Elm St", "G7H8I9", "555-555-5555",
                "K-12", "Music, Arts", "53.1000", "-113.2000"));
        dummySchools = new CatholicSchools(schools);
    }

    @Test
    void readData() {
        try {
            CatholicSchools schoolsFromFile = new CatholicSchools();
            assertTrue(schoolsFromFile.getTotalSchools() > 0);
        } catch (IOException e) {
            fail("IOException thrown during readData");
        }
    }

    @Test
    void getTotalSchools() {
        assertEquals(3, dummySchools.getTotalSchools());
    }

    @Test
    void findBySchoolName() {
        CatholicSchool found = dummySchools.findBySchoolName("St. Mary");
        assertNotNull(found);
        assertEquals("St. Mary", found.getSchoolName());

        assertNull(dummySchools.findBySchoolName("Nonexistent School"));
    }

    @Test
    void filterByGradeLevel() {
        CatholicSchools filtered = dummySchools.filterByGradeLevel("K-12");
        assertEquals(2, filtered.getTotalSchools());

        filtered = dummySchools.filterByGradeLevel("K-8");
        assertEquals(1, filtered.getTotalSchools());
    }

    @Test
    void getSchools() {
        assertEquals(dummySchools.getTotalSchools(), dummySchools.getSchools().size());

        boolean containsStJohn = dummySchools.getSchools().stream()
                .anyMatch(s -> s.getSchoolName().equals("St. John"));
        assertTrue(containsStJohn);
    }
}
