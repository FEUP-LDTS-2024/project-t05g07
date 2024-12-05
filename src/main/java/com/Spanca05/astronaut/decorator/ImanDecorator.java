package com.Spanca05.astronaut.decorator;

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
}
