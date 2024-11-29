package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Wall;


public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui, Position cameraOffSet) {
        gui.drawWall(wall.getPosition().minus(cameraOffSet));
    }
}
