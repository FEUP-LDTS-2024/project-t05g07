package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.decorator.concretedecorators.EscudoDecorator;
import com.Spanca05.astronaut.decorator.concretedecorators.ImanDecorator;
import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;

public class AstronautController extends GameController {
    private Power power;
    private long activationTime;
    private boolean isPowerActive;

    public AstronautController(Arena arena) {
        super(arena);
        power = arena;
        activationTime = 0;
        isPowerActive = false;
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
        if (power.isEmpty(position)) {
            getModel().getAstronaut().setPosition(position);

            if (power.isMonster(position)) {
                // Para na posição do monstro quando morre.
                getModel().getAstronaut().setDirection(null);
                getModel().getAstronaut().die();
            }

            // A different logic might be necessary.
            // If the astronaut dies, the game goes to the menu.
            // He didn't really die if he reached the end of the level.
            // Yes, Astronaut's life has to be "false" in the menu,
            // but he didn't die.
            if (getModel().isEndBlock(position)) getModel().getAstronaut().die();

            if(getModel().isCoin(position)) getModel().catchCoin(position);

            if (getModel().isStar(position)) getModel().catchStar(position);

            if (getModel().isPowerup(position)) activatePowerup(position);

            power.catchPoint(position);
        }
        else {
            getModel().getAstronaut().setDirection(null);
        }
    }

    private void activatePowerup(Position position) {
        if (!isPowerActive) {
            if (getModel().isImanPowerup(position))
                power = new ImanDecorator(power);
            else if (getModel().isEscudoPowerup(position))
                power = new EscudoDecorator(power);

            isPowerActive = true;
            System.out.println("activated power up");
        }
        activationTime = System.currentTimeMillis();
    }

    private void deactivatePowerup() {
        power = getModel();
        isPowerActive = false;
        System.out.println("deactivated power up");
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

        if (isPowerActive && time - activationTime > 5000) {
            deactivatePowerup();
        }
    }
}

