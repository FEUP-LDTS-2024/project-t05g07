package com.Spanca05.astronaut.decorator.concretedecorators;

import com.Spanca05.astronaut.decorator.Power;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.Wall;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EscudoDecoratorTest {
    private Power helper() {
        Arena arenaMock = Mockito.mock(Arena.class);

        List<Monster> monsters = new ArrayList<>();
        Monster m1 = new Monster(1, 1);
        Monster m2 = new Monster(2, 2);
        Monster m3 = new Monster(3, 3);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(4, 4));
        walls.add(new Wall(5, 5));
        walls.add(new Wall(6, 6));

        Mockito.when(arenaMock.getMonsters()).thenReturn(monsters);
        Mockito.when(arenaMock.getWalls()).thenReturn(walls);

        Mockito.when(arenaMock.isEmpty(new Position(1, 1))).thenReturn(true);
        Mockito.when(arenaMock.isEmpty(new Position(2, 2))).thenReturn(true);
        Mockito.when(arenaMock.isEmpty(new Position(3, 3))).thenReturn(true);
        Mockito.when(arenaMock.isEmpty(new Position(4, 4))).thenReturn(false);
        Mockito.when(arenaMock.isEmpty(new Position(5, 5))).thenReturn(false);
        Mockito.when(arenaMock.isEmpty(new Position(6, 6))).thenReturn(false);
        Mockito.when(arenaMock.isEmpty(new Position(7, 7))).thenReturn(true);

        return arenaMock;
    }

    @Test
    public void isEmpty() {
        EscudoDecorator ed = new EscudoDecorator(helper());
        boolean empty1 = ed.isEmpty(new Position(1, 1));
        assertFalse(empty1);
        boolean empty2 = ed.isEmpty(new Position(2, 2));
        assertFalse(empty2);
        boolean empty3 = ed.isEmpty(new Position(3, 3));
        assertFalse(empty3);
        boolean empty4 = ed.isEmpty(new Position(7, 7));
        assertTrue(empty4);
    }
}
