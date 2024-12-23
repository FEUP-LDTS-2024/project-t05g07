package com.Spanca05.astronaut.model.game.arena;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.*;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    public void setUp() throws Exception {
        arena = new Arena(10,10,1);
    }

    @Test
    public void setAstronaut() {
        Astronaut astronaut = new Astronaut(0,0);
        arena = Mockito.spy(arena);
        arena.setAstronaut(astronaut);
        assertEquals(astronaut, arena.getAstronaut());
        assertEquals(arena.getCameraPosition(), astronaut.getPosition().minus(new Position(9,9)));
    }

    @Test
    public void removeFromMonsters() {
        List<Monster> monsters = new ArrayList<>();
        Monster m1 = new Monster(0,0);
        Monster m2 = new Monster(1,1);
        monsters.add(m1);
        arena.setMonsters(monsters);
        assertEquals(arena.getMonsters().size(), 1);
        arena.addToMonsters(m2);
        assertEquals(arena.getMonsters().size(), 2);

        arena.removeFromMonsters(m1.getPosition());
        assertEquals(arena.getMonsters().size(), 1);
        arena.removeFromMonsters(new Position(9,9));
        assertEquals(arena.getMonsters().size(), 1);

        Point p1 = new Point(2,2);
        assertNotEquals(p1.getPosition(), m2.getPosition());
        arena.removeFromMonsters(p1.getPosition());
        assertEquals(arena.getMonsters().size(), 1);
    }

    @Test
    public void getCoinsPowers() {
        List<Point> points = new ArrayList<>();

        Point p1 = new Point(0,0);
        Point p2 = new Point(1,1);
        Point p3 = new Coin(2,2);
        Point p4 = new Coin(3,3);
        Point p5 = new Iman(4,4);
        Point p6 = new Escudo(5,5);
        Point p7 = new BonusCoins(6,7);

        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);
        points.add(p6);
        points.add(p7);

        arena.setPoints(points);

        assertEquals(arena.getCoins().size(),2);
        assertEquals(arena.getPowers().size(),3);
        assertEquals(arena.getPoints().size(),7);
    }

    @Test
    public void pollPowerup() {
        Iman iman = new Iman(0,0);
        List<Point> points = new ArrayList<>();
        points.add(iman);
        arena.setPoints(points);

        arena.catchPoint(iman.getPosition());
        assertEquals(arena.getCaughtPowerups().size(), 1);
        Powerup powerup = arena.pollPowerup();
        assertInstanceOf(Iman.class, powerup);
        assertEquals(powerup, iman);
        assertEquals(arena.getCaughtPowerups().size(), 0);
    }

    @Test
    public void isEmpty() {
        List<Wall> walls = new ArrayList<>();
        Wall w1 = new Wall(0,0);
        walls.add(w1);
        arena.setWalls(walls);
        assertEquals(arena.getWalls(), walls);

        Position pos = w1.getPosition();
        assertFalse(arena.isEmpty(pos));
        assertTrue(arena.isEmpty(new Position(1,1)));
    }

    @Test
    public void isMonster() {
        List<Monster> monsters = new ArrayList<>();
        Monster m1 = new Monster(0,0);
        monsters.add(m1);
        arena.setMonsters(monsters);

        Position pos = m1.getPosition();
        assertTrue(arena.isMonster(pos));
        assertFalse(arena.isMonster(new Position(1,1)));
    }

    @Test
    public void isEndblock() {
        EndBlock e = new EndBlock(0,0);
        arena.setEndBlock(e);
        assertEquals(arena.getEndBlock(), e);

        Position pos = e.getPosition();
        assertTrue(arena.isEndBlock(pos));
        assertFalse(arena.isEndBlock(new Position(1,1)));
    }

    @Test
    public void isStar() throws Exception {
        List<Star> stars = new ArrayList<>();
        Star s1 = new Star(0,0);
        Star s2 = new Star(1,1);
        Star s3 = new Star(2,2);
        assertNotEquals(s1.getPosition(),s2.getPosition());
        assertNotEquals(s2.getPosition(),s3.getPosition());
        assertNotEquals(s1.getPosition(),s3.getPosition());
        stars.add(s1);
        stars.add(s2);
        stars.add(s3);
        arena.setStar(stars);
        assertTrue(arena.getStars().size() >= 3);

        assertTrue(arena.isStar(s1.getPosition()));
        assertTrue(arena.isStar(s2.getPosition()));
        assertTrue(arena.isStar(s3.getPosition()));
        assertFalse(arena.isStar(new Position(-1,-1)));
        assertFalse(arena.isStar(new Position(4,4)));
    }

    @Test
    public void catchPoint() {
        List<Point> points = new ArrayList<>();
        Point p1 = new Point(0,0);
        points.add(p1);
        arena.setPoints(points);

        arena.catchPoint(new Position(1,1));
        assertEquals(points.size(), 1);
        arena.catchPoint(p1.getPosition());
        assertEquals(points.size(), 0);
    }

    @Test
    public void catchStar() throws Exception {
        List<Star> stars = new ArrayList<>();
        Star s1 = new Star(0,0);
        stars.add(s1);
        arena.setStar(stars);

        arena.catchStar(new Position(1,1));
        assertEquals(stars.size(), 1);
        arena.catchStar(s1.getPosition());
        assertEquals(stars.size(), 0);
    }
}
