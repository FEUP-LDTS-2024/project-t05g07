package com.Spanca05.astronaut.controller.game;

import com.Spanca05.astronaut.Game;
import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.model.game.elements.monsters.Spike;
import com.Spanca05.astronaut.model.game.elements.monsters.Trap;

public class TrapController extends GameController {

    private long timer;
    private Position astronautLastPosition;
    private boolean spawned = false;

    public TrapController(Arena arena) {
        super(arena);
        this.timer = 0;
        this.astronautLastPosition = null;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        for (Wall wall: getModel().getWalls()) {
            // Demasiados ifs
            if (wall instanceof Trap && astronautLastPosition != null) {
                if (time - timer > 500 && !spawned) {
                    spawnSpike(astronautLastPosition);
                }
                else if (time - timer > 2500 && spawned) {
                    despawnSpike(astronautLastPosition);
                    this.timer = 0;
                    this.astronautLastPosition = null;
                }

            }
            else if (wall instanceof Trap &&
                    touched(wall.getPosition())) {
                this.timer = time;
                this.astronautLastPosition = getModel().getAstronaut().getPosition();
            }
        }
    }

    private boolean touched(Position wall) {
        Position astronaut = getModel().getAstronaut().getPosition();
        if (astronaut.equals(new Position(wall.getX() - 1, wall.getY()))) return true;
        else if (astronaut.equals(new Position(wall.getX() + 1, wall.getY()))) return true;
        else if (astronaut.equals(new Position(wall.getX(), wall.getY() - 1))) return true;
        else return astronaut.equals(new Position(wall.getX(), wall.getY() + 1));
    }

    private void spawnSpike(Position position) {
        Spike spike = new Spike(position.getX(), position.getY());
        getModel().addToMonsters(spike);
        spawned = true;
        System.out.println("spawned");
    }

    private void despawnSpike(Position position) {
        getModel().removeFromMonsters(position);
        spawned = false;
        System.out.println("despawned");
    }
}
