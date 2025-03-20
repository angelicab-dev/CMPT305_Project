import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of PublicSchool objects loaded from a CSV file.
 */
public class PublicSchools {
    private List<PublicSchool> schools;

    /**
     * Constructs a PublicSchools object by reading data from the CSV file.
     * @throws IOException if the file cannot be read.
     */
    public PublicSchools() throws IOException {
        this.schools = new ArrayList<>();
        readData();
    }

    /**
     * Constructs a PublicSchools object with an existing list of PublicSchool objects.
     *
     * @param schools the list of PublicSchool objects.
     */
    public PublicSchools(List<PublicSchool> schools) {
        this.schools = new ArrayList<>(schools);
    }

    /**
     * Reads the CSV file and creates PublicSchool objects.
     *
     * @throws IOException if the file cannot be found or read.
     */
    public void readData() throws IOException {
        String csvFileName = "src/main/resources/Edmonton_Public_Schools.csv";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFileName))) {
            // Skip header row
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 10) {
                    String schoolName = values[1].trim();
                    PublicSchool school = getPublicSchool(values, schoolName);
                    schools.add(school);
                }
            }
        }
    }

    private static PublicSchool getPublicSchool(String[] values, String schoolName) {
        String street = values[2].trim();
        String postalCode = values[3].trim();
        String phoneNumber = values[6].trim();
        String gradeLevel = values[9].trim();
        String programs = values[11].trim();
        String latitude = values[12].trim();
        String longitude = values[13].trim();
        PublicSchool school = new PublicSchool(schoolName, street, postalCode,
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
     * @return the PublicSchool object if found; otherwise, null.
     */
    public PublicSchool findBySchoolName(String schoolName) {
        for (PublicSchool school : schools) {
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
     * @return a new PublicSchools object containing schools that match the grade level.
     */
    public PublicSchools filterByGradeLevel(String gradeLevel) {
        List<PublicSchool> filtered = new ArrayList<>();
        for (PublicSchool school : schools) {
            if (school.getGradeLevel().equalsIgnoreCase(gradeLevel.trim())) {
                filtered.add(school);
            }
        }
        return new PublicSchools(filtered);
    }

    /**
     * Returns the list of PublicSchool objects.
     *
     * @return the list of schools.
     */
    public List<PublicSchool> getSchools() {
        return schools;
    }
}