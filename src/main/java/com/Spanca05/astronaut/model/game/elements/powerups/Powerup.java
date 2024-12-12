package com.Spanca05.astronaut.model.game.elements.powerups;


import com.Spanca05.astronaut.model.game.elements.Point;

public abstract class Powerup extends Point {
    public Powerup() {}

    public Powerup(int x, int y) {
        super(x, y);
    }

    public abstract long getDuration();

    public abstract void extendDuration();

    public abstract int getUpgradeAmount();
}
