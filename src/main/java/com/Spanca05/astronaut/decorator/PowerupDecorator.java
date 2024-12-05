package com.Spanca05.astronaut.decorator;

public class PowerupDecorator implements Power {
    protected Power wrappee;

    public PowerupDecorator(Power wrappee) {
        this.wrappee = wrappee;
    }
}
