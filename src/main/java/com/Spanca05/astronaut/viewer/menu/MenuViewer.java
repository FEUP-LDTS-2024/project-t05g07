package com.Spanca05.astronaut.viewer.menu;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.viewer.Viewer;

import java.awt.image.BufferedImage;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawMenu(new Position(0,0));
        gui.drawButton1(new Position(5, 7), getModel().isSelected(0));
        gui.drawButton2(new Position(5, 9), getModel().isSelected(1));
        gui.drawButton3(new Position(5, 11), getModel().isSelected(2));
    }
}