package com.Spanca05.astronaut.model.game.elements.powerups;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ImanTest {

    @Test
    public void updateUpgradeAmount() {
        Iman iman = new Iman();
        int previousAmount = iman.getUpgradeAmount();
        assertEquals(200, previousAmount);

        iman.extendDuration();
        assertEquals(iman.getUpgradeAmount(), previousAmount * 2);
        assertEquals(iman.getUpgradeAmount(), 400);
        previousAmount *= 2;

        iman.extendDuration();
        assertEquals(iman.getUpgradeAmount(), previousAmount * 2);
        assertEquals(iman.getUpgradeAmount(), 800);
        previousAmount *= 2;

        iman.extendDuration();
        assertNotEquals(iman.getUpgradeAmount(), previousAmount * 2);
        assertEquals(iman.getUpgradeAmount(), 999);


    }
}
