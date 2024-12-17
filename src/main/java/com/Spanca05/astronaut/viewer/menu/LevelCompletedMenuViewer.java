package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.LevelCompletedMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class LevelCompletedMenuViewer extends Viewer<LevelCompletedMenu> {
    public LevelCompletedMenuViewer(LevelCompletedMenu levelCompletedMenu) { super(levelCompletedMenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawSecondMenu(new Position(0, 0));

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawCompleteButton1(new Position(5, 5), getModel().isSelected(0));
            gui.drawCompleteButton2(new Position(5, 7), getModel().isSelected(1));
            gui.drawCompleteButton3(new Position(5, 9), getModel().isSelected(2));

        }
    }

}
