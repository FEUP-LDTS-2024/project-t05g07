package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LevelCompletedMenuViewerTest {

    private LevelCompletedMenuViewer levelCompletedMenuViewer;
    private GUI guiMock;
    private LevelCompletedMenu levelCompletedMenuMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        levelCompletedMenuMock = mock(LevelCompletedMenu.class);

        levelCompletedMenuViewer = new LevelCompletedMenuViewer(levelCompletedMenuMock);

        when(levelCompletedMenuMock.getNumberEntries()).thenReturn(3);
        when(levelCompletedMenuMock.isSelected(0)).thenReturn(true);
        when(levelCompletedMenuMock.isSelected(1)).thenReturn(false);
        when(levelCompletedMenuMock.isSelected(2)).thenReturn(true);
    }

    @Test
    public void testDrawElements() {
        levelCompletedMenuViewer.drawElements(guiMock);

        verify(guiMock).drawSecondMenu(new Position(0, 0));

        verify(guiMock, times(3)).drawCompleteButton1(new Position(5, 5), true);
        verify(guiMock, times(3)).drawCompleteButton2(new Position(5, 7), false);
        verify(guiMock, times(3)).drawCompleteButton3(new Position(5, 9), true);
    }
}
