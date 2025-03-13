package ca.macewan.cmpt305lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PropertyAssessments {

    private String csvFileName;
    private ArrayList<PropertyAssessment> data;

    private ArrayList<PropertyAssessment> arrayAssessmentValues;

    String neighbourhoodName;


    public PropertyAssessments(String csvFileName) throws IOException {
        this.csvFileName = csvFileName;

    }

    public PropertyAssessments(ArrayList<PropertyAssessment> assessmentValues) throws IOException {

        this.arrayAssessmentValues = assessmentValues;
    }


    public void readData() throws IOException{

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvFileName))) {
            // Skip the header - this assumes the first line is a header
            reader.readLine();

            data = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");
                PropertyAssessment property = new PropertyAssessment(values);

                data.add(property);

            }
        }

    }

    public PropertyAssessments propertiesAssessmentValues() throws IOException {
        PropertyAssessments propertyAssessments = new PropertyAssessments(data);
        return propertyAssessments;
    }

    public PropertyAssessments neighbourhoodAssessmentValues(String neighbourhoodName) throws IOException{
        this.neighbourhoodName = neighbourhoodName.toUpperCase();
        ArrayList<PropertyAssessment> arrayNeighbourhoodAssessmentValues  = new ArrayList<>();

        //for loop to through the data
        for (int i = 0; i < data.size(); i++) {

            PropertyAssessment property = data.get(i);

            //filters the data by neighbourhood name
            if (property.getNeighbourhood().compareTo(neighbourhoodName.toUpperCase()) == 0) {
                arrayNeighbourhoodAssessmentValues.add(property);
            }
        }
        //return a PropertyAssessment object with the updated array of given neighbourhood name
        return new PropertyAssessments(arrayNeighbourhoodAssessmentValues);

    }

    public PropertyAssessments propertyAssessment(int accountNumber) throws IOException{

        ArrayList<PropertyAssessment> extractedProperty  = new ArrayList<>();

        //for loop to through the data
        for (int i = 0; i < data.size(); i++) {

            PropertyAssessment property = data.get(i);

            //filters the data by neighbourhood name
            if ((property.getAccountNumber()) == accountNumber) {
                extractedProperty.add(property);

            }
        }
        //return a PropertyAssessment object with the updated array of given neighbourhood name
        return new PropertyAssessments(extractedProperty);

    }

    public PropertyAssessments classAssessmentValues(String className) throws IOException {
        ArrayList<PropertyAssessment>  assessmentClassValues = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {

            PropertyAssessment property = data.get(i);
            property.propertyClasses();

            //(assessmentClass.getClassList().contains(allCaps))
            if (property.getClassList().contains((className.toUpperCase()))) {
                //System.out.println("neighbourhood matches");
                assessmentClassValues.add(property);
            }

        }
        return new PropertyAssessments(assessmentClassValues);

    }

    public int getN(){
            return arrayAssessmentValues.size();
    }

    public int calculateMin() throws IOException {

        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0; i < arrayAssessmentValues.size(); i++){
            PropertyAssessment assessmentValue = arrayAssessmentValues.get(i);
            values.add(assessmentValue.getAssessedValue());
        }
        Collections.sort(values);
        return values.getFirst();
    }

    public int calculateMax() throws IOException {
        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0; i < arrayAssessmentValues.size(); i++){
            PropertyAssessment assessmentValue = arrayAssessmentValues.get(i);
            values.add(assessmentValue.getAssessedValue());

        }
        Collections.sort(values);
        return values.get(values.size()-1);
    }

    public int calculateRange() throws IOException {
        int min = calculateMin();
        int max = calculateMax();
        //int range = max - min;
        return max - min;
    }


    public int calculateMean(){


        double addValues = 0;
        for (int i = 0; i < arrayAssessmentValues.size(); i++) {
            //PropertyAssessment property = arrayAssessmentValues.get(i);
            double assessedValue = arrayAssessmentValues.get(i).getAssessedValue();
            addValues += assessedValue;
            //addValues += arrayAssessmentValues.get(i);
        }

        double calculateMean = addValues / arrayAssessmentValues.size();
        return (int) Math.round(calculateMean);
    }


    public int calculateMedian() {

        int[] assessedValues = new int [arrayAssessmentValues.size()];
        for (int i = 0; i < arrayAssessmentValues.size(); i++) {
            PropertyAssessment property = arrayAssessmentValues.get(i);
            assessedValues[i] = (property.getAssessedValue());

        }

        Arrays.sort(assessedValues);
        if((assessedValues.length)%2 == 0){ // length of array is even

            int firstNum = assessedValues.length/2;
            int secondNum =(assessedValues.length/2)+1;
            int middleNum = (firstNum+secondNum)/2;

            //return arrayIntegers.get(middleNum);
            return assessedValues[middleNum];
        }
        else{ // length of array is odd

            int index = (assessedValues.length+1)/2;
            return assessedValues[index];
        }

    }



    public void displayPropertyStatistics() throws IOException {

        PropertyAssessment property = arrayAssessmentValues.getFirst();



        System.out.println("Account number = " + property.getAccountNumber());
        System.out.println("Address = " + property.displayAddress());
        System.out.println("Assessed value = " + property.getAssessedValue());

        property.propertyClasses();

        System.out.println("Assessment class: " + property.classNameAndPercent());
        System.out.println("Neighbourhood = " + property.getNeighbourhood() + " (" + property.getWard() + ")");
        System.out.println("Location = " + "(" + property.displayLocation() + ")");



    }


    @Override
    public String toString() {
        return Arrays.toString(arrayAssessmentValues.toArray());
    }


}
