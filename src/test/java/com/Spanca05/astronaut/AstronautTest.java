package com.Spanca05.astronaut;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AstronautTest {
    private Astronaut hero;

    @BeforeEach
    public void helper() {
        hero = new Astronaut(5, 5);
    }

    @Test
    public void testConstructorWithCoordinates() {
        assertEquals(5, hero.getPosition().getX());
        assertEquals(5, hero.getPosition().getY());
    }

    @Test
    public void testConstructorWithPosition() {
        Position position = new Position(2, 2);
        Astronaut customHero = new Astronaut(position);

        assertEquals(position, customHero.getPosition());
    }

    @Test
    public void testMoveUp() {
        Position newPosition = hero.moveUp();
        assertEquals(5, newPosition.getX());
        assertEquals(4, newPosition.getY());
    }

    @Test
    public void testMoveDown() {
        Position newPosition = hero.moveDown();
        assertEquals(5, newPosition.getX());
        assertEquals(6, newPosition.getY());
    }

    @Test
    public void testMoveLeft() {
        Position newPosition = hero.moveLeft();
        assertEquals(4, newPosition.getX());
        assertEquals(5, newPosition.getY());
    }

    @Test
    public void testMoveRight() {
        Position newPosition = hero.moveRight();
        assertEquals(6 , newPosition.getX());
        assertEquals(5, newPosition.getY());
    }

}