package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

public class PowerUpViewer implements ElementViewer<Powerup> {
    public int frameCount = 0;
    public int powerColor = 1;

    public void update() {
        frameCount++;
        if (frameCount > 7) {
            powerColor = powerColor == 1 ? 2 : 1;
            frameCount = 0;
        }
    }

    @Override
    public void draw(Powerup element, GUI gui, Position cameraOffSet) {
        if (element instanceof Iman)
            gui.drawIman(element.getPosition().minus(cameraOffSet), powerColor);
        if (element instanceof Escudo)
            gui.drawSheild(element.getPosition().minus(cameraOffSet), powerColor);
        if (element instanceof BonusCoins)
            gui.drawDoubleCoins(element.getPosition().minus(cameraOffSet),powerColor);
    }
}


