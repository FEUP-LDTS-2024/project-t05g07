package com.Spanca05.astronaut.model.game.arena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderArenaBuilderTest {
    Arena arena;

    @Test
    public void levelOne() throws Exception {
        arena = new LoaderArenaBuilder(1).createArena();

        assertEquals(arena.getCurrentLevel(), 1);
        assertEquals(arena.getWidth(), 17);
        assertEquals(arena.getHeight(), 30);

        assertEquals(arena.getPoints().size(), 75);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 136);
        assertEquals(arena.getMonsters().size(), 0);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 10);
        assertEquals(arena.getEndBlock().getPosition().getY(), 1);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 12);
        assertEquals(arena.getAstronaut().getPosition().getY(), 26);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelTwo() throws Exception {
        arena = new LoaderArenaBuilder(2).createArena();

        assertEquals(arena.getCurrentLevel(), 2);
        assertEquals(arena.getWidth(), 21);
        assertEquals(arena.getHeight(), 21);

        assertEquals(arena.getPoints().size(), 66);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 120);
        assertEquals(arena.getMonsters().size(), 10);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 1);
        assertEquals(arena.getEndBlock().getPosition().getY(), 19);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 11);
        assertEquals(arena.getAstronaut().getPosition().getY(), 4);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelThree() throws Exception {
        arena = new LoaderArenaBuilder(3).createArena();

        assertEquals(arena.getCurrentLevel(), 3);
        assertEquals(arena.getWidth(), 24);
        assertEquals(arena.getHeight(), 17);

        assertEquals(arena.getPoints().size(), 80);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 106);
        assertEquals(arena.getMonsters().size(), 5);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 19);
        assertEquals(arena.getEndBlock().getPosition().getY(), 1);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 4);
        assertEquals(arena.getAstronaut().getPosition().getY(), 5);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelFour() throws Exception {
        arena = new LoaderArenaBuilder(4).createArena();

        assertEquals(arena.getCurrentLevel(), 4);
        assertEquals(arena.getWidth(), 15);
        assertEquals(arena.getHeight(), 45);

        assertEquals(arena.getPoints().size(), 167);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 275);
        assertEquals(arena.getMonsters().size(), 14);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 6);
        assertEquals(arena.getEndBlock().getPosition().getY(), 1);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 3);
        assertEquals(arena.getAstronaut().getPosition().getY(), 43);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelFive() throws Exception {
        arena = new LoaderArenaBuilder(5).createArena();

        assertEquals(arena.getCurrentLevel(), 5);
        assertEquals(arena.getWidth(), 20);
        assertEquals(arena.getHeight(), 27);

        assertEquals(arena.getPoints().size(), 88);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 160);
        assertEquals(arena.getMonsters().size(), 0);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 2);
        assertEquals(arena.getEndBlock().getPosition().getY(), 1);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 16);
        assertEquals(arena.getAstronaut().getPosition().getY(), 25);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelSix() throws Exception {
        arena = new LoaderArenaBuilder(6).createArena();

        assertEquals(arena.getCurrentLevel(), 6);
        assertEquals(arena.getWidth(), 19);
        assertEquals(arena.getHeight(), 28);

        assertEquals(arena.getPoints().size(), 113);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 165);
        assertEquals(arena.getMonsters().size(), 5);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 1);
        assertEquals(arena.getEndBlock().getPosition().getY(), 1);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 15);
        assertEquals(arena.getAstronaut().getPosition().getY(), 26);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelSeven() throws Exception {
        arena = new LoaderArenaBuilder(7).createArena();

        assertEquals(arena.getCurrentLevel(), 7);
        assertEquals(arena.getWidth(), 24);
        assertEquals(arena.getHeight(), 26);

        assertEquals(arena.getPoints().size(), 125);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 179);
        assertEquals(arena.getMonsters().size(), 0);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 2);
        assertEquals(arena.getEndBlock().getPosition().getY(), 12);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 20);
        assertEquals(arena.getAstronaut().getPosition().getY(), 24);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelEight() throws Exception {
        arena = new LoaderArenaBuilder(8).createArena();

        assertEquals(arena.getCurrentLevel(), 8);
        assertEquals(arena.getWidth(), 15);
        assertEquals(arena.getHeight(), 31);

        assertEquals(arena.getPoints().size(), 100);
        assertEquals(arena.getStars().size(), 3);
        assertEquals(arena.getWalls().size(), 123);
        assertEquals(arena.getMonsters().size(), 32);

        assertNotEquals(arena.getEndBlock(), null);
        assertEquals(arena.getEndBlock().getPosition().getX(), 5);
        assertEquals(arena.getEndBlock().getPosition().getY(), 1);

        assertNotEquals(arena.getAstronaut(), null);
        assertEquals(arena.getAstronaut().getPosition().getX(), 3);
        assertEquals(arena.getAstronaut().getPosition().getY(), 29);

        assertNotEquals(arena.getCameraPosition(), null);
    }

    @Test
    public void levelNine() {
        assertThrows(NullPointerException.class, () -> arena = new LoaderArenaBuilder(9).createArena());
    }
}
