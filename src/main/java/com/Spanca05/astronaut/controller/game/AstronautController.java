package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.decorator.concretedecorators.EscudoDecorator;
import com.Spanca05.astronaut.decorator.concretedecorators.ImanDecorator;
import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

public class AstronautController extends GameController {
    private Power power;
    private long activationTime;
    private boolean isPowerActive;
    private String currentPower;

    public AstronautController(Arena arena) {
        super(arena);
        power = arena;
        activationTime = 0;
        isPowerActive = false;
        currentPower = "";
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

            //power.isMonster(position)
            if (getModel().isMonster(position)) {
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

            //if(getModel().isCoin(position)) getModel().catchCoin(position);

            if (getModel().isStar(position)) getModel().catchStar(position);

            // Bug aqui também, iman n apanha o powerup
            if (getModel().isPowerup(position)) activatePowerup(position);

            power.catchPoint(position);
        }
        else {
            getModel().getAstronaut().setDirection(null);
        }
    }

    private void activatePowerup(Position position) {
        // Isto está bugado as fuck por enquanto, ok.
        // O que acontece é que apanhar um powerup aumenta
        // a duração do powerup que está ativo, mas não muda
        // o powerup ativo.
        // Inicialmente, que só tinha implementado 1, apanhar
        // outro íman aumentava a duração do íman que estava
        // ativo.

        // O suposto é aumentar a duração se for o mesmo
        // tipo de powerup ou mudar de powerup se for diferente.
        // Era fixe ter vários ativos ao mesmo tempo, mas isso
        // seria uma confusão para implementar.

        // Anyway, depois corrijo isto e logo se vê.

        //if (!isPowerActive) {
            if (getModel().isImanPowerup(position)
                    && !currentPower.equals("iman")) {
                power = getModel();
                power = new ImanDecorator(power);
                currentPower = "iman";
                getModel().getAstronaut().setShield(false);
            }

            else if (getModel().isEscudoPowerup(position)
                    && !currentPower.equals("escudo")) {
                power = getModel();
                power = new EscudoDecorator(power);
                currentPower = "escudo";
                getModel().getAstronaut().setShield(true);
            }

            isPowerActive = true;
            System.out.println("activated power up");
        //}

        activationTime = System.currentTimeMillis();
    }

    private void deactivatePowerup() {
        power = getModel();
        getModel().getAstronaut().setShield(false);
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

