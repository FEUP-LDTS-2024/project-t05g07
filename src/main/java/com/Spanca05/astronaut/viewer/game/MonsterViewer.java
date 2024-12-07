package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.Spike;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui, Position cameraOffSet) {
        if (monster instanceof Spike) gui.drawSpike(monster.getPosition().minus(cameraOffSet));
        else gui.drawMonster(monster.getPosition().minus(cameraOffSet));
    }
}
