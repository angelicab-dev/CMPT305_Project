package ca.macewan.cmpt305lab;

import java.util.Arrays;
import java.util.*;



public class PropertyAssessment implements Comparable<PropertyAssessment> {

    private  String[] property; //string of all values a property contains
    private  int accountNumber; // index: 0
    private  int assessedValue; // index: 8
    private  String houseNumber;
    private  String streetName;
    private  String neighborhood;
    private int neighbourhoodId;
    private  String ward;
    private double latitude;
    private  double longitude;
    private  ArrayList<String> classList;
    private String classOne;
    private String classTwo;
    private String classThree;



    private  ArrayList<String> classListTest;
    private ArrayList<String> classPercentList;



    public PropertyAssessment(String[] property) {
        this.property = property;

        this.accountNumber = Integer.parseInt(property[0].trim());

        this.houseNumber = property[2].trim();
        this.streetName = property[3].trim();

        this.assessedValue = Integer.parseInt(property[8].trim());


        this.neighborhood = property[6].trim();

        this.ward = property[7].trim();

        this.latitude = Double.parseDouble(property[9].trim());
        this.longitude = Double.parseDouble(property[10].trim());

        this.classList = new ArrayList<>();
        this.classPercentList = new ArrayList<>();

        this.classOne = property[15].trim();

        this.classTwo = "";
        this.classThree = "";

        this.classListTest = new ArrayList<>();

    }

    public String displayAddress(){
        Address propertyAddress = new Address(this.houseNumber, this.streetName);
        return propertyAddress.toString();
    }

    public String displayLocation(){
        Location propertyLocation= new Location(this.latitude, this.longitude);
        return propertyLocation.toString();
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }
    public int getAssessedValue() {
        return this.assessedValue;
    }

    public String getNeighbourhood() {
        return this.neighborhood;
    }
    public String getWard() {

        return this.ward;
    }



    public void propertyClasses() {
        if(this.property.length == 16) {
            this.classList.add(this.classOne); //+ " " + property[13].trim() + "%";
            String line = this.classOne + " " + this.property[12].trim() + "%";
            this.classPercentList.add(line);
            //this.classList.add(classTwo);
            //this.classList.add(classThree);
        }

        if(this.property.length == 17) {
            this.classList.add(classOne);

            String line = this.classOne + " " + property[12].trim() + "%";
            this.classPercentList.add(line);

            this.classTwo = property[16].trim();
            this.classList.add(classTwo);

            String lineTwo = this.classTwo + " " + property[13].trim() + "%";
            this.classPercentList.add(lineTwo);
        }
        //String classTwoNum = property[13].trim() + "%";
        if(this.property.length == 18) {
            this.classList.add(classOne);

            String line = this.classOne + " " + property[12].trim() + "%";
            this.classPercentList.add(line);

            this.classTwo = property[16].trim();
            this.classList.add(classTwo);

            String lineTwo = this.classTwo + " " + property[13].trim() + "%";
            this.classPercentList.add(lineTwo);


            this.classThree = property[17].trim(); // + " " + property[14].trim() + "%";
            this.classList.add(classThree);

            String lineThree = this.classThree + " " + property[14].trim() + "%";
            this.classPercentList.add(lineThree);
        }


    }

    public ArrayList<String> getClassList() {
        return this.classList;
    }

    public ArrayList<String> classNameAndPercent() {
        return this.classPercentList;
    }




    public String[] getProperty() {
        return this.property;
    }

    @Override
    public String toString() {
        return Arrays.toString(property);
    }


    @Override
    public int hashCode(){
        return Objects.hashCode(this.accountNumber);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PropertyAssessment) {
            return this.accountNumber == ((PropertyAssessment) obj).accountNumber;
        }
        return false;
    }

    @Override
    public int compareTo(PropertyAssessment o) {

        if (this.neighborhood.compareTo(o.neighborhood) == 0)
            return 0;
        else if (this.neighborhood.compareTo(o.neighborhood) > 0)
            return 1;
        else
            return -1;
    }




}


