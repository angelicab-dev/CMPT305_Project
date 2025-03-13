package ca.macewan.cmpt305lab;

import java.io.IOException;
import java.util.Scanner;

public class Lab3Main {

    public static void main(String[] args) throws IOException {


        // Property_Assessment_Data_2024.csv
        // 1103530 //sample
        // 121300
        // 11219526
        // 3925286 (first row)

        //ask user for filename
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter filename: ");
        String givenFileName = userInput.nextLine();

        System.out.println("\nCSV filename: " + givenFileName);
        String fileNamePath = "src\\main\\resources\\" + givenFileName;




        try {
            PropertyAssessments dataStatistics = new PropertyAssessments(fileNamePath);
            dataStatistics.readData(); // read the date and stores it in a arraylist

            try{
                System.out.println("\nPlease enter a neighbourhood name: ");

                Scanner neighbourhoodInput = new Scanner(System.in);
                String givenNeighbourhoodName = neighbourhoodInput.nextLine();

                PropertyAssessments neighbourhoodStatistics = dataStatistics.neighbourhoodAssessmentValues(givenNeighbourhoodName);

                //int result = neighbourhoodStatistics.countNeighbourhoodProperties(givenNeighbourhoodName);

                if(neighbourhoodStatistics.getN() == 0){
                    System.out.println("Neighbourhood not found");

                }
                else{
                    System.out.println("There are " + neighbourhoodStatistics.getN() + " properties in " + givenNeighbourhoodName);

                    System.out.println("The mean value is CAD " + neighbourhoodStatistics.calculateMean());

                    System.out.println("The median value is CAD " + neighbourhoodStatistics.calculateMedian());


                    try {
                        System.out.println("\nPlease enter an assessment class: ");
                        Scanner classInput = new Scanner(System.in);
                        String givenClassName = classInput.nextLine();
                        PropertyAssessments classAssessmentStatistics = dataStatistics.classAssessmentValues(givenClassName);


                        int value = classAssessmentStatistics.getN();
                        if(value == 0){
                            System.out.println("Sorry, can't find " + givenClassName + " properties");
                        }

                        else{
                            System.out.println("There are " + classAssessmentStatistics.getN() + " " + givenClassName + " properties in Edmonton");
                            System.out.println("The min value is CAD " + classAssessmentStatistics.calculateMin());

                            System.out.println("The max value is CAD " + classAssessmentStatistics.calculateMax());
                        }

                    }


                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

            }

            catch(Exception e){
                System.err.println("Error: " + e.getMessage());
            }


        } catch (IOException e) {
            System.err.println("Error: can't open " + givenFileName);
        }
    }


}
