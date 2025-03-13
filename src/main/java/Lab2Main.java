import java.io.IOException;
import java.util.*;

/**
 * Client side main for lab 2.
 */
public class Lab2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("CSV Filename: ");
        String fileName = scanner.nextLine();
        String csvFileName = "src/main/resources/" + fileName;

        try {
            PropertyAssessments propertyAssessments = new PropertyAssessments(csvFileName);
            System.out.println("Descriptive statistics of all property assessments");
            printData(propertyAssessments);

            // Stats by account number
            System.out.print("\nFind a property assessment by account number: ");
            String accountNumber = scanner.nextLine();
            PropertyAssessment property = propertyAssessments.findByAccountNumber(accountNumber);
            if (property != null) {
                System.out.println(property);
            } else {
                System.out.println("Error: invalid account number...");
            }

            // Stats by neighbourhood
            System.out.print("\nEnter a neighbourhood to see statistics: ");
            String neighbourhood = scanner.nextLine();
            PropertyAssessments neighbourhoodAssessments = propertyAssessments.filterByNeighbourhood(neighbourhood);

            if (neighbourhoodAssessments.getTotalRecords() > 0) {
                System.out.println("\nNeighbourhood: " + neighbourhood);
                System.out.println("Statistics (neighbourhood = " + neighbourhood + ")");
                printData(neighbourhoodAssessments);
            } else {
                System.out.println("No property assessments found for neighbourhood: " + neighbourhood);
            }

        } catch (IOException e) {
            System.out.println("Error: can't open file " + fileName);
        } finally {
            scanner.close();
        }
    }

    /**
     * Prints out the data from the csv
     * @param propertyAssessments PropertyAssessment object where property data is stored
     */
    public static void printData(PropertyAssessments propertyAssessments) {
        System.out.println("n = " + propertyAssessments.getTotalRecords());
        System.out.println("min = $" + propertyAssessments.calculateMinAssessedValue());
        System.out.println("max = $" + propertyAssessments.calculateMaxAssessedValue());
        System.out.println("range = $" + propertyAssessments.calculateRangeAssessedValue());
        System.out.println("mean = $" + propertyAssessments.calculateMeanAssessedValue());
        System.out.println("median = $" + propertyAssessments.calculateMedianAssessedValue());
    }
}
