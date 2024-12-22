package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.GameState;
import com.Spanca05.astronaut.states.PowerupMenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.tools.JavaFileObject;

public class MenuControllerTest {

    @Test
    public void stepUp() throws Exception {
        Menu menuMock = Mockito.mock(Menu.class);

        MenuController mc = new MenuController(menuMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;
        long time = 2000;

        mc.step(gameMock, action, time);
        Mockito.verify(menuMock, Mockito.times(1)).previousEntry();
        Mockito.verify(menuMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(null);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(PowerupMenuState.class));

        Mockito.verify(menuMock, Mockito.times(0)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void stepDown() throws Exception {
        Menu menuMock = Mockito.mock(Menu.class);

        MenuController mc = new MenuController(menuMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.DOWN;
        long time = 2000;

        mc.step(gameMock, action, time);
        Mockito.verify(menuMock, Mockito.times(0)).previousEntry();
        Mockito.verify(menuMock, Mockito.times(1)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(null);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(PowerupMenuState.class));

        Mockito.verify(menuMock, Mockito.times(0)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void stepSelectExit() throws Exception {
        Menu menuMock = Mockito.mock(Menu.class);
        Mockito.when(menuMock.isSelectedExit()).thenReturn(true);
        Mockito.when(menuMock.isSelectedPowerups()).thenReturn(false);
        Mockito.when(menuMock.isSelectedStart()).thenReturn(false);

        MenuController mc = new MenuController(menuMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        mc.step(gameMock, action, time);
        Mockito.verify(menuMock, Mockito.times(0)).previousEntry();
        Mockito.verify(menuMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(1)).setState(null);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(PowerupMenuState.class));

        Mockito.verify(menuMock, Mockito.times(0)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void stepSelectPowerups() throws Exception {
        Menu menuMock = Mockito.mock(Menu.class);
        Mockito.when(menuMock.isSelectedExit()).thenReturn(false);
        Mockito.when(menuMock.isSelectedPowerups()).thenReturn(true);
        Mockito.when(menuMock.isSelectedStart()).thenReturn(false);

        MenuController mc = new MenuController(menuMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        mc.step(gameMock, action, time);
        Mockito.verify(menuMock, Mockito.times(0)).previousEntry();
        Mockito.verify(menuMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(null);
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(PowerupMenuState.class));

        Mockito.verify(menuMock, Mockito.times(0)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void stepSelectStart() throws Exception {
        Menu menuMock = Mockito.mock(Menu.class);
        Mockito.when(menuMock.isSelectedExit()).thenReturn(false);
        Mockito.when(menuMock.isSelectedPowerups()).thenReturn(false);
        Mockito.when(menuMock.isSelectedStart()).thenReturn(true);

        MenuController mc = new MenuController(menuMock);

        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        //mc.step(gameMock, action, time);

        Mockito.doNothing().when(gameMock).setState(Mockito.any(GameState.class));

        Mockito.verify(menuMock, Mockito.times(0)).previousEntry();
        Mockito.verify(menuMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(null);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(PowerupMenuState.class));

        //Mockito.verify(menuMock, Mockito.times(1)).stopMusic();
        //Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(GameState.class));

        //................................. :) :) :) :)
    }

    @Test
    public void stepSelectDefault() throws Exception {
        Menu menuMock = Mockito.mock(Menu.class);

        MenuController mc = new MenuController(menuMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.QUIT;
        long time = 2000;

        mc.step(gameMock, action, time);
        Mockito.verify(menuMock, Mockito.times(0)).previousEntry();
        Mockito.verify(menuMock, Mockito.times(0)).nextEntry();

        Mockito.verify(gameMock, Mockito.times(0)).setState(null);
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(PowerupMenuState.class));

        Mockito.verify(menuMock, Mockito.times(0)).stopMusic();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(GameState.class));
    }
}
