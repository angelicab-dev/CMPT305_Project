package ca.macewan.cmpt305lab;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab2Main {
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

        System.out.println("CSV filename: " + givenFileName);
        String fileNamePath = "src\\main\\resources\\" + givenFileName;
        try{
            PropertyAssessments createData = new PropertyAssessments(fileNamePath);
            createData.readData(); // read the date and stores it in a arraylist
            PropertyAssessments dataStatistics = createData.propertiesAssessmentValues();

            //Statistics for of the whole date
            System.out.println("n = "+dataStatistics.getN());
            System.out.println("min = "+dataStatistics.calculateMin());
            System.out.println("max = "+dataStatistics.calculateMax());
            System.out.println("range = "+dataStatistics.calculateRange());
            System.out.println("mean = "+dataStatistics.calculateMean());
            System.out.println("median = "+dataStatistics.calculateMedian());



            try{
                Scanner accountNumInput = new Scanner(System.in);
                System.out.println("\nFind a property assessment by account number: ");
                int givenAccountNumber = Integer.parseInt(accountNumInput.nextLine());
                PropertyAssessments propertyStatistics = createData.propertyAssessment(givenAccountNumber);


                if(givenAccountNumber <0){
                    System.out.println("Account Number must be a positive number");
                }
                propertyStatistics.displayPropertyStatistics();


                try{
                    System.out.println("\nNeighbourhood: ");
                    Scanner neighbourhoodInput = new Scanner(System.in);
                    String givenNeighbourhoodName = neighbourhoodInput.nextLine();
                    PropertyAssessments neighbourhoodStatistics = createData.neighbourhoodAssessmentValues(givenNeighbourhoodName);
                    System.out.println("test: " + neighbourhoodStatistics);
                    if (neighbourhoodStatistics.getN() == 0){
                        System.out.print("Neighbourhood not found");
                        return;
                    }
                    else{
                        System.out.println("n: " + neighbourhoodStatistics.getN());
                        System.out.println("min = " + neighbourhoodStatistics.calculateMin());
                        System.out.println("max = " + neighbourhoodStatistics.calculateMax());
                        System.out.println("range = "+ neighbourhoodStatistics.calculateRange());
                        System.out.println("mean = "+ neighbourhoodStatistics.calculateMean());
                        System.out.println("median = "+ neighbourhoodStatistics.calculateMedian());
                    }


                }
                catch(NoSuchElementException e){
                    System.out.print("Neighbourhood not found");
                }
            }
            catch (NumberFormatException e){
                System.out.print("Error: Invalid account number");
            }
            catch(NoSuchElementException e){
                System.out.print("\nAccount number not found");
            }

        }
        catch(NoSuchFileException e){
            System.out.print("File not found or invalid: " + givenFileName);
        }
    }


}
