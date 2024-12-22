package com.Spanca05.astronaut.model.menu;

import com.Spanca05.astronaut.model.Wallet;
import com.Spanca05.astronaut.model.game.elements.powerups.BonusCoins;
import com.Spanca05.astronaut.model.game.elements.powerups.Escudo;
import com.Spanca05.astronaut.model.game.elements.powerups.Iman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PowerupMenuTest {

    @Test
    public void nextPreviousEntry() throws Exception {
        PowerupMenu pm = new PowerupMenu();
        assertTrue(pm.isSelected(0));
        assertTrue(pm.isSelectedEscudo());

        pm.nextEntry();
        assertTrue(pm.isSelected(1));
        assertTrue(pm.isSelectedBonusCoins());

        pm.nextEntry();
        assertTrue(pm.isSelected(2));
        assertTrue(pm.isSelectedIman());

        pm.nextEntry();
        assertTrue(pm.isSelected(3));
        assertTrue(pm.isSelectedGoBack());

        pm.nextEntry();
        assertTrue(pm.isSelected(0));

        pm.previousEntry();
        assertTrue(pm.isSelected(3));

        pm.previousEntry();
        assertTrue(pm.isSelected(2));
    }

    @Test
    public void getImanPrice() throws Exception {
        Iman i = new Iman();
        PowerupMenu pm = new PowerupMenu();
        assertEquals(pm.getImanPrice(), i.getUpgradeAmount());
    }

    @Test
    public void getShieldPrice() throws Exception {
        Escudo e = new Escudo();
        PowerupMenu pm = new PowerupMenu();
        assertEquals(pm.getShieldPrice(), e.getUpgradeAmount());
    }

    @Test
    public void getBonusPrice() throws Exception {
        BonusCoins bc = new BonusCoins();
        PowerupMenu pm = new PowerupMenu();
        assertEquals(pm.getBonusPrice(), bc.getUpgradeAmount());
    }

    @Test
    public void isSelected() throws Exception {
        PowerupMenu pm = new PowerupMenu();
        assertTrue(pm.isSelected(0));
        assertFalse(pm.isSelected(1));
        assertFalse(pm.isSelected(2));
        assertFalse(pm.isSelected(3));
    }

    @Test
    public void extendEscudo() throws Exception {
        PowerupMenu pm = new PowerupMenu();

        Wallet wallet = new Wallet();
        wallet.addToTotal(200);
        int previousTotal = wallet.getTotal();

        Escudo escudo = new Escudo();
        long previousDuration = escudo.getDuration();

        pm.extendEscudoDuration();

        assertNotEquals(previousTotal, wallet.getTotal());
        assertNotEquals(previousDuration, escudo.getDuration());

        previousTotal = wallet.getTotal();
        previousDuration = escudo.getDuration();
        pm.extendEscudoDuration();

        assertEquals(previousTotal, wallet.getTotal());
        assertEquals(previousDuration, escudo.getDuration());
    }

    @Test
    public void extendBonusCoins() throws Exception {
        PowerupMenu pm = new PowerupMenu();

        Wallet wallet = new Wallet();
        wallet.addToTotal(200);
        int previousTotal = wallet.getTotal();

        BonusCoins bonusCoins = new BonusCoins();
        long previousDuration = bonusCoins.getDuration();

        pm.extendBonusCoinsDuration();

        assertNotEquals(previousTotal, wallet.getTotal());
        assertNotEquals(previousDuration, bonusCoins.getDuration());

        previousTotal = wallet.getTotal();
        previousDuration = bonusCoins.getDuration();
        pm.extendBonusCoinsDuration();

        assertEquals(previousTotal, wallet.getTotal());
        assertEquals(previousDuration, bonusCoins.getDuration());
    }

    @Test
    public void extendIman() throws Exception {
        PowerupMenu pm = new PowerupMenu();

        Wallet wallet = new Wallet();
        wallet.addToTotal(200);
        int previousTotal = wallet.getTotal();

        Iman iman = new Iman();
        long previousDuration = iman.getDuration();

        pm.extendImanDuration();

        assertNotEquals(previousTotal, wallet.getTotal());
        assertNotEquals(previousDuration, iman.getDuration());

        previousTotal = wallet.getTotal();
        previousDuration = iman.getDuration();
        pm.extendImanDuration();

        assertEquals(previousTotal, wallet.getTotal());
        assertEquals(previousDuration, iman.getDuration());
    }
}
