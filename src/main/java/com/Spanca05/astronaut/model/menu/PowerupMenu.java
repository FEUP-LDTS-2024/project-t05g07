package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

import java.util.Arrays;
import java.util.List;

public class PowerupMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    private Wallet wallet;

    public PowerupMenu(Wallet wallet) {
        this.entries = Arrays.asList("Escudo", "Imobilizador", "Moedas x2", "Score x2", "Iman", "Go Back");
        this.wallet = wallet;
    }

    // Não faz sentido estar a repetir estas funções tho,
    // são iguais às do Menu

    public Wallet getWallet() {
        return wallet;
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

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedEscudo() {
        return isSelected(0);
    }

    public void extendEscudoDuration() {
        Escudo escudo = new Escudo();
        if (wallet.getTotal() >= escudo.getUpgradeAmount())
            extendDuration(escudo);
        else System.out.println("Not enough coins to upgrade. You need "
                + escudo.getUpgradeAmount() + " coins. Current duration: "
                + escudo.getDuration()/1000.0 + " seconds.");
    }

    public boolean isSelectedMoedas() {
        return isSelected(2);
    }

    public boolean isSelectedIman() {
        return isSelected(4);
    }

    public void extendImanDuration() {
        Iman iman = new Iman();
        if (wallet.getTotal() >= iman.getUpgradeAmount())
            extendDuration(iman);
        else System.out.println("Not enough coins to upgrade. You need "
                + iman.getUpgradeAmount() + " coins. Current duration: "
                + iman.getDuration()/1000.0 + " seconds.");
    }

    public boolean isSelectedGoBack() {
        return isSelected(5);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public void extendDuration(Powerup powerup) {
        wallet.subtractFromTotal(powerup.getUpgradeAmount());
        long previousDuration = powerup.getDuration();
        powerup.extendDuration();
        System.out.println("Previous Duration: " + previousDuration/1000.0 + " seconds.");
        System.out.println("Current Duration: " + powerup.getDuration()/1000.0 + " seconds.");
    }
}

