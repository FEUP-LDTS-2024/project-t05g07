package com.Spanca05.astronaut.strategy;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Element;
import com.Spanca05.astronaut.model.game.elements.Monster;

public class TrapStrategy implements HostileStrategy {

    private long timer = 0;
    private Position astronautLastPosition = null;
    private boolean spawned = false;

    @Override
    public void step(Arena arena, Element element, GUI.ACTION action, long time) {
            // Demasiados ifs
            if (astronautLastPosition != null) {
                if (time - timer > 500 && !spawned) {
                    spawnSpike(arena, astronautLastPosition);
                }
                else if (time - timer > 2500 && spawned) {
                    despawnSpike(arena, astronautLastPosition);
                    this.timer = 0;
                    this.astronautLastPosition = null;
                }

            }
            else if (touched(arena, element.getPosition())) {
                this.timer = time;
                this.astronautLastPosition = arena.getAstronaut().getPosition();
        }
    }

    private boolean touched(Arena arena, Position wall) {
        Position astronaut = arena.getAstronaut().getPosition();
        if (astronaut.equals(new Position(wall.getX() - 1, wall.getY()))) return true;
        else if (astronaut.equals(new Position(wall.getX() + 1, wall.getY()))) return true;
        else if (astronaut.equals(new Position(wall.getX(), wall.getY() - 1))) return true;
        else return astronaut.equals(new Position(wall.getX(), wall.getY() + 1));
    }

    private void spawnSpike(Arena arena, Position position) {
        Monster spike = new Monster(position.getX(), position.getY());
        spike.setStrategy(new SpikeStrategy());
        spike.setType("spike");
        arena.addToMonsters(spike);
        spawned = true;
        System.out.println("spawned");
    }

    private void despawnSpike(Arena arena, Position position) {
        arena.removeFromMonsters(position);
        spawned = false;
        System.out.println("despawned");
    }
}
