import java.util.List;
import java.util.Objects;

/**
 * Represents a property assessment.
 * Includes all the details about the property.
 * Account number, assessed value, address, neighbourhood, location, assessment class(es).
 * Implements comparable to be able to compare properties on their assessed values.
 */
public class PropertyAssessment implements Comparable<PropertyAssessment> {
    private String accountNumber;
    private int assessedValue;
    private Address address;
    private Neighbourhood neighbourhood;
    private Location location;
    private List<AssessmentClass> assessmentClasses;
    private int propertyTax;

    /**
     * Makes a new PropertyAssessment with the specified details.
     * @param accountNumber The unique account number of each property.
     * @param assessedValue The assessed value of the property.
     * @param suit The suit of the property.
     * @param houseNumber The house number of the property.
     * @param street The street of the property.
     * @param neighbourhood The neighbourhood name of the property.
     * @param ward The ward name of the property.
     * @param latitude The latitude of the property.
     * @param longitude The longitude of the property.
     * @param assessmentClasses The assessment classes of the property.
     */
    public PropertyAssessment(String accountNumber, int assessedValue, String suit, String houseNumber, String street, String neighbourhood, String ward, String latitude, String longitude, List<AssessmentClass> assessmentClasses) {
        this.accountNumber = accountNumber;
        this.assessedValue = assessedValue;
        this.address = new Address(suit, houseNumber, street);
        this.neighbourhood = new Neighbourhood(neighbourhood, ward);
        this.location = new Location(latitude, longitude);
        this.assessmentClasses = assessmentClasses;
        this.propertyTax = calculatePropertyTax(this.assessedValue);
    }

    /**
     * Returns the account number of the property.
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the assessed value of the property.
     * @return The assessed value.
     */
    public int getAssessedValue() {
        return assessedValue;
    }

    /**
     * Returns the address of the property.
     * @return The address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns the neighbourhood and ward of the property.
     * @return Returns the neighbourhood and ward together.
     */
    public Neighbourhood getNeighbourhood() {
        return neighbourhood;
    }

    /**
     * Returns the location of the property.
     * @return Returns the latitude and longitude together.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the list of the assessment classes of the property.
     * @return A list of assessment classes.
     */
    public List<AssessmentClass> getAssessmentClasses() {
        return assessmentClasses;
    }

    public int calculatePropertyTax(int propertyValue) {
        double taxRate = 0.089;
        return (int) (propertyValue * taxRate);
    }

    public int getPropertyTax() {
        return propertyTax;
    }





    /**
     * Compares assessed values of one property with another.
     * @param other the object to be compared.
     * @return Positive, negative, or a zero.
     */
    @Override
    public int compareTo(PropertyAssessment other) {
        return Integer.compare(this.assessedValue, other.assessedValue);
    }

    @Override
    public String toString() {
        return "Account Number = " + accountNumber + "\n" +
                "Address = " + address + "\n" +
                "Assessed Value = $" + assessedValue + "\n" +
                "Assessment Class = " + assessmentClasses + "\n" +
                "Neighbourhood = " + neighbourhood + "\n" +
                "Location = " + location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyAssessment that = (PropertyAssessment) o;
        return accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
