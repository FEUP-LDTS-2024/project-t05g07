package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.LoaderArenaBuilder;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(0).createArena()));
        }
    }
}
