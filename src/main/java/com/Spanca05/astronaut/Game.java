package com.Spanca05.astronaut;


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.io.IOException;

public class Game {
    private Screen screen;
    private boolean run;
    private Arena arena;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        Terminal terminal = new DefaultTerminalFactory()
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.getDefaultOfSize(20)
                )
                .createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); //We don't need a cursor
        screen.startScreen();   //screens  must be started
        screen.doResizeIfNecessary();   //resize screen if necessary

        this.arena = new Arena(80, 40);
    }

    public void run() throws IOException {
        run = true;
        while (run) {
            draw(); //Calls draw method
            processKey(screen.readInput());
            if (arena.verifyMonsterCollisions() || arena.verifyExistingCoins()) {
                run = false;
            }
        }
        screen.close();
    }
    public void gameOver() throws IOException {
        run=false;
        screen.close();
    }

    private void draw() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        screen.doResizeIfNecessary();
        screen.clear(); //Clear tela
        arena.draw(graphics);
        screen.refresh();   //Refresh screen
    }

    private void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.EOF) {
            run = false;
            return;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            run = false;
            return;
        }
        arena.processKey(key);
    }


}

