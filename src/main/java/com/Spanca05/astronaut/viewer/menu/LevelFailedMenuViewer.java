package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class LevelFailedMenuViewer extends Viewer<LevelFailedMenu> {
    public LevelFailedMenuViewer(LevelFailedMenu levelFailedMenu) { super(levelFailedMenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "Level Failed", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");


    }
}
