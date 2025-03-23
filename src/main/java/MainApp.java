import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;


public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Use a BorderPane to split the window into left for the filters and right for the map.
        BorderPane root = new BorderPane();

        // Left Pane (Filters)
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(20));
        leftPane.setHgap(10);
        leftPane.setVgap(10);

        // "Filter By" title
        Label filterByLabel = new Label("Filter By");
        filterByLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        leftPane.add(filterByLabel, 0, 0, 2, 1);

        // Assessed Value with checkbox
        CheckBox cbAssessedValue = new CheckBox("Assessed Value");
        leftPane.add(cbAssessedValue, 0, 1, 2, 1);

        // Min/Max Assessed Value
        Label lblMinAssessed = new Label("Min ($):");
        TextField tfMinAssessed = new TextField();
        tfMinAssessed.setPromptText("Min Assessed Value");
        leftPane.add(lblMinAssessed, 0, 2);
        leftPane.add(tfMinAssessed, 1, 2);

        Label lblMaxAssessed = new Label("Max ($):");
        TextField tfMaxAssessed = new TextField();
        tfMaxAssessed.setPromptText("Max Assessed Value");
        leftPane.add(lblMaxAssessed, 0, 3);
        leftPane.add(tfMaxAssessed, 1, 3);

        // Attractions with checkbox
        CheckBox cbAttractions = new CheckBox("Attractions");
        leftPane.add(cbAttractions, 0, 4, 2, 1);

        // Attractions Address and Radius
        Label lblAttrAddress = new Label("Address:");
        TextField tfAttrAddress = new TextField();
        leftPane.add(lblAttrAddress, 0, 5);
        leftPane.add(tfAttrAddress, 1, 5);

        Label lblAttrRadius = new Label("Radius (km):");
        Slider sldAttrRadius = new Slider();
        sldAttrRadius.setMin(0);
        sldAttrRadius.setMax(100);
        sldAttrRadius.setValue(50);
        sldAttrRadius.setShowTickLabels(true);
        leftPane.add(sldAttrRadius, 1, 6);
        leftPane.add(lblAttrRadius, 0, 6);

        // Property Tax with checkbox
        CheckBox lblPropertyTax = new CheckBox("Property Tax");
        leftPane.add(lblPropertyTax, 0, 7, 2, 1);

        Label lblMinTax = new Label("Min ($):");
        TextField tfMinTax = new TextField();
        tfMinTax.setPromptText("Min Tax Value");
        leftPane.add(lblMinTax, 0, 8);
        leftPane.add(tfMinTax, 1, 8);

        Label lblMaxTax = new Label("Max ($):");
        TextField tfMaxTax = new TextField();
        tfMaxTax.setPromptText("Max Tax Value");
        leftPane.add(lblMaxTax, 0, 9);
        leftPane.add(tfMaxTax, 1, 9);

        // Schools with checkbox
        CheckBox cbSchools = new CheckBox("Schools");
        leftPane.add(cbSchools, 0, 10, 2, 1);

        // Schools School dropdown, Address, Radius
        Label lblSchool = new Label("School:");
        ComboBox<String> cbSchoolType = new ComboBox<>();
        cbSchoolType.getItems().addAll("All", "Catholic", "Public");
        cbSchoolType.setValue("All");
        leftPane.add(lblSchool, 0, 11);
        leftPane.add(cbSchoolType, 1, 11);

        Label lblSchoolAddress = new Label("Address:");
        TextField tfSchoolAddress = new TextField();
        leftPane.add(lblSchoolAddress, 0, 12);
        leftPane.add(tfSchoolAddress, 1, 12);

        Label lblSchoolRadius = new Label("Radius (km):");
        Slider sldSchoolRadius = new Slider();
        sldSchoolRadius.setMin(0);
        sldSchoolRadius.setMax(100);
        sldSchoolRadius.setValue(50);
        sldSchoolRadius.setShowTickLabels(true);
        leftPane.add(lblSchoolRadius, 0, 13);
        leftPane.add(sldSchoolRadius, 1, 13);

        // Search Button
        Button btnSearch = new Button("Search");
        leftPane.add(btnSearch, 0, 14, 2, 1);

        // Right Pane (Map View + Table Tabs)
        VBox rightPane = new VBox();
        rightPane.setPadding(new Insets(10));
        rightPane.setSpacing(10); // Space between map and table tabs


        // Map View at the top
        StackPane mapPane = new StackPane();
        new MapView(mapPane);
        Label lblMapView = new Label("Map View");
        mapPane.getChildren().add(lblMapView);
        mapPane.setPrefHeight(450);


        // Create TabPane
        TabPane tabPane = new TabPane();
        tabPane.setPrefHeight(200);

        // Home Table using PropertyAssessment objects
        TableView<PropertyAssessment> homesTable = new TableView<>();
        homesTable.setPrefHeight(200);
        homesTable.setPrefWidth(550);

        TableColumn<PropertyAssessment, String> assessedValueCol = new TableColumn<>("Assessed Value");
        assessedValueCol.setCellValueFactory(new PropertyValueFactory<>("assessedValue"));
        assessedValueCol.setMinWidth(183);

        TableColumn<PropertyAssessment, String> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressCol.setMinWidth(183);

        TableColumn<PropertyAssessment, String> neighbourhoodCol = new TableColumn<>("Neighbourhood");
        neighbourhoodCol.setCellValueFactory(new PropertyValueFactory<>("neighbourhood"));
        neighbourhoodCol.setMinWidth(183);

        homesTable.getColumns().addAll(assessedValueCol, addressCol, neighbourhoodCol);

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
        attractionNameCol.setCellValueFactory(new PropertyValueFactory<>("attractionName"));
        attractionNameCol.setPrefWidth(183);

        TableColumn<Attraction, String> attractionTypeCol = new TableColumn<>("Type");
        attractionTypeCol.setCellValueFactory(new PropertyValueFactory<>("attractionType"));
        attractionTypeCol.setPrefWidth(183);

        TableColumn<Attraction, String> attractionAddressCol = new TableColumn<>("Address");
        attractionAddressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        attractionAddressCol.setPrefWidth(183);

        attractionsTable.getColumns().addAll(attractionNameCol, attractionTypeCol, attractionAddressCol);

        // Create Homes Tab
        Tab homeTab = new Tab("Homes", homesTable);
        homeTab.setClosable(false);

        // Create School Tab
        Tab schoolsTab = new Tab("Schools", schoolsTable);
        schoolsTab.setClosable(false);

        // Create Attractions Tab
        Tab attractionsTab = new Tab("Attractions", attractionsTable);
        attractionsTab.setClosable(false);

        tabPane.getTabs().addAll(homeTab, schoolsTab, attractionsTab);
        rightPane.getChildren().addAll(mapPane, tabPane);

        root.setLeft(leftPane);
        root.setRight(rightPane);

        // Search Button Event Handler
        btnSearch.setOnAction(e -> {
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
                        if (pa.getAssessedValue() >= minValue && pa.getAssessedValue() <= maxValue) {
                            filteredProperties.add(pa);
                        }
                    }

                    // Display them in the Homes table
                    homesTable.setItems(filteredProperties);
                } catch (IOException ex) {
                    ex.printStackTrace();
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

                // Refresh the TableView with the new data.
                schoolsTable.setItems(schoolDataList);
            }
        });

        Scene scene = new Scene(root, 900, 700);
        primaryStage.setTitle("Home Finder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
