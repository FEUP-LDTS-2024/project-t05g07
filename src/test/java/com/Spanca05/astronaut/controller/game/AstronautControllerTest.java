package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.model.game.elements.Point;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AstronautControllerTest {
    private Arena helper() {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        return arenaMock;
    }

    @Test
    public void moveAstronautLeft() throws Exception {
        Arena helper = helper();

        AstronautController ac = new AstronautController(helper);
        ac.moveAstronautLeft();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(1)).getLeft();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getRight();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getUp();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getDown();
    }

    @Test
    public void moveAstronautRight() throws Exception {
        Arena helper = helper();

        AstronautController ac = new AstronautController(helper);
        ac.moveAstronautRight();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getLeft();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(1)).getRight();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getUp();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getDown();
    }

    @Test
    public void moveAstronautUp() throws Exception {
        Arena helper = helper();

        AstronautController ac = new AstronautController(helper);
        ac.moveAstronautUp();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getLeft();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getRight();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(1)).getUp();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getDown();
    }

    @Test
    public void moveAstronautDown() throws Exception {
        Arena helper = helper();

        AstronautController ac = new AstronautController(helper);
        ac.moveAstronautDown();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getLeft();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getRight();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(0)).getUp();
        Mockito.verify(helper.getAstronaut().getPosition(), Mockito.times(1)).getDown();
    }

    @Test
    public void stepLeft() throws Exception {
        Arena helper = helper();

        AstronautController ac = Mockito.spy(new AstronautController(helper));
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;
        Mockito.when(helper.getAstronaut().getDirection()).thenReturn(action);

        ac.step(gameMock, action, time);
        Mockito.verify(helper.getAstronaut(), Mockito.times(1)).getDirection();
        Mockito.verify(ac, Mockito.times(1)).moveAstronautLeft();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautRight();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautUp();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautDown();
    }

    @Test
    public void stepRight() throws Exception {
        Arena helper = helper();

        AstronautController ac = Mockito.spy(new AstronautController(helper));
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.RIGHT;
        long time = 2000;
        Mockito.when(helper.getAstronaut().getDirection()).thenReturn(action);

        ac.step(gameMock, action, time);
        Mockito.verify(helper.getAstronaut(), Mockito.times(1)).getDirection();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautLeft();
        Mockito.verify(ac, Mockito.times(1)).moveAstronautRight();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautUp();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautDown();
    }

    @Test
    public void stepUp() throws Exception {
        Arena helper = helper();

        AstronautController ac = Mockito.spy(new AstronautController(helper));
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;
        long time = 2000;
        Mockito.when(helper.getAstronaut().getDirection()).thenReturn(action);

        ac.step(gameMock, action, time);
        Mockito.verify(helper.getAstronaut(), Mockito.times(1)).getDirection();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautLeft();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautRight();
        Mockito.verify(ac, Mockito.times(1)).moveAstronautUp();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautDown();
    }

    @Test
    public void stepDown() throws Exception {
        Arena helper = helper();

        AstronautController ac = Mockito.spy(new AstronautController(helper));
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.DOWN;
        long time = 2000;
        Mockito.when(helper.getAstronaut().getDirection()).thenReturn(action);

        ac.step(gameMock, action, time);
        Mockito.verify(helper.getAstronaut(), Mockito.times(1)).getDirection();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautLeft();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautRight();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautUp();
        Mockito.verify(ac, Mockito.times(1)).moveAstronautDown();
    }

    @Test
    public void stepNull() throws Exception {
        Arena helper = helper();

        AstronautController ac = Mockito.spy(new AstronautController(helper));
        Game gameMock = Mockito.mock(Game.class);
        long time = 2000;
        Mockito.when(helper.getAstronaut().getDirection()).thenReturn(null);

        ac.step(gameMock, null, time);
        Mockito.verify(helper.getAstronaut(), Mockito.times(1)).getDirection();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautLeft();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautRight();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautUp();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautDown();
    }

    @Test
    public void stepNone() throws Exception {
        Arena helper = helper();

        AstronautController ac = Mockito.spy(new AstronautController(helper));
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.NONE;
        long time = 2000;
        Mockito.when(helper.getAstronaut().getDirection()).thenReturn(action);

        ac.step(gameMock, action, time);
        Mockito.verify(helper.getAstronaut(), Mockito.times(1)).getDirection();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautLeft();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautRight();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautUp();
        Mockito.verify(ac, Mockito.times(0)).moveAstronautDown();
    }

    @Test
    void moveAstronautEmpty() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position after = new Position(0, 0);
        Mockito.when(((Power) arenaMock).isEmpty(after)).thenReturn(true);
        Mockito.when(arenaMock.getCaughtPowerups()).thenReturn(new LinkedList<>());

        GUI.ACTION action = GUI.ACTION.RIGHT;
        Astronaut astronaut = Mockito.spy(new Astronaut(-1, 0));
        astronaut.setDirection(action);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronaut);

        AstronautController ac = new AstronautController(arenaMock);

        Game game = Mockito.mock(Game.class);
        ac.step(game, action, 1000);
        Mockito.verify(astronaut, Mockito.times(1)).setPosition(after);
        Mockito.verify(arenaMock, Mockito.times(1)).catchPoint(after);
        Mockito.verify(astronaut, Mockito.times(0)).setDirection(null);
    }

    @Test
    void moveAstronautNotEmpty() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position after = new Position(0, 0);
        Mockito.when(((Power) arenaMock).isEmpty(after)).thenReturn(false);
        Mockito.when(arenaMock.getCaughtPowerups()).thenReturn(new LinkedList<>());

        GUI.ACTION action = GUI.ACTION.RIGHT;
        Astronaut astronaut = Mockito.spy(new Astronaut(-1, 0));
        astronaut.setDirection(action);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronaut);

        AstronautController ac = new AstronautController(arenaMock);

        Game game = Mockito.mock(Game.class);
        ac.step(game, action, 1000);
        Mockito.verify(astronaut, Mockito.never()).setPosition(after);
        Mockito.verify(arenaMock, Mockito.never()).catchPoint(after);
        Mockito.verify(astronaut, Mockito.times(1)).setDirection(null);
    }

    @Test
    public void moveToMonster() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position after = new Position(0, 0);
        Mockito.when(((Power) arenaMock).isEmpty(after)).thenReturn(true);
        Mockito.when(arenaMock.isMonster(after)).thenReturn(true);
        Mockito.when(arenaMock.getCaughtPowerups()).thenReturn(new LinkedList<>());

        GUI.ACTION action = GUI.ACTION.RIGHT;
        Astronaut astronaut = Mockito.spy(new Astronaut(-1, 0));
        astronaut.setDirection(action);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronaut);

        AstronautController ac = new AstronautController(arenaMock);

        Game game = Mockito.mock(Game.class);
        ac.step(game, action, 1000);
        Mockito.verify(astronaut, Mockito.times(1)).setDirection(null);
        Mockito.verify(astronaut, Mockito.times(1)).die();
    }

    @Test
    public void moveToEndBlock() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position after = new Position(0, 0);
        Mockito.when(((Power) arenaMock).isEmpty(after)).thenReturn(true);
        Mockito.when(arenaMock.isEndBlock(after)).thenReturn(true);
        Mockito.when(arenaMock.getCaughtPowerups()).thenReturn(new LinkedList<>());

        GUI.ACTION action = GUI.ACTION.RIGHT;
        Astronaut astronaut = Mockito.spy(new Astronaut(-1, 0));
        astronaut.setDirection(action);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronaut);

        AstronautController ac = new AstronautController(arenaMock);

        Game game = Mockito.mock(Game.class);
        ac.step(game, action, 1000);
        Mockito.verify(astronaut, Mockito.times(1)).win();
    }

    @Test
    public void moveToStar() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position after = new Position(0, 0);
        Mockito.when(((Power) arenaMock).isEmpty(after)).thenReturn(true);
        Mockito.when(arenaMock.isStar(after)).thenReturn(true);
        Mockito.when(arenaMock.getCaughtPowerups()).thenReturn(new LinkedList<>());

        GUI.ACTION action = GUI.ACTION.RIGHT;
        Astronaut astronaut = Mockito.spy(new Astronaut(-1, 0));
        astronaut.setDirection(action);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronaut);

        AstronautController ac = new AstronautController(arenaMock);

        Game game = Mockito.mock(Game.class);
        ac.step(game, action, 1000);
        Mockito.verify(arenaMock, Mockito.times(1)).catchStar(after);
    }
}
