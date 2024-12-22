package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.states.MenuState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerupMenuControllerTest {

    @Test
    public void stepUp() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(1)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));

        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();
    }

    @Test
    public void stepDown() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.DOWN;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(1)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));

        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();
    }

    @Test
    public void stepQuit() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.QUIT;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuState.class));

        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();
    }

    @Test
    public void stepSelectEscudo() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);
        Mockito.when(pmMock.isSelectedEscudo()).thenReturn(true);
        Mockito.when(pmMock.isSelectedBonusCoins()).thenReturn(false);
        Mockito.when(pmMock.isSelectedIman()).thenReturn(false);
        Mockito.when(pmMock.isSelectedGoBack()).thenReturn(false);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(1)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();

        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepSelectBonusCoins() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);
        Mockito.when(pmMock.isSelectedEscudo()).thenReturn(false);
        Mockito.when(pmMock.isSelectedBonusCoins()).thenReturn(true);
        Mockito.when(pmMock.isSelectedIman()).thenReturn(false);
        Mockito.when(pmMock.isSelectedGoBack()).thenReturn(false);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(1)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();

        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepSelectIman() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);
        Mockito.when(pmMock.isSelectedEscudo()).thenReturn(false);
        Mockito.when(pmMock.isSelectedBonusCoins()).thenReturn(false);
        Mockito.when(pmMock.isSelectedIman()).thenReturn(true);
        Mockito.when(pmMock.isSelectedGoBack()).thenReturn(false);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(1)).extendImanDuration();

        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepSelectGoBack() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);
        Mockito.when(pmMock.isSelectedEscudo()).thenReturn(false);
        Mockito.when(pmMock.isSelectedBonusCoins()).thenReturn(false);
        Mockito.when(pmMock.isSelectedIman()).thenReturn(false);
        Mockito.when(pmMock.isSelectedGoBack()).thenReturn(true);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.SELECT;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();

        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    @Test
    public void stepSelectDefault() throws Exception {
        PowerupMenu pmMock = Mockito.mock(PowerupMenu.class);

        PowerupMenuController pmc = new PowerupMenuController(pmMock);
        Game gameMock = Mockito.mock(Game.class);
        GUI.ACTION action = GUI.ACTION.RIGHT;
        long time = 2000;

        pmc.step(gameMock, action, time);
        Mockito.verify(pmMock, Mockito.times(0)).extendEscudoDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendBonusCoinsDuration();
        Mockito.verify(pmMock, Mockito.times(0)).extendImanDuration();

        Mockito.verify(pmMock, Mockito.times(0)).previousEntry();
        Mockito.verify(pmMock, Mockito.times(0)).nextEntry();
        Mockito.verify(gameMock, Mockito.times(0)).setState(Mockito.any(MenuState.class));
    }
}
