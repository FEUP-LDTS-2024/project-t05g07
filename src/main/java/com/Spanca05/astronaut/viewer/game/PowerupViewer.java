package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.EndBlock;
import com.Spanca05.astronaut.model.game.elements.Powerup;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup powerup, GUI gui, Position cameraOffSet) {
        gui.drawPowerup(powerup.getPosition().minus(cameraOffSet));
    }
}
