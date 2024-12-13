package com.Spanca05.astronaut.model.game.elements.powerups;

public class BonusCoins extends Powerup {
    private static long duration = 3000;
    private static int upgradeAmount = 200;

    public BonusCoins() {}

    public BonusCoins(int x, int y) {
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
    }
}

