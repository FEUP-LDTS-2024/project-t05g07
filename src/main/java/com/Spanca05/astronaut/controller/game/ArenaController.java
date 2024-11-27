package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final AstronautController astronautController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);
        this.astronautController = new AstronautController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            astronautController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}
