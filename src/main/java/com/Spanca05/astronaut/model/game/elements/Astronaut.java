package com.Spanca05.astronaut.model.game.elements;

public class Astronaut extends Element {
    private boolean life;

    public Astronaut(int x, int y) {
        super(x, y);
        this.life = true;
    }

    public void die() {
        this.life = false;
    }

    public boolean getLife() {
        return life;
    }
}
