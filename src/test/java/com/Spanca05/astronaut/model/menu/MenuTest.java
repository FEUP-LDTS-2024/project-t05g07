package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.Game;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {

    @Test
    public void nextPreviousEntry() throws Exception {

        Menu menu = new Menu(Mockito.mock(Game.class));
        assertTrue(menu.isSelected(0));
        assertTrue(menu.isSelectedStart());

        menu.nextEntry();
        assertTrue(menu.isSelected(1));
        assertTrue(menu.isSelectedPowerups());

        menu.nextEntry();
        assertTrue(menu.isSelected(2));
        assertTrue(menu.isSelectedExit());

        menu.nextEntry();
        assertTrue(menu.isSelected(0));

        menu.previousEntry();
        assertTrue(menu.isSelected(2));

        menu.previousEntry();
        assertTrue(menu.isSelected(1));
    }

    @Test
    public void isSelected() throws Exception {
        Menu menu = new Menu(Mockito.mock(Game.class));
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
        assertFalse(menu.isSelected(2));
    }
}
