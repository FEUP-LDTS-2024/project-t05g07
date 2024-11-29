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
    private final CameraController cameraController;

    public ArenaController(Arena arena) {
        super(arena);
        this.astronautController = new AstronautController(arena);
        this.monsterController = new MonsterController(arena);
        this.cameraController = new CameraController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || !getModel().getAstronaut().getLife())
            game.setState(new MenuState(new Menu()));
        else {
            astronautController.step(game, action, time);
            monsterController.step(game, action, time);
            cameraController.step(game, action,time);

        }
    }
}
