package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.monsters.Monster;
import com.Spanca05.astronaut.model.game.elements.monsters.Spike;


public class SpikeController extends GameController {

    public SpikeController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        //_________________________________________________
        for (Monster monster : getModel().getMonsters()) {
            if (getModel().isMonster(monster.getPosition()) && monster instanceof Spike) {
                Position pos = monster.getPosition();
                killIfTouched(pos);
            }
        }
    }

    private void killIfTouched(Position position) {
        if (getModel().getAstronaut().getPosition().equals(position)) {
            getModel().getAstronaut().die();
        }
    }
    //_________________________________________________________
}
