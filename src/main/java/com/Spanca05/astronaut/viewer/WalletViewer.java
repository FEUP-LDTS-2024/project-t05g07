package com.Spanca05.astronaut.viewer;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;

import java.io.IOException;

public class WalletViewer extends Viewer<Wallet> {

    public WalletViewer(Wallet wallet) {
        super(wallet);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawWallet();
        gui.drawScore(getModel().getTotal());
    }
}
