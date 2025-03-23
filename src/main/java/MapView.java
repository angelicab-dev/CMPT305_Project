import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.Objects;

public class MapView {
    private ImageView mapImageView;
    private StackPane mapPane; // Use StackPane as container

    private final double minLon = -113.720049, maxLon = -113.320418;
    private final double minLat = 53.393703, maxLat = 53.657116;

    public MapView(StackPane mapPane) {
        this.mapPane = mapPane; // Reference the provided mapPane

        // Load Edmonton Map safely
        Image mapImage = new Image(Objects.requireNonNull(getClass().getResource("/edmonton.png")).toExternalForm());
        mapImageView = new ImageView(mapImage);
        mapImageView.setFitWidth(600);
        mapImageView.setFitHeight(450);

        // Add map to the provided StackPane
        mapPane.getChildren().add(mapImageView);
    }

    public void addMarker(double latitude, double longitude) {
        double x = (longitude - minLon) / (maxLon - minLon) * mapImageView.getFitWidth();
        double y = (1 - (latitude - minLat) / (maxLat - minLat)) * mapImageView.getFitHeight();

        Circle marker = new Circle(x, y, 5, Color.RED);
        mapPane.getChildren().add(marker);
    }
}