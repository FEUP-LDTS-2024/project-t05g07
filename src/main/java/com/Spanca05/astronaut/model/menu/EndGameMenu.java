package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.model.Wallet;

import java.util.Arrays;
import java.util.List;

public class EndGameMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    private int currentLevel = 1;

    public EndGameMenu(int currentLevel) {
        this.currentLevel = currentLevel;
        this.entries = Arrays.asList("Retry", "Next Level", "Exit");
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

    public String getEntry(int i) {return entries.get(i);}

    public boolean isSelected(int i) {return currentEntry == i;}

    public boolean isSelectedRetry() {return isSelected(0);}

    public boolean isSelectedNextLevel() {return isSelected(1);}

    public boolean isSelectedExit() {return isSelected(2);}

    public int getNumberEntries() {return this.entries.size();}
}
