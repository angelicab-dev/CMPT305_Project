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


}
