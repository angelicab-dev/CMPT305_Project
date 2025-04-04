/**
 * This class represents a school with its details
 */
public class School {
    private String schoolName;
    private String street;
    private String postalCode;
    private String phoneNumber;
    private String gradeLevel;
    private Location location;
    private String schoolType;

    /**
     * Constructor to initialize a school object
     *
     * @param schoolName  Name of the school
     * @param street      Street address of the school
     * @param postalCode  Postal code of the school
     * @param phoneNumber Phone number of the school
     * @param gradeLevel  Grade level of the school
     * @param latitude    Latitude of the school's location
     * @param longitude   Longitude of the school's location
     */
    public School(String schoolName, String street, String postalCode,
                  String phoneNumber, String gradeLevel, String latitude, String longitude, String schoolType) {
        this.schoolName = schoolName;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.gradeLevel = gradeLevel;
        this.location = new Location(latitude, longitude);
        this.schoolType = schoolType;
    }


    /**
     * Returns the name of the school.
     * @return the school name.
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * Returns the street address of the school.
     * @return the street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the postal code of the school.
     * @return the postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Returns the phone number of the school.
     * @return the phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the location of the school.
     * @return the location object containing latitude and longitude.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the grade level of the school.
     * @return the grade level.
     */
    public String getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Returns the school type (Catholic or Public)
     * @return the school type
     */
    public String getSchoolType() {
        return schoolType;
    }
}
