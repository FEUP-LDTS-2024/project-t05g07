package com.Spanca05.astronaut.controller.menu;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.arena.LoaderArenaBuilder;
import com.Spanca05.astronaut.model.menu.EndGameMenu;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.GameState;
import com.Spanca05.astronaut.states.MenuState;

import java.io.IOException;

public class EndGameMenuController extends Controller<EndGameMenu> {
    public EndGameMenuController(EndGameMenu endGameMenu) {super(endGameMenu);}

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
                if(getModel().isSelectedRetry()) game.setState(new GameState(new LoaderArenaBuilder(getModel().getCurrentLevel()).createArena(getModel().getWallet())));
                if(getModel().isSelectedNextLevel()) {
                    getModel().nextLevel();
                    game.setState(new GameState(new LoaderArenaBuilder(getModel().getCurrentLevel()).createArena(getModel().getWallet())));
                }
                if(getModel().isSelectedExit()) game.setState(new MenuState(new Menu(getModel().getWallet())));
        }
    }
}
