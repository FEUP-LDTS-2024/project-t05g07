package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class PointViewerTest {
    private PointViewer pointViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Point pointMock;
    private Powerup powerupMock;
    private PowerUpViewer powerUpViewerMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        pointMock = mock(Point.class);
        powerupMock = mock(Powerup.class);
        powerUpViewerMock = mock(PowerUpViewer.class);
        pointViewer = new PointViewer();
        pointViewer.powerv = powerUpViewerMock;
    }

    @Test
    public void testUpdateTrue() {
        pointViewer.pointColor =1;
        pointViewer.frameCount = 10;
        pointViewer.update();
        assertEquals(2, pointViewer.pointColor);
    }

    @Test
    public void testUpdateTruePos() {
        pointViewer.pointColor=2;
        pointViewer.frameCount = 10;
        pointViewer.update();
        assertEquals(1, pointViewer.pointColor);
    }
    @Test
    public void testUpdateFalse() {
        pointViewer.pointColor=1;
        pointViewer.frameCount = 5;
        pointViewer.update();
        assertEquals(1, pointViewer.pointColor);
    }
    @Test
    public void testDrawPoint() {
        Position pointPositionMock = mock(Position.class);
        when(pointMock.getPosition()).thenReturn(pointPositionMock);
        when(pointPositionMock.minus(cameraOffSetMock)).thenReturn(pointPositionMock);

        pointViewer.draw(pointMock, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawPoint(pointPositionMock, pointViewer.pointColor);
    }
    @Test
    public void testDrawPower() {
        Position pointPositionMock = mock(Position.class);
        when(powerupMock.getPosition()).thenReturn(pointPositionMock);
        when(pointPositionMock.minus(cameraOffSetMock)).thenReturn(pointPositionMock);

        pointViewer.draw(powerupMock, guiMock, cameraOffSetMock);

        verify(powerUpViewerMock, times(1)).draw(powerupMock, guiMock, cameraOffSetMock);
        verifyNoInteractions(guiMock);
    }

}

