import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    int win_width=700;
    int win_height=500;

    @Override
    public void start(Stage primaryStage) {

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(bp, win_width, win_height);//new Scene(fxmlLoader.load(), win_width, win_height);

        // Set the stage (window) title, scene, and then show the stage
        primaryStage.setTitle("Property Assessment Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
