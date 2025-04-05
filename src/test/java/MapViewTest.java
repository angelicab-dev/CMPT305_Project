import javafx.application.Platform;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapViewTest {

    private MapView mapPane;

    PropertyAssessment property;
    Attraction attraction;
    School school;

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
        assertEquals(2, mapPane.getChildren().size());
    }

    @Test
    void doesNotAddHomeMarkerWithinOneKm() {
        int initialSize = mapPane.getChildren().size();

        mapPane.addMarkerHome(53.5, -113.5, "home", property);
        assertEquals(initialSize + 1, mapPane.getChildren().size());

        // Attempt to add home marker within 1 km
        mapPane.addMarkerHome(53.5005, -113.5005, "home", property);

        // Should not add if within 1km
        assertEquals(initialSize + 1, mapPane.getChildren().size());
    }

    @Test
    void addsMarkerType() {
        int initialSize = mapPane.getChildren().size();

        mapPane.addMarkerSchool(53.5, -113.5, "school", school);
        assertEquals(initialSize + 1, mapPane.getChildren().size());

        mapPane.addMarkerAttraction(53.6, -113.6, "attraction", attraction);
        assertEquals(initialSize + 2, mapPane.getChildren().size());

        mapPane.addMarkerHome(53.7, -113.7, "unknownType", property);
        assertEquals(initialSize + 3, mapPane.getChildren().size());
    }


    @Test
    void clearMarkers() {
//        mapPane.addMarkerHome(53.5, -113.5, "home", property);
//        mapPane.addMarkerSchool(53.6, -113.6, "school", school);
//        mapPane.addMarkerAttraction(53.4, -113.4, "attraction", attraction);

        // Check if markers have been added
        assertTrue(mapPane.getChildren().size() > 1);

        mapPane.clearMarkers();

        // Check if markers have been removed (should only have the map image)
        assertEquals(2, mapPane.getChildren().size());
    }
}
