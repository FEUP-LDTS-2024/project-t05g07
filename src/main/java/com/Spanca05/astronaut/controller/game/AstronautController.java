package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.decorator.ImanDecorator;
import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.decorator.PowerupDecorator;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Iman;

import java.util.Timer;

public class AstronautController extends GameController {
    Power power;
    public AstronautController(Arena arena) {
        super(arena);
        power = arena;
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

            // A different logic might be necessary.
            // If the astronaut dies, the game goes to the menu.
            // He didn't really die if he reached the end of the level.
            // Yes, Astronaut's life has to be "false" in the menu,
            // but he didn't die.
            if (getModel().isEndBlock(position)) getModel().getAstronaut().die();

            if (getModel().isPowerup(position)) {
                //long startTime = System.currentTimeMillis();
                //while (System.currentTimeMillis() - startTime < 2000) {
                    power = new ImanDecorator(power);
                    power.catchPoint(position);
                //}
            }

            if (getModel().isPoint(position)) getModel().catchPoint(position);
        } else {
            getModel().getAstronaut().setDirection(null);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (getModel().getAstronaut().getDirection()) {
            case UP -> moveAstronautUp();
            case DOWN -> moveAstronautDown();
            case LEFT -> moveAstronautLeft();
            case RIGHT -> moveAstronautRight();
            case null, default -> {
            }
        }
    }
}

