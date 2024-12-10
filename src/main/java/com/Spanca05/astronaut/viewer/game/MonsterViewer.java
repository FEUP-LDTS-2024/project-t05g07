package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.strategy.SpikeStrategy;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui, Position cameraOffSet) {
        if (monster.getStrategy() instanceof SpikeStrategy) gui.drawSpike(monster.getPosition().minus(cameraOffSet));
        else gui.drawMonster(monster.getPosition().minus(cameraOffSet));
    }
}
