package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;

public class PointViewer implements ElementViewer<Point> {
    @Override
    public void draw(Point point, GUI gui, Position cameraOffSet) {
        gui.drawPoint(point.getPosition().minus(cameraOffSet));
    }
}
