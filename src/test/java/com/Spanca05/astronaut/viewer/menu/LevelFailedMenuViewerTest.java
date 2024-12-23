package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LevelFailedMenuViewerTest {

    private LevelFailedMenuViewer levelFailedMenuViewer;
    private GUI guiMock;
    private LevelFailedMenu levelFailedMenuMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        levelFailedMenuMock = mock(LevelFailedMenu.class);

        levelFailedMenuViewer = new LevelFailedMenuViewer(levelFailedMenuMock);

        when(levelFailedMenuMock.isSelected(0)).thenReturn(true);
        when(levelFailedMenuMock.isSelected(1)).thenReturn(false);
    }

    @Test
    public void testDrawElements() {
        levelFailedMenuViewer.drawElements(guiMock);

        verify(guiMock).drawSecondMenu(new Position(0, 0));

        verify(guiMock).drawFailedButton1(new Position(5, 6), true);
        verify(guiMock).drawFailedButton2(new Position(5, 8), false);
    }
}
