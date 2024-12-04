package com.Spanca05.astronaut.model.game.elements;

public abstract class Powerup extends Element {
    private Power power;

    public Powerup(int x, int y) {
        super(x, y);
        this.power = createPower();
    }

    protected abstract Power createPower();
}
