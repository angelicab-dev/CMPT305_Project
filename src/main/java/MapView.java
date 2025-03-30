import javafx.scene.effect.DropShadow;
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
        // Default to "home" marker if no type provided.
        addMarker(latitude, longitude, "home");
    }

    public void addMarker(double latitude, double longitude, String markerType) {
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

        // Apply an outline effect using DropShadow with zero offsets.
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

    // Method to clear markers (removes all nodes except the base map image)
    public void clearMarkers() {
        this.getChildren().removeIf(node -> node != mapImageView);
    }
}
