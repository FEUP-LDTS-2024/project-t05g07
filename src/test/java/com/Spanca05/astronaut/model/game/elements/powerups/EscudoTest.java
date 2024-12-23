package com.Spanca05.astronaut.model.game.elements.powerups;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EscudoTest {

    @Test
    public void updateUpgradeAmount() {
        Escudo escudo = new Escudo();
        int previousAmount = escudo.getUpgradeAmount();
        assertEquals(200, previousAmount);

        escudo.extendDuration();
        assertEquals(escudo.getUpgradeAmount(), previousAmount * 2);
        assertEquals(escudo.getUpgradeAmount(), 400);
        previousAmount *= 2;

        escudo.extendDuration();
        assertEquals(escudo.getUpgradeAmount(), previousAmount * 2);
        assertEquals(escudo.getUpgradeAmount(), 800);
        previousAmount *= 2;

        escudo.extendDuration();
        assertNotEquals(escudo.getUpgradeAmount(), previousAmount * 2);
        assertEquals(escudo.getUpgradeAmount(), 999);
    }
}
