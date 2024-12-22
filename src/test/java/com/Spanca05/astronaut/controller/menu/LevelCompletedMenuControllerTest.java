package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import com.Spanca05.astronaut.states.GameState;
import com.Spanca05.astronaut.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LevelCompletedMenuControllerTest {

    @Test
    public void stepUp() throws Exception {
        LevelCompletedMenu lcmMock = Mockito.mock(LevelCompletedMenu.class);

        LevelCompletedMenuController lcmc = new LevelCompletedMenuController(lcmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;
        long time = 2000;

        lcmc.step(gameMock, action, time);
        Mockito.verify(lcmMock, Mockito.times(1)).previousEntry();
        Mockito.verify(lcmMock, Mockito.times(0)).nextEntry();

        Mockito.verify(lcmMock, Mockito.times(0)).nextLevel();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));

        Mockito.verify(gameMock, Mockito.times(0)).setCurrentLevel(lcmMock.getCurrentLevel() + 1);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepDown() throws Exception {
        LevelCompletedMenu lcmMock = Mockito.mock(LevelCompletedMenu.class);

        LevelCompletedMenuController lcmc = new LevelCompletedMenuController(lcmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.DOWN;
        long time = 2000;

        lcmc.step(gameMock, action, time);
        Mockito.verify(lcmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(lcmMock, Mockito.times(1)).nextEntry();

        Mockito.verify(lcmMock, Mockito.times(0)).nextLevel();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));

        Mockito.verify(gameMock, Mockito.times(0)).setCurrentLevel(lcmMock.getCurrentLevel() + 1);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepSelectExit() throws Exception {
        LevelCompletedMenu lcmMock = Mockito.mock(LevelCompletedMenu.class);
        Mockito.when(lcmMock.isSelectedNextLevel()).thenReturn(false);
        Mockito.when(lcmMock.isSelectedRetry()).thenReturn(false);
        Mockito.when(lcmMock.isSelectedExit()).thenReturn(true);

        LevelCompletedMenuController lcmc = new LevelCompletedMenuController(lcmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        lcmc.step(gameMock, action, time);
        Mockito.verify(lcmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(lcmMock, Mockito.times(0)).nextEntry();

        Mockito.verify(lcmMock, Mockito.times(0)).nextLevel();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));

        Mockito.verify(gameMock, Mockito.times(1)).setCurrentLevel(lcmMock.getCurrentLevel() + 1);
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }
}
