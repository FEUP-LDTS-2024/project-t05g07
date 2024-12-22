package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.states.GameState;
import com.Spanca05.astronaut.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LevelFailedMenuControllerTest {

    @Test
    public void stepUp() throws Exception {
        LevelFailedMenu lfmMock = Mockito.mock(LevelFailedMenu.class);

        LevelFailedMenuController lfmc = new LevelFailedMenuController(lfmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;
        long time = 2000;

        lfmc.step(gameMock, action, time);
        Mockito.verify(lfmMock, Mockito.times(1)).previousEntry();
        Mockito.verify(lfmMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setCurrentLevel(lfmMock.getCurrentLevel());
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepDown() throws Exception {
        LevelFailedMenu lfmMock = Mockito.mock(LevelFailedMenu.class);

        LevelFailedMenuController lfmc = new LevelFailedMenuController(lfmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.DOWN;
        long time = 2000;

        lfmc.step(gameMock, action, time);
        Mockito.verify(lfmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(lfmMock, Mockito.times(1)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setCurrentLevel(lfmMock.getCurrentLevel());
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepSelectExit() throws Exception {
        LevelFailedMenu lfmMock = Mockito.mock(LevelFailedMenu.class);
        Mockito.when(lfmMock.isSelectedRetry()).thenReturn(false);
        Mockito.when(lfmMock.isSelectedExit()).thenReturn(true);

        LevelFailedMenuController lfmc = new LevelFailedMenuController(lfmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        lfmc.step(gameMock, action, time);
        Mockito.verify(lfmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(lfmMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
        Mockito.verify(gameMock, Mockito.times(1)).setCurrentLevel(lfmMock.getCurrentLevel());
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    /*@Test
    public void stepSelectRetry() throws Exception {
        LevelFailedMenu lfmMock = Mockito.mock(LevelFailedMenu.class);
        Mockito.when(lfmMock.isSelectedRetry()).thenReturn(true);
        Mockito.when(lfmMock.isSelectedExit()).thenReturn(false);

        LevelFailedMenuController lfmc = new LevelFailedMenuController(lfmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        lfmc.step(gameMock, action, time);
        Mockito.verify(lfmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(lfmMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameState.class));
        Mockito.verify(gameMock, Mockito.times(0)).setCurrentLevel(lfmMock.getCurrentLevel());
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }*/
}
