package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CameraControllerTest {

    @Test
    public void step() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(astronautMock.getPosition()).thenReturn(Mockito.mock(Position.class));
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);

        CameraController cc = new CameraController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        cc.step(gameMock, action, time);
        Mockito.verify(astronautMock.getPosition(), Mockito.times(1)).minus(new Position(8,7));
    }
}
