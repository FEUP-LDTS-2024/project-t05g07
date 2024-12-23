package com.Spanca05.astronaut.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevelCompletedMenuTest {

    @Test
    public void nextPreviousEntry() throws Exception {

        LevelCompletedMenu lcm = new LevelCompletedMenu(1);
        assertTrue(lcm.isSelected(0));
        assertTrue(lcm.isSelectedNextLevel());

        lcm.nextEntry();
        assertTrue(lcm.isSelected(1));
        assertTrue(lcm.isSelectedRetry());

        lcm.nextEntry();
        assertTrue(lcm.isSelected(2));
        assertTrue(lcm.isSelectedExit());

        lcm.nextEntry();
        assertTrue(lcm.isSelected(0));

        lcm.previousEntry();
        assertTrue(lcm.isSelected(2));

        lcm.previousEntry();
        assertTrue(lcm.isSelected(1));
    }

    @Test
    public void isSelected() throws Exception {
        LevelCompletedMenu lcm = new LevelCompletedMenu(1);
        assertTrue(lcm.isSelected(0));
        assertFalse(lcm.isSelected(1));
        assertFalse(lcm.isSelected(2));
    }

    @Test
    public void nextLevel() throws Exception {
        LevelCompletedMenu lcm = new LevelCompletedMenu(7);
        lcm.nextLevel();
        assertEquals(lcm.getCurrentLevel(), 8);
        lcm.nextLevel();
        assertEquals(lcm.getCurrentLevel(), 8);
    }
}
