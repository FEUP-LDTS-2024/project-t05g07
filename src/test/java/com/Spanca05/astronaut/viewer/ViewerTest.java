package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.viewer.menu.LevelFailedMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ViewerTest {

    private GUI guiMock;
    private LevelFailedMenu levelFailedMenuMock; //exemplo, podia ser outro menu
    private LevelFailedMenuViewer levelFailedMenuViewer;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);

        levelFailedMenuMock = mock(LevelFailedMenu.class);

        when(levelFailedMenuMock.isSelected(0)).thenReturn(true);
        when(levelFailedMenuMock.isSelected(1)).thenReturn(false);

        levelFailedMenuViewer = new LevelFailedMenuViewer(levelFailedMenuMock);
    }

    @Test
    public void testDraw() throws IOException {

        levelFailedMenuViewer.draw(guiMock);

        verify(guiMock).clear();
        verify(guiMock).refresh();  
    }
}
