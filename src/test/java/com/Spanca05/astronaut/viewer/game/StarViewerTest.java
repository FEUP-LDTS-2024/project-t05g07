package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Star;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class StarViewerTest {

    private StarViewer starViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Star starMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        starMock = mock(Star.class);

        starViewer = new StarViewer();
    }

    @Test
    public void testUpdateTrue() {
        starViewer.starColor =1;
        starViewer.frameCount = 10;
        starViewer.update();
        assertEquals(2, starViewer.starColor);
    }

    @Test
    public void testUpdateTruePos() {
        starViewer.starColor=2;
        starViewer.frameCount = 10;
        starViewer.update();
        assertEquals(1, starViewer.starColor);
    }
    @Test
    public void testUpdateFalse() {
        starViewer.starColor=1;
        starViewer.frameCount = 5;
        starViewer.update();
        assertEquals(1, starViewer.starColor);
    }
    @Test
    public void testDrawStar() {
        Position starPositionMock = mock(Position.class);
        when(starMock.getPosition()).thenReturn(starPositionMock);
        when(starPositionMock.minus(cameraOffSetMock)).thenReturn(starPositionMock);

        starViewer.draw(starMock, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawStar(starPositionMock, starViewer.starColor);
    }
}
