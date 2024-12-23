package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Star;

public class StarViewer implements ElementViewer<Star>{
    public int frameCount = 0;
    public int starColor = 1;

    public void update() {
        frameCount++;
        if (frameCount > 10) {
            starColor = starColor == 1 ? 2 : 1;
            frameCount = 0;
        }
    }
    @Override
    public void draw(Star star, GUI gui, Position cameraOffSet) {
        gui.drawStar(star.getPosition().minus(cameraOffSet),starColor);
    }
}

