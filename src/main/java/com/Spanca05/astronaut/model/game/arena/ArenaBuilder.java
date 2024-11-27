package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setAstronaut(createAstronaut());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Astronaut createAstronaut();
}