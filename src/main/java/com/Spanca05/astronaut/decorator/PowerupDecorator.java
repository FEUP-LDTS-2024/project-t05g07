package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;

public class PowerupDecorator implements Power {
    protected Power wrappee;

    public PowerupDecorator(Power wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void catchPoint(Position position) {
        wrappee.catchPoint(position);
    }
}
