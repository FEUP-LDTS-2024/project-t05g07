package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Wall extends Element {
    public Wall(int x, int y) {
        super(x, y);
    }

    public void execute(Arena arena, GUI.ACTION action, long time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

    }
}
