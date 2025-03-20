/**
 * Represents a Catholic school with selected details.
 */
public class CatholicSchool {
    private String schoolName;
    private String street;
    private String postalCode;
    private String phoneNumber;
    private String gradeLevel;
    private String programs;
    private Location location;

    /**
     * Constructs a new CatholicSchool.
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
    public CatholicSchool(String schoolName, String street, String postalCode, String phoneNumber,
                          String gradeLevel, String programs, String latitude, String longitude) {
        this.schoolName = schoolName;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.gradeLevel = gradeLevel;
        this.programs = programs;
        this.location = new Location(latitude, longitude);
    }

    // Getters
    public String getSchoolName() {
        return schoolName;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public String getPrograms() {
        return programs;
    }

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
        CatholicSchool that = (CatholicSchool) o;
        return schoolName.equals(that.schoolName);
    }

    @Override
    public int hashCode() {
        return schoolName.hashCode();
    }
}
