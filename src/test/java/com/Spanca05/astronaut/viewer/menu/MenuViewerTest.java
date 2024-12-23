package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.viewer.WalletViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuViewerTest {

    private MenuViewer menuViewer;
    private GUI guiMock;
    private Menu menuMock;

    @BeforeEach
    public void setUp() {
        guiMock = mock(GUI.class);
        menuMock = mock(Menu.class);
        menuViewer = new MenuViewer(menuMock);

        when(menuMock.isSelected(0)).thenReturn(true);
        when(menuMock.isSelected(1)).thenReturn(false);
        when(menuMock.isSelected(2)).thenReturn(true);
    }

    @Test
    public void testDrawElements() throws IOException {
        menuViewer.drawElements(guiMock);

        verify(guiMock).drawMenu(new Position(0, 0));

        verify(guiMock).drawButton1(new Position(5, 7), true);
        verify(guiMock).drawButton2(new Position(5, 9), false);
        verify(guiMock).drawButton3(new Position(5, 11), true);
    }
}
