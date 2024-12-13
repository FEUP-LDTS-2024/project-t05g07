package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.WalletViewer;

public class PowerupMenuViewer extends Viewer<PowerupMenu> {
    private final WalletViewer walletViewer;

    public PowerupMenuViewer(PowerupMenu powerupMenu) {
        super(powerupMenu);
        this.walletViewer = new WalletViewer(new Wallet());
    }

    @Override
    public void drawElements(GUI gui) {
        walletViewer.drawElements(gui);

        gui.drawText(new Position(5, 5), "Power-ups", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? powerupColour(i) : "#FFFFFF");
    }

    private String powerupColour(int i) {
        return switch (i) {
            case 0 -> "#FFC0CB";
            case 1 -> "#00FF00";
            case 2 -> "#FFA500";
            default -> "#FFD700";
        };
    }
}
