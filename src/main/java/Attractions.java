import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of Attraction objects loaded from a CSV file.
 */
public class Attractions {

    // Stores a list of all attractions from a CSV file
    private static List<Attraction> attractions;

    /**
     * Constructs an Attractions object by reading data from the CSV file.
     *
     * @throws IOException if the CSV file cannot be read.
     */
    public Attractions() throws IOException {
        attractions = new ArrayList<>();
        readData();
    }

    /**
     * Constructs an Attractions object with an existing list of Attraction objects.
     *
     * @param attractions a list of Attraction objects.
     */
    public Attractions(List<Attraction> attractions) {
        this.attractions = new ArrayList<>(attractions);

    }

    /**
     * Reads data from a CSV file and populates the attractions list.
     *
     * @throws IOException if the CSV file cannot be read.
     */
    public void readData() throws IOException {
        String csvFileName = "src/main/resources/Attractions_20250325.csv";

        try (Reader fileReader = Files.newBufferedReader(Paths.get(csvFileName));
             CSVReader csvReader = new CSVReaderBuilder(fileReader)
                     .withSkipLines(1)  // Skip the header row
                     .build()) {

            String[] values;

            while ((values = csvReader.readNext()) != null) {
                if (values.length >= 9) {
                    String attractionName = values[0].trim();
                    Attraction attraction = getAttraction(attractionName, values);
                    attractions.add(attraction);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Creates an Attraction object from the CSV row values.
     *
     * @param facilityName the name of the facility.
     * @param values an array of strings representing a CSV row.
     * @return an Attraction object populated with data from the CSV row.
     */
    private static Attraction getAttraction(String facilityName, String[] values) {
        String latitude = values[1].trim();
        String longitude = values[2].trim();
        String type = values[4].trim();
        String address = values[5].trim();
        String quadrant = values[6].trim();
        String url = values[7].trim();

        Attraction facility = new Attraction(facilityName, latitude, longitude, type, address, quadrant, url);
        return facility;
    }

    /**
     * Returns the total number of attractions loaded.
     *
     * @return the count of Attraction objects.
     */
    public int getTotalAttractions() {

        return attractions.size();
    }

    public Attraction findByFacilityName(String facilityName) {
        for (Attraction facility : attractions) {
            if (facility.getFacilityName().equalsIgnoreCase(facilityName.trim())) {
                return facility;
            }
        }
        return null;
    }

    /**
     * Finds and returns an Attraction by its facility name.
     *
     * @param facilityName the name of the facility to search for.
     * @return the Attraction object if found; otherwise, null.
     */
    public Attractions filterByAttractionType(String facilityType) {

        List<Attraction> filteredAttractions = new ArrayList<>();
        for (Attraction facility : attractions) {
            if (facility.getAttractionType().equalsIgnoreCase(facilityType.trim())) {
                filteredAttractions.add(facility);
            }
        }
        return new Attractions(filteredAttractions);
    }

    /**
     * Filters attractions based on their type.
     *
     * @param facilityType the type of attractions to filter by.
     * @return a new Attractions object containing attractions that match the specified type.
     */
    public static List<Attraction> getAttractions() {
        return attractions;
    }
}