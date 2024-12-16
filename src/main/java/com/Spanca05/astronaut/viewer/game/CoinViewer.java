package com.Spanca05.astronaut.viewer.game;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    int frameCount = 0;
    int coinColor = 1;

    public void update() {
        frameCount++;
        if (frameCount > 10) {
            coinColor = coinColor == 1 ? 2 : 1;
            frameCount = 0;
        }
    }

    @Override
    public void draw(Coin coin, GUI gui, Position cameraOffSet) {
        gui.drawCoin(coin.getPosition().minus(cameraOffSet), coinColor);
    }
}
