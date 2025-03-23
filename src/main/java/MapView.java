import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MapView extends Pane {
    private ImageView mapImageView;

    private final double minLon = -113.720049, maxLon = -113.320418;
    private final double minLat = 53.393703, maxLat = 53.657116;

    public MapView() {
        // Load Edmonton Map
        Image mapImage = new Image(getClass().getResource("/edmonton.png").toExternalForm());
        mapImageView = new ImageView(mapImage);
        mapImageView.setFitWidth(600); // Set map width
        mapImageView.setFitHeight(450); // Set map height
        this.getChildren().add(mapImageView);
    }

    public void addMarker(double latitude, double longitude) {
        double x = (longitude - minLon) / (maxLon - minLon) * mapImageView.getFitWidth();
        double y = (1 - (latitude - minLat) / (maxLat - minLat)) * mapImageView.getFitHeight();

        Circle marker = new Circle(x, y, 5, Color.RED);
        this.getChildren().add(marker);
    }
}