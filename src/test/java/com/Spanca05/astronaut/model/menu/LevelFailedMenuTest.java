package com.Spanca05.astronaut.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LevelFailedMenuTest {

    @Test
    public void nextPreviousEntry() throws Exception {
        LevelFailedMenu lfm = new LevelFailedMenu(1);
        assertTrue(lfm.isSelected(0));
        assertTrue(lfm.isSelectedRetry());

        lfm.nextEntry();
        assertTrue(lfm.isSelected(1));
        assertTrue(lfm.isSelectedExit());

        lfm.nextEntry();
        assertTrue(lfm.isSelected(0));

        lfm.previousEntry();
        assertTrue(lfm.isSelected(1));

        lfm.previousEntry();
        assertTrue(lfm.isSelected(0));
    }

    @Test
    public void isSelected() throws Exception {
        LevelFailedMenu lfm = new LevelFailedMenu(1);
        assertTrue(lfm.isSelected(0));
        assertFalse(lfm.isSelected(1));
    }
}
