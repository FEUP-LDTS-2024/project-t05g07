package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
}
