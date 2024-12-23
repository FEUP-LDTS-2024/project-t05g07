package com.Spanca05.astronaut.viewer;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.viewer.game.AstronautViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class AstronautViewerTest {

    @Mock
    GUI gui;

    @Mock
    Astronaut astronaut;

    @Mock
    Position cameraOffSet;

    // Manually initialize AstronautViewer
    private AstronautViewer astronautViewer;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        astronautViewer = new AstronautViewer();  // Initialize class with mocks
    }
    @Test
    void testUpdate_TogglesPositionAfter15Frames() {
        // Verify that the astronaut position toggles after 15 frames
        astronautViewer.update();
        int initialPosition = astronautViewer.nautaPos;  // Store the initial position

        // Simulate 15 updates to toggle position
        for (int i = 0; i < 15; i++) {
            astronautViewer.update();
        }

        // After 15 updates, verify that the position has toggled
        assertNotEquals(initialPosition, astronautViewer.nautaPos);
    }
}
