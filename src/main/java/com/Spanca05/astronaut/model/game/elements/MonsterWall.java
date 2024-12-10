package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.strategy.HostileStrategy;

public class MonsterWall extends Wall {
    private HostileStrategy strategy;

    public MonsterWall(int x, int y) {
        super(x, y);
    }

    public void setStrategy(HostileStrategy strategy) {
        this.strategy = strategy;
    }

    public void drawThroughStrategy(GUI gui, Position cameraOffSet) {
        strategy.draw(this, gui, cameraOffSet);
    }

    @Override
    public void execute(Arena arena, GUI.ACTION action, long time) {
        strategy.step(arena, this, action, time);
    }
}
