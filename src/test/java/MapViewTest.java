import javafx.application.Platform;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapViewTest {

    private MapView mapPane;

    // Initialize JavaFX
    @BeforeAll
    static void initJavaFX() {
        Platform.startup(() -> { /* no-op */ });
    }

    @BeforeEach
    void setUp() {
        mapPane = new MapView();
        mapPane.setPrefSize(375, 450);

        VBox centerPane = new VBox();
        centerPane.getChildren().add(mapPane);
    }

    @Test
    void initializesMap() {
        // Ensure only the map image is present initially.
        assertEquals(1, mapPane.getChildren().size());
    }

    @Test
    void doesNotAddHomeMarkerWithinOneKm() {
        int initialSize = mapPane.getChildren().size();

        mapPane.addMarker(53.5, -113.5, "home");
        assertEquals(initialSize + 1, mapPane.getChildren().size());

        // Attempt to add home marker within 1 km
        mapPane.addMarker(53.5005, -113.5005, "home");

        // Should not add if within 1km
        assertEquals(initialSize + 1, mapPane.getChildren().size());
    }

    @Test
    void addsMarkerType() {
        int initialSize = mapPane.getChildren().size();

        mapPane.addMarker(53.5, -113.5, "school");
        assertEquals(initialSize + 1, mapPane.getChildren().size());

        mapPane.addMarker(53.6, -113.6, "attraction");
        assertEquals(initialSize + 2, mapPane.getChildren().size());

        mapPane.addMarker(53.7, -113.7, "unknownType");
        assertEquals(initialSize + 3, mapPane.getChildren().size());
    }


    @Test
    void clearMarkers() {
        mapPane.addMarker(53.5, -113.5, "home");
        mapPane.addMarker(53.6, -113.6, "school");
        mapPane.addMarker(53.4, -113.4, "attraction");

        // Check if markers have been added
        assertTrue(mapPane.getChildren().size() > 1);

        mapPane.clearMarkers();

        // Check if markers have been removed (should only have the map image)
        assertEquals(1, mapPane.getChildren().size());
    }
}
