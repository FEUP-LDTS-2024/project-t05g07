package com.Spanca05.astronaut;

import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MonsterTest {
    private Monster monster;

    @BeforeEach
    public void helper() {
        monster = new Monster(5, 5);
    }

    @Test
    void testRandomMove() {
        Position currentPosition = monster.getPosition();
        Position newPosition = monster.randomMove(currentPosition);

        int deltaX = Math.abs(newPosition.getX() - currentPosition.getX());
        int deltaY = Math.abs(newPosition.getY() - currentPosition.getY());

        assertNotEquals(0 , deltaX + deltaY);
        assertTrue(deltaX <= 1 && deltaY <= 1);
    }

    @Test
    void testMove() {
        Position currentPosition = monster.getPosition();
        Position newPosition = monster.move(currentPosition);

        int deltaX = Math.abs(newPosition.getX() - currentPosition.getX());
        int deltaY = Math.abs(newPosition.getY() - currentPosition.getY());

        assertNotEquals(0, deltaX + deltaY);
        assertTrue(deltaX <= 1 && deltaY <= 1);
    }


}