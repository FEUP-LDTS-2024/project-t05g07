package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.EndBlock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class EndBlockViewerTest {

    private EndBlockViewer endBlockViewer;
    private GUI guiMock;
    private Position cameraOffSetMock;
    private EndBlock endBlockMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        cameraOffSetMock = mock(Position.class);
        endBlockMock = mock(EndBlock.class);

        endBlockViewer = new EndBlockViewer();
    }

    @Test
    public void testUpdateTrue() {
        endBlockViewer.endBlockColor =1;
        endBlockViewer.frameCount = 15;
        endBlockViewer.update();
        assertEquals(2, endBlockViewer.endBlockColor);
    }

    @Test
    public void testUpdateTruePos() {
        endBlockViewer.endBlockColor=2;
        endBlockViewer.frameCount = 15;
        endBlockViewer.update();
        assertEquals(1, endBlockViewer.endBlockColor);
    }
    @Test
    public void testUpdateFalse() {
        endBlockViewer.endBlockColor=1;
        endBlockViewer.frameCount = 5;
        endBlockViewer.update();
        assertEquals(1, endBlockViewer.endBlockColor);
    }
    @Test
    public void testDrawEndBlock() {
        Position endBlockPositionMock = mock(Position.class);
        when(endBlockMock.getPosition()).thenReturn(endBlockPositionMock);
        when(endBlockPositionMock.minus(cameraOffSetMock)).thenReturn(endBlockPositionMock);

        endBlockViewer.draw(endBlockMock, guiMock, cameraOffSetMock);

        verify(guiMock, times(1)).drawEndBlock(endBlockPositionMock, endBlockViewer.endBlockColor);
    }
}
