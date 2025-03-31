import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PublicSchoolsTest {

    private PublicSchools dummySchools;

    @BeforeEach
    void setUp() {
        List<PublicSchool> schools = new ArrayList<>();
        schools.add(new PublicSchool("Central High", "101 Main St", "12345", "555-555-5555",
                "9-12", "STEM, Arts", "53.1234", "-113.9876"));
        schools.add(new PublicSchool("West High", "202 Side St", "54321", "111-222-3333",
                "9-12", "Sports, Music", "53.2345", "-113.8765"));
        schools.add(new PublicSchool("North High", "303 North St", "67890", "444-555-6666",
                "7-8", "Arts", "53.3456", "-113.7654"));
        dummySchools = new PublicSchools(schools);
    }

    @Test
    void readData() {
        try {
            PublicSchools schoolsFromFile = new PublicSchools();
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
        PublicSchool found = dummySchools.findBySchoolName("Central High");
        assertNotNull(found);
        assertEquals("Central High", found.getSchoolName());

        PublicSchool notFound = dummySchools.findBySchoolName("Nonexistent School");
        assertNull(notFound);
    }

    @Test
    void filterByGradeLevel() {
        PublicSchools filtered = dummySchools.filterByGradeLevel("9-12");
        assertEquals(2, filtered.getTotalSchools());

        filtered = dummySchools.filterByGradeLevel("7-8");
        assertEquals(1, filtered.getTotalSchools());

        filtered = dummySchools.filterByGradeLevel("K-6");
        assertEquals(0, filtered.getTotalSchools());
    }

    @Test
    void getSchools() {
        List<PublicSchool> schoolList = dummySchools.getSchools();
        assertEquals(dummySchools.getTotalSchools(), schoolList.size());

        boolean containsCentral = schoolList.stream()
                .anyMatch(s -> s.getSchoolName().equals("Central High"));
        assertTrue(containsCentral);
    }
}
