package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.strategy.HostileStrategy;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Monster extends Element {
    private HostileStrategy strategy;
    private String type;

    public Monster(int x, int y) {
        super(x, y);
    }

    public void setStrategy(HostileStrategy strategy) {
        this.strategy = strategy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void execute(Arena arena, GUI.ACTION action, long time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        strategy.step(arena, this, action, time);
    }

}
