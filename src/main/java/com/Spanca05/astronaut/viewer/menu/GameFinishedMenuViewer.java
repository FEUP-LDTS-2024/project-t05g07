package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.GameFinishedMenu;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class GameFinishedMenuViewer extends Viewer<GameFinishedMenu> {
    public GameFinishedMenuViewer(GameFinishedMenu gameFinishedMenu) { super(gameFinishedMenu); }

    @Override
    public void drawElements(GUI gui) {
        //gui.drawText(new Position(5, 5), "YOU WON", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++){}
           /* gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");*/


    }

}
