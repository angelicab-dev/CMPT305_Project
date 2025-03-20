public class School {
    private String schoolName;
    private String street;
    private String postalCode;
    private String phoneNumber;
    private String gradeLevel;
    private Location location;

    public School(String schoolName, String street, String postalCode,
                  String phoneNumber, String gradeLevel, String latitude, String longitude) {
        this.schoolName = schoolName;
        this.street = street;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.gradeLevel = gradeLevel;
        this.location = new Location(latitude, longitude);
    }

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

    public Location getLocation() {
        return location;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }
}
