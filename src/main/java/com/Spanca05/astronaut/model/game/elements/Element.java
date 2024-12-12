package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.model.Position;

public class Element {
    private Position position;

    public Element() {}

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
