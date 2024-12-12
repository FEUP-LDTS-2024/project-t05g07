package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.WalletViewer;

public class MenuViewer extends Viewer<Menu> {
    private final WalletViewer walletViewer;

    public MenuViewer(Menu menu) {
        super(menu);
        this.walletViewer = new WalletViewer(menu.getWallet());
    }

    @Override
    public void drawElements(GUI gui) {
        walletViewer.drawElements(gui);

        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}