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
        gui.drawFinalMenu(new Position(0, 0));
        gui.drawFailedButton2(new Position(5, 8), getModel().isSelected(1));
    }
}
