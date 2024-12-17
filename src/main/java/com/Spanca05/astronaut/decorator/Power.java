package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.Point;

import java.util.List;

public interface Power {
    List<Monster> getMonsters();
    List<Point> getPoints();
    boolean isEmpty(Position position);
    void catchPoint(Position position);
}
