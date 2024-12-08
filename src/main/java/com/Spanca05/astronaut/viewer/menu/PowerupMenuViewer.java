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
        gui.drawText(new Position(5, 5), "Power-ups", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? powerupColour(i) : "#FFFFFF");
    }

    private String powerupColour(int i) {
        return switch (i) {
            //case 0 -> "#FFC0CB";
            //case 4 -> "#FFA500";
            default -> "#FFD700";
        };
    }
}
