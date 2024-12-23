package com.Spanca05.astronaut.model.game.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AstronautTest {

    @Test
    public void dieNoShield() throws Exception {
        Astronaut astronaut = new Astronaut(0,0);
        assertFalse(astronaut.hasShield());
        astronaut.die();
        assertFalse(astronaut.isAlive());
    }

    @Test
    public void dieWithShield() throws Exception {
        Astronaut astronaut = new Astronaut(0,0);
        astronaut.setShield(true);
        assertTrue(astronaut.hasShield());
        astronaut.die();
        assertTrue(astronaut.isAlive());
    }
}
