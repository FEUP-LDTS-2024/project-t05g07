package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.game.elements.Powerup;

public class ImanDecorator extends PowerupDecorator {

    public ImanDecorator(Power wrappee) {
        super(wrappee);
    }
}
