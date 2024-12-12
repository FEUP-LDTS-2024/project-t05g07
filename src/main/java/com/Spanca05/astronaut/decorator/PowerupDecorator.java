package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Monster;

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
    public boolean isEmpty(Position position) {
        return wrappee.isEmpty(position);
    }

    @Override
    public void catchPoint(Position position) {
        wrappee.catchPoint(position);
    }

}
