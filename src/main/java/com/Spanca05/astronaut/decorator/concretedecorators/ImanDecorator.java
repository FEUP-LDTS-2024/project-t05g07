package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.decorator.PowerupDecorator;
import com.Spanca05.astronaut.model.Position;

public class ImanDecorator extends PowerupDecorator {

    public ImanDecorator(Power wrappee) {
        super(wrappee);
    }

    @Override
    public void catchPoint(Position position) {
        Position adj;
        for (int i = position.getX() - 2; i <= position.getX() + 2; i++) {
            for (int j = position.getY() - 2; j <= position.getY() + 2; j++) {
                adj = new Position(i, j);
                wrappee.catchPoint(adj);
            }
        }
    }

    /*@Override
    public boolean isPowerup(Position position) {
        Position adj;
        for (int i = position.getX() - 2; i <= position.getX() + 2; i++) {
            for (int j = position.getY() - 2; j <= position.getY() + 2; j++) {
                adj = new Position(i, j);
                if (wrappee.isPowerup(adj)) return true;
            }
        }
        return false;
    }*/
}
