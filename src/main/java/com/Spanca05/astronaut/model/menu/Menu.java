    package com.Spanca05.astronaut.model.menu;

    import com.Spanca05.astronaut.Game;
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

        public Menu(Game game) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
            this.entries = Arrays.asList("Level " + currentLevel, "Power-ups", "Exit");
            this.themeMusic = new BackGroundMusic("theme.wav");
            this.themeMusic.setVolume(-5.0f);
            this.themeMusic.playLoop();
            this.currentLevel = game.getCurrentLevel();
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

        public int getCurrentLevel() {
            return currentLevel;
        }

        public boolean isSelected(int i) {return currentEntry == i;}

        public boolean isSelectedExit() {
            return isSelected(2);
        }

        public boolean isSelectedPowerups() {
            themeMusic.stop();
            return isSelected(1);
        }

        public boolean isSelectedStart() {
            return isSelected(0);
        }

    }

