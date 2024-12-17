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
            this.themeMusic.setVolume(-5.0f);
            this.themeMusic.playLoop();
            this.currentLevel = getCurrentLevel();
        }

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

    public boolean isSelectedEntry(int i) {
        return currentEntry == i;
    }

        public void nextLevel() {
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

        public int getCurrentLevel() {
            return currentLevel;
        }

        public boolean isSelected(int i) {return currentEntry == i;}

        public boolean isSelectedExit() {
            return isSelected(2);
        }

        public boolean isSelectedPowerups() {
            return isSelected(1);
        }

        public boolean isSelectedStart() {
            return isSelected(0);
        }

    }

