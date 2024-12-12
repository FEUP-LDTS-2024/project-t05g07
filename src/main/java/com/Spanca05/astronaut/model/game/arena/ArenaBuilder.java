package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.elements.*;
import com.Spanca05.astronaut.model.game.elements.Monster;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena(Wallet wallet) {
        Arena arena = new Arena(getWidth(), getHeight(), getCurrentLevel(), wallet);

        arena.setAstronaut(createAstronaut());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setEndBlock(createEndBlock());
        arena.setPoints(createPoints());
        //arena.setCoins(createCoins());
        arena.setStar(createStar());

        return arena;
    }

    protected abstract int getCurrentLevel();

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    //protected abstract List<Coin> createCoins();

    protected abstract List<Star> createStar();

    protected abstract Astronaut createAstronaut();

    protected abstract List<Point> createPoints();

    protected abstract EndBlock createEndBlock();
}