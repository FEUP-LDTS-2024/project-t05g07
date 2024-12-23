package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.GameFinishedMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameFinishedMenuViewerTest {

    private GameFinishedMenuViewer gameFinishedMenuViewer;
    private GUI guiMock;
    private GameFinishedMenu gameFinishedMenuMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        gameFinishedMenuMock = mock(GameFinishedMenu.class);
        gameFinishedMenuViewer = new GameFinishedMenuViewer(gameFinishedMenuMock);
        when(gameFinishedMenuMock.isSelected(1)).thenReturn(true);
    }

    @Test
    public void testDrawElements() {
        gameFinishedMenuViewer.drawElements(guiMock);
        verify(guiMock).drawFinalMenu(new Position(0, 0));
        verify(guiMock).drawFailedButton2(new Position(5, 8), true);
    }
}
