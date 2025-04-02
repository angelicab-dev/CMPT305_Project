import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PropertyTaxes {


    /*
    To calculate property tax, the following are defined in Tax Breakdown:
    1. City budget
    2. Total assessed value of all properties in our city (extract from Property Assessments class)
    3. budget / total assessed value of all properties = municipal tax rate

    Property tax calculation:
    your property assessed value * municipal tax rate = your municipal property taxes
    - municipal tax rate (2024) = 8.9%
     */

    /*
    Has the same structure as PropertyAssessments class instead it will have a list of property taxes
     */

    private List<PropertyAssessment> properties;

    public PropertyTaxes() throws IOException {
        this.properties = new ArrayList<>();
        readData();

    }

    public PropertyTaxes(List<PropertyAssessment> properties) {
        this.properties = properties;
    }

    public List<PropertyAssessment> getAssessments() {
        return properties;
    }

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

    public void addPropertyAssessment(PropertyAssessment property) {
        properties.add(property);
    }

    public PropertyTaxes filterByAssessmentClass(String assessmentClass) {
        List<PropertyAssessment> filteredList = new ArrayList<>();

        for (PropertyAssessment property : properties) {
            for (AssessmentClass assessment : property.getAssessmentClasses()) {
                String classType = assessment.getClassName();

                if (classType.equalsIgnoreCase(assessmentClass.trim())) {
                    filteredList.add(property);
                    break; // Avoid duplicate additions
                }
            }
        }
        return new PropertyTaxes(filteredList);
    }

    public double calculateMinPropertyTax() {
        return properties.stream().mapToInt(PropertyAssessment::getPropertyTax).min().orElse(0);
    }

    public double calculateMaxPropertyTax() {
        return properties.stream().mapToInt(PropertyAssessment::getPropertyTax).max().orElse(0);
    }




    /*
    private int propertyValue;
    private List<PropertyAssessment> propertyAssessments;

    //private List<> modifiedAssessmentList;

    public PropertyTaxes(List<PropertyAssessment> propertyAssessmentsList) {
        this.propertyAssessments = propertyAssessmentsList;
    }

    public PropertyTaxes(int assessedPropertyValue) {
        this.propertyValue = assessedPropertyValue;
    }

    public int getPropertyValue() {
        return propertyValue;
    }

    public double calculatePropertyTax() {
        double taxRate = 0.089;
        return propertyValue * taxRate;
    }

     */





}
