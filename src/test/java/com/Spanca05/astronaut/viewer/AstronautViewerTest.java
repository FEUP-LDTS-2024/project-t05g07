package com.Spanca05.astronaut.viewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.viewer.game.AstronautViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AstronautViewerTest {

    private AstronautViewer astronautViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Astronaut astronautMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        astronautMock = mock(Astronaut.class);

        astronautViewer = new AstronautViewer();
    }

    @Test
    public void testUpdateTrue() {
        astronautViewer.nautaPos=1;
        astronautViewer.frameCount = 15;
        astronautViewer.update();
        assertEquals(2, astronautViewer.nautaPos);
    }

    @Test
    public void testUpdateTruePos() {
        astronautViewer.nautaPos=2;
        astronautViewer.frameCount = 15;
        astronautViewer.update();
        assertEquals(1, astronautViewer.nautaPos);
    }
    @Test
    public void testUpdateFalse() {
        astronautViewer.nautaPos=1;
        astronautViewer.frameCount = 5;
        astronautViewer.update();
        assertEquals(1, astronautViewer.nautaPos);
    }
    @Test
    public void testDrawAstronaut() {
        Position nautaPositionMock = mock(Position.class);
        when(astronautMock.getPosition()).thenReturn(nautaPositionMock);
        when(nautaPositionMock.minus(cameraOffSetMock)).thenReturn(nautaPositionMock);

        astronautViewer.draw(astronautMock, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawAstronaut(nautaPositionMock, astronautViewer.nautaPos,astronautMock.getAngle());
    }
}
