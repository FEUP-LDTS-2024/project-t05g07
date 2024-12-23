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

        // Initialize the viewer with the mocked LevelFailedMenu
        levelFailedMenuViewer = new LevelFailedMenuViewer(levelFailedMenuMock);

        // Mock the model's isSelected behavior
        when(levelFailedMenuMock.isSelected(0)).thenReturn(true);
        when(levelFailedMenuMock.isSelected(1)).thenReturn(false);
    }

    @Test
    public void testDrawElements() {
        // Call the method under test
        levelFailedMenuViewer.drawElements(guiMock);

        // Verify that drawSecondMenu is called once with the correct position
        verify(guiMock).drawSecondMenu(new Position(0, 0));

        // Verify the drawing of failed buttons with the correct positions and selection states
        verify(guiMock).drawFailedButton1(new Position(5, 6), true);  // For index 0 (selected)
        verify(guiMock).drawFailedButton2(new Position(5, 8), false); // For index 1 (not selected)
    }
}
