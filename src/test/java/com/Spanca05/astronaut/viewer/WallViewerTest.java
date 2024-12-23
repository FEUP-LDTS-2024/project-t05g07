package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.MonsterWall;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WallViewerTest {
    private WallViewer wallViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Wall wallMock;
    private MonsterWall monsterWallMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        wallMock = mock(Wall.class);
        monsterWallMock = mock(MonsterWall.class);
        wallViewer = new WallViewer();
    }

    @Test
    public void testDrawWall() {
        Position wallPositionMock = mock(Position.class);
        when(wallMock.getPosition()).thenReturn(wallPositionMock);
        when(wallPositionMock.minus(cameraOffSetMock)).thenReturn(wallPositionMock);


        wallViewer.draw(wallMock, guiMock, cameraOffSetMock);
        verify(guiMock, times(1)).drawWall(wallPositionMock.minus(cameraOffSetMock));
    }
    @Test
    public void testDrawMonsterWall() {
        Position wallPositionMock = mock(Position.class);
        when(monsterWallMock.getPosition()).thenReturn(wallPositionMock);
        when(wallPositionMock.minus(cameraOffSetMock)).thenReturn(wallPositionMock);

        wallViewer.draw(monsterWallMock, guiMock, cameraOffSetMock);
        verify(guiMock, times(1)).drawTrap(wallPositionMock.minus(cameraOffSetMock));
    }
}
