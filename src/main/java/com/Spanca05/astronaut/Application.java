package com.Spanca05.astronaut;

import com.Spanca05.astronaut.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    /*private final LanternaGUI gui;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }*/

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.run();
    }
}
