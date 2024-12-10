package com.Spanca05.astronaut.model.game.elements.monsters;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.strategy.HostileStrategy;

public class MonsterWall extends Wall {
    private HostileStrategy strategy;

    public MonsterWall(int x, int y) {
        super(x, y);
    }

    public HostileStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(HostileStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void execute(Arena arena, GUI.ACTION action, long time) {
        strategy.step(arena, this, action, time);
    }
}
