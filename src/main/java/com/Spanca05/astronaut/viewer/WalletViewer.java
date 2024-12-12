package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;

public class WalletViewer extends Viewer<Wallet> {

    public WalletViewer(Wallet wallet) {
        super(wallet);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(1, 1), "Coins: " + getModel().getTotal(), "#FFFFFF");
    }
}
