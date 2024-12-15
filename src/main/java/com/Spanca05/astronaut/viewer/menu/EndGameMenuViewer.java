package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.EndGameMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class EndGameMenuViewer extends Viewer<EndGameMenu> {
    public EndGameMenuViewer(EndGameMenu endGameMenu) { super(endGameMenu); }

    @Override
    public void drawElements(GUI gui) {
        gui.drawSecondMenu(new Position(0,0));
        gui.draw2Button1(new Position(5, 5), getModel().isSelected(0));
        gui.draw2Button2(new Position(5, 7), getModel().isSelected(1));
        gui.draw2Button3(new Position(5, 9), getModel().isSelected(2));
    }
}