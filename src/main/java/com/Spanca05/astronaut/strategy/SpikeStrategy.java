package com.Spanca05.astronaut.strategy;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Element;

public class SpikeStrategy implements HostileStrategy {

    @Override
    public void step(Arena arena, Element element, GUI.ACTION action, long time) {
        Position pos = element.getPosition();
        killIfTouched(arena, pos);

    }

    private void killIfTouched(Arena arena, Position position) {
        if (arena.getAstronaut().getPosition().equals(position)) {
            arena.getAstronaut().die();
        }
    }
}
