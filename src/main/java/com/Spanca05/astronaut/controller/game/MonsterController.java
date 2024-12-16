package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.model.game.elements.Monster;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class MonsterController extends GameController {

    public MonsterController(Arena arena) {
        super(arena);
        //this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for (Monster monster : getModel().getMonsters()) {
            monster.execute(getModel(), action, time);
        }
        for (Wall wall : getModel().getWalls()) {
            wall.execute(getModel(), action, time);
        }
        /*if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters())
                moveMonster(monster, monster.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }*/
    }

    /*private void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getAstronaut().getPosition().equals(position))
                getModel().getAstronaut().die();
        }
    }*/
}
