package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Powerup;
import com.Spanca05.astronaut.model.game.elements.Iman;

public class PowerupViewer implements ElementViewer<Powerup> {
    @Override
    public void draw(Powerup powerup, GUI gui, Position cameraOffSet) {
        if (powerup instanceof Iman) {
            drawIman((Iman) powerup, gui, cameraOffSet);
        }
    }

    private void drawIman(Iman powerup, GUI gui, Position cameraOffSet) {
        gui.drawIman(powerup.getPosition().minus(cameraOffSet));
    }
}
