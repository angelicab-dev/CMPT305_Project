import javafx.application.Platform;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        // Created objects for testing
        property = new PropertyAssessment("1001", 500000, "Main St", "123", "Apt 4B", "Downtown", "Ward 6", "53.5461", "-113.4938",
                List.of(new AssessmentClass("Residential", "100")));

        attraction = new Attraction("KinsmenTwinArenas", "53.45124394828186",
                "-113.5138927", "Arena", "1979 111 St NW, Edmonton, AB T6J 7C6",
                "SW", "https://www.edmonton.ca/kinsmentwinarenas/");

        school = new School("Central High", "101 Main St", "12345", "555-555-5555",
                "9-12", "53.1234", "-113.9876", "Public");
    }



    @Test
    void addMarkerHome() {
        mapPane.addMarkerHome(property.getLocation().getLatitude(), property.getLocation().getLongitude(), "home", property);
        assertEquals(4, mapPane.getChildren().size());

    }

    @Test
    void addMarkerTax() {
        mapPane.addMarkerTax(property.getLocation().getLatitude(), property.getLocation().getLongitude(), "tax", property);
        assertEquals(4, mapPane.getChildren().size());
    }

    @Test
    void addMarkerAttraction() {
        mapPane.addMarkerAttraction(attraction.getAttractionLocation().getLatitude(), attraction.getAttractionLocation().getLongitude(), "attraction", attraction);
        assertEquals(4, mapPane.getChildren().size());
    }

    @Test
    void addMarkerSchool() {
        mapPane.addMarkerSchool(school.getLocation().getLatitude(), school.getLocation().getLongitude(), "school", school);
        assertEquals(4, mapPane.getChildren().size());
    }

    @Test
    void clearMarkers() {
        mapPane.addMarkerHome(53.5, -113.5, "home", property);
        mapPane.addMarkerSchool(53.6, -113.6, "school", school);
        mapPane.addMarkerAttraction(53.4, -113.4, "attraction", attraction);

        // Check if markers have been added
        assertTrue(mapPane.getChildren().size() > 1);

        mapPane.clearMarkers();

        // Check if markers have been removed (should only have the map image)
        assertEquals(2, mapPane.getChildren().size());
    }
}
