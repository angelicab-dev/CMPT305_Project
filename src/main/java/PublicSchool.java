/**
 * Represents a Public school with selected details.
 */
public class PublicSchool {
    private String schoolName;
    private String street;
    private String postalCode;
    private String phoneNumber;
    private String gradeLevel;
    private String programs;
    private Location location;

    /**
     * Constructs a new PublicSchool.
     *
     * @param schoolName the name of the school.
     * @param street the street address.
     * @param postalCode the postal code.
     * @param phoneNumber the phone number.
     * @param gradeLevel the grade level(s) offered.
     * @param programs the programs offered.
     * @param latitude the latitude value as a String.
     * @param longitude the longitude value as a String.
     */
    public PublicSchool(String schoolName, String street, String postalCode, String phoneNumber,
                        String gradeLevel, String programs, String latitude, String longitude) {
        this.schoolName = schoolName;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.gradeLevel = gradeLevel;
        this.programs = programs;
        this.location = new Location(latitude, longitude);
    }

    /**
     * Returns the name of the school.
     * @return the school name.
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * Returns the street address.
     * @return the street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the postal code.
     * @return the postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Returns the phone number.
     * @return the phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the grade level(s) offered.
     * @return the grade level(s).
     */
    public String getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Returns the programs offered.
     * @return the programs.
     */
    public String getPrograms() {
        return programs;
    }

    /**
     * Returns the location of the school.
     * @return the longitude and latitude.
     */
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "School Name: " + schoolName + "\n" +
                "Street: " + street + "\n" +
                "Postal Code: " + postalCode + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Grade Level: " + gradeLevel + "\n" +
                "Programs: " + programs + "\n" +
                "Location: " + location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublicSchool that = (PublicSchool) o;
        return schoolName.equals(that.schoolName);
    }

    @Override
    public int hashCode() {
        return schoolName.hashCode();
    }
}
