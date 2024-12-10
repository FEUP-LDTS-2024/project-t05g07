package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Coin;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.Point;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

public class PointViewer implements ElementViewer<Point> {
    @Override
    public void draw(Point point, GUI gui, Position cameraOffSet) {
        if (point instanceof Powerup)
            drawPowerup((Powerup) point, gui, cameraOffSet);
        else if (point instanceof Coin)
            gui.drawCoin(point.getPosition().minus(cameraOffSet));
        else
            gui.drawPoint(point.getPosition().minus(cameraOffSet));
    }

    private void drawPowerup(Powerup powerup, GUI gui, Position cameraOffSet) {
        if (powerup instanceof Iman) {
            gui.drawIman(powerup.getPosition().minus(cameraOffSet));
        }
        else if (powerup instanceof Escudo) {
            gui.drawEscudo(powerup.getPosition().minus(cameraOffSet));
        }
    }
}
