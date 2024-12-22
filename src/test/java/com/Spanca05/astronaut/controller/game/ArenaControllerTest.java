package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.states.GameFinishedMenuState;
import com.Spanca05.astronaut.states.LevelCompletedMenuState;
import com.Spanca05.astronaut.states.LevelFailedMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArenaControllerTest {

    @Test
    public void stepQuit() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        Mockito.when(astronautMock.isAlive()).thenReturn(true);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);

        ArenaController ac = new ArenaController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.QUIT;
        long time = 2000;

        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any());
    }

    @Test
    public void stepMove() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        Mockito.when(astronautMock.isAlive()).thenReturn(true);
        Mockito.when(astronautMock.getDirection()).thenReturn(null);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);

        ArenaController ac = new ArenaController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        ac.step(gameMock, action, time);
        Mockito.verify(astronautMock, Mockito.times(1)).setDirection(action);

        action = GUI.ACTION.RIGHT;
        ac.step(gameMock, action, time);
        Mockito.verify(astronautMock, Mockito.times(1)).setDirection(action);

        action = GUI.ACTION.UP;
        ac.step(gameMock, action, time);
        Mockito.verify(astronautMock, Mockito.times(1)).setDirection(action);

        action = GUI.ACTION.DOWN;
        ac.step(gameMock, action, time);
        Mockito.verify(astronautMock, Mockito.times(1)).setDirection(action);

        action = null;
        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.never()).setState(Mockito.any());
        Mockito.verify(astronautMock, Mockito.never()).setDirection(action);

        action = GUI.ACTION.SELECT;
        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.never()).setState(Mockito.any());
        Mockito.verify(astronautMock, Mockito.never()).setDirection(action);
    }

    @Test
    public void stepMoveNull() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        Mockito.when(astronautMock.isAlive()).thenReturn(true);

        GUI.ACTION action = GUI.ACTION.LEFT;
        Mockito.when(astronautMock.getDirection()).thenReturn(action);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);

        ArenaController ac = new ArenaController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        long time = 2000;

        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.never()).setState(Mockito.any());
        Mockito.verify(astronautMock, Mockito.never()).setDirection(action);
    }

    @Test
    public void stepNotAlivePassed() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        Mockito.when(astronautMock.isAlive()).thenReturn(false);
        Mockito.when(astronautMock.isLevelPassed()).thenReturn(true);
        Mockito.when(astronautMock.getDirection()).thenReturn(null);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(arenaMock.getCurrentLevel()).thenReturn(8);

        ArenaController ac = new ArenaController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameFinishedMenuState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(LevelCompletedMenuState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(LevelFailedMenuState.class));

        Mockito.when(arenaMock.getCurrentLevel()).thenReturn(7);
        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameFinishedMenuState.class));
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(LevelCompletedMenuState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(LevelFailedMenuState.class));
    }

    @Test
    public void stepNotAliveNotPassed() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        Mockito.when(astronautMock.isAlive()).thenReturn(false);
        Mockito.when(astronautMock.isLevelPassed()).thenReturn(false);
        Mockito.when(astronautMock.getDirection()).thenReturn(null);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(arenaMock.getCurrentLevel()).thenReturn(8);

        ArenaController ac = new ArenaController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        ac.step(gameMock, action, time);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameFinishedMenuState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(LevelCompletedMenuState.class));
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(LevelFailedMenuState.class));
    }
}
