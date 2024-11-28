package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;

public class AstronautController extends GameController {
    public AstronautController(Arena arena) {
        super(arena);
    }

    public void moveAstronautLeft() {
        moveAstronaut(getModel().getAstronaut().getPosition().getLeft());
    }

    public void moveAstronautRight() {
        moveAstronaut(getModel().getAstronaut().getPosition().getRight());
    }

    public void moveAstronautUp() {
        moveAstronaut(getModel().getAstronaut().getPosition().getUp());
    }

    public void moveAstronautDown() {
        moveAstronaut(getModel().getAstronaut().getPosition().getDown());
    }

    private void moveAstronaut(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getAstronaut().setPosition(position);

            if (getModel().isMonster(position)) getModel().getAstronaut().die();

            if (getModel().isPoint(position)) getModel().catchPoint(position);

        }

    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveAstronautUp();
        if (action == GUI.ACTION.RIGHT) moveAstronautRight();
        if (action == GUI.ACTION.DOWN) moveAstronautDown();
        if (action == GUI.ACTION.LEFT) moveAstronautLeft();
    }
}
