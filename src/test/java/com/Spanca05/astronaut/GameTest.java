package com.Spanca05.astronaut;

import com.Spanca05.astronaut.gui.LanternaGUI;
import com.Spanca05.astronaut.states.MenuState;
import com.Spanca05.astronaut.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;
    private LanternaGUI mockGUI;
    private State mockState;

    @BeforeEach
    public void setUp() throws FontFormatException, IOException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        mockGUI = mock(LanternaGUI.class);
        mockState = mock(State.class);

        game = new Game();
    }

    @Test
    public void testGameConstructor()  {
        assertEquals(1, game.getCurrentLevel() );

        assertTrue(game.getState() instanceof MenuState);

    }

    @Test
    public void testSetCurrentLevel() {
        game.setCurrentLevel(3);
        assertEquals(3, game.getCurrentLevel());

        game.setCurrentLevel(-5);
        assertEquals(3, game.getCurrentLevel());
    }

    @Test
    public void testSetState() {
        game.setState(mockState);
        assertEquals(mockState, game.getState());

        State newState = mock(State.class);
        game.setState(newState);
        assertEquals(newState, game.getState());
    }
}
