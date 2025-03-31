import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;
import java.util.ArrayList;
import java.util.List;

public class MapView extends Pane {
    private ImageView mapImageView;
    private final double minLon = -113.7312, maxLon = -113.2560;
    private final double minLat = 53.3333, maxLat = 53.7162;

    // List to keep track of home markers' positions (latitude and longitude).
    private List<double[]> homeMarkerPositions = new ArrayList<>();

    public MapView() {
        // Load Edmonton Map
        Image mapImage = new Image(getClass().getResource("/edmonton.png").toExternalForm());
        mapImageView = new ImageView(mapImage);
        mapImageView.setFitWidth(700); // Set map width
        mapImageView.setFitHeight(700); // Set map height
        this.getChildren().add(mapImageView);
    }

    public void addMarker(double latitude, double longitude, String markerType) {
        // If this is a home marker, check if there's already one within 1 km.
        if (markerType.equalsIgnoreCase("home")) {
            for (double[] pos : homeMarkerPositions) {
                double distance = Radius.calculateDistance(pos[0], pos[1], latitude, longitude);
                if (distance < 1.0) { // Skip adding if within 1 km
                    return;
                }
            }
            // No marker is within 1 km, so add this marker's position.
            homeMarkerPositions.add(new double[] { latitude, longitude });
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

        this.getChildren().add(icon);
    }

    // Clears all markers from the map and resets the home marker positions.
    public void clearMarkers() {
        this.getChildren().removeIf(node -> node != mapImageView);
        homeMarkerPositions.clear();
    }
}
