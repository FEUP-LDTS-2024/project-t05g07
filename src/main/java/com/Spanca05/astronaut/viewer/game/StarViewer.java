package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Star;

public class StarViewer implements ElementViewer<Star>{
    @Override
    public void draw(Star star, GUI gui, Position cameraOffSet) {
        gui.drawStar(star.getPosition().minus(cameraOffSet));
    }
}

