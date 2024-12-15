package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.audio.BackGroundMusic;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;
    private int currentLevel = 1;
    private final BackGroundMusic themeMusic;

    public Menu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.entries = Arrays.asList("Level " + currentLevel, "Power-ups", "Exit");
        this.themeMusic = new BackGroundMusic("theme.wav");
        this.themeMusic.setVolume(-30.0f);
        this.themeMusic.playLoop();
    }

    // Como é que eu faço voltar pro menu com o currentLevel no
    // nível em que tava...................

    /*public Menu(int currentLevel) {
        this.currentLevel = currentLevel;
        this.entries = Arrays.asList("Level " + this.currentLevel, "Power-ups", "Exit");
    }*/

    public void stopMusic() {
        themeMusic.stop();
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public void nextLevel() {
        // Atualizar aqui quando se adicionarem mais níveis.
        if (currentLevel < 8 && isSelectedStart()) {
            currentLevel++;
            entries.set(0, "Level " + currentLevel);
        }
    }

    public void previousLevel() {
        if (currentLevel > 1 && isSelectedStart()) {
            currentLevel--;
            entries.set(0, "Level " + currentLevel);
        }
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public boolean isSelectedPowerups() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        stopMusic();
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
