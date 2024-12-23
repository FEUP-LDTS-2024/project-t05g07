package com.Spanca05.astronaut.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.awt.FontFormatException;
import java.net.URISyntaxException;

public class LanternaGUITest {

    private LanternaGUI gui;
    private Screen mockScreen;
    private int width;
    private int height;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        gui = new LanternaGUI(width,height);
        mockScreen = mock(Screen.class);
    }

    @Test
    void testCreateScreen() throws IOException {
        Terminal mockTerminal = mock(Terminal.class);

        when(mockTerminal.getTerminalSize()).thenReturn(new TerminalSize(80, 24));

        Screen screen = gui.createScreen(mockTerminal);
        verify(mockTerminal, times(2)).getTerminalSize();

        assertNotNull(screen);
    }
    @Test
    void testCreateTerminal() throws IOException {
        int width = 80, height = 24;
        AWTTerminalFontConfiguration fontConfig = mock(AWTTerminalFontConfiguration.class);

        Terminal terminal = gui.createTerminal(width, height, fontConfig);

        assertNotNull(terminal);
    }
    
    @Test
    void testClearScreen() {
        mockScreen.clear();
        verify(mockScreen, times(1)).clear();
    }

    @Test
    void testRefresh() throws IOException {
        mockScreen.refresh();
        verify(mockScreen, times(1)).refresh();
    }

    @Test
    void testClose() throws IOException {
        mockScreen.close();
        verify(mockScreen, times(1)).close();
    }

    @Test
    void testLoadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        AWTTerminalFontConfiguration fontConfig = gui.loadSquareFont();
        assertNotNull(fontConfig);
    }
}
