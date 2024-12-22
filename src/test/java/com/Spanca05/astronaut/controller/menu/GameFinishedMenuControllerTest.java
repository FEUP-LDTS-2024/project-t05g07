package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.GameFinishedMenu;
import com.Spanca05.astronaut.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GameFinishedMenuControllerTest {

    @Test
    public void stepSelectExit() throws Exception {
        GameFinishedMenu gfmMock = Mockito.mock(GameFinishedMenu.class);
        Mockito.when(gfmMock.isSelectedExit()).thenReturn(true);

        GameFinishedMenuController gfmc = new GameFinishedMenuController(gfmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        gfmc.step(gameMock, action, time);
        Mockito.verify(gfmMock, Mockito.times(1)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(1)).setCurrentLevel(1);
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    /*@Test
    public void stepNotSelectExit() throws Exception {
        GameFinishedMenu gfmMock = Mockito.mock(GameFinishedMenu.class);
        Mockito.when(gfmMock.isSelectedExit()).thenReturn(false);

        GameFinishedMenuController gfmc = new GameFinishedMenuController(gfmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        gfmc.step(gameMock, action, time);
        Mockito.verify(gfmMock, Mockito.times(0)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(0)).setCurrentLevel(1);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }*/
}
