package com.Spanca05.astronaut.model.menu;

import java.util.Arrays;
import java.util.List;

public class PowerupMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public PowerupMenu() {
        this.entries = Arrays.asList("Escudo", "Imobilizador", "Moedas x2", "Score x2", "Iman", "Go Back");
    }

    // Não faz sentido estar a repetir estas funções tho,
    // são iguais às do Menu

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

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedGoBack() {
        return isSelected(5);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}

