import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of CatholicSchool objects loaded from a CSV file.
 */
public class CatholicSchools {
    private List<CatholicSchool> schools;

    /**
     * Constructs a CatholicSchools object by reading data from the CSV file.
     * @throws IOException if the file cannot be read.
     */
    public CatholicSchools() throws IOException {
        this.schools = new ArrayList<>();
        readData();
    }

    /**
     * Constructs a CatholicSchools object with an existing list of CatholicSchool objects.
     *
     * @param schools the list of CatholicSchool objects.
     */
    public CatholicSchools(List<CatholicSchool> schools) {
        this.schools = new ArrayList<>(schools);
    }

    /**
     * Reads the CSV file and creates CatholicSchool objects.
     *
     * @throws IOException if the file cannot be found or read.
     */
    public void readData() throws IOException {
        String csvFileName = "src/main/resources/Edmonton_Catholic_Schools.csv";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFileName))) {
            // Skip header row
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 10) {
                    String schoolName = values[1].trim();
                    CatholicSchool school = getCatholicSchool(values, schoolName);
                    schools.add(school);
                }
            }
        }
    }

    private static CatholicSchool getCatholicSchool(String[] values, String schoolName) {
        String street = values[2].trim();
        String postalCode = values[3].trim();
        String phoneNumber = values[5].trim();
        String gradeLevel = values[9].trim();
        String programs = values[11].trim();
        String latitude = values[12].trim();
        String longitude = values[13].trim();
        CatholicSchool school = new CatholicSchool(schoolName, street, postalCode,
                phoneNumber, gradeLevel, programs, latitude, longitude);
        return school;
    }

    /**
     * Returns the total number of schools.
     *
     * @return the total count.
     */
    public int getTotalSchools() {
        return schools.size();
    }

    /**
     * Finds a school by its name.
     *
     * @param schoolName the name of the school.
     * @return the CatholicSchool object if found; otherwise, null.
     */
    public CatholicSchool findBySchoolName(String schoolName) {
        for (CatholicSchool school : schools) {
            if (school.getSchoolName().equalsIgnoreCase(schoolName.trim())) {
                return school;
            }
        }
        return null;
    }

    /**
     * Filters schools by grade level.
     *
     * @param gradeLevel the grade level to filter by.
     * @return a new CatholicSchools object containing schools that match the grade level.
     */
    public CatholicSchools filterByGradeLevel(String gradeLevel) {
        List<CatholicSchool> filtered = new ArrayList<>();
        for (CatholicSchool school : schools) {
            if (school.getGradeLevel().equalsIgnoreCase(gradeLevel.trim())) {
                filtered.add(school);
            }
        }
        return new CatholicSchools(filtered);
    }

    /**
     * Returns the list of CatholicSchool objects.
     *
     * @return the list of schools.
     */
    public List<CatholicSchool> getSchools() {
        return schools;
    }
}
