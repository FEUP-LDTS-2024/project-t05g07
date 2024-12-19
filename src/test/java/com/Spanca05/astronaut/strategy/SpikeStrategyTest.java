package com.Spanca05.astronaut.strategy;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.model.game.elements.Element;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SpikeStrategyTest {
    private Arena helper() {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position p1 = new Position(1,1);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(astronautMock.getPosition()).thenReturn(p1);

        return arenaMock;
    }

    @Test
    public void stepTrue() throws Exception {
        Arena arenaMock = helper();
        Astronaut astronautMock = arenaMock.getAstronaut();

        Element e1 = new Element(1, 1);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        SpikeStrategy ss = new SpikeStrategy();
        ss.step(arenaMock, e1, action, time);

        Mockito.verify(astronautMock, Mockito.times(1)).die();
    }

    @Test
    public void stepFalse() throws Exception {
        Arena arenaMock = helper();
        Astronaut astronautMock = arenaMock.getAstronaut();

        Element e2 = new Element(2, 2);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        SpikeStrategy ss = new SpikeStrategy();
        ss.step(arenaMock, e2, action, time);

        Mockito.verify(astronautMock, Mockito.never()).die();
    }
}
