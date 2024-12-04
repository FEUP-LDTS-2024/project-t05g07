package com.Spanca05.astronaut.model.game.elements;

public final class Iman extends Powerup {

    public Iman(int x, int y) {
        super(x, y);
    }

    @Override
    protected Power createPower() {
        return new ImanPower();
    }
}
