package com.Spanca05.astronaut.model.game.elements;

import com.Spanca05.astronaut.model.Position;


public class Camera {

        private Position position;

    public Camera(Position position) {
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
