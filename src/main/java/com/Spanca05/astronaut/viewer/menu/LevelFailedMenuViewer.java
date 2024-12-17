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
        gui.draw2Button1(new Position(5, 5), getModel().isSelected(0));
        gui.draw2Button2(new Position(5, 7), getModel().isSelected(1));
        gui.draw2Button3(new Position(5, 9), getModel().isSelected(2));
       /* gui.drawText(new Position(5, 5), "Level Failed", "#FFFFFF");

        for(int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");

*/
    }
}
