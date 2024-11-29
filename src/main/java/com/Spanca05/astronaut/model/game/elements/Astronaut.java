package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.gui.GUI;

public class Astronaut extends Element {
    private boolean life;
    private GUI.ACTION direction;

    public Astronaut(int x, int y) {
        super(x, y);
        this.life = true;
        this.direction = null;
    }

    public void setDirection(GUI.ACTION direction) {
        this.direction = direction;
    }

    public GUI.ACTION getDirection() {
        return direction;
    }

    public void die() {
        this.life = false;
    }

    public boolean isAlive() {
        return life;
    }
}
