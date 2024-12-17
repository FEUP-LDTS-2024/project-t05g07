package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.LevelFailedMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class LevelFailedMenuViewer extends Viewer<LevelFailedMenu> {
    public LevelFailedMenuViewer(LevelFailedMenu levelFailedMenu) { super(levelFailedMenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawSecondMenu(new Position(0,0));
        gui.drawFailedButton1(new Position(5, 6), getModel().isSelected(0));
        gui.drawFailedButton2(new Position(5, 8), getModel().isSelected(1));
    }
}
