package com.Spanca05.astronaut;

import com.Spanca05.astronaut.gui.LanternaGUI;
import com.Spanca05.astronaut.model.menu.Menu;
import com.Spanca05.astronaut.states.MenuState;
import com.Spanca05.astronaut.states.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private int currentLevel;

    public Game() throws FontFormatException, IOException, URISyntaxException,UnsupportedAudioFileException,LineUnavailableException {
        this.gui = new LanternaGUI(288, 240);
        this.currentLevel = 1;
        this.state = new MenuState(new Menu(this));
    }

    public void setCurrentLevel(int level) {
        if (level > 0) {
            this.currentLevel = level;
        }
    }

    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        new Game().start();
    }

    public State getState(){
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    void start() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        int FPS = 50;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
