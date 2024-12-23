package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.audio.BackGroundMusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LevelCompletedMenu {
    private final List<String> entries;
    private int currentEntry = 0;
    private int currentLevel = 1;
    private final BackGroundMusic themeMusic;

    public LevelCompletedMenu(int currentLevel) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.currentLevel = currentLevel;
        this.entries = Arrays.asList("Next Level", "Retry", "Exit");
        this.themeMusic = new BackGroundMusic("theme.wav");
        this.themeMusic.setVolume(-5.0f);
        this.themeMusic.playLoop();
    }

    public void nextEntry() {
        currentEntry++;
        if(currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if(currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public void nextLevel() {
        // Atualizar aqui quando se adicionarem mais níveis.
        if (currentLevel < 8) {
            ++currentLevel;
        }
    }

    public int getCurrentLevel() {return this.currentLevel;}

    public boolean isSelected(int i) {return currentEntry == i;}

    public boolean isSelectedRetry() {
        themeMusic.stop();
        return isSelected(1);
    }

    public boolean isSelectedNextLevel() {return isSelected(0);}

    public boolean isSelectedExit() {return isSelected(2);}

    public int getNumberEntries() {return this.entries.size();}
}
