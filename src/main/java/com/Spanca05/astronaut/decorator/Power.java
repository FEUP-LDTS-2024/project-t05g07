package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;

import java.util.List;

public interface Power {
    void catchPoint(Position position, List<Point> points);
}
