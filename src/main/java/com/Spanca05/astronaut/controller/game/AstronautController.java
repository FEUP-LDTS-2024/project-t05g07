package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.audio.SoundEffect;
import com.Spanca05.astronaut.decorator.concretedecorators.BonusCoinsDecorator;
import com.Spanca05.astronaut.decorator.concretedecorators.EscudoDecorator;
import com.Spanca05.astronaut.decorator.concretedecorators.ImanDecorator;
import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AstronautController extends GameController {
    private Power power;
    private long activationTime;
    private boolean isPowerActive;
    private Powerup currentPower;
    private final SoundEffect movementSound;
    private final SoundEffect powerUpSound;

    public AstronautController(Arena arena) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super(arena);
        power = arena;
        activationTime = 0;
        isPowerActive = false;
        currentPower = null;
        movementSound = new SoundEffect("movement.wav");
        powerUpSound = new SoundEffect("powerUp.wav");
    }

    public void moveAstronautLeft() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        moveAstronaut(getModel().getAstronaut().getPosition().getLeft());
    }

    public void moveAstronautRight() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        moveAstronaut(getModel().getAstronaut().getPosition().getRight());
    }

    public void moveAstronautUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        moveAstronaut(getModel().getAstronaut().getPosition().getUp());
    }

    public void moveAstronautDown() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        moveAstronaut(getModel().getAstronaut().getPosition().getDown());
    }

    private void moveAstronaut(Position position) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (power.isEmpty(position)) {

            movementSound.play();

            getModel().getAstronaut().setPosition(position);

            if (getModel().isMonster(position)) {
                // Para na posição do monstro quando morre.
                getModel().getAstronaut().setDirection(null);
                getModel().getAstronaut().die();
            }

            if (getModel().isEndBlock(position)) getModel().getAstronaut().win();

            //if(getModel().isCoin(position)) getModel().catchCoin(position);

            if (getModel().isStar(position)) getModel().catchStar(position);

            // Sim, o Iman está bugado porque isPowerup só aceita uma posição.
            // Depois corrijo.................................................
            if (getModel().isPowerup(position)) {
                powerUpSound.playInNewThread();
                activatePowerup(position);
            }

            power.catchPoint(position);
        }
        else {
            getModel().getAstronaut().setDirection(null);
        }
    }

    private void activatePowerup(Position position) {

        if (getModel().isImanPowerup(position)
                && !(currentPower instanceof Iman)) {
            power = getModel();
            power = new ImanDecorator(power);
            currentPower = new Iman();
            getModel().getAstronaut().setShield(false);
        }

        else if (getModel().isEscudoPowerup(position)
                && !(currentPower instanceof Escudo)) {
            power = getModel();
            power = new EscudoDecorator(power);
            currentPower = new Escudo();
            getModel().getAstronaut().setShield(true);
        }

        else if (getModel().isBonusCoinsPowerup(position)
                && !(currentPower instanceof BonusCoins)) {
            power = getModel();
            power = new BonusCoinsDecorator(power);
            currentPower = new BonusCoins();
            getModel().getAstronaut().setShield(false);
        }

        isPowerActive = true;
        System.out.println("activated power up");

        activationTime = System.currentTimeMillis();
    }

    private void deactivatePowerup() {
        power = getModel();
        getModel().getAstronaut().setShield(false);
        isPowerActive = false;
        System.out.println("deactivated power up");
    }

    private void rotateAstronaut(Position position) {
        switch (getModel().getAstronaut().getDirection()) {
            case UP -> getModel().getAstronaut().setAngle(180);
            case DOWN -> getModel().getAstronaut().setAngle(0);
            case LEFT -> getModel().getAstronaut().setAngle(90);
            case RIGHT -> getModel().getAstronaut().setAngle(-90);
            default -> {}
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        switch (getModel().getAstronaut().getDirection()) {
            case UP -> {
                moveAstronautUp();
                getModel().getAstronaut().setAngle(180);}
            case DOWN -> {
                moveAstronautDown();
                getModel().getAstronaut().setAngle(0);}
            case LEFT ->{
                moveAstronautLeft();
                getModel().getAstronaut().setAngle(90);
            }
            case RIGHT -> {
                moveAstronautRight();
                getModel().getAstronaut().setAngle(-90);}

            case null, default -> {
            }
        }

        if (isPowerActive && time - activationTime > currentPower.getDuration()) {
            deactivatePowerup();
        }
    }
}

