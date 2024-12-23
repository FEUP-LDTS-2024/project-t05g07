package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.viewer.game.MonsterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class MonsterViewerTest {
    private MonsterViewer monsterViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private Monster monsterMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        monsterViewer = new MonsterViewer();
        monsterMock = mock(Monster.class);
    }

    @Test
    public void testDrawSpike() {
        Position wallPositionMock = mock(Position.class);
        when(monsterMock.getPosition()).thenReturn(wallPositionMock);
        when(wallPositionMock.minus(cameraOffSetMock)).thenReturn(wallPositionMock);

        monsterViewer.draw(monsterMock, guiMock, cameraOffSetMock);
        verify(guiMock, times(1)).drawSpike(wallPositionMock.minus(cameraOffSetMock));
    }
}