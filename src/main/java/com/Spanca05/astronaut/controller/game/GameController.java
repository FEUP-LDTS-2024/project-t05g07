package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.controller.Controller;
import com.Spanca05.astronaut.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}