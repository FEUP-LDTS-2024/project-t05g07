package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;

import java.util.List;

public class ImanDecorator extends PowerupDecorator {

    @Override
    public void catchPoint(Position position, List<Point> points) {
        for (int i = position.getX() - 2; i <= position.getX() + 2; i++) {
            for (int j = position.getY() - 2; j <= position.getY() + 2; j++) {
                Point adj = new Point(i, j);
                points.remove(adj);
            }
        }

        /*for (Point point : points) {
            if (position.equals(point.getPosition())) {
                points.remove(point);
                break;
            }
        }*/
    }
}
