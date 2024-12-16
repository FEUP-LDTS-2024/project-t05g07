package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.audio.BackGroundMusic;
import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import com.Spanca05.astronaut.model.game.elements.powerups.Powerup;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PowerupMenu {
    private final List<String> entries;
    private int currentEntry = 0;
    private final Wallet wallet;
    private final BackGroundMusic themeMusic;

    public PowerupMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.entries = Arrays.asList("Escudo", "Moedasx2", "Iman", "Go Back");
        this.wallet = new Wallet();
        this.themeMusic = new BackGroundMusic("theme.wav");
        this.themeMusic.setVolume(-10.0f);
        this.themeMusic.playLoop();
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

    public boolean isSelectedEscudo() {
        return isSelected(0);
    }

    public void extendEscudoDuration() {
        Escudo escudo = new Escudo();
        if (wallet.getTotal() >= escudo.getUpgradeAmount())
            extendDuration(escudo);
        else cannotUpgradeMessage(escudo);
    }

    public boolean isSelectedBonusCoins() {
        return isSelected(1);
    }

    public void extendBonusCoinsDuration() {
        BonusCoins bonusCoins = new BonusCoins();
        if (wallet.getTotal() >= bonusCoins.getUpgradeAmount())
            extendDuration(bonusCoins);
        else cannotUpgradeMessage(bonusCoins);
    }

    public boolean isSelectedIman() {
        return isSelected(2);
    }

    public void extendImanDuration() {
        Iman iman = new Iman();
        if (wallet.getTotal() >= iman.getUpgradeAmount())
            extendDuration(iman);
        else cannotUpgradeMessage(iman);
    }

    public boolean isSelectedGoBack() {
        this.themeMusic.stop();
        return isSelected(3);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    private void extendDuration(Powerup powerup) {
        wallet.subtractFromTotal(powerup.getUpgradeAmount());
        long previousDuration = powerup.getDuration();
        powerup.extendDuration();
        System.out.println("Previous Duration: " + previousDuration/1000.0 + " seconds.");
        System.out.println("Current Duration: " + powerup.getDuration()/1000.0 + " seconds.");
    }

    private void cannotUpgradeMessage(Powerup powerup) {
        System.out.println("Not enough coins to upgrade. You need "
                + powerup.getUpgradeAmount() + " coins. Current duration: "
                + powerup.getDuration()/1000.0 + " seconds.");
    }
}

