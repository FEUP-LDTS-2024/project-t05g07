package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.model.game.elements.*;
import com.Spanca05.astronaut.model.game.elements.Monster;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Arena arena = new Arena(getWidth(), getHeight(), getCurrentLevel());

        arena.setAstronaut(createAstronaut());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setEndBlock(createEndBlock());
        arena.setPoints(createPoints());
        arena.setStar(createStar());

        return arena;
    }

    protected abstract int getCurrentLevel();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract List<Star> createStar();

    protected abstract Astronaut createAstronaut();

    protected abstract List<Point> createPoints();

    protected abstract EndBlock createEndBlock();
}