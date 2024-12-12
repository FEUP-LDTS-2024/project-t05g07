package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.EndGameMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class EndGameMenuViewer extends Viewer<EndGameMenu> {
    public EndGameMenuViewer(EndGameMenu endGameMenu) { super(endGameMenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Game Over", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");


    }
}
