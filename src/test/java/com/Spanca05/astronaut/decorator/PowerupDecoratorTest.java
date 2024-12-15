package com.Spanca05.astronaut.decorator;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Coin;
import com.Spanca05.astronaut.model.game.elements.Monster;
import com.Spanca05.astronaut.model.game.elements.Point;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerupDecoratorTest {
    private Power helper() {
        Arena arenaMock = Mockito.mock(Arena.class);

        List<Monster> monsters = new ArrayList<>();
        Monster m1 = new Monster(1, 1);
        Monster m2 = new Monster(2, 2);
        Monster m3 = new Monster(3, 3);
        monsters.add(m1);
        monsters.add(m2);
        monsters.add(m3);

        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 3));

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(1, 1));
        walls.add(new Wall(2, 2));
        walls.add(new Wall(3, 3));

        arenaMock.setMonsters(monsters);
        arenaMock.setPoints(points);
        arenaMock.setWalls(walls);

        return arenaMock;
    }

    @Test
    public void getMonsters() {
        PowerupDecorator pd = new PowerupDecorator(helper());
        List<Monster> monsters1 = helper().getMonsters();
        List<Monster> monsters2 = pd.getMonsters();
        assertEquals(monsters1, monsters2);
    }

    @Test
    public void getPoints() {
        PowerupDecorator pd = new PowerupDecorator(helper());
        List<Point> points1 = helper().getPoints();
        List<Point> points2 = pd.getPoints();
        assertEquals(points1, points2);
    }

    @Test
    public void isEmptyFalse() {
        Position p1 = new Position(1, 1);
        PowerupDecorator pd = new PowerupDecorator(helper());
        boolean b1 = helper().isEmpty(p1);
        boolean b2 = pd.isEmpty(p1);
        assertEquals(b1, b2);
    }

    @Test
    public void isEmptyTrue() {
        Position p1 = new Position(4, 4);
        PowerupDecorator pd = new PowerupDecorator(helper());
        boolean b1 = helper().isEmpty(p1);
        boolean b2 = pd.isEmpty(p1);
        assertEquals(b1, b2);
    }

    @Test
    public void catchPoint() {
        Arena arena = Mockito.mock(Arena.class);
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        arena.setPoints(points);

        arena.catchPoint(new Position(1,1));
        List<Point> p1 = arena.getPoints();

        arena.setPoints(points);
        PowerupDecorator pd = new PowerupDecorator(arena);
        pd.catchPoint(new Position(1,1));
        List<Point> p2 = arena.getPoints();

        assertEquals(p1, p2);
    }

    @Test
    public void amount() {
        PowerupDecorator pd = new PowerupDecorator(helper());

        int a1 = helper().amount(new Point(1, 1));
        int a2 = pd.amount(new Point(1, 1));
        assertEquals(a1, a2);

        int a3 = helper().amount(new Coin(1, 1));
        int a4 = pd.amount(new Coin(1, 1));
        assertEquals(a3, a4);

        int a5 = helper().amount(new Iman(1, 1));
        int a6 = pd.amount(new Iman(1, 1));
        assertEquals(a5, a6);
    }
}
