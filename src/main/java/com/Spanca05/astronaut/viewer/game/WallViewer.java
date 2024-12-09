package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.model.game.elements.monsters.Trap;


public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui, Position cameraOffSet) {
        if (wall instanceof Trap) gui.drawTrap(wall.getPosition().minus(cameraOffSet));
        else gui.drawWall(wall.getPosition().minus(cameraOffSet));
    }
}
