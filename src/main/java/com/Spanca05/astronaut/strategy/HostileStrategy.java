package com.Spanca05.astronaut.strategy;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Element;

public interface HostileStrategy {
    void step(Arena arena, Element element, GUI.ACTION action, long time);
}
