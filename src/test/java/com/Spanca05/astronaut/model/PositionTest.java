package com.Spanca05.astronaut.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position position1;
    private Position position2;
    private Position original;

    @BeforeEach
    public void helper() {
        position1 = new Position(4, 4);
        position2 = new Position(5, 5);
        original = new Position(7, 9);
    }

    @Test
    public void testConstructor() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    public void testGetX() {
        assertEquals(4, position1.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(4, position1.getY());
    }

    @Test
    public void testEqualsTrue() {
        Position copy = new Position(4, 4);
        assertTrue(position1.equals(copy));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(position1.equals(position2));
    }
}