package com.Spanca05.astronaut.model.menu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameFinishedMenuTest {
    @Test
    public void isSelected() throws Exception {
        GameFinishedMenu gfm = new GameFinishedMenu();
        assertTrue(gfm.isSelected(0));
        assertTrue(gfm.isSelectedExit());
        assertFalse(gfm.isSelected(1));
    }
}
