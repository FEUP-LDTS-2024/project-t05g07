package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.WalletViewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuViewer extends Viewer<Menu> {

    private final WalletViewer walletViewer;

    public MenuViewer(Menu menu) {
        super(menu);
        this.walletViewer = new WalletViewer(new Wallet());
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenu(new Position(0,0));
        walletViewer.drawElements(gui);
        gui.drawButton1(new Position(5, 7), getModel().isSelected(0));
        gui.drawButton2(new Position(5, 9), getModel().isSelected(1));
        gui.drawButton3(new Position(5, 11), getModel().isSelected(2));

    }
}