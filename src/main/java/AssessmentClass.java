import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Assessment class(es) for a property with how much percent each assessment class(es) is.
 */
public class AssessmentClass {
    private String className;
    private int percentage;

    /**
     * Makes an AssessmentClass with the class name and the correlating percentage.
     * @param className The name of the assessment class (Residential, commercial, etc).
     * @param percentage The percentage of the assessment class.
     */
    public AssessmentClass(String className, String percentage) {
        this.className = className.trim();
        try {
            this.percentage = Integer.parseInt(percentage);
        } catch (NumberFormatException e) {
            this.percentage = 0; // Default to 0% if invalid
        }
    }

    /**
     * Returns the name of the assessment class.
     * @return The class name.
     */
    public String getClassName() {
        return className;
    }

    /**
     * Returns the percentage of the associated assessment class.
     * @return the percentage value.
     */
    public int getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return className + " " + percentage + "%";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssessmentClass that = (AssessmentClass) o;
        return percentage == that.percentage && Objects.equals(className, that.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, percentage);
    }

    /**
     * Puts together the percentages and the names of the assessment class(es).
     * Percentages of the assessment classes are in columns 13, 14, 15 and the names are in the columns 16, 17, 18.
     * If empty it is skipped.
     * @param row An array of strings containing assessment class data.
     * @return A list of the assessment class objects parsed.
     */
    public static List<AssessmentClass> parseAssessmentClasses(String[] row) {
        List<AssessmentClass> assessmentClasses = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int percentIndex = 12 + i;
            int nameIndex = 15 + i;

            if (nameIndex < row.length) {
                String name = (row[nameIndex] != null) ? row[nameIndex].trim() : "";
                String percentage = (row[percentIndex] != null) ? row[percentIndex].trim() : "0";

                if (!name.isEmpty()) { // Ensures the name is valid
                    assessmentClasses.add(new AssessmentClass(name, percentage));
                }
            }
        }
        return assessmentClasses;
    }
}
