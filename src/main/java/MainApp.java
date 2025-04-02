import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Use a BorderPane to split the window into left for the filters and right for the map.
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: white;"); // White background for the entire BorderPane

        //Application Icon
        Image appIcon = new Image(String.valueOf(getClass().getResource("/House_Icon.png")));
        primaryStage.getIcons().add(appIcon);

        // Left Pane (Filters)
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(20));
        leftPane.setHgap(10);
        leftPane.setVgap(10);

        // "Filter" title
        Label filterByLabel = new Label("FILTER");
        filterByLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        leftPane.add(filterByLabel, 0, 0, 2, 1);

        //Filter Icon
        Image filterIcon = new Image(String.valueOf(getClass().getResource("/filter-icon.png")));
        ImageView filterIconView = new ImageView(filterIcon);
        filterIconView.setFitWidth(20);
        filterIconView.setFitHeight(20);
        filterIconView.setPreserveRatio(true);

        //Hbox for the filter icon and text
        HBox hbox = new HBox(10, filterIconView, filterByLabel);
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setStyle("-fx-padding: 5;");

        //Hbox added to the left pane
        leftPane.add(hbox, 0, 0, 2, 1);

        // Assessed Value with checkbox
        CheckBox cbAssessedValue = new CheckBox("Assessed Value");
        cbAssessedValue.setStyle(
                "-fx-font-size: 14px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-min-width: 25px; " +
                        "-fx-min-height: 25px; "
        );

        cbAssessedValue.setTextFill(Color.DARKBLUE);
        leftPane.add(cbAssessedValue, 0, 1, 2, 1);

        // Min/Max Assessed Value
        Label lblMinAssessed = new Label("Min ($):");
        lblMinAssessed.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        TextField tfMinAssessed = new TextField();
        tfMinAssessed.setPromptText("Min Assessed Value");
        leftPane.add(lblMinAssessed, 0, 2);
        leftPane.add(tfMinAssessed, 1, 2);

        Label lblMaxAssessed = new Label("Max ($):");
        lblMaxAssessed.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        TextField tfMaxAssessed = new TextField();
        tfMaxAssessed.setPromptText("Max Assessed Value");
        leftPane.add(lblMaxAssessed, 0, 3);
        leftPane.add(tfMaxAssessed, 1, 3);

        // Attractions with checkbox
        CheckBox cbAttractions = new CheckBox("Attractions");
        cbAttractions.setStyle(
                "-fx-font-size: 14px; " + "-fx-font-weight: bold;" + "-fx-min-width: 25px;" + "-fx-min-height: 25px;" + "-fx-padding: 15px 0px 0px 0px;"
        );
        cbAttractions.setTextFill(Color.DARKBLUE);
        leftPane.add(cbAttractions, 0, 4, 2, 1);

        // Attractions Address and Radius
        Label lblAttrAddress = new Label("Address:");
        lblAttrAddress.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        TextField tfAttrAddress = new TextField();
        tfAttrAddress.setPromptText("Home Address");
        leftPane.add(lblAttrAddress, 0, 5);
        leftPane.add(tfAttrAddress, 1, 5);

        Label lblAttrRadius = new Label("Radius (km):");
        lblAttrRadius.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        Slider sldAttrRadius = new Slider();
        sldAttrRadius.setMin(0);
        sldAttrRadius.setMax(10);
        sldAttrRadius.setValue(5);
        sldAttrRadius.setMajorTickUnit(2);
        sldAttrRadius.setShowTickLabels(true);
        sldAttrRadius.setShowTickMarks(true);
        leftPane.add(sldAttrRadius, 1, 6);
        leftPane.add(lblAttrRadius, 0, 6);

        // Property Tax with checkbox
        CheckBox cbPropertyTax = new CheckBox("Property Tax");
        cbPropertyTax.setStyle(
                "-fx-font-size: 14px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-min-width: 25px; " +
                        "-fx-min-height: 25px; "
        );
        cbPropertyTax.setTextFill(Color.DARKBLUE);
        leftPane.add(cbPropertyTax, 0, 7, 2, 1);

        Label lblMinTax = new Label("Min ($):");
        lblMinTax.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        TextField tfMinTax = new TextField();
        tfMinTax.setPromptText("Min Tax Value");
        leftPane.add(lblMinTax, 0, 8);
        leftPane.add(tfMinTax, 1, 8);

        Label lblMaxTax = new Label("Max ($):");
        lblMaxTax.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );
        TextField tfMaxTax = new TextField();
        tfMaxTax.setPromptText("Max Tax Value");
        leftPane.add(lblMaxTax, 0, 9);
        leftPane.add(tfMaxTax, 1, 9);

        // Schools with checkbox
        CheckBox cbSchools = new CheckBox("Schools");
        cbSchools.setStyle(
                "-fx-font-size: 14px; " + "-fx-font-weight: bold;" + "-fx-min-width: 25px;" + "-fx-min-height: 25px;"+"-fx-padding: 15px 0px 0px 0px;"
        );
        cbSchools.setTextFill(Color.DARKBLUE);

        leftPane.add(cbSchools, 0, 10, 2, 1);

        // Schools School dropdown, Address, Radius
        Label lblSchool = new Label("School:");
        lblSchool.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        ComboBox<String> cbSchoolType = new ComboBox<>();
        cbSchoolType.getItems().addAll("All", "Catholic", "Public");
        cbSchoolType.setValue("All");
        leftPane.add(lblSchool, 0, 11);
        leftPane.add(cbSchoolType, 1, 11);

        Label lblSchoolAddress = new Label("Address:");
        lblSchoolAddress.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        TextField tfSchoolAddress = new TextField();
        tfSchoolAddress.setPromptText("Home Address");
        leftPane.add(lblSchoolAddress, 0, 12);
        leftPane.add(tfSchoolAddress, 1, 12);

        Label lblSchoolRadius = new Label("Radius (km):");
        lblSchoolRadius.setStyle(
                "-fx-font-size: 12px; " +
                        "-fx-font-weight: bold; "
        );

        Slider sldSchoolRadius = new Slider();
        sldSchoolRadius.setMin(0);
        sldSchoolRadius.setMax(10);
        sldSchoolRadius.setValue(5);
        sldSchoolRadius.setMajorTickUnit(2);
        sldSchoolRadius.setShowTickLabels(true);
        sldSchoolRadius.setShowTickMarks(true);
        leftPane.add(lblSchoolRadius, 0, 13);
        leftPane.add(sldSchoolRadius, 1, 13);

        // Search Button
        Button btnSearch = new Button("Search");
        btnSearch.setStyle(
                "-fx-font-size: 16px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-color: DARKBLUE; " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 5px 50px; " +
                        "-fx-border-radius: 8px; " +
                        "-fx-background-radius: 8px;"
        );
        leftPane.add(btnSearch, 0, 14, 2, 1);

        // Center Pane (Map View)
        MapView mapPane = new MapView();
        mapPane.setPrefSize(375, 450);
        VBox centerPane = new VBox();
        centerPane.getChildren().add(mapPane);

        // Right Pane (Table Tabs)
        VBox rightPane = new VBox();
        rightPane.setPadding(new Insets(10));


        // Create TabPane
        TabPane tabPane = new TabPane();
        tabPane.setPrefHeight(200);

        // Home Table using PropertyAssessment objects
        TableView<PropertyAssessment> homesTable = new TableView<>();
        tabPane.setPrefHeight(800);
        tabPane.setPrefWidth(500);

        TableColumn<PropertyAssessment, String> assessedValueCol = new TableColumn<>("Assessed Value");
        assessedValueCol.setCellValueFactory(new PropertyValueFactory<>("assessedValue"));
        assessedValueCol.setMinWidth(140);

        TableColumn<PropertyAssessment, String> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressCol.setMinWidth(183);

        TableColumn<PropertyAssessment, String> neighbourhoodCol = new TableColumn<>("Neighbourhood");
        neighbourhoodCol.setCellValueFactory(new PropertyValueFactory<>("neighbourhood"));
        neighbourhoodCol.setMinWidth(183);

        homesTable.getColumns().addAll(assessedValueCol, addressCol, neighbourhoodCol);

        //Property Tax tab
        // Table view initializes a table for property tab
        TableView<PropertyAssessment> propertyTaxTable = new TableView<>();
        tabPane.setPrefHeight(800);
        tabPane.setPrefWidth(500);

        /*
        No content for the Property Tax yet
        */
        TableColumn<PropertyAssessment, String> assessedValueTaxTab = new TableColumn<>("Assessed Value");
        assessedValueTaxTab.setCellValueFactory(new PropertyValueFactory<>("assessedValue"));
        assessedValueTaxTab.setMinWidth(160);

        TableColumn<PropertyAssessment, Integer> propertyTaxCol = new TableColumn<>("Property Tax");
        assessedValueTaxTab.setCellValueFactory(new PropertyValueFactory<>("propertyTax"));
        propertyTaxCol.setMinWidth(160);

        TableColumn<PropertyAssessment, String> addressTaxTab = new TableColumn<>("Address");
        addressTaxTab.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressTaxTab.setMinWidth(160);

        propertyTaxTable.getColumns().addAll(assessedValueTaxTab, propertyTaxCol, addressTaxTab);


        // Schools Table using School objects
        TableView<School> schoolsTable = new TableView<>();
        schoolsTable.setPrefHeight(200);
        schoolsTable.setPrefWidth(550);

        TableColumn<School, String> schoolNameCol = new TableColumn<>("School Name");
        schoolNameCol.setCellValueFactory(new PropertyValueFactory<>("schoolName"));
        schoolNameCol.setPrefWidth(131);

        TableColumn<School, String> streetCol = new TableColumn<>("Address");
        streetCol.setCellValueFactory(new PropertyValueFactory<>("street"));
        streetCol.setPrefWidth(121);

        TableColumn<School, String> postalCodeCol = new TableColumn<>("Postal Code");
        postalCodeCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        postalCodeCol.setPrefWidth(75);

        TableColumn<School, String> phoneNumberCol = new TableColumn<>("Phone Number");
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumberCol.setPrefWidth(90);

        TableColumn<School, String> gradeLevelCol = new TableColumn<>("Grade Level(s)");
        gradeLevelCol.setCellValueFactory(new PropertyValueFactory<>("gradeLevel"));
        gradeLevelCol.setPrefWidth(131);

        schoolsTable.getColumns().addAll(schoolNameCol, streetCol, postalCodeCol, phoneNumberCol, gradeLevelCol);

        // Attraction Table using Attraction objects
        TableView<Attraction> attractionsTable = new TableView<>();
        attractionsTable.setPrefHeight(200);
        attractionsTable.setPrefWidth(550);

        TableColumn<Attraction, String> attractionNameCol = new TableColumn<>("Name");
        attractionNameCol.setCellValueFactory(new PropertyValueFactory<>("facilityName"));
        attractionNameCol.setPrefWidth(183);

        TableColumn<Attraction, String> attractionTypeCol = new TableColumn<>("Type");
        attractionTypeCol.setCellValueFactory(new PropertyValueFactory<>("attractionType"));
        attractionTypeCol.setPrefWidth(183);

        TableColumn<Attraction, String> attractionAddressCol = new TableColumn<>("Address");
        attractionAddressCol.setCellValueFactory(new PropertyValueFactory<>("attractionAddress"));
        attractionAddressCol.setPrefWidth(183);

        attractionsTable.getColumns().addAll(attractionNameCol, attractionTypeCol, attractionAddressCol);

        // Create Homes Tab
        Tab homeTab = new Tab("Homes", homesTable);
        homeTab.setClosable(false);

        // Create Property Tax Tab
        Tab taxTab = new Tab("Property Tax", propertyTaxTable);
        taxTab.setClosable(false);


        // Create School Tab
        Tab schoolsTab = new Tab("Schools", schoolsTable);
        schoolsTab.setClosable(false);

        // Create Attractions Tab
        Tab attractionsTab = new Tab("Attractions", attractionsTable);
        attractionsTab.setClosable(false);

        tabPane.getTabs().addAll(homeTab,taxTab, schoolsTab, attractionsTab);
        rightPane.getChildren().add(tabPane);


        root.setLeft(leftPane);
        root.setCenter(centerPane);
        root.setRight(rightPane);
        // Search Button Event Handler
        btnSearch.setOnAction(e -> {
            // Clear the map markers at the start of each search so they don't overlap.
            mapPane.clearMarkers();

            if (cbAssessedValue.isSelected()) {
                try {
                    // Load all property assessments from the CSV
                    PropertyAssessments propertyAssessments = new PropertyAssessments();

                    // First, filter by "Residential" only
                    PropertyAssessments residentialOnly = propertyAssessments.filterByAssessmentClass("Residential");

                    // Determine min and max values from the text fields
                    int minValue = tfMinAssessed.getText().isEmpty()
                            ? residentialOnly.calculateMinAssessedValue()
                            : Integer.parseInt(tfMinAssessed.getText().trim());
                    int maxValue = tfMaxAssessed.getText().isEmpty()
                            ? residentialOnly.calculateMaxAssessedValue()
                            : Integer.parseInt(tfMaxAssessed.getText().trim());

                    // Filter the properties within that range
                    ObservableList<PropertyAssessment> filteredProperties = FXCollections.observableArrayList();
                    for (PropertyAssessment pa : residentialOnly.getAssessments()) {
                        // Add this filter: if assessed value is less than 10,000, skip it.
                        if (pa.getAssessedValue() < 10000) {
                            continue;
                        }
                        if (pa.getAddress().getFullAddress().trim().isEmpty()) {
                            continue;
                        }
                        if (pa.getAssessedValue() >= minValue && pa.getAssessedValue() <= maxValue) {
                            filteredProperties.add(pa);
                        }
                    }

                    //sort filteredProperties in ascending order
                    filteredProperties = filteredProperties.stream()
                            .sorted(Comparator.comparing(PropertyAssessment::getAssessedValue))
                            .collect(Collectors.toCollection(FXCollections::observableArrayList));

                    // Display them in the Homes table
                    homesTable.setItems(filteredProperties);

                    // Add markers for each assessed property using the "home" marker type
                    for (PropertyAssessment pa : filteredProperties) {
                        double lat = pa.getLocation().getLatitude();
                        double lon = pa.getLocation().getLongitude();
                        mapPane.addMarker(lat, lon, "home");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (cbAttractions.isSelected()) {
                try {
                    Attractions attractionsData = new Attractions();
                    List<Attraction> allAttractions = attractionsData.getAttractions();
                    ObservableList<Attraction> attractionsList = FXCollections.observableArrayList(allAttractions);

                    String attractionAddress = tfAttrAddress.getText().trim();
                    if (!attractionAddress.isEmpty()) {
                        // Look for a property assessment with the provided address
                        PropertyAssessments propertyAssessments = new PropertyAssessments();
                        PropertyAssessment centerProperty = null;
                        for (PropertyAssessment pa : propertyAssessments.getAssessments()) {
                            if (pa.getAddress().getFullAddress().equalsIgnoreCase(attractionAddress)) {
                                centerProperty = pa;
                                break;
                            }
                        }

                        // If a matching property is found, use its location as the center for radius filtering
                        if (centerProperty != null) {
                            double centerLat = centerProperty.getLocation().getLatitude();
                            double centerLon = centerProperty.getLocation().getLongitude();
                            double radiusKm = sldAttrRadius.getValue();

                            ObservableList<Attraction> filteredAttractions = FXCollections.observableArrayList();
                            for (Attraction attraction : allAttractions) {
                                double attractionLat = attraction.getAttractionLocation().getLatitude();
                                double attractionLon = attraction.getAttractionLocation().getLongitude();
                                double distance = Radius.calculateDistance(centerLat, centerLon, attractionLat, attractionLon);
                                if (distance <= radiusKm) {
                                    filteredAttractions.add(attraction);
                                }
                            }
                            attractionsList = filteredAttractions;
                        }
                    }

                    // Update the attractions table with the (possibly) filtered list.
                    attractionsTable.setItems(attractionsList);

                    // Add markers for each attraction using the "attraction" marker type
                    for (Attraction attraction : attractionsList) {
                        double lat = attraction.getAttractionLocation().getLatitude();
                        double lon = attraction.getAttractionLocation().getLongitude();
                        mapPane.addMarker(lat, lon, "attraction");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if(cbPropertyTax.isSelected()) {
                try{
                    //PropertyAssessments propertyAssessments = new PropertyAssessments();
                    PropertyTaxes propertyTax = new PropertyTaxes();

                    PropertyTaxes residentialOnlyTax = propertyTax.filterByAssessmentClass("Residential");


                    // Determine min and max values from the text fields for Property
                    int minValue = tfMinTax.getText().isEmpty()
                            ? (int) residentialOnlyTax.calculateMinPropertyTax()
                            : Integer.parseInt(tfMinTax.getText().trim());
                    int maxValue = tfMaxTax.getText().isEmpty()
                            ? (int) residentialOnlyTax.calculateMaxPropertyTax()
                            : Integer.parseInt(tfMaxTax.getText().trim());


                    //double

                    ObservableList<PropertyAssessment> filteredProperties = FXCollections.observableArrayList();
                    for (PropertyAssessment pa : residentialOnlyTax.getAssessments()) {
                        //pa.propertyTax();

                        // Add this filter: if assessed value is less than 10,000, skip it.
                        if (pa.getAssessedValue() < 10000) {
                            continue;
                        }
                        if (pa.getAddress().getFullAddress().trim().isEmpty()) {
                            continue;
                        }
                        if (pa.getPropertyTax() >= minValue && pa.getPropertyTax() <= maxValue) {
                            filteredProperties.add(pa);
                        }
                    }
                    //sort filteredProperties by ascending order
                    filteredProperties = filteredProperties.stream()
                            .sorted(Comparator.comparing(PropertyAssessment::getPropertyTax))
                            .collect(Collectors.toCollection(FXCollections::observableArrayList));

                    propertyTaxTable.setItems(filteredProperties);

                    /*
                    for (PropertyAssessment pa : filteredProperties) {
                        double lat = pa.getLocation().getLatitude();
                        double lon = pa.getLocation().getLongitude();
                        mapPane.addMarker(lat, lon, "tax");
                        }
                     */


                }
                catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }



            // If "Schools" is checked, load the school data
            if (cbSchools.isSelected()) {
                // ObservableList for School objects for the TableView
                ObservableList<School> schoolDataList = FXCollections.observableArrayList();
                String schoolType = cbSchoolType.getValue();
                String address = tfSchoolAddress.getText().trim();
                // If the address is empty then radius filtering is skipped.

                // Load Public Schools if "Public" or "All" is selected.
                if (schoolType.equals("Public") || schoolType.equals("All")) {
                    try {
                        PublicSchools publicSchools = new PublicSchools();
                        List<PublicSchool> pubs = publicSchools.getSchools();
                        for (PublicSchool ps : pubs) {

                            // Create a School object from a PublicSchool
                            School s = new School(
                                    ps.getSchoolName(),
                                    ps.getStreet(),
                                    ps.getPostalCode(),
                                    ps.getPhoneNumber(),
                                    ps.getGradeLevel(),
                                    String.valueOf(ps.getLocation().getLatitude()),
                                    String.valueOf(ps.getLocation().getLongitude())
                            );
                            schoolDataList.add(s);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                // Load Catholic Schools if "Catholic" or "All" is selected.
                if (schoolType.equals("Catholic") || schoolType.equals("All")) {
                    try {
                        CatholicSchools catholicSchools = new CatholicSchools();
                        List<CatholicSchool> catholics = catholicSchools.getSchools();
                        for (CatholicSchool cs : catholics) {
                            // Create a School object from a CatholicSchool.
                            School s = new School(
                                    cs.getSchoolName(),
                                    cs.getStreet(),
                                    cs.getPostalCode(),
                                    cs.getPhoneNumber(),
                                    cs.getGradeLevel(),
                                    String.valueOf(cs.getLocation().getLatitude()),
                                    String.valueOf(cs.getLocation().getLongitude())
                            );
                            schoolDataList.add(s);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                // If the user has provided a property address, use it as the center for radius filtering.
                String centerAddress = tfSchoolAddress.getText().trim();
                if (!centerAddress.isEmpty()) {
                    try {
                        // Load all property assessments to find the matching property
                        PropertyAssessments propertyAssessments = new PropertyAssessments();
                        PropertyAssessment centerProperty = null;
                        for (PropertyAssessment pa : propertyAssessments.getAssessments()) {
                            if (pa.getAddress().getFullAddress().equalsIgnoreCase(centerAddress)) {
                                centerProperty = pa;
                                break;
                            }
                        }
                        // If found, use its location as the center for the radius filter
                        if (centerProperty != null) {
                            double centerLat = centerProperty.getLocation().getLatitude();
                            double centerLon = centerProperty.getLocation().getLongitude();
                            double radiusKm = sldSchoolRadius.getValue();
                            ObservableList<School> filteredSchools = FXCollections.observableArrayList();
                            for (School s : schoolDataList) {
                                double schoolLat = s.getLocation().getLatitude();
                                double schoolLon = s.getLocation().getLongitude();
                                double distance = Radius.calculateDistance(centerLat, centerLon, schoolLat, schoolLon);
                                if (distance <= radiusKm) {
                                    filteredSchools.add(s);
                                }
                            }
                            schoolDataList = filteredSchools;
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                schoolsTable.setItems(schoolDataList);

                // Add markers for each school using the "school" marker type
                for (School s : schoolDataList) {
                    double lat = s.getLocation().getLatitude();
                    double lon = s.getLocation().getLongitude();
                    mapPane.addMarker(lat, lon, "school");
                }
            }
        });

        Scene scene = new Scene(root,1500, 750);
        primaryStage.setTitle("Home Finder");

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
