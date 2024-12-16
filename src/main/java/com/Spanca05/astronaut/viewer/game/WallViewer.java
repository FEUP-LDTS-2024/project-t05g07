package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Wall;
import com.Spanca05.astronaut.model.game.elements.MonsterWall;


public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui, Position cameraOffSet) {
        if (wall instanceof MonsterWall) drawMonsterWall((MonsterWall) wall, gui, cameraOffSet);
        else gui.drawWall(wall.getPosition().minus(cameraOffSet));
    }

    private void drawMonsterWall(MonsterWall monsterWall, GUI gui, Position cameraOffSet) {
        if (monsterWall.getType().equals("trap")) gui.drawTrap(monsterWall.getPosition().minus(cameraOffSet));
    }
}
