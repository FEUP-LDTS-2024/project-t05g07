package com.Spanca05.astronaut.viewer.game;

import java.io.IOException;
import java.util.List;

import com.Spanca05.astronaut.gui.GUI;
import com.Spanca05.astronaut.model.Position;
import com.Spanca05.astronaut.model.game.arena.Arena;
import com.Spanca05.astronaut.model.game.elements.Element;
import com.Spanca05.astronaut.viewer.Viewer;
import com.Spanca05.astronaut.viewer.WalletViewer;

public class GameViewer extends Viewer<Arena> {
    public PointViewer pv;
    public AstronautViewer nautav;
    public EndBlockViewer endv;
    public StarViewer starv;
    public CoinViewer coinv;
    public PowerUpViewer powerv;
    public WalletViewer walletViewer;

    public GameViewer(Arena arena) {
        super(arena);
        this.pv = new PointViewer();
        this.nautav = new AstronautViewer();
        this.endv = new EndBlockViewer();
        this.starv = new StarViewer();
        this.coinv = new CoinViewer();
        this.powerv = new PowerUpViewer();
        this.walletViewer = new WalletViewer(arena.getWallet());
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        // Update color
        this.pv.update();
        this.nautav.update();
        this.endv.update();
        this.starv.update();
        this.coinv.update();
        this.powerv.update();

        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getEndBlock(), this.endv);
        drawElement(gui, getModel().getAstronaut(), this.nautav );
        drawElements(gui, getModel().getPoints(), this.pv);
        drawElements(gui, getModel().getStars(), this.starv);
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElements(gui, getModel().getCoins(), this.coinv);
        drawElements(gui,getModel().getPowers(), this.powerv);
        walletViewer.drawElements(gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer, getModel().getCameraPosition());
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        drawElement(gui, element, viewer, getModel().getCameraPosition());
    }

    // This one is called by the above draws.
    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer, Position cameraOffSet) {
        viewer.draw(element, gui, cameraOffSet);
    }
}