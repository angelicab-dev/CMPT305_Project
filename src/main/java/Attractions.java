import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.w3c.dom.Attr;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Attractions {

    // Stores a list of all attractions from a CSV file
    private List<Attraction> attractions;



    public Attractions() throws IOException {

        this.attractions = new ArrayList<>();
        readData();
    }

    public Attractions(List<Attraction> attractions) {
        this.attractions = new ArrayList<>(attractions);

    }


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
                    Attraction attraction = getAttraction(values, attractionName);
                    attractions.add(attraction);
                }
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    private static Attraction getAttraction(String[] values, String schoolName) {
        String latitude = values[1].trim();
        String longitude = values[2].trim();
        String type = values[4].trim();
        String address = values[5].trim();
        String quadrant = values[6].trim();
        String url = values[7].trim();


        Attraction facility = new Attraction(schoolName, latitude, longitude, type, address, quadrant, url);
        return facility;
    }

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

    public Attractions filterByAttractionType(String facilityType) {

        List<Attraction> filteredAttractions = new ArrayList<>();
        for (Attraction facility : attractions) {
            if (facility.getAttractionType().equalsIgnoreCase(facilityType.trim())) {
                filteredAttractions.add(facility);
            }
        }
        return new Attractions(filteredAttractions);
    }


    public List<Attraction> getAttractions() {
        return attractions;
    }

}
