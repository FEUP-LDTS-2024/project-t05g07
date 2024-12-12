package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.states.MenuState;

import java.io.IOException;

public class PowerupMenuController extends Controller<PowerupMenu> {

    public PowerupMenuController(PowerupMenu powerupMenu) {
        super(powerupMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedEscudo()) getModel().extendEscudoDuration();
                if (getModel().isSelectedIman()) getModel().extendImanDuration();
                if (getModel().isSelectedGoBack()) game.setState(new MenuState(new Menu()));
        }
    }
}
