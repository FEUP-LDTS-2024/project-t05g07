package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.menu.PowerupMenu;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.WalletViewer;

import java.io.IOException;

public class PowerupMenuViewer extends Viewer<PowerupMenu> {
    private final WalletViewer walletViewer;

    public PowerupMenuViewer(PowerupMenu powerupMenu) {
        super(powerupMenu);
        this.walletViewer = new WalletViewer(new Wallet());
    }


    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawSecondMenu(new Position(0, 0));
        walletViewer.drawElements(gui);
        gui.drawPricetag(new Position(1,4));
        gui.drawPricetag(new Position(1,6));
        gui.drawPricetag(new Position(1,8));
        gui.drawPrice(new Position(1,0), getModel().getShieldPrice());
        gui.drawPrice(new Position(1,32), getModel().getBonusPrice());
        gui.drawPrice(new Position(1,64), getModel().getImanPrice());
        gui.drawPower1(new Position(5, 4), getModel().isSelected(0));
        gui.drawPower2(new Position(5, 6), getModel().isSelected(1));
        gui.drawPower3(new Position(5, 8), getModel().isSelected(2));
        gui.drawReturn(new Position(5,10), getModel().isSelected(3));
    }
}
