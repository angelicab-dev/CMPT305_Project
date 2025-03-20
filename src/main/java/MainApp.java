import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

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
        TextField tfAttrRadius = new TextField();
        leftPane.add(lblAttrRadius, 0, 6);
        leftPane.add(tfAttrRadius, 1, 6);

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
        cbSchoolType.getItems().addAll("Catholic", "Public");
        leftPane.add(lblSchool, 0, 11);
        leftPane.add(cbSchoolType, 1, 11);

        Label lblSchoolAddress = new Label("Address:");
        TextField tfSchoolAddress = new TextField();
        leftPane.add(lblSchoolAddress, 0, 12);
        leftPane.add(tfSchoolAddress, 1, 12);

        Label lblSchoolRadius = new Label("Radius (km):");
        TextField tfSchoolRadius = new TextField();
        leftPane.add(lblSchoolRadius, 0, 13);
        leftPane.add(tfSchoolRadius, 1, 13);

        // Search Button
        Button btnSearch = new Button("Search");
        leftPane.add(btnSearch, 0, 14, 2, 1);

        // Add left pane to the root layout
        root.setLeft(leftPane);

        // Right Pane Map View
        StackPane mapPane = new StackPane();

        Label lblMapView = new Label("Map View");
        mapPane.getChildren().add(lblMapView);

        // Put the map pane in the center of the BorderPane
        root.setCenter(mapPane);

        // Create and show the scene
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Home Finder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}