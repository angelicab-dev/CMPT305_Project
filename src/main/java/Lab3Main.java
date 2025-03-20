import java.util.Scanner;
import java.io.IOException;

/**
 * Client side main for lab 3.
 */
public class Lab3Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the CSV filename: ");
        String fileName = scanner.nextLine();
        String csvFilePath = "src/main/resources/" + fileName;

        try {
            PropertyAssessments propertyAssessments = new PropertyAssessments();

            // Prompt for neighbourhood and filter
            System.out.print("Please enter a neighbourhood name: ");
            String neighbourhood = scanner.nextLine();
            PropertyAssessments neighbourhoodAssessments = propertyAssessments.filterByNeighbourhood(neighbourhood);

            if (neighbourhoodAssessments.getTotalRecords() > 0) {
                System.out.println("There are " + neighbourhoodAssessments.getTotalRecords() + " properties in " + neighbourhood);
                System.out.println("The mean value is CAD " + neighbourhoodAssessments.calculateMeanAssessedValue());
                System.out.println("The median value is CAD " + neighbourhoodAssessments.calculateMedianAssessedValue());
                System.out.println("The max value is CAD " + neighbourhoodAssessments.calculateMaxAssessedValue());
                System.out.println("The min value is " + neighbourhoodAssessments.calculateMinAssessedValue());
            } else {
                System.out.println("Sorry, can't find data in " + neighbourhood);
            }

            // Prompt for assessment class and filter
            System.out.print("\nPlease enter an assessment class: ");
            String assessmentClass = scanner.nextLine();
            PropertyAssessments assessmentFiltered = propertyAssessments.filterByAssessmentClass(assessmentClass);

            if (assessmentFiltered.getTotalRecords() > 0) {
                System.out.println("There are " + assessmentFiltered.getTotalRecords() + " " + assessmentClass + " properties in Edmonton");
                System.out.println("The min value is CAD " + assessmentFiltered.calculateMinAssessedValue());
                System.out.println("The max value is CAD " + assessmentFiltered.calculateMaxAssessedValue());
                System.out.println("The mean value is CAD " + assessmentFiltered.calculateMeanAssessedValue());
                System.out.println("The median value is CAD " + assessmentFiltered.calculateMedianAssessedValue());
            } else {
                System.out.println("Sorry, can't find " + assessmentClass + " properties.");
            }

        } catch (IOException e) {
            System.out.println("Error in opening " + fileName);
        } finally {
            scanner.close();
        }
    }
}
