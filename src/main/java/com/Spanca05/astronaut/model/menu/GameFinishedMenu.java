package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.audio.BackGroundMusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameFinishedMenu {
    private final List<String> entries;
    private int currentEntry = 0;
    private final BackGroundMusic themeMusic;

    public GameFinishedMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.entries = Arrays.asList("Exit");
        this.themeMusic = new BackGroundMusic("theme.wav");
        this.themeMusic.setVolume(-5.0f);
        this.themeMusic.playLoop();
    }

    public void stopMusic() {
        themeMusic.stop();
    }

    public boolean isSelected(int i) {return currentEntry == i;}

    public boolean isSelectedExit() {return isSelected(0);}

}
