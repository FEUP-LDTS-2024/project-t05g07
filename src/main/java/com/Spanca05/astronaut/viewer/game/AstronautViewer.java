package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.game.elements.Astronaut;

public class AstronautViewer implements ElementViewer<Astronaut> {
    @Override
    public void draw(Astronaut astronaut, GUI gui) {
        gui.drawAstronaut(astronaut.getPosition());
    }
}
