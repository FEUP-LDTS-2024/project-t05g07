package com.Spanca05.astronaut;


import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Astronaut;
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
        Astronaut customHero = new Astronaut(2, 2);

        assertEquals(position, customHero.getPosition());
    }

}