package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;

public class PointViewer implements ElementViewer<Point> {
    int frameCount = 0;
    int pointColor = 1;

    public void update() {
        frameCount++;
        if (frameCount > 10) {
            pointColor = pointColor == 1 ? 2 : 1;
            frameCount = 0;
        }
    }

    @Override
    public void draw(Point point, GUI gui, Position cameraOffSet) {
        /*if (point instanceof Powerup)
            drawPowerUp((Powerup) point, gui, cameraOffSet);
        if (point instanceof Coin)
            gui.drawCoin(point.getPosition().minus(cameraOffSet));
        else{*/
        gui.drawPoint(point.getPosition().minus(cameraOffSet), pointColor);
    }

    /*private void drawPowerUp(Powerup powerup, GUI gui, Position cameraOffSet) {
        if (powerup instanceof Iman) {
            gui.drawIman(powerup.getPosition().minus(cameraOffSet));
        }
        else if (powerup instanceof Escudo) {
            gui.drawEscudo(powerup.getPosition().minus(cameraOffSet));
        }
    }*/
}
