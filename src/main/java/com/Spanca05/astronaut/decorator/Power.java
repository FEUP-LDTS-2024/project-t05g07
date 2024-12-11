package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;

import java.util.List;

public interface Power {
    List<Monster> getMonsters();
    boolean isEmpty(Position position);
    //boolean isMonster(Position position);
    void catchPoint(Position position);
}
