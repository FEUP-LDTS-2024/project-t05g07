package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.Point;

import java.util.List;

public class PowerupDecorator implements Power {
    protected Power wrappee;

    public PowerupDecorator(Power wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public List<Monster> getMonsters() {
        return wrappee.getMonsters();
    }

    @Override
    public List<Point> getPoints() {
        return wrappee.getPoints();
    }

    @Override
    public boolean isEmpty(Position position) {
        return wrappee.isEmpty(position);
    }

    /*@Override
    public boolean isPowerup(Position position) {
        return wrappee.isPowerup(position);
    }*/

    @Override
    public void catchPoint(Position position) {
        wrappee.catchPoint(position);
    }
}
