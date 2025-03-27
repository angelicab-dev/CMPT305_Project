import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class MapView extends Pane {
    private ImageView mapImageView;

    private final double minLon = -113.720049, maxLon = -113.320418;
    private final double minLat = 53.393703, maxLat = 53.657116;

    public MapView() {
        // Load Edmonton Map
        Image mapImage = new Image(getClass().getResource("/edmonton.png").toExternalForm());
        mapImageView = new ImageView(mapImage);
        mapImageView.setFitWidth(450); // Set map width
        mapImageView.setFitHeight(450); // Set map height
        this.getChildren().add(mapImageView);
    }

    public void addMarker(double latitude, double longitude) {
        double x = (longitude - minLon) / (maxLon - minLon) * mapImageView.getFitWidth();
        double y = (1 - (latitude - minLat) / (maxLat - minLat)) * mapImageView.getFitHeight();

        // Create a FontIcon with the home icon
        FontIcon homeIcon = new FontIcon(FontAwesomeSolid.HOME);
        homeIcon.setIconColor(Color.RED);
        homeIcon.setIconSize(16);

        // Position the icon at the calculated coordinates
        // Adjust position to center the icon at the point
        homeIcon.setLayoutX(x - 8);
        homeIcon.setLayoutY(y + 8);

        this.getChildren().add(homeIcon);
    }

    // Optional: Add a method for different marker types
    public void addMarker(double latitude, double longitude, String markerType) {
        double x = (longitude - minLon) / (maxLon - minLon) * mapImageView.getFitWidth();
        double y = (1 - (latitude - minLat) / (maxLat - minLat)) * mapImageView.getFitHeight();

        FontIcon icon;

        // Choose icon based on marker type
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
                icon = new FontIcon(FontAwesomeSolid.MAP_MARKER);
                icon.setIconColor(Color.GREEN);
                break;
            default:
                icon = new FontIcon(FontAwesomeSolid.MAP_PIN);
                icon.setIconColor(Color.PURPLE);
        }

        icon.setIconSize(16);
        icon.setLayoutX(x - 8);
        icon.setLayoutY(y + 8);

        this.getChildren().add(icon);
    }
}