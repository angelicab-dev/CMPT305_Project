import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represets a collection of property assessments loaded from the csv file.
 * Statistical calculations.
 */
public class PropertyAssessments {
    private List<PropertyAssessment> assessments;

    /**
     * Makes a PropertyAssessments object by reading data from the csv file.
     * @throws IOException If the file can't be read or opened.
     */
    public PropertyAssessments() throws IOException {
        this.assessments = new ArrayList<>();
        readData();
    }

    /**
     * Makes a PropertyAssessments object with an existing list of PropertyAssessment objects.
     * @param assessments
     */
    public PropertyAssessments(List<PropertyAssessment> assessments) {
        this.assessments = new ArrayList<>(assessments);
    }

    /**
     * Returns the list of property assessments.
     * @return The list of property assessments.
     */
    public List<PropertyAssessment> getAssessments() {
        return assessments;
    }

    /**
     * Read the contents of a CSV file line by line and put it in the propertyAssessment collection.
     * @throws IOException If the file cannot be found or read
     */
    public void readData() throws IOException {
        String csvFileName = "src/main/resources/Property_Assessment_Data_2024.csv";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFileName))) {
            reader.readLine(); // Skip header
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 8) {
                    String accountNumber = values[0];
                    int assessedValue = Integer.parseInt(values[8]);
                    String suite = values[1];
                    String houseNumber = values[2];
                    String street = values[3];
                    String neighbourhood = values[6];
                    String ward = values[7];
                    String latitude = values[9];
                    String longitude = values[10];
                    List<AssessmentClass> assessmentClasses = AssessmentClass.parseAssessmentClasses(values);

                    addPropertyAssessment(new PropertyAssessment(accountNumber, assessedValue, suite, houseNumber, street, neighbourhood, ward, latitude, longitude, assessmentClasses));
                }
            }
        }
    }

    /**
     * Filters by neighbourhood name of each of the properties.
     * @param neighbourhood Name of the neighbourhood to filter by.
     * @return A new PropertyAssessments object containing only the properties from the filtered neighbourhood name.
     */
    public PropertyAssessments filterByNeighbourhood(String neighbourhood) {
        List<PropertyAssessment> filteredList = new ArrayList<>();

        for (PropertyAssessment property : assessments) {
            String neighbourhoodName = property.getNeighbourhood().getName();

            if (neighbourhoodName.trim().equalsIgnoreCase(neighbourhood.trim())) {
                filteredList.add(property);
            }
        }
        return new PropertyAssessments(filteredList);
    }

    /**
     * Filters by assessment class of each of the properties.
     * @param assessmentClass Name of the assessment class to filter by.
     * @return A new PropertyAssessments object containing only the properties from the filtered assessment class.
     */
    public PropertyAssessments filterByAssessmentClass(String assessmentClass) {
        List<PropertyAssessment> filteredList = new ArrayList<>();

        for (PropertyAssessment property : assessments) {
            for (AssessmentClass assessment : property.getAssessmentClasses()) {
                String classType = assessment.getClassName();

                if (classType.equalsIgnoreCase(assessmentClass.trim())) {
                    filteredList.add(property);
                    break; // Avoid duplicate additions
                }
            }
        }
        return new PropertyAssessments(filteredList);
    }

    /**
     * Adds a new property assessment to the collection.
     * @param property The PropertyAssessment object to add.
     */
    public void addPropertyAssessment(PropertyAssessment property) {
        assessments.add(property);
    }

    /**
     * Searches for a property assessment by its account number.
     * @param accountNumber The account number to search for.
     * @return The PropertyAssessment object with the matching account number.
     */
    public PropertyAssessment findByAccountNumber(String accountNumber) {
        for (PropertyAssessment property : assessments) {
            if (property.getAccountNumber().equals(accountNumber)) {
                return property;
            }
        }
        return null;
    }

    /**
     * Gets the total record size of the csv file.
     * @return Total size of csv property assessments.
     */
    public int getTotalRecords() {
        return assessments.size();
    }

    /**
     * Uses stream().mapToInt to find the min value for assessed value.
     * @return Lowest assessed value.
     */
    public int calculateMinAssessedValue() {
        return assessments.stream().mapToInt(PropertyAssessment::getAssessedValue).min().orElse(0);
    }

    /**
     * Uses stream().mapToInt to find the max value for assessed value.
     * @return Highest assessed value.
     */
    public int calculateMaxAssessedValue(){
        return assessments.stream().mapToInt(PropertyAssessment::getAssessedValue).max().orElse(0);
    }

    /**
     * Uses stream().mapToInt to find the mean value for assessed value.
     * @return Average assessed value.
     */
    public int calculateMeanAssessedValue() {
        return assessments.isEmpty() ? 0 : (int) assessments.stream().mapToInt(PropertyAssessment::getAssessedValue).average().orElse(0);
    }

    /**
     * Checks if empty, if not, calculates the mean value.
     * @return Mean assessed value.
     */
    public int calculateMedianAssessedValue() {
        if (assessments.isEmpty()) {
            return 0;
        }
        List<Integer> values = new ArrayList<>();
        for (PropertyAssessment property : assessments) {
            values.add(property.getAssessedValue());
        }
        values.sort(Integer::compareTo);
        int size = values.size();
        return (size % 2 == 1) ? values.get(size / 2) : (values.get(size / 2) + values.get(size / 2 - 1)) / 2;
    }

    /**
     * Gets the max and min values from assessed value and minuses them to get the range.
     * @return Range of assessed value.
     */
    public int calculateRangeAssessedValue() {
        int min = assessments.stream().mapToInt(PropertyAssessment::getAssessedValue).min().orElse(0);
        int max = assessments.stream().mapToInt(PropertyAssessment::getAssessedValue).max().orElse(0);
        return max - min;
    }
}
