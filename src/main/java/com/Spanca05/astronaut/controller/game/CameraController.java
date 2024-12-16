package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;

import java.io.IOException;

public class CameraController extends GameController {

    public CameraController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().setCameraPosition(getModel().getAstronaut().getPosition().minus(new Position(9,9)));
    }
}