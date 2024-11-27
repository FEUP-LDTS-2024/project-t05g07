package com.Spanca05.astronaut;

import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.Spanca05.astronaut.model.game.elements.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArenaTest {
    private Arena arena;

    @BeforeEach
    public void helper() {
        arena = new Arena(10, 10);
    }

    @Test
    public void testHeroCanMoveToValidPosition() {
        Position validPosition = new Position(3, 3);
        assertTrue(arena.canAstronautMove(validPosition));
    }

    @Test
    public void testHeroCannotMoveToInvalidPosition() {
        Position invalidPosition = new Position(-1 , -1);
        assertFalse(arena.canAstronautMove(invalidPosition));
    }

    @Test
    public void testHeroRetrieveCoins() {
        Position coinPosition = arena.getCoins().get(0).getPosition();
        arena.getAstronaut().setPosition(coinPosition);

        arena.retrieveCoins();

        assertFalse(arena.getCoins().contains(new Coin(coinPosition)));
    }

    @Test
    void testMonsterCollisions() {
        Position monsterPosition = arena.getMonsters().get(0).getPosition();
        arena.getAstronaut().setPosition(monsterPosition);

        assertTrue(arena.verifyMonsterCollisions());
    }

    @Test
    public void testVictoryCondition() {
        arena.getCoins().clear();

        assertTrue(arena.verifyExistingCoins());
    }

    @Test
    public void testDefeatCondition() {
        Position monsterPosition = arena.getMonsters().get(0).getPosition();
        arena.getAstronaut().setPosition(monsterPosition);

        assertTrue(arena.verifyMonsterCollisions());
    }

    @Test
    public void testMoveHeroUp() {
        Position initialPosition = arena.getAstronaut().getPosition();

        Position expectedPosition = new Position(initialPosition.getX(), initialPosition.getY() - 1);

        arena.moveAstronaut(expectedPosition);

        assertEquals(expectedPosition, arena.getAstronaut().getPosition());
    }

    @Test
    public void testMoveHeroDown() {
        Position initialPosition = arena.getAstronaut().getPosition();

        Position expectedPosition = new Position(initialPosition.getX(), initialPosition.getY() + 1);

        arena.moveAstronaut(expectedPosition);

        assertEquals(expectedPosition, arena.getAstronaut().getPosition());
    }

    @Test
    public void testMoveHeroRight() {
        Position initialPosition = arena.getAstronaut().getPosition();

        Position expectedPosition = new Position(initialPosition.getX() +1, initialPosition.getY() );

        arena.moveAstronaut(expectedPosition);

        assertEquals(expectedPosition, arena.getAstronaut().getPosition());
    }

    @Test
    public void testMoveHeroLeft() {
        Position initialPosition = arena.getAstronaut().getPosition();

        Position expectedPosition = new Position(initialPosition.getX()-1, initialPosition.getY() );

        arena.moveAstronaut(expectedPosition);

        assertEquals(expectedPosition, arena.getAstronaut().getPosition());
    }

    @Test
    public void testInvalidKeyDoesNotMoveHero() {
        KeyStroke key = new KeyStroke('a', false, false);

        Position initialPosition = arena.getAstronaut().getPosition();

        arena.processKey(key);

        assertEquals(initialPosition, arena.getAstronaut().getPosition());
    }
}