package com.Spanca05.astronaut.model.game.elements.powerups;

public class Escudo extends Powerup {
    private static long duration = 3000;
    private static int upgradeAmount = 200;

    public Escudo() {}

    public Escudo(int x, int y) {
        super(x, y);
    }

    @Override
    public long getDuration() {
        return duration;
    }

    @Override
    public void extendDuration() {
        duration += 500;
        updateUpgradeAmount();
    }

    @Override
    public int getUpgradeAmount() {
        return upgradeAmount;
    }

    private void updateUpgradeAmount() {
        upgradeAmount *= 2;
        if (upgradeAmount > 999) upgradeAmount = 999;
    }
}
