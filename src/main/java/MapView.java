import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.info;

public class MapView extends Pane {
    private ImageView mapImageView;
    private final double minLon = -113.7312, maxLon = -113.2560;
    private final double minLat = 53.3333, maxLat = 53.7162;

    // List to keep track of home markers' positions (latitude and longitude).
    private List<double[]> homeMarkerPositions = new ArrayList<>();
    // List to keep track of tax markers' positions (latitude and longitude).
    private List<double[]> taxMarkerPositions = new ArrayList<>();

    private VBox legend; // Legend box


    public MapView() {
        // Load Edmonton Map
        Image mapImage = new Image(getClass().getResource("/edmonton.png").toExternalForm());
        mapImageView = new ImageView(mapImage);
        mapImageView.setFitWidth(700); // Set map width
        mapImageView.setFitHeight(750); // Set map height
        this.getChildren().add(mapImageView);

        legendOverlay();
    }
    private void legendOverlay() {
        legend = new VBox(10);
        legend.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8); -fx-padding: 10; -fx-border-color: black; -fx-border-radius: 5;");
        legend.setAlignment(Pos.TOP_LEFT);

        // Add legend items with icons
        Label legendLabel = new Label("LEGEND");
        legendLabel.setStyle("-fx-font-weight: bold; ");

        legend.getChildren().add(legendLabel);

        legend.getChildren().add(createLegendItem("Home", FontAwesomeSolid.HOME, Color.RED));
        legend.getChildren().add(createLegendItem("Tax", FontAwesomeSolid.DOLLAR_SIGN, Color.ORANGE));
        legend.getChildren().add(createLegendItem("Attraction", FontAwesomeSolid.TREE, Color.GREEN));
        legend.getChildren().add(createLegendItem("School", FontAwesomeSolid.SCHOOL, Color.BLUE));

        // Position the legend in the top-left corner
        legend.setLayoutX(10);
        legend.setLayoutY(10);

        this.getChildren().add(legend);
    }

    private HBox createLegendItem(String name, FontAwesomeSolid iconType, Color color) {
        FontIcon icon = new FontIcon(iconType);
        icon.setIconColor(color);
        icon.setIconSize(16);

        Label label = new Label(name);
        HBox item = new HBox(10, icon, label);
        item.setAlignment(Pos.CENTER_LEFT);

        return item;
    }




    public void addMarker(double latitude, double longitude, String markerType) {
        // If this is a home marker, check if there's already one within 1 km.
        if (markerType.equalsIgnoreCase("home")) {

            for (double[] pos : homeMarkerPositions) {
                double distance = Radius.calculateDistance(pos[0], pos[1], latitude, longitude);
                if (distance < 2.0) { // Skip adding if within 1 km
                    return;
                }
            }
            // No marker is within 1 km, so add this marker's position.
            homeMarkerPositions.add(new double[] { latitude, longitude });
        }

        if (markerType.equalsIgnoreCase("tax")) {
            // Check if the tax marker is within 1 km of any home marker.
            for (double[] pos : taxMarkerPositions) {
                double distance = Radius.calculateDistance(pos[0], pos[1], latitude, longitude);
                if (distance < 2.0) { // Skip adding if within 1 km
                    return;
                }
            }
            // No home marker is within 1 km, so add this marker's position.
            taxMarkerPositions.add(new double[] { latitude, longitude });
        }


        double x = (longitude - minLon) / (maxLon - minLon) * mapImageView.getFitWidth();
        double y = (1 - (latitude - minLat) / (maxLat - minLat)) * mapImageView.getFitHeight();

        FontIcon icon;
        switch (markerType.toLowerCase()) {
            case "home":
                icon = new FontIcon(FontAwesomeSolid.HOME);
                icon.setIconColor(Color.RED);
                break;
            case "school":
                icon = new FontIcon(FontAwesomeSolid.SCHOOL);
                icon.setIconColor(Color.BLUE);
                break;
            case "tax":
                icon = new FontIcon(FontAwesomeSolid.DOLLAR_SIGN);
                icon.setIconColor(Color.ORANGE);
                break;
            default:
                icon = new FontIcon(FontAwesomeSolid.MAP_PIN);
                icon.setIconColor(Color.PURPLE);
        }

        icon.setIconSize(16);

        // Apply an outline effect using DropShadow.
        DropShadow outline = new DropShadow();
        outline.setRadius(2.0);
        outline.setSpread(0.7);
        outline.setOffsetX(0);
        outline.setOffsetY(0);
        outline.setColor(Color.BLACK);
        icon.setEffect(outline);

        icon.setLayoutX(x - 8);
        icon.setLayoutY(y + 8);
        // Popup Label
        Label popup = new Label("Test");
        popup.setStyle("-fx-background-color: white; -fx-padding: 5px; -fx-border-color: black;");
        popup.setVisible(false);
        popup.setLayoutX(x + 10);
        popup.setLayoutY(y - 10);

        // Show popup on marker click
        icon.setOnMouseClicked(event -> popup.setVisible(!popup.isVisible()));
        this.getChildren().addAll(icon, popup);
    }


    public void addMarkerAttraction(double latitude, double longitude, String markerType, Attraction place) {
        // If this is a home marker, check if there's already one within 1 km.
        if (markerType.equalsIgnoreCase("home")) {

            for (double[] pos : homeMarkerPositions) {
                double distance = Radius.calculateDistance(pos[0], pos[1], latitude, longitude);
                if (distance < 2.0) { // Skip adding if within 1 km
                    return;
                }
            }
            // No marker is within 1 km, so add this marker's position.
            homeMarkerPositions.add(new double[] { latitude, longitude });
        }

        if (markerType.equalsIgnoreCase("tax")) {
            // Check if the tax marker is within 1 km of any home marker.
            for (double[] pos : taxMarkerPositions) {
                double distance = Radius.calculateDistance(pos[0], pos[1], latitude, longitude);
                if (distance < 2.0) { // Skip adding if within 1 km
                    return;
                }
            }
            // No home marker is within 1 km, so add this marker's position.
            taxMarkerPositions.add(new double[] { latitude, longitude });
        }


        double x = (longitude - minLon) / (maxLon - minLon) * mapImageView.getFitWidth();
        double y = (1 - (latitude - minLat) / (maxLat - minLat)) * mapImageView.getFitHeight();

        FontIcon icon;
        switch (markerType.toLowerCase()) {

            case "attraction":
                icon = new FontIcon(FontAwesomeSolid.TREE);
                icon.setIconColor(Color.GREEN);
                break;
            default:
                icon = new FontIcon(FontAwesomeSolid.MAP_PIN);
                icon.setIconColor(Color.PURPLE);
        }

        icon.setIconSize(16);

        // Apply an outline effect using DropShadow.
        DropShadow outline = new DropShadow();
        outline.setRadius(2.0);
        outline.setSpread(0.7);
        outline.setOffsetX(0);
        outline.setOffsetY(0);
        outline.setColor(Color.BLACK);
        icon.setEffect(outline);

        icon.setLayoutX(x - 8);
        icon.setLayoutY(y + 8);

        // Popup Label
        Label popup = new Label(place.getFacilityName());
        popup.setStyle("-fx-background-color: white; -fx-padding: 5px; -fx-border-color: black;");
        popup.setVisible(false);
        popup.setLayoutX(x + 10);
        popup.setLayoutY(y - 10);

        // Listener event set up for hovering on attraction icons on map
        icon.setOnMouseEntered(event -> popup.setVisible(true));
        icon.setOnMouseExited(event -> popup.setVisible(false));
        this.getChildren().addAll(icon, popup);
    }

    // Clears all markers from the map and resets the home marker positions.
    public void clearMarkers() {
        this.getChildren().removeIf(node -> node != mapImageView);
        homeMarkerPositions.clear();
        taxMarkerPositions.clear();
        legendOverlay();

    }
}
