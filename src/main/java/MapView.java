import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.File;

public class MapView extends StackPane {

    public MapView() {
        // Load the image
        File file = new File("src/main/resources/edmonton.png");
        Image mapImage = new Image(file.toURI().toString());

        // Create an ImageView
        ImageView imageView = new ImageView(mapImage);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        // Add the imageView to StackPane
        this.getChildren().add(imageView);
    }
}