package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

public class PointViewer implements ElementViewer<Point> {
    int frameCount = 0;
    int pointColor = 1;
    public PowerUpViewer powerv = new PowerUpViewer();

    public void update() {
        frameCount++;
        if (frameCount > 10) {
            pointColor = pointColor == 1 ? 2 : 1;
            frameCount = 0;
        }
    }
    public void draw(Point point, GUI gui, Position cameraOffSet) {
        if (point instanceof Powerup) {powerv.draw( (Powerup) point,gui,cameraOffSet);}
        else gui.drawPoint(point.getPosition().minus(cameraOffSet), pointColor);
    }
}
