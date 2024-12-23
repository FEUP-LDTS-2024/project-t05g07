package com.Spanca05.astronaut.model.game.elements.powerups;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BonusCoinsTest {

    @Test
    public void updateUpgradeAmount() {
        BonusCoins bonusCoins = new BonusCoins();
        int previousAmount = bonusCoins.getUpgradeAmount();
        assertEquals(200, previousAmount);

        bonusCoins.extendDuration();
        assertEquals(bonusCoins.getUpgradeAmount(), previousAmount * 2);
        assertEquals(bonusCoins.getUpgradeAmount(), 400);
        previousAmount *= 2;

        bonusCoins.extendDuration();
        assertEquals(bonusCoins.getUpgradeAmount(), previousAmount * 2);
        assertEquals(bonusCoins.getUpgradeAmount(), 800);
        previousAmount *= 2;

        bonusCoins.extendDuration();
        assertNotEquals(bonusCoins.getUpgradeAmount(), previousAmount * 2);
        assertEquals(bonusCoins.getUpgradeAmount(), 999);
    }
}
