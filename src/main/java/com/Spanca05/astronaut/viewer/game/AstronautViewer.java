package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Astronaut;

public class AstronautViewer implements ElementViewer<Astronaut> {
    int frameCount = 0;
    int nautaPos = 1;

    public void update() {
        frameCount++;
        if (frameCount > 15) {
            nautaPos = nautaPos == 1 ? 2 : 1;
            frameCount = 0;
        }
    }
    @Override
    public void draw(Astronaut astronaut, GUI gui, Position cameraOffSet) {
        gui.drawAstronaut(astronaut.getPosition().minus(cameraOffSet), nautaPos, astronaut.getAngle());
    }
}
