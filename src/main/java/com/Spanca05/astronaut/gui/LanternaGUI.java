package com.Spanca05.astronaut.gui;

import com.googlecode.lanterna.screen.Screen;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }
}
