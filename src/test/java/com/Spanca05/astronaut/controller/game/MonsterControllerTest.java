package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.MonsterWall;
import com.Spanca05.astronaut.model.game.elements.Wall;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class MonsterControllerTest {

    @Test
    public void step() throws Exception {
        Arena arenaMock = Mockito.mock(Arena.class);

        List<Monster> monsters = new ArrayList<>();
        Monster m1 = Mockito.mock(Monster.class);
        Monster m2 = Mockito.mock(Monster.class);
        Monster m3 = Mockito.mock(Monster.class);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);

        List<Wall> walls = new ArrayList<>();
        MonsterWall w1 = Mockito.mock(MonsterWall.class);
        Wall w2 = Mockito.mock(Wall.class);
        Wall w3 = Mockito.mock(Wall.class);
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);

        Mockito.when(arenaMock.getMonsters()).thenReturn(monsters);
        Mockito.when(arenaMock.getWalls()).thenReturn(walls);

        MonsterController mc = new MonsterController(arenaMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.LEFT;
        long time = 2000;

        mc.step(gameMock, action, time);

        Mockito.verify(m1, Mockito.times(1)).execute(arenaMock, action, time);
        Mockito.verify(m2, Mockito.times(1)).execute(arenaMock, action, time);
        Mockito.verify(m3, Mockito.times(1)).execute(arenaMock, action, time);
        Mockito.verify(w1, Mockito.times(1)).execute(arenaMock, action, time);
        Mockito.verify(w2, Mockito.times(1)).execute(arenaMock, action, time);
        Mockito.verify(w3, Mockito.times(1)).execute(arenaMock, action, time);
    }
}
