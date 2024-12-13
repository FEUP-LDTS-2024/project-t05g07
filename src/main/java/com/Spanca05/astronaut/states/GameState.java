package com.Spanca05.astronaut.states;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.controller.game.ArenaController;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.game.GameViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameState extends State<Arena> {
    public GameState(Arena arena) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        return new ArenaController(getModel());
    }
}
