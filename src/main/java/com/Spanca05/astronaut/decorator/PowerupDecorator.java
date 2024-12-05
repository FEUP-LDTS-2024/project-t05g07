package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Point;

public class PowerupDecorator implements Power {
    protected Power wrappee;

    public PowerupDecorator(Power wrappee) {
        this.wrappee = wrappee;
    }



}
