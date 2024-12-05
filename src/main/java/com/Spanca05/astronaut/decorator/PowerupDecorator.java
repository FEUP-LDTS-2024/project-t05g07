package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;

import java.util.List;

public class PowerupDecorator implements Power {
    protected Power wrappee;

    @Override
    public void catchPoint(Position position, List<Point> points) {
        wrappee.catchPoint(position, points);
    }
}
