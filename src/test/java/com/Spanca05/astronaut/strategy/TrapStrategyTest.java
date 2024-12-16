package com.Spanca05.astronaut.strategy;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
import com.Spanca05.astronaut.model.game.elements.Element;
import com.Spanca05.astronaut.model.game.elements.Monster;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class TrapStrategyTest {
    private Arena helper() {
        Arena arenaMock = Mockito.mock(Arena.class);
        Position p1 = new Position(1,1);
        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(astronautMock.getPosition()).thenReturn(p1);

        return arenaMock;
    }

    @Test
    public void stepDidntTouch() {
        Arena arenaMock = helper();

        Element e1 = new Element(1, 1);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        TrapStrategy ss = new TrapStrategy();
        ss.step(arenaMock, e1, action, time);

        assertNull(ss.getAstronautLastPosition());
    }

    @Test
    public void stepTouched() {
        Arena arenaMock = helper();
        Astronaut astronautMock = arenaMock.getAstronaut();

        Element e1 = new Element(1, 2);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        TrapStrategy ss = new TrapStrategy();
        ss.step(arenaMock, e1, action, time);

        assertEquals(ss.getAstronautLastPosition(), astronautMock.getPosition());

        Element e2 = new Element(1, 0);
        Element e3 = new Element(2, 1);
        Element e4 = new Element(0, 1);

        ss.step(arenaMock, e2, action, time);
        assertEquals(ss.getAstronautLastPosition(), astronautMock.getPosition());

        ss.step(arenaMock, e3, action, time);
        assertEquals(ss.getAstronautLastPosition(), astronautMock.getPosition());

        ss.step(arenaMock, e4, action, time);
        assertEquals(ss.getAstronautLastPosition(), astronautMock.getPosition());
    }

    @Test
    public void spawnedOnce() {
        Arena arenaMock = Mockito.mock(Arena.class);

        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(astronautMock.getPosition()).thenReturn(new Position(0,1));

        Element e1 = new Element(0, 0);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 0;

        TrapStrategy ss = new TrapStrategy();
        ss.step(arenaMock, e1, action, time);
        ss.step(arenaMock, e1, action, time + 501);

        Mockito.verify(arenaMock, Mockito.times(1)).addToMonsters(Mockito.any(Monster.class));

        ss.step(arenaMock, e1, action, time + 1499);

        Mockito.verify(arenaMock, Mockito.times(1)).addToMonsters(Mockito.any(Monster.class));
    }

    @Test
    public void despawned() {
        Arena arenaMock = Mockito.mock(Arena.class);

        Astronaut astronautMock = Mockito.mock(Astronaut.class);
        Mockito.when(arenaMock.getAstronaut()).thenReturn(astronautMock);
        Mockito.when(astronautMock.getPosition()).thenReturn(new Position(0,1));

        Element e1 = new Element(0, 0);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 0;

        TrapStrategy ss = new TrapStrategy();
        ss.step(arenaMock, e1, action, time);
        ss.step(arenaMock, e1, action, time + 501);
        ss.step(arenaMock, e1, action, time + 1501);

        Mockito.verify(arenaMock, Mockito.times(1)).removeFromMonsters(new Position(0, 1));

        ss.step(arenaMock, e1, action, time + 1502);

        Mockito.verify(arenaMock, Mockito.times(1)).removeFromMonsters(new Position(0, 1));
    }

    /*@Test
    public void milEQuinhentosNotSpawned() {

    }*/
}
