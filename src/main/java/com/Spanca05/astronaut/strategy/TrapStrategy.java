package com.Spanca05.astronaut.strategy;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Element;
import com.Spanca05.astronaut.model.game.elements.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TrapStrategy implements HostileStrategy {

    private final List<GangOfSpike> spikes = new ArrayList<>();
    // Por causa disto, não volta a respawnar quando o shield acaba e
    // o Astronaut está a tocar na Trap, mas c'est la vie, não é um bug,
    // é uma feature.
    private Position astronautLastPosition = null;

    @Override
    public void step(Arena arena, Element element, GUI.ACTION action, long time) {

        if (touched(arena, element.getPosition())
                && !Objects.equals(astronautLastPosition, arena.getAstronaut().getPosition())) {
            spikes.add(new GangOfSpike(arena.getAstronaut().getPosition(), time));
            this.astronautLastPosition = arena.getAstronaut().getPosition();
        }

        for (GangOfSpike spike : spikes) {
            Position spawnPoint = spike.getSpawnPoint();
            boolean spawned = spike.getSpawned();
            long timer = spike.getTimer();

            if (time - timer > 500 && !spawned) {
                spawnSpike(arena, spawnPoint);
                spike.setSpawned();
            }
            else if (time - timer > 1500 && spawned) {
                despawnSpike(arena, spawnPoint);
                spikes.remove(spike);
                break;
            }
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
    }

    private void despawnSpike(Arena arena, Position position) {
        arena.removeFromMonsters(position);
    }

    private static class GangOfSpike {
        private final Position spawnPoint;
        private boolean spawned;
        private final long timer;

        private GangOfSpike(Position spawnPoint, long timer) {
            this.spawnPoint = spawnPoint;
            this.spawned = false;
            this.timer = timer;
        }

        private Position getSpawnPoint() {
            return spawnPoint;
        }

        private boolean getSpawned() {
            return spawned;
        }

        private void setSpawned() {
            this.spawned = true;
        }

        private long getTimer() {
            return timer;
        }
    }

    protected Position getAstronautLastPosition() {
        return this.astronautLastPosition;
    }
}
