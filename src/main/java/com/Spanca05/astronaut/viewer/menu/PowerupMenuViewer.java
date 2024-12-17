package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.viewer.Viewer;

public class PowerupMenuViewer extends Viewer<PowerupMenu> {
    public PowerupMenuViewer(PowerupMenu powerupMenu) {
        super(powerupMenu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawSecondMenu(new Position(0, 0));
        gui.drawPower1(new Position(5, 4), getModel().isSelected(0));
        gui.drawPower2(new Position(5, 6), getModel().isSelected(1));
        gui.drawPower3(new Position(5, 8), getModel().isSelected(2));
        gui.drawReturn(new Position(5,10), getModel().isSelected(3));
    }
}
